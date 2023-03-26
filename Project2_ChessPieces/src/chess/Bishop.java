/**
 * Name: Jiali Han
 * Project 02: Chess Pieces
 */

package chess;

/**
 * This class represents Bishop Chess Piece.
 * It inherits the AbstractChessPiece class.
 * It defines the canMove() method because
 * a bishop can only move diagonally.
 */
public class Bishop extends AbstractChessPiece {

    /**
     * This constructor creates a bishop chess piece by specifying the row, col, and color.
     * The types of row and col must be int, and the values of them should be checked
     * If the type specified does not match OR the value is not valid
     * throw an IllegalArgumentException
     *
     * @param row The initial row for the chess piece
     * @param col The initial int for the chess piece
     * @param color The initial color for the chess piece
     * @throws IllegalArgumentException if chess piece's position is not valid
     */
    public Bishop(int row, int col, Color color) throws IllegalArgumentException {
        super(row, col, color);
    }

    /**
     * Determine if a bishop can move to a given cell.
     * Since bishop can only move diagonally.
     *
     * @param row the row where the piece might be moved to.
     * @param col the column where the piece might be moved to.
     * @return True if bishop can move to that location. False otherwise.
     */
    @Override
    public boolean canMove(int row, int col) {
        if(!validPosition(row, col)) {
            return false;
        }
        Position bishop = new Position(this.getRow(), this.getColumn());
        return bishop.isDiagonal(new Position(row, col));
    }
}
