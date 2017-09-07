package flag;

import java.awt.*;
import javax.swing.JPanel;


public class Flag extends JPanel{

	Flag(){
		// sets preferred size when constructor is run
		setPreferredSize(new Dimension(750,390));
	};
	
	// This method returns the height of the window to be used in the other methods' calculations
	public double height() {
		double h = getHeight(); // gets height of window
		int w = getWidth(); 	// gets width of window
		
		h = (w/h < 1.9) ? w/1.9 : h;  // if the w/h ratio is less than 1.9, then the height is adjusted to be the width/1.9, otherwise, it stays the same
		return h; 
	}
	

	// paints the elements
	 public void paint(Graphics g){
		paintStripes(g); // invokes the stripes method to paint the stripes
		paintUnion(g); // invokes the union method to paint the union
		
		
		// the for loops below paint the two grids of stars, because the paintStar method only paints a single star.
		//The outer for loops are for the y axis, while the inner for loops are for the x axis
		
		for(int x=1; x<=9; x+=2) { 					// paints the outer grid
			double offsety = (height()*0.054)*x;	// defines the y offset(vertical) between the stars, multiplied by how many offsets needed (x)		
			for (int i=1; i<=11; i+=2) {			// paints the line of stars
				double offsetx = (height()*0.063)*i;	// the x offset, multiplied by how many offsets needed (i)					
				paintStar(g,offsetx, offsety);			// calls the paint method and passes the offsets into the parameter
			}
		}
		
		for (int x=2; x<=8; x+=2) {					// paints the inner grid
			double offsety = (height()*0.054)*x;
			for (int i=2; i<=10; i+=2) {			
				double offsetx = (height()*0.063)*i;
				paintStar(g, offsetx, offsety);
			}
		}
	 }

	 
	 private void paintStripes(Graphics g) {
		 	Color red = new Color(191,10,48);				// creates custom red color object
		 	final double width = (height()*1.9);	 		// makes the width always equal the height * 1.9
		 	final double heightStripe = (height()/13);		// makes the stripes' height be the height/13 
		 	for (int i=0; i<=12; i++){						// loops through for the number of stripes needed
		 		double offsety = i*heightStripe;			// the vertical offset is always the height of the stripe 
		 		
		 		// if statement alternates between red and white to paint the alternating red/white stripes
		 		if (i%2 == 0){								
		 			g.setColor(red);
		 		} else {
		 			g.setColor(Color.white);
		 		}
		 		g.fillRect(0,(int)offsety,(int)width,(int)heightStripe);
		 	}		
	 }
	 
	 
	 private void paintUnion(Graphics g){
		 final double height = height()*7/13; 	// sets height of union (ratio is 7/13)
		 final double width = height()*0.76;	// sets width of union
		 Color blue = new Color(0,40,104);		// creates blue color object
		 g.setColor(blue);
		 g.fillRect(0, 0, (int)width, (int)height);		// takes parameters of height and width that are casted to ints
	 }
	 
	 /*paints a single star based on the offsets that are passed into the parameters. 
	  * Uses trigonometric functions to calculate where each point is.
	  * */
	 private void paintStar(Graphics g, double offsetx, double offsety){
		 g.setColor(Color.white); 

		 // arrays to contain the x & y coordinates of the star
		 int[] xcoord = new int[10];		
		 int[] ycoord = new int[10];	
		 // loops through 10 times to add 10 points
		 for (int i=0; i<10; i++) {
			 double angle = (i-0.5) * (Math.PI*2 / 10);		// gives the angle of the circle to use (i-0.5 is used to rotate the star)
			 
			 // if i is even, then the outer radius is used, else the inner radius is used. it alternates between inner and outer radius
			 double radius = i % 2 == 0 ? height()*0.0616/2 : (height()*0.0616/2)/2.618;
			 xcoord[i] = (int) (Math.cos(angle)*radius + offsetx); // formulas to determine the x & y locations of the given points of star
			 ycoord[i] = (int) (Math.sin(angle)*radius + offsety);
		 }
		 
		 g.fillPolygon(xcoord, ycoord, 10);
	 }

}