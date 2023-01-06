package me.erdong.thkij.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    public static final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        System.out.println(Pattern.matches("x+", "xxx"));
        System.out.println(Pattern.matches("x+", "xxx "));

        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        // System.out.println(m.matches());
        System.out.println("+++++++++++++++");
        while (m.find()) {
            // System.out.println(m.matches());
            for (int j = 0; j <= m.groupCount(); j++) {
                System.out.printf("start index: %d%n", m.start());
                System.out.printf("end index: %d%n", m.end());
                System.out.println("--------------------------");
                System.out.printf("[%s], ", m.group(j));
                System.out.printf("start index: %d, ", m.start(j));
                System.out.printf("end index: %d", m.end(j));
                System.out.println();
            }
            // System.out.println();
        }
    }
}
