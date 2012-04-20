import java.util.Random;

public class Board {

	int theBoard[][];
	public static final int BLANK = 0;
	public static final int SHIP = 1;
	public static final int HIT = 2;
	public static final int MISS = 3;
	int boardDim;
	public static int noOfShips;

	public Board(int boardSize) {
		boardDim = boardSize;
		theBoard = new int[boardSize][boardSize];

		// blank board
		for (int i = 0; i < boardSize - 1; i++) {
			for (int j = 0; j < boardSize - 1; j++) {
				theBoard[i][j] = BLANK;
			}

		}

	}

	//put ships on the board
	void setLocationCells(int numberOfShips) {
		noOfShips = numberOfShips;
		for (int count = 0; count < numberOfShips; ) {
			Random r = new Random();
			int horizPosition = r.nextInt(boardDim);
			int vertPosition = r.nextInt(boardDim);
			int Direction = r.nextInt(2);
			if (Direction == 1) {
				// extend horizontally
				if ((horizPosition + 3) < boardDim) {
					if (theBoard[horizPosition][vertPosition] != SHIP
							&& theBoard[horizPosition + 1][vertPosition] != SHIP
							&& theBoard[horizPosition + 2][vertPosition] != SHIP) {
						theBoard[horizPosition][vertPosition] = SHIP;
						theBoard[horizPosition + 1][vertPosition] = SHIP;
						theBoard[horizPosition + 2][vertPosition] = SHIP;
						count++;
					} 
				} else {
					if (theBoard[horizPosition][vertPosition] != SHIP
							&& theBoard[horizPosition - 1][vertPosition] != SHIP
							&& theBoard[horizPosition - 2][vertPosition] != SHIP) {
						theBoard[horizPosition][vertPosition] = SHIP;
						theBoard[horizPosition - 1][vertPosition] = SHIP;
						theBoard[horizPosition - 2][vertPosition] = SHIP;
						count++;
					} 
				}
			} else if (Direction == 0) {
				// extend vertically
				if ((vertPosition + 3) < boardDim) {
					if (theBoard[vertPosition][vertPosition] != SHIP
							&& theBoard[vertPosition][vertPosition + 1] != SHIP
							&& theBoard[vertPosition][vertPosition + 2] != SHIP) {
						theBoard[vertPosition][vertPosition] = SHIP;
						theBoard[vertPosition][vertPosition + 1] = SHIP;
						theBoard[vertPosition][vertPosition + 2] = SHIP;
						count++;
					} 
				} else {
					if (theBoard[horizPosition][vertPosition] != SHIP
							&& theBoard[horizPosition][vertPosition - 1] != SHIP
							&& theBoard[horizPosition][vertPosition - 2] != SHIP) {
						theBoard[horizPosition][vertPosition] = SHIP;
						theBoard[horizPosition][vertPosition - 1] = SHIP;
						theBoard[horizPosition][vertPosition - 2] = SHIP;
						count++;
					}
					
				}
			}

		}
	}
	public int[][] getBoard(){
		return theBoard;
	}

	public void displayBoard() {
		System.out.print(boardDim);
		for (int i = 0; i < boardDim; i++) {
			System.out.println();
			for (int j = 0; j < boardDim; j++) {
				System.out.printf(" %s", theBoard[i][j]);
			}

		}
	}

}
