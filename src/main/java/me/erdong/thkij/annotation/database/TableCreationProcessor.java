package me.erdong.thkij.annotation.database;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.SimpleElementVisitor9;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;

import static javax.lang.model.SourceVersion.RELEASE_11;

public class TableCreationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> annotated = roundEnv.getElementsAnnotatedWith(DBTable.class);
        for (Element element : annotated) {
            System.out.println(element.getClass().getName());
            System.out.println(element.getSimpleName().toString());
        }

        /*for (TypeElement annotation : annotations) {
            annotation.accept(new TableCreationVisitor<>(), null);
        }*/

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

    private static class TableCreationVisitor<R, P> extends SimpleElementVisitor9<R, P> {
        @Override
        public R visitType(TypeElement e, P p) {
            System.out.println("x");
            return super.visitType(e, p);
        }

        @Override
        public R visitVariable(VariableElement e, P p) {
            System.out.println("y");
            return super.visitVariable(e, p);
        }
    }
}
