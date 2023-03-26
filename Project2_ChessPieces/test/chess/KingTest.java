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
 * This is a class that test constructor and all methods in class King.
 */
class KingTest {
    private King k1;
    private King k2;

    /**
     * Setup two King instances for tests.
     */
    @BeforeEach
    public void setUp() {
        k1 = new King(0, 3, Color.WHITE);
        k2 = new King(7, 3, Color.BLACK);
    }

    /**
     * Test whether King constructor works properly.
     */
    @Test
    public void testKing() {
        King k1 = new King(0, 3, Color.WHITE);
        King k2 = new King(7, 3, Color.BLACK);
    }

    /**
     * Test whether King constructor handles exception properly.
     */
    @Test
    public void testKingException() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> new King(-1, 3, Color.WHITE), "Expected to throw IllegalArgumentException, but it didn't.");
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
        assertEquals(3, k1.getColumn());
        assertEquals(3, k2.getColumn());
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
     */
    @Test
    public void testCanMove() {
        // k1 = new King(0, 3, Color.WHITE);
        // k2 = new King(7, 3, Color.BLACK);
        assertTrue(k1.canMove(1, 3));
        assertTrue(k1.canMove(0, 4));
        assertTrue(k2.canMove(7, 2));
        assertTrue(k2.canMove(6, 4));
        assertFalse(k1.canMove(1, 5));
        assertFalse(k1.canMove(4, 4));
        assertFalse(k1.canMove(-1, 3));
        assertFalse(k2.canMove(7, 3));
        assertFalse(k2.canMove(5, 2));
        assertFalse(k2.canMove(8, 3));
    }

    /**
     * Test whether canKill() method works properly.
     */
    @Test
    public void testCanKill() {
        // k1 = new King(0, 3, Color.WHITE);
        // k2 = new King(7, 3, Color.BLACK);

        // Test case 1: different color && canMove() == True --> canKill() == True
        ChessPiece c1 = new Bishop(1, 3, Color.BLACK);
        ChessPiece c2 = new Queen(0, 4, Color.BLACK);
        assertTrue(k1.canKill(c1));
        assertTrue(k1.canKill(c2));

        // Test case 2: different color && canMove() == False --> canKill() == False
        ChessPiece c3 = new Bishop(1, 5, Color.BLACK);
        ChessPiece c4 = new Queen(4, 4, Color.BLACK);
        assertFalse(k1.canKill(c3));
        assertFalse(k1.canKill(c4));

        // Test case 3: same color && canMove() == True --> canKill() == False
        ChessPiece c5 = new Bishop(7, 2, Color.BLACK);
        ChessPiece c6 = new Queen(6, 4, Color.BLACK);
        assertFalse(k2.canKill(c5));
        assertFalse(k2.canKill(c6));

        // Test case 4: diff color && canMove() == False --> canKill() == False
        ChessPiece c7 = new Bishop(5, 2, Color.WHITE);
        ChessPiece c8 = new Queen(7, 3, Color.WHITE);
        assertFalse(k2.canKill(c7));
        assertFalse(k2.canKill(c8));
    }
}