/**
 * Name: Jiali Han
 * Project 03: Questions
 * Reference:
 * 1) How to handle multiple arguments in Java?
 * https://www.geeksforgeeks.org/variable-arguments-varargs-in-java/
 * 2) How to convert int to String in Java?
 * https://www.javatpoint.com/java-int-to-string
 */

package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents the MultipleChoice class for Question.
 * It inherits from AbstractQuestion class and overrides answer(), compareTo(), compareToMultipleChoice() methods
 * A MultipleChoice question can be created by passing the text of the question, the correct answer and the options.
 * A question must have at least 3 options, but no more than 8.
 * An answer can be entered as one of the option numbers in a string.
 * Only one option is correct.
 */
public class MultipleChoice extends AbstractQuestion {
    private final int correctAnswer;
    private final List<String> options = new ArrayList<>();

    /**
     * Constructs a MultipleChoice object with the given text of the question,
     * the correct answer (only 1, e.g."2") and the options (at least 3, no more than 8)
     *
     * @param text   the text of the question
     * @param correctAnswer   the only correct answer of the question
     * @param inputOptions   the options of the question\
     * @throws IllegalArgumentException If correctAnswer is null or empty or blank
     */
    public MultipleChoice(String text, String correctAnswer, String... inputOptions)
            throws IllegalArgumentException{
        super(text);

        // case 1: if correctAnswer is not valid, throw IAE
        if (!checkIfValid(correctAnswer)) {
            throw new IllegalArgumentException("Correct answer cannot be null or empty or blank.");
        }

        // case 2: if correctAnswer is not in number format, throw IAE
        try {
            this.correctAnswer = Integer.parseInt(correctAnswer);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Correct answer must be in number format.");
        }

        // case 3: when number in the correctAnswer is out of options boundary (1-8), throw IAE
        if (Integer.parseInt(correctAnswer) < 1 || Integer.parseInt(correctAnswer) > 8) {
            throw new IllegalArgumentException("Correct answer is invalid. Options can only be between 1-8.");
        }

        // case 4: if inputOptions is less than 3 or more than 8, throw IAE
        if (inputOptions.length < 3 || inputOptions.length > 8) {
            throw new IllegalArgumentException("Number of input options is invalid. A question should have 3-8 options.");
        }

        // case 5: if any inputOption is invalid, throw IAE
        for (String option: inputOptions) {
            if (!checkIfValid(option)) {
                throw new IllegalArgumentException("Option cannot be null or empty or blank.");
            }
        }

        this.options.addAll(Arrays.asList(inputOptions));
    }

    /**
     * Overrides the answer method for MultipleChoice question.
     * The CORRECT answer must be the same as CorrectAnswer.
     * otherwise, return INCORRECT
     *
     * @param answer the answer given
     * @return "Correct" if answer is the same as CorrectAnswer.
     * @throws IllegalArgumentException If answer is null or empty or blank
     */
    @Override
    public String answer(String answer) throws IllegalArgumentException{
        // when the answer for question is null, empty, or blank, throw IAE
        if (!checkIfValid(answer)) {
            throw new IllegalArgumentException("Answer cannot be null or empty or blank.");
        }
        // when the answer is out of options boundary (1 - 8), throw IAE
        if (Integer.parseInt(answer) < 1 || Integer.parseInt(answer) > 8) {
            throw new IllegalArgumentException("Answer cannot be out of options boundary.");
        }

        this.answer = answer;

        if (this.correctAnswer == Integer.parseInt(answer)) {
            return CORRECT;
        } else {
            return INCORRECT;
        }
    }

    @Override
    public String getAnswer() {
        return this.answer;
    }

    /**
     * Returns the comparison result given a specific question type.
     *
     * @param question question to compare.
     * @return -1 if this is smaller than question, -1 if bigger, 0 if equal
     */
    @Override
    public int compareTo(Question question) throws IllegalArgumentException{
        // if the questions are the same
        if (question.getText().equals(this.getText())) {
            return 0;
        }

        if (question instanceof MultipleChoice) {
            return this.compareToMultipleChoice(question);
        }
        return ((AbstractQuestion) question).compareToMultipleChoice(question);
    }

    /**
     * Returns the comparison result with MultipleChoice questions based on lexicographical order.
     *
     * @param question question to compare.
     * @return negative if this is smaller than question, positive if bigger, 0 if equal
     */
    @Override
    public int compareToMultipleChoice(Question question) {
        return this.getText().compareTo(question.getText());
    }

    @Override
    public String toString() { //facilitates testing
        StringBuilder sb = new StringBuilder();
        sb.append("Question: ").append(this.getText()).append("\n");

        sb.append("Options: ").append(options.toString()).append("\n");

        sb.append("Correct Answer: ").append(correctAnswer).append("\n");

        return sb.toString();
    }
}
