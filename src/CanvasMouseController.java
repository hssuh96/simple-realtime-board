import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class CanvasMouseController implements MouseMotionListener, MouseListener {
	private DrawingFrame bT;
	private Point p1, p2;
	private boolean HaveToremoveFrontShape = false; // indicates the need for remove front shape
	
	public CanvasMouseController(DrawingFrame jF){
	   bT = jF;
	   jF.getShapeContainer().addMouseListener(this);
	   jF.getShapeContainer().addMouseMotionListener(this);
	}
	
	public void mouseDragged(MouseEvent arg0) {
	   p2 = arg0.getPoint();
	   if(HaveToremoveFrontShape)
	      bT.removeFrontShape(); // remove front shape
	   bT.addShape(p1, p2); // draw current shape
	   HaveToremoveFrontShape = true;
	}

	public void mouseMoved(MouseEvent arg0) {
	   
	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {
	   p1 = arg0.getPoint();
	   HaveToremoveFrontShape = false;
	}

	public void mouseReleased(MouseEvent arg0) {
	   p2 = arg0.getPoint();
	   bT.addShape(p1,p2); // add shape
	   HaveToremoveFrontShape = false;
	}

	public void mouseEntered(MouseEvent arg0) {
	   
	}

	public void mouseExited(MouseEvent arg0) {
	   
	}
}
