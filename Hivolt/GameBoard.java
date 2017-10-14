import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import java.util.Random;

	public class GameBoard extends JFrame implements KeyListener{
		
		//variables
		static int sizer = 700;
		static Color brightPink = new Color(255,20,147);
		public static Random rand = new Random();
		
		//variables that represent the actual positions of the x coordinates on the grid
		//used in xPoints array
		static int x1 = 154;
		static int x2 = 187;
		static int x3 = 220;
		static int x4 = 253;
		static int x5 = 286;
		static int x6 = 319;
		static int x7 = 352;
		static int x8 = 385;
		static int x9 = 418;
		static int x10 = 451;
		static int x11 = 484;
		static int x12 = 517;
		
		
		//variables that represent the actual positions of the y coordinates on the grid
		//used in yPoints array
		static int y1 = 199;
		static int y2 = 232;
		static int y3 = 265;
		static int y4 = 298;
		static int y5 = 331;
		static int y6 = 364;
		static int y7 = 397;
		static int y8 = 430;
		static int y9 = 463;
		static int y10 = 496;
		static int y11 = 529;
		static int y12 = 562;

		
		//Arrays that hold all possible locations for characters and tiles
		static int[] xPoints = {x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12};
		static int[] yPoints = {y1, y2, y3, y4, y5, y6, y7, y8, y9, y10, y11, y12};
		static int randomXPoint = rand.nextInt(xPoints.length);
		static int randomYPoint = rand.nextInt(yPoints.length);
		
		//Variables for moving characthers around (Erick)
		Player p;
		Fences fence;
		Monster monsters;
		Boolean alreadyRan = false;
		
		//method that initializes the rest of the drawings
		public GameBoard () {
			this.addKeyListener(this);
			init();
		}
		
		//method to move charachters (Erick)
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			//System.out.println("our player is at x= "+ p.getX()+ " and y="+p.getY());
			//If else statement to coordinate key pressing with player movement
			if(key == KeyEvent.VK_D) {
				p.setX(p.getX() + 33);
				repaint();
			} else if(key == KeyEvent.VK_A) {
				p.setX(p.getX() - 33);
				repaint();
			} else if (key == KeyEvent.VK_Q) {
				p.setX(p.getX() - 33);
				p.setY(p.getY() - 33);
				repaint();
			} else if (key == KeyEvent.VK_E) {
				p.setX(p.getX() + 33);
				p.setY(p.getY() - 33);	
				repaint();
			} else if (key == KeyEvent.VK_Z) {
				p.setX(p.getX() - 33);
				p.setY(p.getY() + 33);	
				repaint();
			} else if (key == KeyEvent.VK_C) {
				p.setX(p.getX() + 33);
				p.setY(p.getY() + 33);
				repaint();
			} else if(key == KeyEvent.VK_X) {
				p.setY(p.getY() + 33);
				repaint();
			} else if(key == KeyEvent.VK_S) {
				repaint();
			} else if(key == KeyEvent.VK_W) {
				p.setY(p.getY() - 33);
				repaint();
			} else if (key == KeyEvent.VK_R) {
				repaint();
			}
			
		}
		//sets the dimensions of the whole game and colors background black
		public void init() {
			setSize(sizer, sizer + 23);
			setBackground(Color.black);
		}
		
		//Method to create random location coordinates (Hunter)
		public void coordRando() {
			randomXPoint = rand.nextInt(xPoints.length);
			randomYPoint = rand.nextInt(yPoints.length);
		}
		
		//method that checks players are not in fence border (Hunter)
		public void coordChecker() {
//			System.out.println(getX());
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
		} else if (randomXPoint == getX()) {
//			System.out.println(getX());
			coordRando();
			coordChecker();
			}
		else if (randomYPoint == getY()) {
			coordRando();
			coordChecker();
		}
		}
		
		//method where grid is created
		public void paint(Graphics g) {
			//David did this code
			
			//this sets the background color as black
			paintBackground(g);
			
			//Paint the Tiles
			paintTiles(g);
			
			//Replay Button Creation
			paintReplay(g);
			
			//Creates Hivolt Title
			paintTitle(g);
			
			//creates fence border
			paintBorder(g);
			
			//creates 20 interior fences
			//create random positioning of all 20 interior fences
			if (!this.alreadyRan) {
				System.out.println(this.alreadyRan);
				Fences fence = new Fences(randomXPoint,randomYPoint,g);
				Player player = new Player(randomXPoint,randomYPoint,g);
				Monster ohm = new Monster(randomXPoint,randomYPoint);
				this.fence = fence;
				this.p = player;
				this.monsters = ohm;

			}
			this.fence.paintFences(g);
			this.alreadyRan = true;
			//creates 12 mhos
			//create random positioning of 12 mhos
			this.monsters.paintMonsters(g);
			
			//creates random you character
			//create random position of you character
			this.p.paintPlayers(g);
			//this.p = player;
			
		}   
		
		//Method used to paint background black and lay down pink boarder surrounding tiles (David)
		public void paintBackground(Graphics g){
			 g.setColor(Color.black);
			 g.fillRect(0, 0, this.getWidth(), this.getHeight());
			//sets board background to pink
			g.setColor(brightPink);
			//sizes the board background
			g.fillRect(sizer*7/32, (sizer*1/4) + 23, (sizer*9/16) + 4, (sizer*9/16) + 4);
		}
		
		
		//Method that lays black tiles in correct position on top of pink boarder to create grid (HUnter)
		private void paintTiles(Graphics g) {
			//For loop that lays down 144 tiles
			for (int c = 0; c < 144; c++) {
				
				//sets color of tiles to be black
				g.setColor(Color.black);
				//if else block that places tiles in proper location
				//each if or else if statement corresponds to a new row
				if (c < 12) {
					g.fillRect((sizer * 7/32) + c *(sizer *9/192 + 1) + 1, (sizer * 1/4) + 24 , (sizer * 9/192), (sizer * 9/192));
				} else if (c < 24) {
					g.fillRect((sizer * 7/32) + (c-12) *(sizer *9/192 + 1) + 1, (sizer * 9/192) + (sizer * 1/4) + 25, (sizer * 9/192), (sizer * 9/192));
				} else if (c < 36) {
					g.fillRect((sizer * 7/32) + (c-24) *(sizer *9/192 + 1) + 1, 2*(sizer * 9/192) + (sizer * 1/4) + 25 + 1, (sizer * 9/192), (sizer * 9/192));
				} else if (c < 48) {
					g.fillRect((sizer * 7/32) + (c-36) *(sizer *9/192 + 1) + 1, 3*(sizer * 9/192) + (sizer * 1/4) + 25 + 2, (sizer * 9/192), (sizer * 9/192));
				} else if (c < 60) {
					g.fillRect((sizer * 7/32) + (c-48) *(sizer *9/192 + 1) + 1, 4*(sizer * 9/192) + (sizer * 1/4) + 25 + 3, (sizer * 9/192), (sizer * 9/192));
				} else if (c < 72) {
					g.fillRect((sizer * 7/32) + (c-60) *(sizer *9/192 + 1) + 1, 5*(sizer * 9/192) + (sizer * 1/4) + 25 + 4, (sizer * 9/192), (sizer * 9/192));
				} else if (c < 84) {
					g.fillRect((sizer * 7/32) + (c-72) *(sizer *9/192 + 1) + 1, 6*(sizer * 9/192) + (sizer * 1/4) + 25 + 5, (sizer * 9/192), (sizer * 9/192));
				} else if (c < 96) {
					g.fillRect((sizer * 7/32) + (c-84) *(sizer *9/192 + 1) + 1, 7*(sizer * 9/192) + (sizer * 1/4) + 25 + 6, (sizer * 9/192), (sizer * 9/192));
				} else if (c < 108) {
					g.fillRect((sizer * 7/32) + (c-96) *(sizer *9/192 + 1) + 1, 8*(sizer * 9/192) + (sizer * 1/4) + 25 + 7, (sizer * 9/192), (sizer * 9/192));
				} else if (c < 120) {
					g.fillRect((sizer * 7/32) + (c-108) *(sizer *9/192 + 1) + 1, 9*(sizer * 9/192) + (sizer * 1/4) + 25 + 8, (sizer * 9/192), (sizer * 9/192));
				} else if (c < 132) {
					g.fillRect((sizer * 7/32) + (c-120) *(sizer *9/192 + 1) + 1, 10*(sizer * 9/192) + (sizer * 1/4) + 25 + 9, (sizer * 9/192), (sizer * 9/192));
				} else if (c < 144) {
					g.fillRect((sizer * 7/32) + (c-132) *(sizer *9/192 + 1) + 1, 11*(sizer * 9/192) + (sizer * 1/4) + 25 + 10, (sizer * 9/192), (sizer * 9/192));
				}
			}
			
		}

		//Method that draws replay instructions (Hunter)
		public void paintReplay(Graphics g) {
			g.setColor(Color.ORANGE);
			g.fillRect(sizer * 14/16, sizer * 15/16, sizer * 1/10, sizer * 1/20);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
			g.setColor(Color.BLACK);  
			g.drawString("Press R", sizer * 57/64 - 2, sizer * 31/32-2);
			g.drawString("to replay", sizer * 57/64 - 2, sizer * 31/32+10);
			
		}

		//method that paints title (hunter)
		public void paintTitle(Graphics g) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 130)); 
			g.setColor(Color.ORANGE); 
			g.drawString("HIVOLTS", sizer * 4/32, sizer * 3/16 + 23);
			
		}

		//method painting boarder
		private void paintBorder(Graphics g) {
			g.setColor(Color.yellow);
			for (int c = 0; c < 12; c++) {
				g.fillRect(x1 , yPoints[c] , (sizer * 9/192), (sizer * 9/192));
				g.fillRect(x12 , yPoints[c] , (sizer * 9/192), (sizer * 9/192));
				g.fillRect(xPoints[c], y1, (sizer * 9/192), (sizer * 9/192));
				g.fillRect(xPoints[c], y12, (sizer * 9/192), (sizer * 9/192));
			}
			
		}
		//auto generated method for Key Events (Erick)
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}


	}
		
	
