package me.erdong.thkij.generic;

import me.erdong.thkij.util.New;

import java.util.List;
import java.util.Map;

class Pet{}

public class LimitsOfInference {
    static void f(Map<String, List<? extends Pet>> petPeople) {}
    public static void main(String[] args) {
        f(New.map()); // Does not compile
    }
}
