/**
 * Lab 6: PriorityQueue w / Recursive Data Structure
 * Name: Jiali Han
 */

package cs5004.collections;

import java.util.Objects;


/**
 * This is a concrete class called ListPriorityQueue.
 * The implementation used my own recursive data structure with no use of Java's built-in collections.
 */
public class ListPriorityQueue implements PriorityQueue {
    private Node head;

    /**
     * This is a constructor to create a ListPriorityQueue.
     *
     * @param head head node in ListPriorityQueue
     */
    public ListPriorityQueue(Node head) {
        this.head = head;
    }

    /**
     * This is a method to create and return an empty PQ.
     * Special Note: the createEmpty method should be a public class method (static) in your concrete class.
     * It is NOT part of the PQ interface.
     *
     * @return an empty PQ
     */
    public static PriorityQueue createEmpty() {
        return new ListPriorityQueue(new EmptyNode());
    }

    @Override
    public Boolean isEmpty() {
        return this.head.isEmpty();
    }

    /**
     * Adds the given element (the priority and its associated value) to the PQ.
     * Your PQ should be ordered from highest to lowest priority.
     * If the nodes have the same priority treat the new node as if it's priority is lower than compared node.
     * For ex. if queue looks like this [ ( 2, "grape") ], then after adding a new node,
     * the queue should be ordered like [ (2, "grape"), (2, "apple") ]
     *
     * @param priority priority of the add element
     * @param value value of the add element
     * @return an updated PQ after adding this given element
     */
    @Override
    public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
        if (priority == null) {
            throw new IllegalArgumentException("Priority for the adding element cannot be null.");
        }
        if (priority < 1 || priority > 10) {
            throw new IllegalArgumentException("The range of acceptable values for PriorityNode should be between 1-10.");
        }
        if (value == null) {
            throw new IllegalArgumentException("Value for the adding element cannot be null.");
        }
        return new ListPriorityQueue(this.head.add(priority, value));
    }

    /**
     * Returns the value in the PQ that has the highest priority.
     * For two positive integers, i and j. If i < j then i has a lower priority than j.
     * After a call to peek() the PQ remains unchanged.
     * If there are multiple elements that have the same priority, return the value of the earliest added element.
     *
     * @return value in PQ with highest priority (head node's value)
     * @throws EmptyPriorityQueueException if calling peek() on an empty PQ
     */
    @Override
    public String peek() throws EmptyPriorityQueueException {
        if (this.isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        return head.peek();
    }

    /**
     * Returns a copy of the PQ without the element with the highest priority.
     *
     * @return copy of PQ with no head node (PQ.rest)
     * @throws EmptyPriorityQueueException if Calling pop() on an empty PQ
     */
    @Override
    public PriorityQueue pop() throws EmptyPriorityQueueException{
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        return new ListPriorityQueue(this.head.pop());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Priority Queue: ");
        ListPriorityQueue PQ = new ListPriorityQueue(this.head);
        while (!PQ.head.isEmpty()) {
            String value;
            try {
                value = PQ.head.peek();
            } catch (EmptyPriorityQueueException e) {
                throw new RuntimeException(e);
            }
            sb.append(value).append(" -> ");
            PQ.head = PQ.head.pop();
        }
        sb.append("null");
        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof ListPriorityQueue)) return false;
        ListPriorityQueue o = (ListPriorityQueue) other;
        return this.head.equals(o.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.head);
    }
}
