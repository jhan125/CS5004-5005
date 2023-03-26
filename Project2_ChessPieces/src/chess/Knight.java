/**
 * Name: Jiali Han
 * Project 02: Chess Pieces
 */

package chess;

/**
 * This class represents Knight Chess Piece.
 * It inherits the AbstractChessPiece class.
 * It defines the canMove() method because
 * a knight can move only in an L pattern:
 * two cells horizontally and one vertically or vice versa.
 */
public class Knight extends AbstractChessPiece {

    /**
     * This constructor creates a knight chess piece by specifying the row, col, and color.
     * The types of row and col must be int, and the values of them should be checked
     * If the type specified does not match OR the value is not valid
     * throw an IllegalArgumentException
     *
     * @param row The initial row for the chess piece
     * @param col The initial int for the chess piece
     * @param color The initial color for the chess piece
     * @throws IllegalArgumentException if chess piece's position is not valid
     */
    public Knight(int row, int col, Color color) throws IllegalArgumentException {
        super(row, col, color);
    }

    /**
     * Determine if a knight can move to a given cell.
     * Since a knight can move only in an L pattern.
     *
     * @param row the row where the piece might be moved to.
     * @param col the column where the piece might be moved to.
     * @return True if knight can move to that location. False otherwise.
     */
    @Override
    public boolean canMove(int row, int col) {
        if(!validPosition(row, col)) {
            return false;
        }
        Position knight = new Position(this.getRow(), this.getColumn());
        return knight.isLPattern(new Position(row, col));
    }
}
