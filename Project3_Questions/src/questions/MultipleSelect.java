/**
 * Name: Jiali Han
 * Project 03: Questions
 * Reference:
 * How to handle multiple arguments in Java?
 * https://www.geeksforgeeks.org/variable-arguments-varargs-in-java/
 */

package questions;

import java.util.*;

/**
 * This class represents the MultipleSelect class for Question.
 * It inherits from AbstractQuestion class and overrides answer(),compareTo(), compareToMultipleChoice() methods
 * A MultipleSelect question can be created by passing the text of the question, the correct answer and the options.
 * A question must have at least 3 options, but no more than 8.
 * An answer can be entered the option numbers in a string.
 * An answer is correct if and only if it contains all the correct options and none of the incorrect ones.
 */
public class MultipleSelect extends AbstractQuestion {
    private final Set<Integer> correctAnswers = new HashSet<>();
    private final List<String> options = new ArrayList<>();

    /**
     * Constructs a MultipleChoice object with the given text of the question,
     * the correct answer (multiple, e.g."2 3") and the options (at least 3, no more than 8)
     *
     * @param text   the text of the question
     * @param correctAnswer   the only correct answer of the question
     * @param inputOptions   the options of the question
     * @throws IllegalArgumentException If correctAnswer is null or empty or blank
     */
    public MultipleSelect(String text, String correctAnswer, String... inputOptions)
            throws IllegalArgumentException {
        super(text);

        // case 1: when the question text for Constructor is invalid (null/empty/blank), throw IAE
        if (!checkIfValid(correctAnswer)) {
            throw new IllegalArgumentException("Correct answer cannot be null or empty or blank.");
        }

        String[] ans = correctAnswer.split(" ");
        // case 2: if correctAnswer is not a string consist of numbers, throw IAE
        try {
            for (String s : ans) {
                int a = Integer.parseInt(s);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Correct answer must be in number format.");
        }

        // case 3: when any number in the correctAnswer is out of options boundary (1-8), throw IAE
        for (String s: ans) {
            if (Integer.parseInt(s) < 1 || Integer.parseInt(s) > 8) {
                throw new IllegalArgumentException("Correct answer is invalid. Options can only be between 1-8.");
            }
        }

        // case 4: when inputOptions is less than 3 or more than 8, throw IAE
        if (inputOptions.length < 3 || inputOptions.length > 8) {
            throw new IllegalArgumentException("Number of input options is invalid. A question should have 3-8 options.");
        }

        // case 5: when any inputOption is invalid (null/empty/blank), throw IAE
        for (String option: inputOptions) {
            if (!checkIfValid(option)) {
                throw new IllegalArgumentException("Option cannot be null or empty or blank.");
            }
        }

        for (String s: ans) {
            correctAnswers.add(Integer.parseInt(s));
        }
        this.options.addAll(Arrays.asList(inputOptions));
    }

    /**
     * Overrides the answer method for MultipleSelect question.
     * The CORRECT answer must contain all the correct options and none of the incorrect ones.
     * otherwise, return INCORRECT
     *
     * @param answer the answer given
     * @return "Correct" if answer contains all the correct options and none of the incorrect ones.
     * @throws IllegalArgumentException If answer is invalid
     */
    @Override
    public String answer(String answer) throws IllegalArgumentException{
        // case 1: when the answer for question is invalid as null, empty, or blank
        if (!checkIfValid(answer)) {
            throw new IllegalArgumentException("Answer cannot be null or empty or blank.");
        }

        // case 2: when any answer is out of options boundary (1-8), throw IAE
        String[] user = answer.split(" ");
        for (String s: user) {
                if (Integer.parseInt(s) < 1 || Integer.parseInt(s) > 8) {
                    throw new IllegalArgumentException("Your answer is invalid. A question only has 3-8 answers.");
                }
        }

        // case 3: when any answer is not a string consist of numbers, throw IAE
        Set<Integer> userAnswers = new HashSet<>();
        try {
            for (String s: user) {
                userAnswers.add(Integer.parseInt(s));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Answer must be a string of numbers.");
        }

        // record answer
        this.answer = answer;

        // return expected output
        if (userAnswers.equals(correctAnswers)) {
            return CORRECT;
        } else {
            return INCORRECT;
        }
    }

    /**
     * Returns the comparison result given a specific question type.
     *
     * @param question question to compare.
     * @return 1 if it has to be above this type questions, -1 otherwise
     */
    @Override
    public int compareTo(Question question) throws IllegalArgumentException{
        // if the questions are the same
        if (question.getText().equals(this.getText())) {
            return 0;
        }

        if (question instanceof MultipleSelect) {
            return this.compareToMultipleSelect(question);
        }
        return ((AbstractQuestion) question).compareToMultipleSelect(question);
    }

    /**
     * Returns the comparison result with MultipleSelect questions based on lexicographical order.
     *
     * @param question question to compare.
     * @return negative if this is smaller than question, positive if bigger, 0 if equal
     */
    @Override
    public int compareToMultipleSelect(Question question) {
        return this.getText().compareTo(question.getText());
    }

    @Override
    public String toString() { // facilitate testing
        StringBuilder sb = new StringBuilder();
        sb.append("Question: ").append(this.getText()).append("\n");

        sb.append("Options: ").append(options.toString()).append("\n");

        sb.append("Correct Answer: ").append(correctAnswers.toString()).append("\n");

        return sb.toString();
    }
}
