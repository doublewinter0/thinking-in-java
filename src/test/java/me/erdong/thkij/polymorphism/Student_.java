package me.erdong.thkij.polymorphism;

/**
 * @author erdong at 07:48, 28/05/2021
 */
public class Student_ extends Person {
    public Student_() {
        super(10, "xm");
    }

    // @Override
    void py() {
        System.out.println("这是 Student_ 里面的 py()");
    }
}
