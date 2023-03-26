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
 * This is a class that test constructor and all methods in class Rook.
 */
class RookTest {
    private Rook r1;
    private Rook r2;

    /**
     * Setup two Rook instances for tests.
     */
    @BeforeEach
    public void setUp() {
        r1 = new Rook(0, 7, Color.WHITE);
        r2 = new Rook(7, 0, Color.BLACK);
    }

    /**
     * Test whether Rook constructor works properly.
     */
    @Test
    public void testRook() {
        Rook r1 = new Rook(0, 7, Color.WHITE);
        Rook r2 = new Rook(7, 0, Color.BLACK);
    }

    /**
     * Test whether Rook constructor handles exception properly.
     */
    @Test
    public void testRookException() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> new Rook(8, -3, Color.WHITE), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    /**
     * Test whether getRow() method works properly.
     */
    @Test
    public void testGetRow() {
        assertEquals(0, r1.getRow());
        assertEquals(7, r2.getRow());
    }

    /**
     * Test whether getColumn() method works properly.
     */
    @Test
    public void testGetColumn() {
        assertEquals(7, r1.getColumn());
        assertEquals(0, r2.getColumn());
    }

    /**
     * Test whether getColor() method works properly.
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.WHITE, r1.getColor());
        assertEquals(Color.BLACK, r2.getColor());
    }

    /**
     * Test whether validPosition() method works properly.
     */
    @Test
    public void testValidPosition() {
        assertTrue(r1.validPosition(r1.getRow(), r1.getColumn()));
        assertTrue(r2.validPosition(r2.getRow(), r2.getColumn()));
    }

    /**
     * Test whether canMove() method works properly.
     * A rook can move horizontally or vertically.
     */
    @Test
    public void testCanMove() {
        // r1 = new Rook(0, 7, Color.WHITE);
        // r2 = new Rook(7, 0, Color.BLACK);
        assertTrue(r1.canMove(0, 1));
        assertTrue(r1.canMove(7, 7));
        assertTrue(r2.canMove(7, 4));
        assertTrue(r2.canMove(4, 0));
        assertFalse(r1.canMove(1, 5));
        assertFalse(r1.canMove(-1, 4));
        assertFalse(r1.canMove(4, 1));
        assertFalse(r2.canMove(0, 5));
        assertFalse(r2.canMove(1, 6));
        assertFalse(r2.canMove(1, 8));
    }

    /**
     * Test whether canKill() method works properly.
     */
    @Test
    public void testCanKill() {
        // r1 = new Rook(0, 7, Color.WHITE);
        // r2 = new Rook(7, 0, Color.BLACK);

        // Test case 1: different color && canMove() == True --> canKill() == True
        ChessPiece c1 = new Bishop(0, 1, Color.BLACK);
        ChessPiece c2 = new Queen(7, 7, Color.BLACK);
        assertTrue(r1.canKill(c1));
        assertTrue(r1.canKill(c2));

        // Test case 2: different color && canMove() == False --> canKill() == False
        ChessPiece c3 = new Bishop(1, 5, Color.BLACK);
        ChessPiece c4 = new Queen(4, 1, Color.BLACK);
        assertFalse(r1.canKill(c3));
        assertFalse(r1.canKill(c4));

        // Test case 3: same color && canMove() == True --> canKill() == False
        ChessPiece c5 = new Bishop(7, 4, Color.BLACK);
        ChessPiece c6 = new Queen(4, 0, Color.BLACK);
        assertFalse(r2.canKill(c5));
        assertFalse(r2.canKill(c6));

        // Test case 4: diff color && canMove() == False --> canKill() == False
        ChessPiece c7 = new Bishop(1, 6, Color.WHITE);
        ChessPiece c8 = new Queen(3, 3, Color.WHITE);
        assertFalse(r2.canKill(c7));
        assertFalse(r2.canKill(c8));
    }

}