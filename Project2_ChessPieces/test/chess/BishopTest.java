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
 * This is a class that test constructor and all methods in class Bishop.
 */
class BishopTest {

    private Bishop b1;
    private Bishop b2;

    /**
     * Setup some Bishop instances for tests.
     */
    @BeforeEach
    public void setUp() {
        b1 = new Bishop(0, 5, Color.WHITE);
        b2 = new Bishop(7, 2, Color.BLACK);
    }

    /**
     * Test whether Bishop constructor works properly.
     */
    @Test
    public void testBishop() {
        b1 = new Bishop(0, 5, Color.WHITE);
        b2 = new Bishop(7, 2, Color.BLACK);
    }

    /**
     * Test whether Bishop constructor handles exception properly.
     */
    @Test
    public void testBishopException() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> new Bishop(-1, 9, Color.WHITE), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    /**
     * Test whether getRow() method works properly.
     */
    @Test
    public void testGetRow() {
        assertEquals(0, b1.getRow());
        assertEquals(7, b2.getRow());
    }

    /**
     * Test whether getColumn() method works properly.
     */
    @Test
    public void testGetColumn() {
        assertEquals(5, b1.getColumn());
        assertEquals(2, b2.getColumn());
    }

    /**
     * Test whether getColor() method works properly.
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.WHITE, b1.getColor());
        assertEquals(Color.BLACK, b2.getColor());
    }

    /**
     * Test whether validPosition() method works properly.
     */
    @Test
    public void testValidPosition() {
        assertTrue(b1.validPosition(b1.getRow(),b1.getColumn()));
        assertTrue(b2.validPosition(b2.getRow(),b2.getColumn()));
    }

    /**
     * Test whether canMove() method works properly.
     */
    @Test
    public void testCanMove() {
        // b1 = new Bishop(0, 5, Color.WHITE);
        // b2 = new Bishop(7, 2, Color.BLACK);
        assertTrue(b1.canMove(1, 6));
        assertTrue(b1.canMove(1, 4));
        assertTrue(b2.canMove(6, 1));
        assertTrue(b2.canMove(6, 3));
        assertFalse(b1.canMove(1, 5));
        assertFalse(b1.canMove(0, 4));
        assertFalse(b1.canMove(-1, 3));
        assertFalse(b2.canMove(7, 3));
        assertFalse(b2.canMove(6, 2));
        assertFalse(b2.canMove(-1, 3));
    }

    /**
     * Test whether canKill() method works properly.
     */
    @Test
    public void testCanKill() {
        // b1 = new Bishop(0, 5, Color.WHITE);
        // b2 = new Bishop(7, 2, Color.BLACK);

        // Test case 1: different color && canMove() == True --> canKill() == True
        ChessPiece c1 = new King(1, 6, Color.BLACK);
        ChessPiece c2 = new Queen(1, 4, Color.BLACK);
        assertTrue(b1.canKill(c1));
        assertTrue(b1.canKill(c2));

        // Test case 2: different color && canMove() == False --> canKill() == False
        ChessPiece c3 = new King(5, 3, Color.BLACK);
        ChessPiece c4 = new Queen(7, 3, Color.BLACK);
        assertFalse(b1.canKill(c3));
        assertFalse(b2.canKill(c4));

        // Test case 3: same color && canMove() == True --> canKill() == False
        ChessPiece c5 = new King(6, 1, Color.BLACK);
        ChessPiece c6 = new Queen(6, 6, Color.BLACK);
        assertFalse(b2.canKill(c5));
        assertFalse(b2.canKill(c6));

        // Test case 4: diff color && canMove() == False --> canKill() == False
        ChessPiece c7 = new King(1, 5, Color.WHITE);
        ChessPiece c8 = new Queen(0, 4, Color.WHITE);
        assertFalse(b2.canKill(c7));
        assertFalse(b2.canKill(c8));
    }
}