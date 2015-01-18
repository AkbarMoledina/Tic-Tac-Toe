import java.util.Scanner;

public class TTT {
	private static int col, row;
	private static Scanner scan = new Scanner(System.in);
	private static char[][] board = new char[3][3];
	private static char turn = 'X';

	private static void play() {
		boolean playing = true;
		int counter = 1;
		while (playing) {
			printBoard();
			// Counter for detecting if the game is a draw
			counter++;
			do {
				System.out.println("Player " + turn + ". Enter a column and a row:");
				row = scan.nextInt() - 1;
				col = scan.nextInt() - 1;
			/* conditions to prevent numbers outside the range and 
				to prevent the user choosing an already occupied space */
			} while (row < 0 || row > 2 || col < 0 || col > 2 || board[col][row] == 'X' || board[col][row] == 'O');

			board[col][row] = turn;
			// Ending the game if someone wins
			if (gameOver(col, row)) {
				playing = false;
				printBoard();
				System.out.
				println("Player " + turn + " wins, ggwp!");
			}
			
			// Changing player turns at the end of a turn
			if (turn == 'X')
				turn = 'O';
			else
				turn = 'X';
			
			// Draw conditions
			if (counter > 9 && !gameOver(col, row)) {
				playing = false;
				printBoard();
				System.out.println("It's a draw!");
				}
		}
	}

	// Method for printing the board
	private static void printBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					System.out.print("| ");
				}
				System.out.print(board[i][j] + " | ");
			}
		}
		System.out.println();
	}

	// Winning conditions
	private static boolean gameOver(int cMove, int rMove) {
		if (board[cMove][0] == board[cMove][1]
				&& board[cMove][1] == board[cMove][2])
			return true;
		if (board[0][rMove] == board[1][rMove]
				&& board[1][rMove] == board[2][rMove])
			return true;
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]
				&& board[1][1] != '-')
			return true;
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]
				&& board[1][1] != '-')
			return true;
		return false;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';

			}
		}
		
		play();
	}
}