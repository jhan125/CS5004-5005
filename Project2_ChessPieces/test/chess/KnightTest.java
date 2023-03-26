/**
 * Name: Jiali Han
 * Project 02: Chess Pieces
 */

package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This is a class that test constructor and all methods in class Knight.
 */
class KnightTest {
    private Knight k1;
    private Knight k2;

    /**
     * Setup two Knight instances for tests.
     */
    @BeforeEach
    public void setUp() {
        k1 = new Knight(0, 6, Color.WHITE);
        k2 = new Knight(7, 1, Color.BLACK);
    }

    /**
     * Test whether Knight constructor works properly.
     */
    @Test
    public void testKnight() {
        Knight k1 = new Knight(0, 6, Color.WHITE);
        Knight k2 = new Knight(7, 1, Color.BLACK);
    }

    /**
     * Test whether Knight constructor handles exception properly.
     */
    @Test
    public void testKnightException() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> new Knight(8, 3, Color.WHITE), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    /**
     * Test whether getRow() method works properly.
     */
    @Test
    public void testGetRow() {
        assertEquals(0, k1.getRow());
        assertEquals(7, k2.getRow());
    }

    /**
     * Test whether getColumn() method works properly.
     */
    @Test
    public void testGetColumn() {
        assertEquals(6, k1.getColumn());
        assertEquals(1, k2.getColumn());
    }

    /**
     * Test whether getColor() method works properly.
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.WHITE, k1.getColor());
        assertEquals(Color.BLACK, k2.getColor());
    }

    /**
     * Test whether validPosition() method works properly.
     */
    @Test
    public void testValidPosition() {
        assertTrue(k1.validPosition(k1.getRow(), k1.getColumn()));
        assertTrue(k2.validPosition(k2.getRow(), k2.getColumn()));
    }

    /**
     * Test whether canMove() method works properly.
     * A knight can move only in an L pattern.
     */
    @Test
    public void testCanMove() {
        // k1 = new Knight(0, 6, Color.WHITE);
        // k2 = new Knight(7, 1, Color.BLACK);
        assertTrue(k1.canMove(2, 5));
        assertTrue(k1.canMove(1, 4));
        assertTrue(k2.canMove(5, 0));
        assertTrue(k2.canMove(6, 3));
        assertFalse(k1.canMove(1, 5));
        assertFalse(k1.canMove(-1, 4));
        assertFalse(k1.canMove(4, 1));
        assertFalse(k2.canMove(0, 5));
        assertFalse(k2.canMove(0, 6));
        assertFalse(k2.canMove(1, 7));
    }

    /**
     * Test whether canKill() method works properly.
     */
    @Test
    public void testCanKill() {
        // k1 = new Knight(0, 6, Color.WHITE);
        // k2 = new Knight(7, 1, Color.BLACK);

        // Test case 1: different color && canMove() == True --> canKill() == True
        ChessPiece c1 = new Bishop(2, 5, Color.BLACK);
        ChessPiece c2 = new Queen(1, 4, Color.BLACK);
        assertTrue(k1.canKill(c1));
        assertTrue(k1.canKill(c2));

        // Test case 2: different color && canMove() == False --> canKill() == False
        ChessPiece c3 = new Bishop(1, 5, Color.BLACK);
        ChessPiece c4 = new Queen(4, 1, Color.BLACK);
        assertFalse(k1.canKill(c3));
        assertFalse(k1.canKill(c4));

        // Test case 3: same color && canMove() == True --> canKill() == False
        ChessPiece c5 = new Bishop(5, 0, Color.BLACK);
        ChessPiece c6 = new Queen(6, 3, Color.BLACK);
        assertFalse(k2.canKill(c5));
        assertFalse(k2.canKill(c6));

        // Test case 4: diff color && canMove() == False --> canKill() == False
        ChessPiece c7 = new Bishop(0, 6, Color.WHITE);
        ChessPiece c8 = new Queen(1, 7, Color.WHITE);
        assertFalse(k2.canKill(c7));
        assertFalse(k2.canKill(c8));
    }
}