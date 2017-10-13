import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends Character{
//Returns coordinates of the player so that player is able to move from current position (Erick and David)
	public Player(int xPoints, int yPoints,Graphics g) {
		
		super(xPoints, yPoints);
		coordRando();
		coordChecker();
		g.setColor(Color.blue);
		this.x = super.xPoints[randomXPoint];
		this.y = super.yPoints[randomYPoint];
				
		g.fillOval(this.x , this.y , (sizer * 9/192), (sizer * 9/192));

		}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}

