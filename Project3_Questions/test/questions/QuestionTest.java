/**
 * Name: Jiali Han
 * Project 03: Questions
 *
 * Reference:
 * 1. Assert equals between 2 Lists in Junit:
 * https://stackoverflow.com/questions/3236880/assert-equals-between-2-lists-in-junit
 * 2. Assert equals between 2 arrays in Junit:
 * https://stackoverflow.com/questions/4228161/comparing-arrays-in-junit-assertions-concise-built-in-way
 */

package questions;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is to test the questionnaire and
 * to verify that an array or collection that contains question objects is sorted correctly.
 */
class QuestionTest {
    private Question trueOrFalse1;
    private Question trueOrFalse2;
    private Question multipleSelect1;
    private Question multipleSelect2;
    private Question multipleChoice1;
    private Question multipleChoice2;
    private Question likert1;
    private Question likert2;

    @BeforeEach
    public void setUp() {
        trueOrFalse1 = new TrueFalse("Is this true that 24 hours make a day?", "True");
        trueOrFalse2 = new TrueFalse("Do you think 20 hours make a day?", "False");

        multipleSelect1 = new MultipleSelect("What makes a day?",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");
        multipleSelect2 = new MultipleSelect("Select all correct options that makes a day.",
                "1 4 5", "1. 24 hours", "2. 60 hours", "3. 6000 minutes", "4. 1440 minutes", "5. 86400 seconds", "6. 10000 seconds");

        multipleChoice1 = new MultipleChoice("How many seconds in one minute?",
                "6", "1. 10","2. 20", "3. 30", "4. 40", "5. 50", "6. 60");
        multipleChoice2 = new MultipleChoice("How many days in one year?",
                "3", "1. 100","2. 200", "3. 365", "4. 400", "5. 500", "6. 600");

        likert1 = new Likert("Do you agree that Animal Crossing is the best game ever?");
        likert2 = new Likert("Rate your 5-point Likert scale on this question: Do you think Starbucks has the best coffee?");
    }

    /**
     * This is to test question ordering
     */
    @Test
    public void testOrdering() {
        // All true/false questions should be before any multiple-choice questions
        assertEquals(-1, trueOrFalse1.compareTo(multipleSelect1));
        assertEquals(-1, trueOrFalse1.compareTo(likert1));
        assertEquals(-1, trueOrFalse1.compareTo(multipleChoice1));

        // All multiple-choice questions should be before any multiple-select questions
        assertEquals(1, multipleChoice1.compareTo(trueOrFalse1));
        assertEquals(-1, multipleChoice1.compareTo(likert1));
        assertEquals(-1, multipleChoice1.compareTo(multipleSelect1));

        // All multiple-select questions should be before any Likert questions
        assertEquals(1, multipleSelect1.compareTo(trueOrFalse1));
        assertEquals(-1, multipleSelect1.compareTo(likert1));
        assertEquals(1, multipleSelect1.compareTo(multipleChoice1));

        // All likert questions should be ordered at last
        assertEquals(1, likert1.compareTo(trueOrFalse1));
        assertEquals(1, likert1.compareTo(multipleChoice1));
        assertEquals(1, likert1.compareTo(multipleSelect1));

        // Within a question type, questions should be ordered in the lexicographical order of their question text.
        assertEquals(5, trueOrFalse1.compareTo(trueOrFalse2));
        assertEquals(15, multipleChoice1.compareTo(multipleChoice2));
        assertEquals(4, multipleSelect1.compareTo(multipleSelect2));
        assertEquals(-14, likert1.compareTo(likert2));
    }

    /**
     * This is to test question ordering via sorting
     */
    @Test
    public void testOrderViaSorting() {

        Question[] expected = {trueOrFalse2, trueOrFalse1, multipleChoice2, multipleChoice1, multipleSelect2, multipleSelect1, likert1, likert2};


        Question[] questionnaire = new Question[]{likert1, likert2, multipleChoice1, multipleChoice2, multipleSelect1, multipleSelect2, trueOrFalse1, trueOrFalse2};
        Arrays.sort(questionnaire);

        assertArrayEquals(expected, questionnaire);


        List<Question> q = new ArrayList<>();
        q.add(likert1);
        q.add(likert2);
        q.add(multipleChoice1);
        q.add(multipleChoice2);
        q.add(multipleSelect1);
        q.add(multipleSelect2);
        q.add(trueOrFalse1);
        q.add(trueOrFalse2);

        Collections.sort(q);

        List<Question> expectedList = Arrays.asList(expected);
        assertIterableEquals(expectedList, q);
    }
}