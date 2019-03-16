package noughtsandcrosses;

public class Board {
	public final static char NOUGHT = 'O';
	public final static char CROSS = 'X';
	public final static char EMPTY = ' ';

	// Each cell is indexed as follows:
	// 1 2 3
	// 4 5 6
	// 7 8 9
	private char[][] grid;         // a matrix to store the positions of the board
	private int numOfMarks;        // number of moves made on the board
	private int lastMarkPosition;  //position of last move made in the board
	
	public Board() {
		grid = new char[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				grid[row][col] = EMPTY;
			}
		}
		numOfMarks = 0;
		lastMarkPosition = 0;
	}

	
	//post: Returns true if the board is finished.
	//      A board is finished because either there is a winner or the board is full.
	public boolean isFinished() {
		return numOfMarks == 9 || getWinnerMark() != EMPTY;
	}

	//post: Records the position of the last mark made on the board. 
	public void setLastMarkPosition(int lastPosition){
		lastMarkPosition = lastPosition;
	}	
	
	//post: Returns the position of the last mark
	public int getLastMarkPosition(){
		return lastMarkPosition;
	}
	
	//post: Returns the mark ('X' or 'O') of the winner player if a winning condition exists in the board,
	//      returns EMPTY otherwise.
	public char getWinnerMark() {
		for (int i = 0; i < 3; i++) {
			// check if there are three in a horizontal row
			if (grid[i][0] != EMPTY && grid[i][0] == grid[i][1]
					&& grid[i][1] == grid[i][2]) {
				return grid[i][0];
			}

			// check if there are three in a vertical row
			if (grid[0][i] != EMPTY && grid[0][i] == grid[1][i]
					&& grid[1][i] == grid[2][i]) {
				return grid[0][i];
			}
		}

		// check if there are three in a diagonal row
		if (grid[1][1] != EMPTY
				&& (grid[1][1] == grid[0][0] && grid[1][1] == grid[2][2] || grid[1][1] == grid[0][2]
						&& grid[1][1] == grid[2][0])) {
			return grid[1][1];
		}

		// otherwise, return EMPTY as there is no winner
		return EMPTY;
	}

	
	//post: Sets the given mark at the given position in the board
	public void setMark(int pos, char mark) throws GameException {
		if (numOfMarks == 9) {
			throw new GameException("attempted to set mark on a full board.");
		}
		
		if (pos < 1 || pos > 9) {
			throw new GameException(
					"attempted to set mark in a wrong position: " + pos);
		}

		if (mark != NOUGHT && mark != CROSS) {
			throw new GameException("attempted to set an invalid mark: "
					+ String.valueOf(mark));
		}

		// perform board update
		int row = (pos - 1) / 3;
		int col = (pos - 1) % 3;

		if (grid[row][col] != EMPTY) {
			throw new GameException(
					"attempted to set mark on a non-empty position: "
							+ pos);
		} else {
			grid[row][col] = mark;
			numOfMarks++;
		}
	}
	
	
	//post: Returns the mark that is at a given position in the board
	public char getMark(int pos) {
		return grid[(pos-1)/3][(pos-1)%3];
	}
	
	
	//post: If the grid is not full, calculates whose turn is, based on the marks in the grid.
	//      Returns EMPTY if the board is already full.
	public char getTurn() {
		if (numOfMarks == 9) {
			return EMPTY;
		} else if (numOfMarks % 2 == 0) {
			// by default, CROSS should go first
			return CROSS;
		} else {
			return NOUGHT;
		}
	}


	//post: Copy the board and returns it
	public Board makeCopy() {
		Board copy = new Board();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				copy.grid[row][col] = this.grid[row][col];
			}
		}
		copy.numOfMarks = this.numOfMarks;
		
		return copy;
	}
	
	
	//post: Prints the given board
	public static void display(Board board) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.print(" ");
				char mark = board.grid[row][col];
				if (mark != EMPTY) {
					System.out.print(mark);
				} else {
					System.out.print((row)*3+(col+1));
				}
				System.out.print(" ");
				if (col < 2) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (row < 2) {
				System.out.println("-----------");
			}
		}
	}
}
