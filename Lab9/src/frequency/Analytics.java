/**Name: Jiali Han
 * Lab 9: Problem 1
 * Reference:
 * https://www.techiedelight.com/remove-punctuation-from-string-java/#:~:text=The%20standard%20solution%20to%20remove,expression%20that%20finds%20punctuation%20characters.
 * https://docs.oracle.com/javase/9/docs/api/java/util/regex/Pattern.html
 */
package frequency;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This is a utility class named Analytics in a package named frequency
 * that provides a public class method (static) to process string message.
 */
public class Analytics {

    /**
     * Takes a String message as its input parameter and
     * returns a frequency count of the words in the message.
     *
     * @param message string of message
     * @return a Map that contains the relative frequency of the times
     * that a given word appears in the message.
     * Relative frequency is computed as the number of occurrences of the word
     * divided by the total number of words in the message.
     */
    public static Map<String, Double> wordFrequency(String message) {
        // If the message string is null or an empty string, return null rather than a Map instance.
        if(message  == null || message.isEmpty()) {
            return null;
        }

        // Tokenize the message using blanks as delimiters between words.
        message = message.replaceAll("\\p{IsPunctuation}", " ");
        message = message.replaceAll("\\s+", " ");

        String[] messageSplit = message.split(" ");

        // build a list of words in UPPERCASE with the use of High Order Functions Map
        List<String> listOfWords = Arrays.stream(messageSplit)
                .map(String::toUpperCase).collect(Collectors.toList());

        // build a map contains words as keys and relative frequency as values
        Map<String, Double> map = new HashMap<>();

        for (String word: listOfWords) {
            int freq = Collections.frequency(listOfWords, word);
            int count = listOfWords.size();
            if (!map.containsKey(word)) {
                map.put(word, (double) freq / count);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        String message = "Really? Like, really? I do need another cookie to cook?";
        System.out.println(wordFrequency(message));
    }
}
