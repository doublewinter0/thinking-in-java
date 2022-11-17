package me.erdong.thkij.inner;

public class Outer {
    private static String desc;
    private int i;

    class Inner {
        private int i;

        int getOutValue() {
            return Outer.this.i;
        }

        int getValue() {
            return this.i;
        }
    }
}
