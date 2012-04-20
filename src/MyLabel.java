import java.awt.Label;


public class MyLabel extends Label{

	//extras I want to store with a label
	int hPos;
	int yPos;
	boolean isBoat;
	
	//constructor
	public MyLabel(String text, int horiz, int vert, boolean isShip) {
		this.hPos = horiz+1;
		this.yPos = vert+1;
		this.isBoat = isShip;
	}
	
	//getX coord
	public int getX(){
		return hPos;
	}
	
	//getY coord 
	public int getY(){
		return yPos;
	}
	
	//is the label a ship?(acutally is it 1/3 of a ship, ships are 3 blocks)
	public boolean isShip(){
		if (isBoat==true) return true;
		else return false;
	}

}
