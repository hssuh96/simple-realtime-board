import java.awt.*;

public class Rectangular extends Shape {

	public Rectangular (Point a1, Point a2) {
		super (a1, a2);
	}
	public Object clone () {
		Rectangular l = new Rectangular (p1,p2);
		return l;
	}
	public void paint (Graphics g) {
	   super.paint(g,super.RECT); // call parent's paint method
	}
}