
public class Board {

	static char[][][] boards = {{
		{'0','0','0','0','0','0','0'},
		{'0','R',' ','G',' ','Y','0'},
		{'0',' ',' ','B',' ','O','0'},
		{'0',' ',' ',' ',' ',' ','0'},
		{'0',' ','G',' ','Y',' ','0'},
		{'0',' ','R','B','O',' ','0'},
		{'0','0','0','0','0','0','0'}}};
	/**
	 * method to print current state of board
	 * @param boardNum the number of the board to print
	 */
	public static void printBoard(int boardNum) {
		System.out.println("  1 2 3 4 5");
		for (int i = 1; i < 6; i++) {
			System.out.print(i);
			for (int j = 1; j < 6; j++) {
				System.out.print(' ' +""+ boards [boardNum][i][j]);
			}
			System.out.println();
		}
	}
	/**
	 * method to make a move and print the board
	 * @param boardNum number of the board to change
	 * @param rowNum row of move
	 * @param colNum column of move
	 * @param move colour of move
	 */
	public static void makeMove (int boardNum, int rowNum, int colNum, char move) {
		if (boards[boardNum][rowNum][colNum] == ' ') {
			if ((move == boards[boardNum][rowNum-1][colNum]) || 
					(move == boards[boardNum][rowNum+1][colNum]) || 
					(move == boards[boardNum][rowNum][colNum+1]) || 
					(move == boards[boardNum][rowNum][colNum-1])) {
				boards[boardNum][rowNum][colNum] = move;
				printBoard(boardNum);
			} else {
				System.out.println("Colour played has to be connected to the same colour");
			}

		} else {
			System.out.println("Position played is not valid, must place colour at an empty spot. Try again.");
		}
		if (checkBoard(boardNum)) {
			System.out.println("Ayyo, board solved!");
		}
	}
	/**
	 * check for completion 
	 * @param boardNum number of board to check
	 * @return
	 */
	public static boolean checkBoard (int boardNum) {
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				int countConnected = 0;
				if (boards[boardNum][i][j] == boards[boardNum][i+1][j]) {
					countConnected++;
				}
				if (boards[boardNum][i][j] == boards[boardNum][i-1][j]) {
					countConnected++;
				}
				if (boards[boardNum][i][j] == boards[boardNum][i][j+1]) {
					countConnected++;
				}
				if (boards[boardNum][i][j] == boards[boardNum][i][j-1]) {
					countConnected++;
				}
				if ((countConnected != 1) && (countConnected != 2)) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * reset the given board
	 * @param boardNum board to reset
	 */
	public static void resetBoard(int boardNum) {
		char[][][] defBoards = {{{'0','0','0','0','0','0','0'},
			{'0','R',' ','G',' ','Y','0'},
			{'0',' ',' ','B',' ','O','0'},
			{'0',' ',' ',' ',' ','O','0'},
			{'0',' ','G',' ','Y',' ','0'},
			{'0',' ','R','B','O',' ','0'},
			{'0','0','0','0','0','0','0'}}};
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				boards[boardNum][i][j] = defBoards[boardNum][i][j];
			}
		}
		printBoard(boardNum);
	}
}

