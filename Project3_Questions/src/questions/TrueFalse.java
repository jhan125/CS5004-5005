/**
 * Name: Jiali Han
 * Project 03: Questions
 */

package questions;

/**
 * This class represents the TrueOrFalse class for Question.
 * It inherits from AbstractQuestion class and overrides answer(),compareTo(), compareToMultipleChoice() methods
 * A TrueOrFalse question can be created by passing the text of the question, the correct answer.
 * The only valid answer to this type of question is a "True" or "False".
 */
public class TrueFalse extends AbstractQuestion {
    private final String correctAnswer;

    /**
     * Constructs a TrueOrFalse object with the given text of the question, and
     * the correct answer (True or False)
     *
     * @param text   the text of the question
     * @param correct   the only correct answer of the question
     * @throws IllegalArgumentException If correctAnswer is null or empty or blank
     */
    public TrueFalse(String text, String correct) throws IllegalArgumentException{
        super(text);

        // case 1: when the question text for Constructor is invalid (null/empty/blank)
        if (!checkIfValid(correct)) {
            throw new IllegalArgumentException("Correct answer cannot be null or empty or blank.");
        }

        // case 2: when correctAnswer is not in True or False format
        if (correct.equals("True") || correct.equals("False")) {
            this.correctAnswer = correct;
        } else {
            throw new IllegalArgumentException("The only valid answer to this type of question is a True or False.");
        }
    }

    /**
     * Overrides the answer method for TrueOrFalse question.
     * The only valid answer to this type of question is a "True" or "False".
     *
     * @param answer the answer given
     * @return "Correct" if answer matches with correctAnswer.
     * @throws IllegalArgumentException If answer is invalid
     */
    @Override
    public String answer(String answer) throws IllegalArgumentException {
        // case 1: when answer is invalid (null/empty/blank)
        if (!checkIfValid(answer)) {
            throw new IllegalArgumentException("Answer cannot be null or empty or blank.");
        }

        // case 2: when answer is not in True or False format
//        if (!answer.equals("True") && !answer.equals("False")) {
//            throw new IllegalArgumentException("The only valid answer to this type of question is a True or False.");
//        }

        this.answer = answer;

        if (answer.equals(correctAnswer)) {
            return CORRECT;
        } else {
            return INCORRECT;
        }
    }

    /**
     * Returns the comparison result given a specific question type.
     *
     * @param question question to compare.
     * @return -1 if this is smaller than question, -1 if bigger, 0 if equal
     */
    @Override
    public int compareTo(Question question) {
        // if the questions are the same
        if (question.getText().equals(this.text)) {
            return 0;
        }

        if (question instanceof TrueFalse) {
            return this.compareToTrueFalse(question);
        } else {
            return ((AbstractQuestion)question).compareToTrueFalse(question);
        }
    }

    /**
     * Returns the comparison result with TrueOrFalse questions based on lexicographical order.
     *
     * @param question question to compare.
     * @return negative if this is smaller than question, positive if bigger, 0 if equal
     */
    @Override
    public int compareToTrueFalse(Question question) {
        return this.getText().compareTo(question.getText());
    }

    @Override
    public String toString() { // facilitate testing
        StringBuilder sb = new StringBuilder();

        sb.append("Question: ").append(this.getText()).append("\n");

        sb.append("Correct Answer: ").append(this.correctAnswer).append("\n");

        return sb.toString();
    }
}
