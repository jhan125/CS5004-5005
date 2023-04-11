/**
 * Name: Jiali Han
 * Project 03: Questions
 * Reference:
 * 1. How to compare two strings lexicographically in Java?
 * https://www.geeksforgeeks.org/compare-two-strings-lexicographically-in-java/
 * 2. How to compare two different type objects?
 * https://stackoverflow.com/questions/11438600/comparing-two-different-data-types-with-compareto-method
 */

package questions;

/**
 * This class represents a Likert class for Question.
 * It inherits from AbstractQuestion class and overrides answer(), compareTo(), compareToLikert() methods.
 * A Likert question can be answered on a fixed, 5-point Likert scale
 * (Strongly Agree, Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree).
 * This type of question can be created by passing the text of the question.
 * An answer can be entered as one of the option numbers, numbered from 1 in the above order.
 * Any valid option number is a "correct" answer.
 */
public class Likert extends AbstractQuestion {

    /**
     * Constructs a Likert object with the given text of the question.
     *
     * @param text   the text of the question
     */
    public Likert(String text) {
        super(text);
    }

    /**
     * Overrides the answer method for Likert question.
     * The CORRECT answer must be one of the 5-point Likert scale (Strongly Agree, Agree,
     * Neither Agree nor Disagree, Disagree, Strongly Disagree),
     * otherwise, return INCORRECT
     *
     * @param answer the answer given
     * @return "Correct" if answer is "1" to "5" as valid options
     * @throws IllegalArgumentException If answer is null or empty or blank
     */
    @Override
    public String answer(String answer) throws IllegalArgumentException {
        if (!checkIfValid(answer)) {
            throw new IllegalArgumentException("Answer cannot be null or empty or blank.");
        }

        switch(answer) {
            case("1"):
                this.answer = "1. Strongly Agree";
                return CORRECT;
            case("2"):
                this.answer = "2. Agree";
                return CORRECT;
            case("3"):
                this.answer = "3. Neither Agree nor Disagree";
                return CORRECT;
            case("4"):
                this.answer = "4. Disagree";
                return CORRECT;
            case("5"):
                this.answer = "5. Strongly Disagree";
                return CORRECT;
            default:
                return INCORRECT;
        }
    }

    /**
     * Returns the comparison result with Likert questions based on lexicographical order.
     *
     * @param question question to compare.
     * @return negative if this is smaller than question, positive if bigger, 0 if equal
     */
    @Override
    public int compareToLikert(Question question) {
        return this.getText().compareTo(question.getText());
    }

    /**
     * Returns the comparison result given a specific question type.
     *
     * @param question question to compare.
     * @return -1 if this is smaller than question, -1 if bigger, 0 if equal
     */
    @Override
    public int compareTo(Question question)  {
        // if the questions are the same, return 0
        if (question.getText().equals(this.getText())) {
            return 0;
        }
        // check question type before comparison
        if (question instanceof Likert) {
            return this.compareToLikert(question);
        }
        return ((AbstractQuestion) question).compareToLikert(question);
    }

    @Override
    public String toString() { // facilitates testing
        StringBuilder sb = new StringBuilder();
        sb.append("Question:").append(this.getText()).append("\n");
        sb.append("Options:\n");
        sb.append("1. Strongly Agree\n");
        sb.append("2. Agree\n");
        sb.append("3. Neither Agree nor Disagree\n");
        sb.append("4. Disagree\n");
        sb.append("5. Strongly Disagree\n");
        return sb.toString();
    }

}
