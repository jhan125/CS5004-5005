/**
 * Name: Jiali Han
 * Project 02: Chess Pieces
 */

package chess;

/**
 * This class represents Queen Chess Piece.
 * It inherits the AbstractChessPiece class.
 * It defines the canMove() method because
 * A queen can move horizontally, vertically and diagonally.
 */
public class Queen extends AbstractChessPiece {

    /**
     * This constructor creates a Queen chess piece by specifying the row, col, and color.
     * The types of row and col must be int, and the values of them should be checked
     * If the type specified does not match OR the value is not valid
     * throw an IllegalArgumentException
     *
     * @param row The initial row for the chess piece
     * @param col The initial int for the chess piece
     * @param color The initial color for the chess piece
     * @throws IllegalArgumentException if chess piece's position is not valid
     */
    public Queen(int row, int col, Color color) throws IllegalArgumentException {
        super(row, col, color);
    }

    /**
     * Determine if a queen can move to a given cell.
     * Since A queen can move horizontally, vertically and diagonally.
     *
     * @param row the row where the piece might be moved to.
     * @param col the column where the piece might be moved to.
     * @return True if queen can move to that location. False otherwise.
     */
    @Override
    public boolean canMove(int row, int col) {
        if (!validPosition(row, col)) {
            return false;
        }
        Position queen = new Position(this.getRow(), this.getColumn());
        Position other = new Position(row, col);
        return (queen.isHorizontal(other) || queen.isVertical(other) || queen.isDiagonal(other));
    }
}
