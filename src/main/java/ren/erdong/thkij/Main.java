package ren.erdong.thkij;

import ren.erdong.thkij.reusing.Beetle;
import ren.erdong.thkij.reusing.Insect;

/**
 * @author erdong at 18:29, 21/05/2021
 */
public class Main extends Insect {
    private int k = printInit("Beetle.k initialized");

    public Main() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 =
            printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
        System.out.println(str);
    }
}
