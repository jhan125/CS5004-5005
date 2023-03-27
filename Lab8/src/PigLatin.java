/**
 * Lab 8
 * Name: Jiali Han
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatin {

    // input: "MAKING A PIG DEAL ABOUT PIG LATIN"
    // output: "AKINGMAY AWAY IGPAY EALDAY ABOUTWAY IGPAY ATINLAY"

    // If the letter begins with a vowel: aeiou
    // then “WAY” is appended to the word.

    // If the letter begins with a consonant (a letter other than a vowel),
    // then the first letter of the word is moved to the end, and then “AY” is appended to it.

    /**
     * Converts a String into pig latin.
     *
     * @param word the String to convert into pig latin
     * @return the output converted to pig latin
     */
    public static String pigLatinConvert(String word) {

        String firstLetter =  word.substring(0,1);

        if (isVowel(firstLetter)) {
            return word + "WAY";
        } else {
            return word.substring(1) + firstLetter + "AY";
        }
    }

    public static String getPigLatin(String input) {
        String[] split = input.split("\\s+");
        List<String> words = Arrays.asList(split);

        List<String> output = words.stream()
                .map(a -> pigLatinConvert(a)).collect(Collectors.toList());

        String res = "";
        for (String s: output) {
            res += " " + s;
        }
        return res.substring(1);
    }

    public static boolean isVowel(String firstLetter) {
        String vowels = "AEIOU";
        return vowels.contains(firstLetter);
    }

}
