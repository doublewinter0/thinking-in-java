package ren.erdong.thkij.initialization;

import java.util.Arrays;
import java.util.Random;

/**
 * @author erdong at 09:24, 13/05/2021
 */
public class ArrayNew {
    public static void main(String[] args) {
        int[] its;
        Random rand = new Random(47);
        its = new int[rand.nextInt(20)];
        System.out.println("length of its = " + its.length);
        System.out.println((Arrays.toString(its)));

        char[] chs;
        chs = new char[rand.nextInt(20)];
        System.out.println("length of chs = " + chs.length);
        System.out.println((Arrays.toString(chs)));
    }
} 
