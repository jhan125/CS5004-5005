/**
 * Lab 6: PriorityQueue w / Recursive Data Structure
 * Name: Jiali Han
 */
package cs5004.collections;

/**
 * This is an interface for Node class.
 */
public interface Node {
    /**
     * Checks if node is empty
     * @return true if node is empty, false otherwise.
     */
    Boolean isEmpty();

    /**
     * Adds a new node with new priority and value.
     *
     * @param priority The new node's (non-negative) priority.
     * @param value The new node's value.
     * @return A copy of the node containing the new node
     */
    Node add(Integer priority, String value) throws IllegalArgumentException;

    /**
     * Gets the value of the first node.
     *
     * @return The value of the first node.
     */
    String peek() throws EmptyPriorityQueueException;

    /**
     * Removes the highest priority node.
     * @return rest of the nodes.
     */
    Node pop();
}
