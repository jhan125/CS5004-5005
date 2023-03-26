/**
 * Name: Jiali Han
 * Project 02: Chess Pieces
 */

package chess;

/**
 * This class represents a position on the chess board.
 * Notice that instructions mentioned Rows decrease in number from top to bottom.
 * It has constructor to create a position and
 * methods to check two cells' positions
 * like samePosition(), isHorizontal(), is Diagonal, isVertical(),
 * isAhead(), isBehind(), isLPattern(), isOneSquare().
 */
public class Position {
    private int row;
    private int col;

    /**
     * This constructor creates the position for a chess piece by specifying the row and col
     *
     * @param row The row of the chess piece
     * @param col The col of the chess piece
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Return whether two chess pieces are in the same position.
     * If both row and col match, return true. Otherwise, return false.
     *
     * @param other The position of other chess piece
     * @return false if two positions are not the same, true otherwise
     */
    public boolean samePosition(Position other) {
        return (this.row == other.row && this.col == other.col);
    }

    /**
     * Returns whether two cells are vertical.
     *
     * @param other The position for the other cell
     * @return false if two cells are not vertical, true otherwise
     */
    public boolean isVertical(Position other) {
        if (samePosition(other)) {
            return false;
        }
        return this.col == other.col && this.row != other.row;
    }

    /**
     * Returns whether two cells are horizontal.
     *
     * @param other The position for the other cell
     * @return false if two cells are not horizontal, true otherwise
     */
    public boolean isHorizontal(Position other) {
        if (samePosition(other)) {
            return false;
        }
        return this.col != other.col && this.row == other.row;
    }

    /**
     * Returns whether other cell is one place forward this chess.
     *
     * @param other The position for the other cell
     * @return false if other cell is not ahead, true otherwise
     */
    public boolean isAhead(Position other) {
        if (samePosition(other)) {
            return false;
        }
        return (this.col == other.col) && (other.row - this.row == 1);
    }

    /**
     * Returns whether other cell is one backward this cell.
     *
     * @param other The position for the other chess piece
     * @return false if other cell is not one backward, true otherwise
     */
    public boolean isBehind(Position other) {
        if (samePosition(other)) {
            return false;
        }
        return (this.col == other.col) && (other.row - this.row == -1);
    }

    /**
     * Returns whether two cells are diagonal.
     *
     * @param other The position for the other cell
     * @return false if two cells are not diagonal, true otherwise
     */
    public boolean isDiagonal(Position other) {
        if (samePosition(other) || isHorizontal(other) || isVertical(other)) {
            return false;
        }
        return (Math.abs(this.row - other.row) == Math.abs(this.col - other.col));
    }

    /**
     * Returns whether two cells are in an L pattern.
     *
     * @param other The position for the other cell
     * @return false if two cells are not in L pattern, true otherwise
     */
    public boolean isLPattern(Position other) {
        if (samePosition(other)) {
            return false;
        }
        boolean L1 = (Math.abs(this.row - other.row) == 1) && (Math.abs(this.col - other.col) == 2);
        boolean L2 = (Math.abs(this.row - other.row) == 2) && (Math.abs(this.col - other.col) == 1);
        return (L1 || L2);
    }

    /**
     * Returns whether other cell is one place forward diagonally to this cell.
     *
     * @param other The position for the other cell
     * @return false if not one place forward diagonally, true otherwise
     */
    public boolean isOneDiag(Position other) {
        if (samePosition(other)) {
            return false;
        }
        return (Math.abs(this.row - other.row) == 1) && (Math.abs(this.col - other.col) == 1);
    }

    /**
     * Returns whether two cells are in an one square in any direction (horizontally, vertically, or diagonally)
     *
     * @param other The position for the other cell
     * @return false if two cells are not in one square, true otherwise
     */
    public boolean isOneSquare(Position other) {
        if (samePosition(other)) {
            return false;
        }
        boolean oneLeft = (this.row == other.row) && (other.col - this.col == -1);
        boolean oneRight = (this.row == other.row) && (other.col - this.col == 1);
        return (oneLeft || oneRight || isOneDiag(other) || isAhead(other) || isBehind(other));
    }
}
