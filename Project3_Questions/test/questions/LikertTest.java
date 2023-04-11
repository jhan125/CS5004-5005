/**
 * Name: Jiali Han
 * Project 03: Questions
 * Reference:
 * Should Java unit test variables be private or public?
 * https://stackoverflow.com/questions/26381403/should-unit-test-member-variables-be-private-or-public
 */

package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is to test the Likert class.
 */
class LikertTest {
    private Question likert1;
    private Question likert2;
    private Question likert3;
    private Question multipleChoice;
    private Question multipleSelect;
    private Question trueOrFalse;

    /**
     * Test whether the constructor works properly.
     */
    @BeforeEach
    public void setUp() {
        likert1 = new Likert("Do you agree that Animal Crossing is the best game ever?");
        // likert2 is used to test compareToLikert method based on lexicographical order
        likert2 = new Likert("Rate your 5-point Likert scale on this question: Do you think Starbucks has the best coffee?");
        // likert3 is used to test exceptions in compareTo methods since it has same text as likert2
        likert3 = new Likert("Rate your 5-point Likert scale on this question: Do you think Starbucks has the best coffee?");
        // all the following questions are created to test compareTo... methods
        multipleChoice = new MultipleChoice("How many seconds in one minute?",
                "6", "1. 10","2. 20", "3. 30", "4. 40", "5. 50", "6. 60");
        multipleSelect = new MultipleSelect("What makes a day?",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");
        trueOrFalse = new TrueFalse("Is this true that 24 hours make a day?", "True");
    }

    /**
     * Test whether constructor creates objects properly.
     */
    @Test
    public void testLikert() {
        likert1 = new Likert("Do you agree that Animal Crossing is the best game ever?");

        likert2 = new Likert("Rate your 5-point Likert scale on this question: Do you think Starbucks has the best coffee?");

        likert3 = new Likert("Rate your 5-point Likert scale on this question: Do you think Starbucks has the best coffee?");
    }

    /**
     * Test whether constructor handles exception properly.
     */
    @Test
    public void testConstructorException() {
        // when the question text for Likert Constructor is null, empty, or blank
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> new Likert(null), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new Likert(""), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new Likert(" "), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testGetText() {
        String expected = "Do you agree that Animal Crossing is the best game ever?";
        assertEquals(expected, likert1.getText());

        expected = "Rate your 5-point Likert scale on this question: Do you think Starbucks has the best coffee?";
        assertEquals(expected, likert2.getText());
    }

    @Test
    public void testAnswer() {
        // return CORRECT if answer is in numeric format and within the given boundary 1-5
        String expected = "Correct";
        assertEquals(expected, likert1.answer("2"));

        // return INCORRECT if answer is out of boundary
        expected = "Incorrect";
        assertEquals(expected, likert2.answer("6"));
    }

    @Test
    public void testAnswerException() {
        // when the answer for Likert question is null, empty, or blank
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> likert1.answer(null), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> likert1.answer(""), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> likert1.answer(" "), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testGetAnswer() {
        // return answer if answer is valid in numeric format and within the given boundary 1-5
        likert1.answer("2");
        String expected = "2. Agree";
        assertEquals(expected, likert1.getAnswer());

        // return empty string if answer is not valid and out of boundary
        likert2.answer("6");
        expected = "";
        assertEquals(expected, likert2.getAnswer());
    }

    @Test
    public void testCompareTo() {
        assertEquals(-14, likert1.compareTo(likert2));
        assertEquals(0, likert2.compareTo(likert3));
        assertEquals(1, likert1.compareTo(trueOrFalse));
        assertEquals(1, likert1.compareTo(multipleChoice));
        assertEquals(1, likert1.compareTo(multipleSelect));
    }

    @Test
    public void testCompareToLikert() {
        assertEquals(-14, ((Likert)likert1).compareToLikert(likert2));
    }

    @Test
    public void testToString() {
        String expected = "Question:Do you agree that Animal Crossing is the best game ever?\n" +
                "Options:\n" +
                "1. Strongly Agree\n" +
                "2. Agree\n" +
                "3. Neither Agree nor Disagree\n" +
                "4. Disagree\n" +
                "5. Strongly Disagree\n";
        assertEquals(expected, likert1.toString());

        expected = "Question:Rate your 5-point Likert scale on this question: Do you think Starbucks has the best coffee?\n" +
                "Options:\n" +
                "1. Strongly Agree\n" +
                "2. Agree\n" +
                "3. Neither Agree nor Disagree\n" +
                "4. Disagree\n" +
                "5. Strongly Disagree\n";
        assertEquals(expected, likert2.toString());
    }
}