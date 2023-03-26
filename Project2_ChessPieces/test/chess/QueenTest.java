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
* This is a class that test constructor and all methods in class Queen.
 */
class QueenTest {
    private Queen q1;
    private Queen q2;

    /**
     * Setup two Queen instances for tests.
     */
    @BeforeEach
    public void setUp() {
        q1 = new Queen(0, 3, Color.WHITE);
        q2 = new Queen(7, 3, Color.BLACK);
    }

    /**
     * Test whether Queen constructor works properly.
     */
    @Test
    public void testQueen() {
        Queen q1 = new Queen(0, 3, Color.WHITE);
        Queen q2 = new Queen(7, 3, Color.BLACK);
    }

    /**
     * Test whether Queen constructor handles exception properly.
     */
    @Test
    public void testQueenException() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> new Queen(8, 3, Color.WHITE), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    /**
     * Test whether getRow() method works properly.
     */
    @Test
    public void testGetRow() {
        assertEquals(0, q1.getRow());
        assertEquals(7, q2.getRow());
    }

    /**
     * Test whether getColumn() method works properly.
     */
    @Test
    public void testGetColumn() {
        assertEquals(3, q1.getColumn());
        assertEquals(3, q2.getColumn());
    }

    /**
     * Test whether getColor() method works properly.
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.WHITE, q1.getColor());
        assertEquals(Color.BLACK, q2.getColor());
    }

    /**
     * Test whether validPosition() method works properly.
     */
    @Test
    public void testValidPosition() {
        assertTrue(q1.validPosition(q1.getRow(), q1.getColumn()));
        assertTrue(q2.validPosition(q2.getRow(), q2.getColumn()));
    }

    /**
     * Test whether canMove() method works properly.
     * A queen can move horizontally, vertically and diagonally.
     */
    @Test
    public void testCanMove() {
        // q1 = new Queen(0, 3, Color.WHITE);
        // q2 = new Queen(7, 3, Color.BLACK);
        assertTrue(q1.canMove(0, 0));
        assertTrue(q1.canMove(2, 1));
        assertTrue(q2.canMove(6, 4));
        assertTrue(q2.canMove(4, 0));
        assertFalse(q1.canMove(2, 4));
        assertFalse(q1.canMove(-1, 4));
        assertFalse(q1.canMove(1, 1));
        assertFalse(q2.canMove(6, 5));
        assertFalse(q2.canMove(5, 2));
        assertFalse(q2.canMove(6, 1));
    }

    /**
     * Test whether canKill() method works properly.
     */
    @Test
    public void testCanKill() {
        // q1 = new Queen(0, 3, Color.WHITE);
        // q2 = new Queen(7, 3, Color.BLACK);

        // Test case 1: different color && canMove() == True --> canKill() == True
        ChessPiece c1 = new Bishop(0, 0, Color.BLACK);
        ChessPiece c2 = new King(2, 1, Color.BLACK);
        assertTrue(q1.canKill(c1));
        assertTrue(q1.canKill(c2));

        // Test case 2: different color && canMove() == False --> canKill() == False
        ChessPiece c3 = new Bishop(2, 4, Color.BLACK);
        ChessPiece c4 = new King(1, 1, Color.BLACK);
        assertFalse(q1.canKill(c3));
        assertFalse(q1.canKill(c4));

        // Test case 3: same color && canMove() == True --> canKill() == False
        ChessPiece c5 = new Bishop(6, 4, Color.BLACK);
        ChessPiece c6 = new King(4, 0, Color.BLACK);
        assertFalse(q2.canKill(c5));
        assertFalse(q2.canKill(c6));

        // Test case 4: diff color && canMove() == False --> canKill() == False
        ChessPiece c7 = new Bishop(5, 2, Color.WHITE);
        ChessPiece c8 = new King(6, 7, Color.WHITE);
        assertFalse(q2.canKill(c7));
        assertFalse(q2.canKill(c8));
    }
}