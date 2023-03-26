/**
 * Name: Jiali Han
 * Project 02: Chess Pieces
 * Reference:
 * How to Move the Pieces?
 * https://www.chess.com/lessons/how-to-move-the-pieces
 */

package chess;

/**
 * This abstract class represents an abstract ChessPiece.
 * It contains common fields and implements the ChessPiece interface.
 */
public abstract class AbstractChessPiece implements ChessPiece {
    // make this field protected so it can be directly accessed or called
    // from a descendant class, but from nowhere else.
    protected Color color;
    protected int row;
    protected int col;

    /**
     * This constructor creates a chess piece by specifying the row, col, and color.
     * The types of row and col must be int, and the values of them should be checked
     * If the type specified does not match OR the value is not valid
     * throw an IllegalArgumentException
     *
     * @param row The initial row for the chess piece
     * @param col The initial col for the chess piece
     * @param color The initial color for the chess piece
     * @throws IllegalArgumentException if chess piece's position is not valid
     */
    public AbstractChessPiece(int row, int col, Color color) throws IllegalArgumentException {
        if (!validPosition(row, col)) {
            throw new IllegalArgumentException("You cannot create a chess piece outside the board boundaries.");
        }
        this.row = row;
        this.col = col;
        this.color = color;
    }

    /**
     * This helper method checks whether a chess piece has a valid position.
     * The types of row and col must be int, and the values of them should be within 0 to 7
     * If the type specified does not match OR the value is not valid
     * return false
     *
     * @param row The initial row for the chess piece
     * @param col The initial int for the chess piece
     * @return false if chess piece's position is not valid, true otherwise
     */
    public boolean validPosition(int row, int col) {
        return (row >= 0 && row <= 7 && col >= 0 && col <= 7);
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return col;
    }

    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Determine if the chess piece can move to a given cell.
     * Will be defined in subclasses given a specific chess piece.
     *
     * @param row the row where the piece might be moved to.
     * @param col the column where the piece might be moved to.
     * @return True if the piece can move to that location. False otherwise.
     */
    @Override
    public boolean canMove(int row, int col) {
        return false;
    }

    /**
     * Determine of the piece can kill another piece starting from its current location.
     * To kill other piece, this piece should have different color and can move to other piece's position.
     *
     * @param piece the piece that might be killed.
     * @return True if the new piece can be killed, false otherwise.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        boolean diffColor = !this.getColor().equals(piece.getColor());
        boolean canMove = canMove(piece.getRow(), piece.getColumn());
        return (diffColor && canMove);
    }
}
