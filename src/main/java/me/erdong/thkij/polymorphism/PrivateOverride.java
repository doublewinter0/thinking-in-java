package me.erdong.thkij.polymorphism;

/**
 * @author erdong at 20:20, 23/05/2021
 */
public class PrivateOverride {
    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}
