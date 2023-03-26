/**
 * Name: Jiali Han
 * Project 02: Chess Pieces
 */

package chess;

/**
 * This class represents pawn Chess Piece.
 * It inherits the AbstractChessPiece class.
 * It defines the canMove() and canKill() method.
 */
public class Pawn extends AbstractChessPiece {
    private int startRow;
    private int startCol;

    /**
     * This constructor creates a Pawn chess piece by specifying the row, col, and color.
     * The types of row and col must be int, and the values of them should be checked
     * If the type specified does not match OR the value is not valid
     * throw an IllegalArgumentException
     *
     * @param row The initial row for the chess piece
     * @param col The initial int for the chess piece
     * @param color The initial color for the chess piece
     * @throws IllegalArgumentException  when this Pawn is created in its royal row.
     * A royal row is row 0 to WHITE Pawns, and row 7 to BLACK Pawns.
     */
    public Pawn(int row, int col, Color color) throws IllegalArgumentException {
        super(row, col, color);
        this.startRow = row;
        this.startCol = col;
        if (color == Color.WHITE) {
            if (row == 0) {
                throw new IllegalArgumentException("Pawns cannot be created in the royal row.");
            }
        } else {
            if (row == 7) {
                throw new IllegalArgumentException("Pawns cannot be created in the royal row.");
            }
        }
    }

    /**
     * Returns whether this is a pawn's start position
     *
     * @return True it is the previous location. False otherwise.
     */
    public boolean startPosition() {
        return ((this.getRow() == startRow) && (this.getColumn() == startCol));
    }

    /**
     * Determine if a pawn can move to a given cell.
     * Since A pawn can move only “ahead,” not backwards towards where its color started.
     * It can move only one place forward in its own column
     * (except the first time it moves: it can move one or two places forward).
     *
     * @param row the row where the piece might be moved to.
     * @param col the column where the piece might be moved to.
     * @return True if pawn can move to that location. False otherwise.
     */
    @Override
    public boolean canMove(int row, int col) {
        if (!validPosition(row, col)) {
            return false;
        }
        Position pawn = new Position(this.getRow(), this.getColumn());
        Position other = new Position(row, col);
        // if color is white, pawn can move ahead
        if (this.getColor() == Color.WHITE) {
            boolean twoAhead = (row - this.row == 2 && this.col == col);
            // if this is the first time movement, a pawn can move one or two places forward
            if (startRow == 1) {
                return (twoAhead || pawn.isAhead(other));
            } else {
                return pawn.isAhead(other);
            }

        // if color is black, pawn can move behind
        } else {
            boolean twoBehind = (this.row - row == 2 && this.col == col);
            if (startRow == 6) {
                return (twoBehind || pawn.isBehind(other));
            } else {
                return pawn.isBehind(other);
            }
        }
    }

    /**
     * Returns whether a pawn can make this kill move.
     * To kill other chess, pawn must move one place forward diagonally
     * (it cannot kill by moving straight).
     *
     * @param row the row where the piece might be moved to.
     * @param col the column where the piece might be moved to.
     * @return True if pawn can kill other chess piece. False otherwise.
     */
    public boolean killMove(int row, int col) {
        if (!validPosition(row, col)) {
            return false;
        }
        Position pawn = new Position(this.getRow(), this.getColumn());
        Position other = new Position(row, col);
        // if color is white, pawn can move ahead
        if (this.getColor() == Color.WHITE) {
            boolean diagAhead = (row - this.row == 1 && Math.abs(col - this.col) == 1);
            return diagAhead;
            // if color is black, pawn can move behind
        } else {
            boolean diagBehind = (row - this.row == -1 && Math.abs(col - this.col) == 1);
            return diagBehind;
        }
    }

    /**
     * Returns whether a pawn can kill other cell.
     * To kill other chess, pawn must move one place forward diagonally
     * (it cannot kill by moving straight).
     *
     * @param piece the chess piece that might be killed.
     * @return True if pawn can kill other chess piece. False otherwise.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        boolean diffColor = !this.color.equals(piece.getColor());
        boolean killMove = killMove(piece.getRow(), piece.getColumn());
        return diffColor && killMove;
    }
}
