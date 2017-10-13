import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyListener;


public class Character extends GameBoard {
	static int[] yss = new int[33];
	static int[] xss = new int[33];
	
	static ArrayList<Integer> xs = new ArrayList<Integer>();
	static ArrayList<Integer> ys = new ArrayList<Integer>();
	int[][] twodarray = new int[33][2];
	private Point location;
	public int y;
	public int x;
	
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
	//Erick, NEED HELP!, tried to add KeyListener to make the code run.
	//Character.addKeyListener(this);
	


	// Erick, Create the variable p, to use it later
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
//		System.out.println(c.getX());
//		System.out.println(c.getY());
		coordRando();
		coordChecker();
		}
	}
	
	
	
	
	
	public void paintCharacters(Graphics g){
		for (int c = 0; c < 33; c++){
			coordRando();
			coordChecker();
			for (int m = 0; m < 12; m++) {
				coordRando();
				coordChecker();
				g.setColor(Color.red);
				g.fillOval(xPoints[randomXPoint] , yPoints[randomYPoint] , (sizer * 9/192), (sizer * 9/192));
				xs.add(randomXPoint);
				ys.add(randomYPoint);
//				System.out.println(xs);
//				System.out.println(ys);
				
				
				
			}
		}
	}
	

	
	public void paintMonsters(Graphics g) {
	

		for (int c = 0; c < 12; c++) {
			coordRando();
			coordChecker();
			g.setColor(Color.red);
			g.fillOval(xPoints[randomXPoint] , yPoints[randomYPoint] , (sizer * 9/192), (sizer * 9/192));
			xs.add(randomXPoint);
			ys.add(randomYPoint);
//			System.out.println(xs);
//			System.out.println(ys);
			
			
			
		}
	}

	public void paintPlayers(Graphics g) {
		coordRando();
		coordChecker();
		g.setColor(Color.blue);
		//g.fillOval(xPoints[randomXPoint] , yPoints[randomYPoint] , (sizer * 9/192), (sizer * 9/192));
		g.fillOval(this.x , this.y , (sizer * 9/192), (sizer * 9/192));

		xs.add(randomXPoint);
		ys.add(randomYPoint);
//		System.out.println(xs);
//		System.out.println(ys);
		
	}
	
	public void paintFences(Graphics g) {
		for (int c = 0; c < 20; c++) {
//			if(xs[c] =1){
//				
//			}
			coordRando();
			coordChecker();
			g.setColor(Color.yellow);
			g.fillRect(xPoints[randomXPoint] , yPoints[randomYPoint] , (sizer * 9/192), (sizer * 9/192));
			xs.add(randomXPoint);
			ys.add(randomYPoint);
//			System.out.println(xs);
//			System.out.println(ys);

		}
	}
// Erick, Use coord to move right, left, down, and up
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			p.setX(p.getX() + 5);
		} else if(key == KeyEvent.VK_LEFT) {
			p.setX(p.getX() - 5);
		} else if(key == KeyEvent.VK_DOWN) {
			p.setY(p.getY() + 5);
		} else if(key == KeyEvent.VK_UP) {
			p.setY(p.getY() - 5);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}	
	// Erick, I don't need keyReleased, only keyPressed 
	public static void main(String args[]){
//		
//		Monster ohn = new Monster(4,2);
//		//Player player = new Player(2,3);
//		Fences fence = new Fences(4,5);
//		System.out.println(ohn.getX());
//		//tell gameboard 
//		//System.out.println(player.getX());
//		System.out.println(fence.getY());
//		ArrayList<Character> monster = new ArrayList<Character>();
		}
	
}





