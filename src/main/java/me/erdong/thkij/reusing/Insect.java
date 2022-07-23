package me.erdong.thkij.reusing;

/**
 * @author erdong at 18:17, 21/05/2021
 */
public class Insect {
    protected static String str = "str";
    private final int i = 9;
    protected int j;

    public Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static final int x1 =
            printInit("static Insect.x1 initialized");

    protected static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}
