import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//Erick, class that lets the player move
public class move extends KeyAdapter{


	Player player;
	
	public move(Player player) {
		this.player = player;
	}
	
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
	}
}
