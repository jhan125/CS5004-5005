/**
 * Project 4: Polynomials
 * Name: Jiali Han
 */


package polynomial;

/**
 * This class implements ListOfTerm interface.
 * It is used to create a single list node of the list.
 */
public class ListNode implements ListOfTerm {
    private Term term;
    private ListOfTerm rest;

    /**
     * This is a constructor to create a ListNode.
     *
     * @param term used to create a ListNode
     * @param rest rest of the list
     */
    public ListNode(Term term, ListOfTerm rest) {
        if (rest == null) {
            rest = new EmptyNode();
        }
        this.term = term;
        this.rest = rest;
    }

    /**
     * Takes in a coefficient, a power and add this term to polynomial.
     *
     * @param coefficient of the term
     * @param degree of the term
     * @return the resulting list of terms
     */
    @Override
    public ListOfTerm addTerm(int coefficient, int degree) throws IllegalArgumentException{
        // exception
        if (degree < 0) {
            throw new IllegalArgumentException("Power can't be negative!");
        }
        if (this.rest == null) {
            rest = new EmptyNode();
        }

        // valid case 1: when add term has higher power
        if (degree > term.getDegree()) {
            int termC = term.getCoefficient();
            int termP = term.getDegree();
            rest = rest.addTerm(termC, termP);
            term = new Term(coefficient, degree);
        } else if (degree == term.getDegree()) {
            // valid case 2: when add term has same power
            term = new Term(term.getCoefficient() + coefficient, degree);
        } else {
            // valid case 3: when add term has lower power
            rest = rest.addTerm(coefficient, degree);
        }
        return this;
    }

    @Override
    public Polynomial add(Polynomial other) {
        if (!(other instanceof PolynomialImpl)) {
            throw new IllegalArgumentException("Adding object must be the same concrete type as the Polynomial object.");
        }

        Polynomial res = other;

        int coefficient = this.term.getCoefficient();
        int power = this.term.getDegree();
        res.addTerm(coefficient, power);
        rest.add(res);

        return res;
    }

    @Override
    public int getCoefficient(int power) {
        if (power == this.term.getDegree()) {
            return this.term.getCoefficient();
        } else {
            return rest.getCoefficient(power);
        }
    }

    @Override
    public int getDegree() {
        return term.getDegree();
    }

    @Override
    public double evaluate(double x) {
        int power = term.getDegree();
        int coefficient = term.getCoefficient();
        double res = Math.pow(x, power) * coefficient;
        return res + rest.evaluate(x);
    }

    @Override
    public Term getTerm() {
        return term;
    }

    @Override
    public ListOfTerm getRest() {
        return rest;
    }

    @Override
    public boolean isSame(ListOfTerm t) {
        return term.equals(t.getTerm()) && rest.equals(t.getRest());
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ListOfTerm) {
            ListOfTerm t = (ListOfTerm) other;
            return this.toString().equals(t.toString());
        }
        return false;
    }

    @Override
    public String toString() {
        return term.toString() + rest.toString();
    }
}
