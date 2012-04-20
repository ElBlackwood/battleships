import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GuiPanel extends JFrame {

	public GuiPanel(int[][] populateBoard) {
		super("Battleships");
		setSize(375, 275);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		int arrayLength = populateBoard.length;
		JPanel p = new JPanel(new GridLayout());
		JPanel p2 = new JPanel();
		

		
		
		for (int i = 0; i < arrayLength - 1; i++) {
			for (int j = 0; j < arrayLength - 1; j++) {
				if (populateBoard[i][j] == 1) {

					JLabel block = new JLabel("");
					block.setBackground(Color.GREEN);
					p.add(block);
					block.addMouseListener(new MouseClass());

				} else {

					JLabel block = new JLabel("");
					block.setBackground(Color.DARK_GRAY);
					p.add(block);
					block.addMouseListener(new MouseClass());
				}
			}

		}
		
		JLabel shotStatus = new JLabel("Fire Away");
		p2.add(shotStatus);
		
		add(p, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);

	}
	
	private class MouseClass implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (((Label) e.getSource()).getBackground() == Color.DARK_GRAY) {
				((Label) e.getSource()).setBackground(Color.BLUE);
				//shotResult.setText("Miss!");
			} else {
				((Label) e.getSource()).setBackground(Color.RED);
				//shotResult.setText("HIT!");
			}
			

		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

}
