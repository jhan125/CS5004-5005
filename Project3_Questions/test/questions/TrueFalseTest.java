/**
 * Name: Jiali Han
 * Project 03: Questions
 */

package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class is to test the TrueOrFalse class.
 */
class TrueFalseTest {
    private Question trueOrFalse1;
    private Question trueOrFalse2;
    private Question trueOrFalse3;
    private Question multipleSelect;
    private Question multipleChoice;
    private Question likert;

    /**
     * Test whether the constructor works properly.
     */
    @BeforeEach
    public void setUp() {
        trueOrFalse1 = new TrueFalse("Is this true that 24 hours make a day?", "True");
        // trueOrFalse2 is used to test compareTo method based on lexicographical order
        trueOrFalse2 = new TrueFalse("Do you think 20 hours make a day?", "False");
        // trueOrFalse3 is used to test exceptions in compareTo methods since it has same text as trueOrFalse2
        trueOrFalse3 = new TrueFalse("Do you think 20 hours make a day?", "False");

        // all the following questions are created to test compareTo... methods
        multipleSelect = new MultipleSelect("What makes a day?",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");

        multipleChoice = new MultipleChoice("How many seconds in one minute?",
                "6", "1. 10","2. 20", "3. 30", "4. 40", "5. 50", "6. 60");

        likert = new Likert("Do you agree that Animal Crossing is the best game ever?");

    }

    /**
     * Test whether constructor creates objects properly.
     */
    @Test
    public void testTrueOrFalse() {
        trueOrFalse1 = new TrueFalse("Is this true that 24 hours make a day?", "True");
        trueOrFalse2 = new TrueFalse("Do you think 20 hours make a day?", "False");
        trueOrFalse3 = new TrueFalse("Do you think 20 hours make a day?", "False");
    }

    /**
     * Test whether constructor handles exception properly.
     */
    @Test
    public void testConstructorException() {
        // test case 1: when the question text for Constructor is invalid (null/empty/blank)
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> new TrueFalse(null, "True"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new TrueFalse("", "True"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new TrueFalse(" ", "True"), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 2: when correctAnswer is not in True or False format
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new TrueFalse("Is this true that 24 hours make a day?", "YES"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new TrueFalse("Is this true that 24 hours make a day?", "1"), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testGetText() {
        String expected = "Is this true that 24 hours make a day?";
        assertEquals(expected, trueOrFalse1.getText());

        expected = "Do you think 20 hours make a day?";
        assertEquals(expected, trueOrFalse2.getText());
    }

    @Test
    public void testAnswer() {
        // return CORRECT if answer matches with correctAnswer.
        String expected = "Correct";
        assertEquals(expected, trueOrFalse1.answer("True"));
        assertEquals(expected, trueOrFalse2.answer("False"));

        // return INCORRECT if answer does not match with correctAnswer.
        expected = "Incorrect";
        assertEquals(expected, trueOrFalse2.answer("True"));
        assertEquals(expected, trueOrFalse1.answer("False"));
    }

    @Test
    public void testAnswerException() {
        // test case 1: when the answer for question is null, empty, or blank
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> trueOrFalse1.answer(null), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> trueOrFalse1.answer(""), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> trueOrFalse1.answer(" "), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 2: when answer is not in True or False format
        exception = assertThrows(IllegalArgumentException.class, ()
                -> trueOrFalse1.answer("9 4"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> trueOrFalse1.answer("Yes"), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testGetAnswer() {
        trueOrFalse1.answer("False");
        String expected = "False";
        assertEquals(expected, trueOrFalse1.getAnswer());

        trueOrFalse2.answer("True");
        expected = "True";
        assertEquals(expected, trueOrFalse2.getAnswer());
    }

    @Test
    public void testCompareTo() {
        assertEquals(5, trueOrFalse1.compareTo(trueOrFalse2));
        assertEquals(0, trueOrFalse2.compareTo(trueOrFalse3));
        assertEquals(-1, trueOrFalse1.compareTo(multipleSelect));
        assertEquals(-1, trueOrFalse1.compareTo(likert));
        assertEquals(-1, trueOrFalse1.compareTo(multipleChoice));
    }

    @Test
    public void testCompareToTrueOrFalse() {
        assertEquals(5, ((TrueFalse)trueOrFalse1).compareToTrueFalse(trueOrFalse2));
        assertEquals(0, ((TrueFalse)trueOrFalse2).compareToTrueFalse(trueOrFalse3));
    }

    @Test
    public void testToString() {
        String expected = "Question: Is this true that 24 hours make a day?\n" +
                "Correct Answer: True\n";
        assertEquals(expected, trueOrFalse1.toString());

        expected = "Question: Do you think 20 hours make a day?\n" +
                "Correct Answer: False\n";
        assertEquals(expected, trueOrFalse2.toString());
    }
}