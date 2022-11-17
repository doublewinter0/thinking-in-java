package me.erdong.thkij.enumerated.dispatch;

public class Goo extends Foo{
    @Override
    public void bar(A a ) {
        System.out.println("Goo.bar(A)");
    }

    // @Override
    public void bar(B b ) {
        System.out.println("Goo.bar(B)");
    }
}
