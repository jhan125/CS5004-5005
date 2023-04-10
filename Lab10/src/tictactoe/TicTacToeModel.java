/**
 * Name: Jiali Han
 * Lab10: Tic-Tac-Toe Model
 */
package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TicTacToeModel implements TicTacToe {
  // use this attribute to store current game state
  private final Player[][] board;
  // use this attribute to store current round of game
  private int round;

  /**
   * This constructor creates a TicTacToeModel with no arguments.
   * TicTacToe is played on a three-by-three grid with two players.
   * TicTacToe starts from round 1.
   */
  public TicTacToeModel() {
    board = new Player[3][3];
    round = 1;
  }

  /**
   * This is a helper method to check whether this position is valid on board.
   *
   * @param r the row of the intended move
   * @param c the column of the intended move
   * @return true if position is valid, false otherwise
   */
  public boolean isValid(int r, int c) {
    return (r >= 0 && r <= 2 && c >= 0 && c <= 2);
  }

  @Override
  public void move(int r, int c) {
    // case 1: if game is over
    if (isGameOver()) {
      throw new IllegalStateException("Game is over already.");
    }
    // case 2: if this position is not valid
    if (!isValid(r, c)) {
      throw new IllegalArgumentException("Position is invalid.");
    }
    // case 3: if this position is occupied
    if (board[r][c] != null) {
      throw new IllegalArgumentException("Position is occupied.");
    }
    // case 4: if this position is valid to move
    board[r][c] = getTurn();
    round++;
  }

  @Override
  public Player getTurn() {
    // {@link Player} X goes first.
    if (round % 2 != 0) {
      return Player.X;
    } else {
      return Player.O;
    }
  }

  @Override
  public boolean isGameOver() {
    // case 1: the board is full
    if (round == 10) {
      return true;
    }
    // case 2: if there's a winner
    return getWinner() != null;
  }

  @Override
  public Player getWinner() {
    // check if the player meets any winning conditions

    // check if any row has 3 same marks
    for (int row = 0; row < 3; row++) {
      if (getMarkAt(row, 0) != null
              && getMarkAt(row, 0) == getMarkAt(row, 1)
              && getMarkAt(row, 1) == getMarkAt(row, 2)) {
        return getMarkAt(row, 0);
      }
    }

    // check if any column has 3 same marks
    for (int col = 0; col < 3; col++) {
      if (getMarkAt(0, col) != null
              && getMarkAt(0, col) == getMarkAt(1, col)
              && getMarkAt(1, col) == getMarkAt(2, col)) {
        return getMarkAt(col, 0);
      }
    }

    // check if any diagonal has 3 same marks
    if (getMarkAt(1, 1) != null) {
      if (getMarkAt(0, 0) == getMarkAt(1,1)
              && getMarkAt(1, 1) == getMarkAt(2, 2)) {
        return getMarkAt(1, 1);
      }
      if (getMarkAt(0, 2) == getMarkAt(1, 1)
              && getMarkAt(2, 0) == getMarkAt(1, 1)) {
        return getMarkAt(1, 1);
      }
    }

    // if there's no winner, return null
    return null;
  }

  /**
   * This helper method checks if there are 3 same marks on the same row.
   * If yes, return true. False otherwise.
   *
   * @param player on the board
   * @return true if there're 3 same marks on the same row, false otherwise.
   */
  public boolean checkRow(Player player) {
    for (int row = 0; row < 3; row++) {
      if (getMarkAt(row, 0) != null
                && getMarkAt(row, 0) == getMarkAt(row, 1)
                && getMarkAt(row, 1) == getMarkAt(row, 2)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Player[][] getBoard() {
    // return a copy of current game state
    Player[][] copy = new Player[3][3];
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        copy[r][c] = board[r][c];
      }
    }
    return copy;
  }

  @Override
  public Player getMarkAt(int r, int c) {
    if (!isValid(r, c)) {
      throw new IllegalArgumentException("Position is invalid.");
    }
    return board[r][c];
  }


  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
        p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
          .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using
    // the helpful built-in String.join method.
    /**********
    List<String> rows = new ArrayList<>();
    for(Player[] row : getBoard()) {
      List<String> rowStrings = new ArrayList<>();
      for(Player p : row) {
        if(p == null) {
          rowStrings.add(" ");
        } else {
          rowStrings.add(p.toString());
        }
      }
      rows.add(" " + String.join(" | ", rowStrings));
    }
    return String.join("\n-----------\n", rows);
    ************/
  }
}
