/**
 * Name: Jiali Han
 * Project 03: Questions
 */

package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is to test the MultipleSelect class.
 */
class MultipleSelectTest {
    private Question multipleSelect1;
    private Question multipleSelect2;
    private Question multipleSelect3;
    private Question multipleChoice;
    private Question likert;
    private Question trueOrFalse;

    /**
     * Test whether the constructor works properly.
     */
    @BeforeEach
    public void setUp() {
        multipleSelect1 = new MultipleSelect("What makes a day?",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");
        // multipleSelect2 is used to test compareTo method based on lexicographical order
        multipleSelect2 = new MultipleSelect("Select all correct options that makes a day.",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");
        // multipleSelect3 is used to test exceptions in compareTo methods since it has same text as multipleSelect2
        multipleSelect3 = new MultipleSelect("Select all correct options that makes a day.",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");

        // all the following questions are created to test compareTo... methods
        multipleChoice = new MultipleChoice("How many seconds in one minute?",
                "6", "1. 10","2. 20", "3. 30", "4. 40", "5. 50", "6. 60");
        likert = new Likert("Do you agree that Animal Crossing is the best game ever?");
        trueOrFalse = new TrueFalse("Is this true that 24 hours make a day?", "True");
    }

    /**
     * Test whether constructor creates objects properly.
     */
    @Test
    public void testMultipleSelect() {
        multipleSelect1 = new MultipleSelect("What makes a day?",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");
        multipleSelect2 = new MultipleSelect("Select all correct options that makes a day.",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");
        multipleSelect3 = new MultipleSelect("Select all correct options that makes a day.",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");
    }

    /**
     * Test whether constructor handles exception properly.
     */
    @Test
    public void testConstructorException() {
        // test case 1: when the question text for Constructor is invalid (null/empty/blank)
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleSelect(null, "1 4", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleSelect("","1 4", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleSelect(" ", "1 4", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes"), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 2: if correctAnswer is not a string consist of numbers, throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleSelect("What makes a day?", "three", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleSelect("What makes a day?", "a b c", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes"), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 3: when any number in the correctAnswer is out of options boundary (1-8), throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleSelect("What makes a day?", "0 4", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleSelect("What makes a day?", "10 4", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes"), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 4: when inputOptions is less than 3 or more than 8, throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleSelect("What makes a day?", "2", "1. 24 hours", "2. 60 hours"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleSelect("What makes a day?", "2", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5", "6", "7", "8", "9"), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 5: when any inputOption is invalid (null/empty/blank), throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("What makes a day?", "2", null,"1", "2", "3", "4", "5"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("What makes a day?", "2", "","1", "2", "3", "4", "5"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("What makes a day?", "2", " ","1", "2", "3", "4", "5"), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testGetText() {
        String expected = "What makes a day?";
        assertEquals(expected, multipleSelect1.getText());

        expected = "Select all correct options that makes a day.";
        assertEquals(expected, multipleSelect2.getText());
    }

    @Test
    public void testAnswer() {
        // return CORRECT if answer contain all the correct options and none of the incorrect ones.
        String expected = "Correct";
        assertEquals(expected, multipleSelect1.answer("1 4 5"));
        assertEquals(expected, multipleSelect1.answer("4 1 5"));
        assertEquals(expected, multipleSelect1.answer("4 5 1"));
        assertEquals(expected, multipleSelect1.answer("1 5 4"));
        assertEquals(expected, multipleSelect1.answer("5 1 4"));

        // return INCORRECT if answer does match CorrectAnswer completely
        expected = "Incorrect";
        assertEquals(expected, multipleSelect1.answer("1 3 4 5"));
        assertEquals(expected, multipleSelect1.answer("1 4"));
        assertEquals(expected, multipleSelect1.answer("5"));
        assertEquals(expected, multipleSelect1.answer("3"));
    }

    @Test
    public void testAnswerException() {
        // test case 1: when the answer for question is null, empty, or blank
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleSelect1.answer(null), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleSelect1.answer(""), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleSelect1.answer(" "), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 2: when any answer is out of options boundary (1-8), throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleSelect1.answer("9 4"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleSelect1.answer("0 4"), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 3: when any answer is not a string consist of numbers, throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleSelect1.answer("one two"), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testGetAnswer() {
        multipleSelect1.answer("2 4");
        String expected = "2 4";
        assertEquals(expected, multipleSelect1.getAnswer());

        multipleSelect2.answer("3");
        expected = "3";
        assertEquals(expected, multipleSelect2.getAnswer());
    }

    @Test
    public void testCompareTo() {
        assertEquals(4, multipleSelect1.compareTo(multipleSelect2));
        assertEquals(1, multipleSelect1.compareTo(trueOrFalse));
        assertEquals(-1, multipleSelect1.compareTo(likert));
        assertEquals(1, multipleSelect1.compareTo(multipleChoice));
    }

    @Test
    public void testCompareToMultipleSelect() {
        assertEquals(4, ((MultipleSelect)multipleSelect1).compareToMultipleSelect(multipleSelect2));
    }

    @Test
    public void testToString() {
        String expected = "Question: What makes a day?\n" +
                "Options: [1. 24 hours, 2. 60 hours, 3. 6000 minutes, 4. 1440 minutes, 5. 86400 seconds, 6. 10000 seconds]\n" +
                "Correct Answer: [1, 4, 5]\n";
        assertEquals(expected, multipleSelect1.toString());

        expected = "Question: Select all correct options that makes a day.\n" +
                "Options: [1. 24 hours, 2. 60 hours, 3. 6000 minutes, 4. 1440 minutes, 5. 86400 seconds, 6. 10000 seconds]\n" +
                "Correct Answer: [1, 4, 5]\n";
        assertEquals(expected, multipleSelect2.toString());
    }
}