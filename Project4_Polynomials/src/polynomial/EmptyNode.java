/**
 * Project 4: Polynomials
 * Name: Jiali Han
 */

package polynomial;

/**
 * This class implements ListOfTerm interface and will be used to create the empty node of the list.
 * An empty node has no term with coefficient of 0 and power of 0.
 */
public class EmptyNode implements ListOfTerm {

    /**
     * This is a constructor to create an empty node.
     */
    public EmptyNode() {}

    @Override
    public ListOfTerm addTerm(int coefficient, int degree) throws IllegalArgumentException{
        // exception
        if (degree < 0) {
            throw new IllegalArgumentException("Power can't be negative!");
        }
        return new ListNode(new Term(coefficient, degree), this);
    }

    @Override
    public Polynomial add(Polynomial other) throws IllegalArgumentException{
        if (!(other instanceof PolynomialImpl)) {
            throw new IllegalArgumentException("Adding object must be the same concrete type as the Polynomial object.");
        }
        return other;
    }

    @Override
    public int getCoefficient(int power){
        return 0;
    }

    @Override
    public int getDegree(){
        return 0;
    }

    @Override
    public double evaluate(double x){
        return 0;
    }

    @Override
    public Term getTerm() {
        return null;
    }

    @Override
    public ListOfTerm getRest() {
        return null;
    }

    @Override
    public boolean isSame(ListOfTerm t) {
        return (t.getTerm() == null) && (t.getRest() == null);
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
        return "";
    }
}
