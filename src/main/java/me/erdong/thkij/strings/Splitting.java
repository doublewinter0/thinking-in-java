package me.erdong.thkij.strings;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";
    public static void split(String regex, int limit) {
        System.out.println(
                Arrays.toString(knights.split(regex, limit)));
    }
    public static void main(String[] args) {
        split(" ", 0);
        split("\\W+", 0);
        split("\\W+?", 0);
        split("\\W+", 2);

        Pattern pattern = Pattern.compile("(agent/installer)|(files/(agent|proxy))");
        Matcher m1 = pattern.matcher("/files/proxy");
        while (m1.find()) {
            System.out.println(m1.group());
        }
        Matcher m2 = pattern.matcher("/run/agent/installer");
        while (m2.find()) {
            System.out.println(m2.group());
        }
    }

}
