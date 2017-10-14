import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Fences extends Character{
		//Constructor for fence locations (David)
	public Fences(int xPoints, int yPoints,Graphics g) {
		super(xPoints, yPoints);
// (Erick)
		for (int c = 0; c < 20; c++) {
			coordRando();
			coordChecker();
			g.setColor(Color.yellow);
			xFences[c] = super.xPoints[randomXPoint];
			yFences[c] = super.yPoints[randomYPoint];
			g.fillRect(xFences[c] ,yFences[c] , (sizer * 9/192), (sizer * 9/192));
			xs.add(randomXPoint);
			ys.add(randomYPoint);
	}
	}
}

