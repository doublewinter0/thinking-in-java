package me.erdong.thkij.operator;

import org.junit.Test;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random(100);
        for (int i = 0; i < 10; i++) {
            System.out.println(rand.nextInt(100));
        }
    }

    @Test
    public void literal() {
        char ch = 0XFFFF; // 65535
        System.out.println((int) ch);
        System.out.println(2 ^ 3);
        int a = 3;
        System.out.println(a << 2);
        short s = -1;
        System.out.println(Integer.toBinaryString(s));
        System.out.println(s >>> 10);
        System.out.println(s);
        s >>>= 10;
        System.out.println(s);
    }

    @Test
    public void go() {
        int x = 1;
        int y = 2;
        int z = x = y;
        System.out.println(z);
    }
}
