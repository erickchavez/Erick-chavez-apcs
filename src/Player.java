import java.awt.event.KeyEvent;

public class Player extends Character{
//Erick chavez, give me the coordinates of the player
	public Player(int xPoints, int yPoints) {
		super(xPoints, yPoints);
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

