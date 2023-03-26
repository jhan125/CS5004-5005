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
 * This is a class that test constructor and all methods in class Pawn.
 */
class PawnTest {

    private Pawn p1;
    private Pawn p2;

    /**
     * Setup two Pawn instances for tests.
     */
    @BeforeEach
    public void setUp() {
        p1 = new Pawn(1, 6, Color.WHITE);
        p2 = new Pawn(6, 3, Color.BLACK);
    }

    /**
     * Test whether Pawn constructor works properly.
     */
    @Test
    public void testPawn() {
        Pawn p1 = new Pawn(1, 6, Color.WHITE);
        Pawn p2 = new Pawn(6, 3, Color.BLACK);
    }

    /**
     * Test whether Pawn constructor handles exception properly.
     */
    @Test
    public void testPawnException() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> new Pawn(8, 3, Color.WHITE), "Expected to throw IllegalArgumentException, but it didn't.");
    }
    /**
     * Test whether getRow() method works properly.
     */
    @Test
    public void testGetRow() {
        assertEquals(1, p1.getRow());
        assertEquals(6, p2.getRow());
    }

    /**
     * Test whether getColumn() method works properly.
     */
    @Test
    public void testGetColumn() {
        assertEquals(6, p1.getColumn());
        assertEquals(3, p2.getColumn());
    }

    /**
     * Test whether getColor() method works properly.
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.WHITE, p1.getColor());
        assertEquals(Color.BLACK, p2.getColor());
    }

    /**
     * Test whether startPosition() method works properly.
     */
    @Test
    public void startPosition() {
        // Test case 1: when p1 changes the col
        assertTrue(p1.startPosition());
        p1.col = 1;
        assertFalse(p1.startPosition());
        // reset p1 to original position
        p1.col = 6;

        // Test case 2: when p2 changes the row
        assertTrue(p2.startPosition());
        p2.row = 1;
        assertFalse(p2.startPosition());
        // reset p2 to original position
        p2.row = 6;
    }

    /**
     * Test whether validPosition() method works properly.
     */
    @Test
    public void testValidPosition() {
        assertTrue(p1.validPosition(p1.getRow(), p1.getColumn()));
        assertTrue(p2.validPosition(p2.getRow(), p2.getColumn()));
    }

    /**
     * Test whether canMove() method works properly.
     * A pawn can move only “ahead,” not backwards towards where its color started.
     * It can move only one place forward in its own column
     * (except the first time it moves: it can move one or two places forward).
     */
    @Test
    public void testCanMove() {
        // p1 = new Pawn(1, 6, Color.WHITE);
        // p2 = new Pawn(6, 3, Color.BLACK);
        assertTrue(p1.canMove(3, 6));
        assertTrue(p1.canMove(2, 6));
        assertTrue(p2.canMove(5, 3));
        assertTrue(p2.canMove(4, 3));
        assertFalse(p1.canMove(1, 7));
        assertFalse(p1.canMove(-1, 7));
        assertFalse(p1.canMove(0, 6));
        assertFalse(p2.canMove(6, 2));
        assertFalse(p2.canMove(5, 2));
        assertFalse(p2.canMove(7, 3));
    }

    /**
     * Test whether canKill() method works properly.
     */
    @Test
    public void testCanKill() {
        // p1 (1, 6, Color.WHITE);
        // p2 (6, 3, Color.BLACK);

        // Test case 1: different color && killMove() == True --> canKill() == True
        ChessPiece c1 = new Bishop(2, 5, Color.BLACK);
        ChessPiece c2 = new King(2, 7, Color.BLACK);
        assertTrue(p1.canKill(c1));
        assertTrue(p1.canKill(c2));

        // Test case 2: different color && killMove() == False --> canKill() == False
        ChessPiece c3 = new Bishop(1, 5, Color.BLACK);
        ChessPiece c4 = new King(2, 6, Color.BLACK);
        assertFalse(p1.canKill(c3));
        assertFalse(p1.canKill(c4));

        // Test case 3: same color && killMove() == True --> canKill() == False
        ChessPiece c5 = new Bishop(5, 2, Color.BLACK);
        ChessPiece c6 = new King(5, 4, Color.BLACK);
        assertFalse(p2.canKill(c5));
        assertFalse(p2.canKill(c6));

        // Test case 4: diff color && killMove() == False --> canKill() == False
        ChessPiece c7 = new Bishop(7, 3, Color.WHITE);
        ChessPiece c8 = new King(6, 2, Color.WHITE);
        assertFalse(p2.canKill(c7));
        assertFalse(p2.canKill(c8));
    }
}