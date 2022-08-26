package me.erdong.thkij.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {
    public static void main(String[] args) throws Exception {
        String s = "/*! Here’s a block of text to use as input to\n" +
                "the regular expression matcher. Note that we’ll\n" +
                "first extract the block of text by looking for\n" +
                "the special delimiters, then process the\n" +
                "extracted block. !*/";
        // Match the specially commented block of text above:
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if (mInput.find())
            s = mInput.group(1); // Captured by parentheses
        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");
        // Replace one or more spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you
        // perform the replacements:
        System.out.println(s);
        while (m.find()) {
            String g = m.group();
            /* appendReplacement( ) also allows you to refer to captured groups directly in the
             *  replacement string by saying "$g", where ‘g’ is the group number. However, this is for
             *  simpler processing and wouldn’t give you the desired results in the preceding program.
             */
            // m.appendReplacement(sb, "$0");
            m.appendReplacement(sb, g.toUpperCase());
            System.out.println("----------------------");
            System.out.format("group: %s, sb: %s%n", g, sb);

        }
        // Put in the remainder of the text:
        m.appendTail(sb);
        System.out.println(sb);
    }
}
