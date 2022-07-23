package me.erdong.thkij.polymorphism;

import org.junit.Test;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        int age = teacher.getAge();
        String name = teacher.getName();
        // System.out.println("age = " + age);
        System.out.println("name = " + name);
    }

    @Test
    public void py() {
        Student_ student_ = new Student_();
    }
}
