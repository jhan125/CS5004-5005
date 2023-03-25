/**
 * Lab 6: PriorityQueue w / Recursive Data Structure
 * Name: Jiali Han
 *
 * Reference:
 * [Objects.hashCode() vs Objects.hash() in Java]
 * https://www.baeldung.com/java-hashcode
 */
package cs5004.collections;
import java.util.Objects;

/**
 * This ListNode class implements Node interface and will be used to construct a list of nodes
 * where every node in this list contains two properties:
 * 1.    A priority - an Integer
 * 2.    A value associated with the priority - for this assignment, the value will be a String.
 */
public class ListNode implements Node {
    private Integer priority;
    private String value;
    private Node next;

    /**
     * This is a constructor to create a ListNode.
     *
     * @param priority for ListNode
     * @param value    for ListNode
     * @param next     next node in the ListNode
     * @throws IllegalArgumentException when priority or value is not acceptable or outside of range (1-10)
     */
    public ListNode(Integer priority, String value, Node next) throws IllegalArgumentException {
        if (priority == null) {
            throw new IllegalArgumentException("The priority for PriorityNode should not be null.");
        }
        if (priority < 1 || priority > 10) {
            throw new IllegalArgumentException("The range of acceptable values for PriorityNode should be between 1-10.");
        }
        if (value == null) {
            throw new IllegalArgumentException("The value for PriorityNode should not be null.");
        }
        this.priority = priority;
        this.value = value;
        this.next = next;
    }

    /**
     * Gets priority of ListNode.
     *
     * @return priority of ListNode
     */
    public Integer getPriority() {
        return this.priority;
    }

    /**
     * Gets value of ListNode.
     *
     * @return value of ListNode
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Gets next node of ListNode.
     *
     * @return next node of ListNode
     */
    public Node getNext() {
        return this.next;
    }

    /**
     * Checks if node is empty.
     *
     * @return true if node is empty, false otherwise.
     */
    @Override
    public Boolean isEmpty() {
        return false;
    }

    /**
     * Adds new node with priority and value to the current node.
     *
     * @param priority the value indicating the element order.
     * @param value    string form of element value.
     * @return INode class of object.
     * @throws IllegalArgumentException when priority or value is not acceptable or out of range
     */
    @Override
    public ListNode add(Integer priority, String value) throws IllegalArgumentException {
        if (priority == null || value == null) {
            throw new IllegalArgumentException("Priority or value cannot be null");
        }
        if (priority > 10 || priority < 1) {
            throw new IllegalArgumentException("Priority Value out of range");
        }

        if (this.isEmpty()) {
            return new ListNode(priority, value, this);
        }
        if (priority > this.priority) { // make new node as head node
            return new ListNode(priority, value, this);
        } else { // recursively add new node to next
            return new ListNode(this.priority, this.value, this.next.add(priority, value));
        }
    }

    /**
     * Returns value of the first list node.
     *
     * @return value of first node.
     */
    @Override
    public String peek() {
        return this.value;
    }

    /**
     * Returns the updated first node in the list node.
     *
     * @return updated first node
     */
    @Override
    public Node pop() {
        return getNext();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof Node)) return false;
        ListNode o = (ListNode) other;
        return this.getPriority().equals(o.getPriority())
                && this.getValue().equals(o.getValue())
                && this.next.equals(o.next);
    }

    @Override
    public int hashCode() {
        // Object.hashCode() method can retrieve the hashcode of an object if object is not null.
        // Objects.hash() can take one or more objects and provides a hashcode for them.
        // Under the hood, the hash() method works by putting the supplied objects into an array and calling Arrays.hashCode() on them.
        // If we provide only one object to the Objects.hash() method, we can't expect the same results as calling Objects.hashCode() on the object.
        return Objects.hash(value, priority, next);
    }
}
