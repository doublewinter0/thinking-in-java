package ren.erdong.thkij.polymorphism_;

import ren.erdong.thkij.polymorphism.Person;

/**
 * @author erdong at 07:48, 28/05/2021
 */
public class Student extends Person {
    public Student() {
        super(10, "xm");
    }

    public void py() {
        System.out.println("这是 Student 里面的 py()");
    }
}
