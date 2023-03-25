/**
 * Lab 6: PriorityQueue w / Recursive Data Structure
 * Name: Jiali Han
 */
package cs5004.collections;
import java.util.Objects;

/**
 * This ListNode class implements Node interface and will be used to construct an empty node
 */
public class EmptyNode implements Node {
    public EmptyNode() {}

    @Override
    public Boolean isEmpty() {return true;}

    @Override
    public Node add(Integer priority, String value) throws IllegalArgumentException {
        if (priority == null) {
            throw new IllegalArgumentException("Priority for the adding element cannot be null.");
        }
        if (priority < 1 || priority > 10) {
            throw new IllegalArgumentException("The range of acceptable values for PriorityNode should be between 1-10.");
        }
        if (value == null) {
            throw new IllegalArgumentException("Value for the adding element cannot be null.");
        }
        return new ListNode(priority, value, this);
    }

    @Override
    public String peek() {return null;}

    @Override
    public Node pop() {
        return null;
    }

    @Override
    public String toString() {return "EmptyNode";}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof EmptyNode)) return false;
        return true;
    }
}
