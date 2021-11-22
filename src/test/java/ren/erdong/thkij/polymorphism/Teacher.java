package ren.erdong.thkij.polymorphism;

/**
 * @author erdong at 08:13, 28/05/2021
 */
public class Teacher extends Person{
    // private String name;

    public Teacher() {
        super(23, "hs");
        name = "hsy";
        System.out.println("this in Teacher: " + this);
        // System.out.println("name in Teacher: " + name);
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode()) + ", name = " + name;
    }

    private String go() {
        return "S";
    }
}
