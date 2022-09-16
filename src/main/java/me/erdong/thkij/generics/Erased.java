package me.erdong.thkij.generics;

public class Erased<T> {
    private final int SIZE = 100;
    public T[] f(Object arg) {
        // if(arg instanceof T) {} // Error
        // T var = new T(); // Error
        // T[] array = new T[SIZE]; // Error
        T[] array1 = (T[])new Integer[SIZE]; // Unchecked warning

        System.out.println(array1);

        return array1;
    }

    public void x() {
        Integer[] a = new Integer[2];

        Erased<String> x = new Erased<>();

        String[] f = x.f(0);

        System.out.println(f);
    }
    public static void main(String[] args) {
        new Erased().x();
    }
}
