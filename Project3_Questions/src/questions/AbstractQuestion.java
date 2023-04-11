/**
 * Name: Jiali Han
 * Project 03: Questions
 * Reference:
 * How to handle multiple arguments in Java?
 * https://www.geeksforgeeks.org/variable-arguments-varargs-in-java/
 */

package questions;

/**
 * This class represents an abstract class for Question.
 */
public abstract class AbstractQuestion implements Question {

    protected final String text; // text of the question is final once created for safety
    protected String answer; // answer to the question will be modified in concrete class constructor

    /**
     * Constructor for an abstract question with text of the question.
     *
     * @param text Text of the question.
     * @throws IllegalArgumentException If question text is null or empty or blank
     */
    public AbstractQuestion(String text) throws IllegalArgumentException {
        if (!checkIfValid(text)) {
            throw new IllegalArgumentException("Text of question cannot be null or empty or blank.");
        }
        this.text = text;
        this.answer = "";
    }

    /**
     * Returns the text of the question.
     *
     * @return text of the question.
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * Returns the answer to the question.
     *
     * @return answer the question.
     */
    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public abstract String answer(String answer);


    /**
     * Returns the comparison result with true/false questions.
     * Since all true/false questions should be before any multiple-choice questions.
     *
     * @param question question to compare.
     * @return 1 if it has to be above this type questions, -1 otherwise.
     */
    public int compareToTrueFalse(Question question) {
        return -1;
    }

    /**
     * Returns the comparison result with MultipleChoice questions.
     *
     * @param question question to compare.
     * @return 1 if it has to be above this type question, -1 otherwise.
     */
    public int compareToMultipleChoice(Question question) {
        if (question instanceof TrueFalse) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Returns the comparison result with MultipleSelect questions.
     *
     * @param question question to compare.
     * @return 1 if it has to be above this type question, -1 otherwise.
     */
    public int compareToMultipleSelect(Question question) {
        if (question instanceof TrueFalse || question instanceof MultipleChoice) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Returns the comparison result with Likert questions.
     *
     * @param question question to compare.
     * @return -1 if it has to be above this type question, 1 otherwise.
     */
    public int compareToLikert(Question question) {
        return 1;
    }

    /**
     * Returns the comparison result given a specific question type.
     *
     * @param question question to compare.
     */
    public abstract int compareTo(Question question);

    /**
     * A helper method to check whether the input is valid.
     *
     * @param input text to compare.
     * @return false If text is null or empty or blank, true otherwise.
     */
    public boolean checkIfValid(String input) {
        if (input == null || input.equals("") || input.equals(" ")) {
            return false;
        } else {
            return true;
        }
    }
}