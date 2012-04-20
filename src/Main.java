import javax.swing.JOptionPane;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// could add user input lines here and make 11 below the resulting
		// variable

		Board newBoard = new Board(showDialog());
		newBoard.setLocationCells(showShipDialog());

		// create gui object g and pass the new board
		Gui g = new Gui(newBoard.getBoard());

	}

	public static int showDialog() {
		Object[] possibilities = { "10", "15", "20" };

		String size = (String) JOptionPane.showInputDialog(null,
				"Choose board size: ", "Setup", JOptionPane.QUESTION_MESSAGE,
				null, possibilities, 10);
		return Integer.parseInt(size);
	}

	public static int showShipDialog() {
		Object[] possibilities = { "4", "6", "10" };

		String size = (String) JOptionPane.showInputDialog(null,
				"Choose number of ships: ", "Setup",
				JOptionPane.QUESTION_MESSAGE, null, possibilities, 4);
		return Integer.parseInt(size);
	}

}
