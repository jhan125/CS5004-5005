/**
 * Lab 6: PriorityQueue w / Recursive Data Structure
 * Name: Jiali Han
 */

import cs5004.collections.EmptyNode;
import cs5004.collections.ListNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * I ensured unit tests are NOT created in the cs5004.collections package.
 * Therefore, these tests should have the same access as any external client.
 */

/**
 * This is the test class for ListNode class.
 */
public class ListNodeTest {
    ListNode node;
    ListNode test;

    @Before
    public void setUp() {
        node = new ListNode(1, "node1", new EmptyNode());
    }

    /**
     * Test constructor of ListNode
     */
    @Test
    public void testPriorityNode() {
        node = new ListNode(1, "node1", new EmptyNode());
    }

    /**
     * Test exception for ListNode constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPriorityNodeException() {
        // case 1: when priority < 1
        test = new ListNode(0, "node0", node);

        // case 2: when priority > 10
        test = new ListNode(100, "node100", node);

        // case 3: when value is null
        test = new ListNode(1, null, node);

        // case 4: when priority is null
        test = new ListNode(null, "node", node);
    }

    /**
     * Test getPriority method of ListNode class.
     */
    @Test
    public void testGetPriority() {
        Assert.assertEquals(1, node.getPriority(), 0.1);
    }

    /**
     * Test getValue method of ListNode class.
     */
    @Test
    public void testGetValue() {
        Assert.assertEquals("node1", node.getValue());
    }

    /**
     * Test add method of ListNode class.
     */
    @Test
    public void testAdd() {
        node = node.add(3, "node3");
        Assert.assertEquals("node3", node.peek());
        node = node.add(4, "node4");
        Assert.assertEquals("node4", node.peek());
        node = node.add(2, "node2");
        Assert.assertEquals("node4", node.peek());
        node = node.add(2, "node2 again");
        Assert.assertEquals("node4", node.peek());
        node = node.add(4, "node4again");
        Assert.assertEquals("node4", node.peek());

    }

    /**
     * Test peek method of ListNode class.
     */
    @Test
    public void testPeek() {
        node = node.add(3, "node3");
        Assert.assertEquals("node3", node.peek());
        node = node.add(4, "node4");
        Assert.assertEquals("node4", node.peek());
        node = node.add(2, "node2");
        Assert.assertEquals("node4", node.peek());
        node = node.add(2, "node2 again");
        Assert.assertEquals("node4", node.peek());
        node = node.add(4, "node4again");
        Assert.assertEquals("node4", node.peek());
    }

    /**
     * Test pop method of ListNode class.
     */
    @Test
    public void testPop() {
        EmptyNode empty = new EmptyNode();
        Assert.assertEquals(new EmptyNode(), node.pop());
        Assert.assertNull(empty.pop());
    }

    /**
     * Test equals method of ListNode class.
     */
    @Test
    public void testEquals() {
        ListNode node1 = new ListNode(1, "node1", node);
        ListNode node2 = new ListNode(1, "node1", node);
        Assert.assertTrue(node1.equals(node2) && node2.equals(node1));
        Assert.assertTrue(node1.hashCode() == node2.hashCode());
    }
}