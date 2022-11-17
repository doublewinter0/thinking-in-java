package me.erdong.thkij.inner;

public class Main {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
    }
}
