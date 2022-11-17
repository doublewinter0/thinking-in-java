package me.erdong.thkij.enumerated.dispatch;

public class Main {
    // Java 静态分派，动态分派
    public static void main(String[] args) {
        Foo foo = new Foo();
        Foo goo = new Goo();

        A a = new A();
        B b = new B();

        foo.bar(a);
        foo.bar(b);
        goo.bar(a);
        goo.bar(b);
        goo.bar(new B());
    }
}
