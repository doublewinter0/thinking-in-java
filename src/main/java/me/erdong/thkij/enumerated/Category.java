package me.erdong.thkij.enumerated;

import java.util.EnumMap;
import java.util.PrimitiveIterator;

import static me.erdong.thkij.enumerated.Input.*;

public enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;

    Category(Input... types) {
        System.out.println(types);
        values = types;
    }

    private static EnumMap<Input, Category> categories =
            new EnumMap<>(Input.class);

    static {
        System.out.println("aaaaaaaaaaaaaaaaaaaa");
        Category.values();
        System.out.println("bbbbbbbbbbbbbbbbbbbb");
        for (Category c : Category.class.getEnumConstants())
            for (Input type : c.values)
                categories.put(type, c);
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }

    public static void main(String[] args) {
        // Category.values();
        System.out.println("xxx");
    }
}
