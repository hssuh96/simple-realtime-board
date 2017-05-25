import java.awt.*;

public class Circle extends Shape {

	public Circle (Point a1, Point a2) {
		super (a1, a2);
	}
	public Object clone () {
		Circle l = new Circle (p1,p2);
		return l;
	}
	public void paint (Graphics g) {
       super.paint(g,super.CIRCLE); // call parent's paint method
	 }
}