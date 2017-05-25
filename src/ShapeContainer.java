import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

public class ShapeContainer extends Container implements java.io.Serializable {
	public int s;
	
	public ShapeContainer () {
		super ();     
		setBackground (Color.white);
		s = 0;
	}
	
	public void paint(Graphics g) { // paint shape container
	   g.setColor(getBackground());
	   g.fillRect(0, 0, getWidth(), getHeight());
	   g.setColor (Color.black);
	   super.paint(g);
	   
	   // paint children components
	   int num = this.getComponentCount();
	   for(int i = 0;i < num;i++){
	      this.getComponents()[i].paint(g); // call children component's paint method
	   }
	}

	public Dimension getPreferredSize () {
		return new Dimension (300,300);
	}
}
