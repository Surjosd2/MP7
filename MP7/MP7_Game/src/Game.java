import java.util.Scanner;
public class Game {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		for (int boardNum = 0; boardNum < 1; boardNum++) {
			Board.printBoard(boardNum);
			while (Board.checkBoard(boardNum) == false) {
				int row = 0;
				int col = 0;
				char moveColour = '`';
				while ((row > 6) || (row <= 0)) {	//accept only 1 to 5
					System.out.print("Enter row number (1-5) or 0 to reset board: ");
					row = scanner.nextInt();
					System.out.println();
					if (row == 0) {
						Board.resetBoard(boardNum);
					}
				}
				while ((col > 6) || (col <= 0)) {	//accept only 1 to 5
					System.out.print("Enter column number (1-5): ");
					col = scanner.nextInt();
					System.out.println();
				}
				while (moveColour != 'R' && moveColour != 'G' && moveColour != 'B' && moveColour != 'Y' && moveColour != 'O') {
					System.out.print("Enter a colour (R, G, B, Y or O): ");
					moveColour = scanner.next().charAt(0);
					System.out.println();
				}
				Board.makeMove(boardNum, row, col, moveColour);
			}
		}
		System.out.println("You solved all boards");
		scanner.close();
	}

}
