/**
 * Name: Jiali Han
 * Project 03: Questions
 */

package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is to test the MultipleChoice class.
 */
class MultipleChoiceTest {
    private Question multipleChoice1;
    private Question multipleChoice2;
    private Question multipleChoice3;
    private Question likert;
    private Question multipleSelect;
    private Question trueOrFalse;

    /**
     * Test whether the constructor works properly.
     */
    @BeforeEach
    public void setUp() {
        multipleChoice1 = new MultipleChoice("How many seconds in one minute?",
                "6", "1. 10","2. 20", "3. 30", "4. 40", "5. 50", "6. 60");

        // multipleChoice2 is used to test compareToMultipleChoice method based on lexicographical order
        multipleChoice2 = new MultipleChoice("How many days in one year?",
                "3", "1. 100","2. 200", "3. 365", "4. 400", "5. 500", "6. 600");
        // multipleChoice3 is used to test exceptions in compareTo methods since it has same text as multipleChoice2
        multipleChoice3 = new MultipleChoice("How many days in one year?",
                "3", "1. 100","2. 200", "3. 365", "4. 400", "5. 500", "6. 600");

        // all the following questions are created to test compareTo... methods
        likert = new Likert("Do you agree that Animal Crossing is the best game ever?");
        multipleSelect = new MultipleSelect("What makes a day?",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");
        trueOrFalse = new TrueFalse("Is this true that 24 hours make a day?", "True");
    }

    /**
     * Test whether constructor creates objects properly.
     */
    @Test
    public void testMultipleChoice() {
        multipleChoice1 = new MultipleChoice("How many seconds in one minute?",
                "6", "1. 10","2. 20", "3. 30", "4. 40", "5. 50", "6. 60");

        multipleChoice2 = new MultipleChoice("How many days in one year?",
                "3", "1. 100","2. 200", "3. 365", "4. 400", "5. 500", "6. 600");

        multipleChoice3 = new MultipleChoice("How many days in one year?",
                "3", "1. 100","2. 200", "3. 365", "4. 400", "5. 500", "6. 600");
    }

    /**
     * Test whether constructor handles exception properly.
     */
    @Test
    public void testConstructorException() {
        // test case 1: when the question text for Constructor is invalid (null/empty/blank)
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice(null, "3", "100","200", "365"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("","3", "100","200", "365"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice(" ", "3", "100","200", "365"), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 2: when correctAnswer is not in number format, throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("How many days in one year?", "three", "100","200", "365"), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 3: when number in the correctAnswer is out of options boundary (1-8), throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("How many days in one year?", "0", "100","200", "365"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("How many days in one year?", "9", "100","200", "365"), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 4: when inputOptions is less than 3 or more than 8, throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("How many days in one year?", "2", "100","365"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("How many days in one year?", "2", "100","365", "3", "4", "5", "6", "7", "8", "9"), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 5: when any inputOption is invalid (null/empty/blank), throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("How many days in one year?", "2", null,"365", "3", "4", "5"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("How many days in one year?", "2", "","365", "3", "4", "5"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> new MultipleChoice("How many days in one year?", "2", " ","365", "3", "4", "5"), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testGetText() {
        String expected = "How many seconds in one minute?";
        assertEquals(expected, multipleChoice1.getText());

        expected = "How many days in one year?";
        assertEquals(expected, multipleChoice2.getText());
    }

    @Test
    public void testAnswer() {
        // return CORRECT if answer is in numeric format and is the same as CorrectAnswer.
        String expected = "Correct";
        assertEquals(expected, multipleChoice1.answer("6"));
        assertEquals(expected, multipleChoice2.answer("3"));

        // return INCORRECT if answer is not the same as CorrectAnswer.
        expected = "Incorrect";
        assertEquals(expected, multipleChoice1.answer("3"));
        assertEquals(expected, multipleChoice2.answer("6"));
    }

    @Test
    public void testAnswerException() {
        // test case 1: when the answer for question is null, empty, or blank
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleChoice1.answer(null), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleChoice1.answer(""), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleChoice1.answer(" "), "Expected to throw IllegalArgumentException, but it didn't.");

        // test case 2: when the answer is out of options boundary (1-8), throw IAE
        exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleChoice1.answer("9"), "Expected to throw IllegalArgumentException, but it didn't.");
        exception = assertThrows(IllegalArgumentException.class, ()
                -> multipleChoice1.answer("0"), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testGetAnswer() {
        // return answer if answer is in numeric format and within the given boundary
        multipleChoice1.answer("2");
        String expected = "2";
        assertEquals(expected, multipleChoice1.getAnswer());

        multipleChoice2.answer("3");
        expected = "3";
        assertEquals(expected, multipleChoice2.getAnswer());
    }

    @Test
    public void testCompareTo() {
        assertEquals(15, multipleChoice1.compareTo(multipleChoice2));
        assertEquals(0, multipleChoice2.compareTo(multipleChoice3));
        assertEquals(1, multipleChoice1.compareTo(trueOrFalse));
        assertEquals(-1, multipleChoice1.compareTo(likert));
        assertEquals(-1, multipleChoice1.compareTo(multipleSelect));
    }

    @Test
    public void testCompareToMultipleChoice() {
        assertEquals(15, ((MultipleChoice)multipleChoice1).compareToMultipleChoice(multipleChoice2));
    }

    @Test
    public void testToString() {
        String expected = "Question: How many seconds in one minute?\n" +
                "Options: [1. 10, 2. 20, 3. 30, 4. 40, 5. 50, 6. 60]\n" +
                "Correct Answer: 6\n";
        assertEquals(expected, multipleChoice1.toString());

        expected = "Question: How many days in one year?\n" +
                "Options: [1. 100, 2. 200, 3. 365, 4. 400, 5. 500, 6. 600]\n" +
                "Correct Answer: 3\n";
        assertEquals(expected, multipleChoice2.toString());
    }
}