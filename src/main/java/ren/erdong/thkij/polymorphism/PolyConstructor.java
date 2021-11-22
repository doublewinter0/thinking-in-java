package ren.erdong.thkij.polymorphism;

/**
 * @author erdong at 08:36, 26/05/2021
 * <p>
 * The actual process of initialization:
 * <p>
 * 1. The storage allocated for the object is initialized to binary zero before anything else happens.
 * </p>
 * <p>
 * 2. The base-class constructors are called as described previously.
 * At this point, the overridden draw() method is called (yes, before the RoundGlyph constructor is called),
 * which discovers a radius value of zero, due to Step 1.
 * </p>
 * <p>
 * 3. Member initializers are called in the order of declaration.
 * </p>
 * <p>
 * 4. The body of the derived-class constructor is called.
 * </p>
 */
class Glyph {
    // private (final) void draw() { System.out.println("Glyph.draw()"); } // 编译期/静态/早 绑定
    // 运行时/动态/晚 绑定
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("this in Glyph: " + this); // 子类调用基类构造器, 上下文为子类对象
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        System.out.println("this in RoundGlyph: " + this);
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PolyConstructor {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
