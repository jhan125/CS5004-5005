/**
 * Name: Jiali Han
 * Project 02: Chess Pieces
 */

package chess;

/**
 * This class represents King Chess Piece.
 * It inherits the AbstractChessPiece class.
 * It defines the canMove() method because
 * A king can move one square in any direction (horizontally, vertically, or diagonally)
 */
public class King extends AbstractChessPiece {

    /**
     * This constructor creates a King chess piece by specifying the row, col, and color.
     * The types of row and col must be int, and the values of them should be checked
     * If the type specified does not match OR the value is not valid
     * throw an IllegalArgumentException
     *
     * @param row The initial row for the chess piece
     * @param col The initial int for the chess piece
     * @param color The initial color for the chess piece
     * @throws IllegalArgumentException if chess piece's position is not valid
     */
    public King(int row, int col, Color color) throws IllegalArgumentException {
        super(row, col, color);
    }

    /**
     * Determine if a king can move to a given cell.
     * Since A king can move one square in any direction (horizontally, vertically, or diagonally)
     *
     * @param row the row where the piece might be moved to.
     * @param col the column where the piece might be moved to.
     * @return True if king can move to that location. False otherwise.
     */
    @Override
    public boolean canMove(int row, int col) {
        if (!validPosition(row, col)) {
            return false;
        }
        Position king = new Position(this.getRow(), this.getColumn());
        Position other = new Position(row, col);
        return (king.isOneSquare(other));
    }
}
