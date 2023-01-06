package me.erdong.thkij.annotation.database;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.SimpleElementVisitor9;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.lang.model.SourceVersion.RELEASE_11;

public class TableCreationProcessor extends AbstractProcessor {
    private String sql = "";

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // Set<? extends Element> annotated = roundEnv.getElementsAnnotatedWithAny(annotations.toArray(new TypeElement[0]));
        Set<? extends Element> annotated = roundEnv.getElementsAnnotatedWith(DBTable.class);
        if (annotated.isEmpty()) return false;

        for (Element element : annotated) {
            // System.out.println(element.getClass().getName());
            // System.out.println(element.getSimpleName().toString());

            element.accept(new TableCreationVisitor<>(), null);
        }

        System.out.println(sql);

        /*sql.lines().forEach(line -> {
            System.out.println(line);
        });*/

        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        HashSet<String> set = new HashSet<>();
        set.add("me.erdong.thkij.annotation.database.Constraints");
        set.add("me.erdong.thkij.annotation.database.DBTable");
        set.add("me.erdong.thkij.annotation.database.SQLInteger");
        set.add("me.erdong.thkij.annotation.database.SQLString");

        return set;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return RELEASE_11;
    }

    private class TableCreationVisitor<R, P> extends SimpleElementVisitor9<R, P> {
        @Override
        public R visitType(TypeElement e, P p) {
            List<? extends Element> enclosedElements = e.getEnclosedElements();
            for (Element enclosedElement : enclosedElements) {
                System.out.println(enclosedElement.getSimpleName());
            }

            DBTable dbTable = e.getAnnotation(DBTable.class);
            if (dbTable != null) {
                sql += "CREATE TABLE ";
                sql += (dbTable.name().length() < 1)
                        ? e.getSimpleName().toString().toUpperCase()
                        : dbTable.name();
                sql += " (";
            }

            return super.visitType(e, p);
        }

        @Override
        public R visitVariable(VariableElement e, P p) {
            String columnName = "";
            if (e.getAnnotation(SQLInteger.class) != null) {
                SQLInteger sInt = e.getAnnotation(
                        SQLInteger.class);
                if (sInt.name().length() < 1)
                    columnName = e.getSimpleName().toString().toUpperCase();
                else
                    columnName = sInt.name();
                sql += "\n " + columnName + " INT" +
                        getConstraints(sInt.constraints()) + ",";
            }
            if (e.getAnnotation(SQLString.class) != null) {
                SQLString sString = e.getAnnotation(
                        SQLString.class);
                if (sString.name().length() < 1)
                    columnName = e.getSimpleName().toString().toUpperCase();
                else
                    columnName = sString.name();
                sql += "\n " + columnName + " VARCHAR(" +
                        sString.value() + ")" +
                        getConstraints(sString.constraints()) + ",";
            }

            return super.visitVariable(e, p);
        }

        private String getConstraints(Constraints con) {
            String constraints = "";
            if (!con.allowNull())
                constraints += " NOT NULL";
            if (con.primaryKey())
                constraints += " PRIMARY KEY";
            if (con.unique())
                constraints += " UNIQUE";
            return constraints;
        }
    }
}
