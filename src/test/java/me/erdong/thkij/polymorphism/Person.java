package me.erdong.thkij.polymorphism;

/**
 * @author erdong at 08:11, 28/05/2021
 */
public class Person {
    private int age;
    protected String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("this in Person: " + this);
        System.out.println(this.name);
        // Student student = (Student) this;
        this.py();
        // student.py();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        System.out.println("this in getName: " + this);
        System.out.println("------");
        System.out.println(this.go());
        System.out.println("------");

        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String go() {
        return "P";
    }

    void py() {
        System.out.println("这是 Person 里面的 py()");
    }
}
