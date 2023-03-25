/**
 * Lab 6: PriorityQueue w / Recursive Data Structure
 * Name: Jiali Han
 */

package cs5004.collections;

/**
 * This is the class for EmptyPriorityQueueException.
 */
public class EmptyPriorityQueueException extends Exception{

    public EmptyPriorityQueueException() {
        super("The Priority Queue is empty.");
    }
}
