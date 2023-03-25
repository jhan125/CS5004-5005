/**
 * Lab 6: PriorityQueue w / Recursive Data Structure
 * Name: Jiali Han
 */

import cs5004.collections.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static cs5004.collections.ListPriorityQueue.createEmpty;

/**
 * This is the test class for ListPriorityQueue class.
 */
public class ListPriorityQueueTest {
    PriorityQueue PQ1; // non-empty PQ
    PriorityQueue PQ2; // empty PQ

    @Before
    public void setUp() {
        ListNode first = new ListNode(1, "node1", new EmptyNode());
        PQ1 = new ListPriorityQueue(first);
        PQ2 = new ListPriorityQueue(new EmptyNode());
    }

    /**
     * Test constructors for ListPriorityQueue
     */
    @Test
    public void testListPriorityQueue() {
        ListNode first = new ListNode(1, "node1", new EmptyNode());
        PQ1 = new ListPriorityQueue(first); // PQ1 = [(1, "node1")]
    }

    /**
     * Test createEmpty() method.
     */
    @Test
    public void testCreateEmpty() {
        PQ2 = createEmpty();
        Assert.assertTrue(PQ2.isEmpty());
    }

    /**
     * Test isEmpty() method.
     */
    @Test
    public void testIsEmpty() {
        Assert.assertTrue(PQ2.isEmpty());
        Assert.assertFalse(PQ1.isEmpty());
    }

    /**
     * Test exceptions of add() method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddException() {
        // case 1: when priority < 1
        PQ1.add(0, "node0");

        // case 2: when priority > 10
        PQ1.add(100, "node100");

        // case 3: when value is null
        PQ1.add(1, null);

        // case 4: when priority is null
        PQ1.add(null, "node");
    }

    /**
     * Test add() method.
     */
    @Test
    public void testAdd() {
        PriorityQueue update1 = PQ1.add(3, "node3");
        String expected = "Priority Queue: node3 -> node1 -> null";
        Assert.assertEquals(expected, update1.toString());

        PriorityQueue update2 = update1.add(4, "node4");
        expected = "Priority Queue: node4 -> node3 -> node1 -> null";
        Assert.assertEquals(expected, update2.toString());

        PriorityQueue update3 = update2.add(2, "node2");
        expected = "Priority Queue: node4 -> node3 -> node2 -> node1 -> null";
        Assert.assertEquals(expected, update3.toString());

        PriorityQueue update4 = update3.add(2, "node2 again");
        expected = "Priority Queue: node4 -> node3 -> node2 -> node2 again -> node1 -> null";
        Assert.assertEquals(expected, update4.toString());
    }

    /**
     * Test peek method.
     */
    @Test
    public void testPeek() throws EmptyPriorityQueueException {
        // "Priority Queue: node1 -> null";
        Assert.assertEquals("node1", PQ1.peek());

        PriorityQueue update1 = PQ1.add(3, "node3");
        // "Priority Queue: node3 -> node1 -> null";
        Assert.assertEquals("node3", update1.peek());

        PriorityQueue update2 = update1.add(4, "node4");
        // "Priority Queue: node4 -> node3 -> node1 -> null";
        Assert.assertEquals("node4", update2.peek());
    }

    /**
     * Test exceptions of peek() method.
     */
    @Test(expected = EmptyPriorityQueueException.class)
    public void testPeekException() throws EmptyPriorityQueueException{
        PQ2.peek();
    }

    /**
     * Test pop method.
     */
    @Test
    public void testPop() throws EmptyPriorityQueueException {
        PriorityQueue update1 = PQ1.add(3, "node3");
        PriorityQueue update2 = update1.pop();
        Assert.assertEquals("node1", update2.peek());
    }

    /**
     * Test exceptions of pop() method.
     */
    @Test(expected = EmptyPriorityQueueException.class)
    public void testPopException() throws EmptyPriorityQueueException{
        PQ2.pop();
    }

    /**
     * Test equals method.
     */
    @Test
    public void testEquals() {
        ListNode node = new ListNode(1, "node1", new EmptyNode());
        ListPriorityQueue pq1 = new ListPriorityQueue(node);
        ListPriorityQueue pq2 = new ListPriorityQueue(node);
        Assert.assertTrue(pq1.equals(pq2));
        Assert.assertTrue(pq1.hashCode() == pq2.hashCode());
    }
}
