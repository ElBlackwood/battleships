import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame {

	private JLabel shotResult;
	public int hitCount=0;	//counts hits
	int max;

	public Gui(int[][] populateBoard) {
		 
		//set up window
		super("Luke and Cal's Battleships");
		max = 3* Board.noOfShips;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
		setResizable(false);
		//sets game board in the middle of the screen
		setLocationRelativeTo(null);

		int arrayLength = populateBoard.length+1;
		//initailize status bar
		shotResult = new JLabel("Fire Away!");

		//setup new panel with a gridlayout
		JPanel p = new JPanel(new GridLayout(arrayLength, arrayLength, 2, 2));
		//setup another panel with normal layout
		JPanel status = new JPanel();
		
		//add label to status panel
		status.add(shotResult);

		
		for (int i = 0; i < arrayLength - 1; i++) {
			for (int j = 0; j < arrayLength - 1; j++) {
				if (populateBoard[i][j] == 1) {
					//create a MyLabel, no text, i and j are also coords, true means its a ship
					MyLabel block = new MyLabel("", i, j, true);			
					block.setBackground(Color.DARK_GRAY);
					//add block to the pane p
					p.add(block);
					//add mouse listener to this block
					block.addMouseListener(new MouseClass());

				} else {
					MyLabel block = new MyLabel("", i, j, false);
					block.setBackground(Color.DARK_GRAY);
					p.add(block);
					block.addMouseListener(new MouseClass());
				}
			}

		}
		//add panes to the frame ie JFrame(the class we extended)
		add(p, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);

	}

	//Mouse Listener Class
	private class MouseClass implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			
			if (hitCount>=max){
				shotResult.setText("CONGRATULATIONS!  YOU SUNK MY BATTLESHIPs");
				
				return;}
			
			
			
			if (!((MyLabel) e.getSource()).isShip()) {
				if(((MyLabel) e.getSource()).getBackground()==Color.BLUE){
					
					shotResult.setText("Already Fired Here");
				}else{
				((MyLabel) e.getSource()).setBackground(Color.BLUE);
				shotResult.setText("Miss! at "
						+ ((MyLabel) e.getSource()).getX() + ","
						+ ((MyLabel) e.getSource()).getY());
				}
			} else {
				if(((MyLabel) e.getSource()).getBackground()==Color.RED){
					
					shotResult.setText("Already Fired Here");
				}
				
				else{
				
				hitCount++;
				((MyLabel) e.getSource()).setBackground(Color.RED);
				((MyLabel) e.getSource()).getY();
				shotResult.setText("HIT! at "
						+ ((MyLabel) e.getSource()).getX() + ","
						+ ((MyLabel) e.getSource()).getY());
				//no more ships, winner!
				if (hitCount==max){
					shotResult.setText("CONGRATULATIONS!  YOU SUNK MY BATTLESHIPs");}
				}
			}

		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}

}
