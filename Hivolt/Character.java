import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyListener;


public class Character extends GameBoard {
	
	//variables/arrays (David)
	static int[] yss = new int[33];
	static int[] xss = new int[33];
	
	//array lists used to store coordinate pairs of all characthers (David) 
	static ArrayList<Integer> xs = new ArrayList<Integer>();
	static ArrayList<Integer> ys = new ArrayList<Integer>();
	int[][] twodarray = new int[33][2];
	private Point location;
	public int y;
	public int x;
	int[] xFences = new int[20];
	int[] yFences = new int[20];
	
	//assigns coord pairs to a variable (Erick)
	public Character(int x, int y){
		this.x = x;
		this.y = y;
	}
	//This stores the x coord of the character
	public int getX(){
		return this.x;
	}
	//This stores the y coord of the character
	public int getY(){
		return this.y;
	}
	//this randomly select a Xpoint and a Ypoint.
	public void coordRando() {
		randomXPoint = rand.nextInt(xPoints.length);
		randomYPoint = rand.nextInt(yPoints.length);
	}
	//Character.addKeyListener(this);
	


	// Method that keeps players from being placed on the fence perimeter (Hunter)
	public void coordChecker(Character c) {
	int x;
	int y;
	if (randomXPoint == 0) {
		coordRando();
		coordChecker();
	} else if (randomXPoint == 11) {
		coordRando();
		coordChecker();
	} else if (randomYPoint == 0) {
		coordRando();
		coordChecker();
	} else if (randomYPoint == 11) {
		coordRando();
		coordChecker();
		System.out.println(randomYPoint);
	} else if (randomXPoint == location.getX() && randomYPoint == location.getY()) {
		coordRando();
		coordChecker();
		}
	}
	
	//Method that places fences in random coordinate location (Hunter)
	public void paintCharacters(Graphics g){
		for (int c = 0; c < 33; c++){
			coordRando();
			coordChecker();
			for (int m = 0; m < 12; m++) {
				coordRando();
				coordChecker();
				g.setColor(Color.red);
				//pulls a random index from array holding all possible coordinates
				g.fillOval(xPoints[randomXPoint] , yPoints[randomYPoint] , (sizer * 9/192), (sizer * 9/192));
				xs.add(randomXPoint);
				ys.add(randomYPoint);
			}
		}
	}
	

	//method that places mhos in random coordinate locations (Hunter)
	public void paintMonsters(Graphics g) {
		for (int c = 0; c < 12; c++) {
			coordRando();
			coordChecker();
			g.setColor(Color.red);
			//pulls a random index from array holding all possible coordinates
			g.fillOval(xPoints[randomXPoint] , yPoints[randomYPoint] , (sizer * 9/192), (sizer * 9/192));
			xs.add(randomXPoint);
			ys.add(randomYPoint);	
		}
	}
	
	
	//method that creates a player (Erick)
	public void paintPlayers(Graphics g) {
		coordRando();
		coordChecker();
		g.setColor(Color.blue);
		g.fillOval(this.x , this.y , (sizer * 9/192), (sizer * 9/192));

		xs.add(randomXPoint);
		ys.add(randomYPoint);
	}
	
	//method that creates interior fences in random spots (Erick)
	public void paintFences(Graphics g) {
		for (int c = 0; c < 20; c++) {
			coordRando();
			coordChecker();
			g.setColor(Color.yellow);
			g.fillRect(xFences[c] ,yFences[c] , (sizer * 9/192), (sizer * 9/192));
			xs.add(randomXPoint);
			ys.add(randomYPoint);
			
		}
	}
}





