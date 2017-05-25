import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController {
	private DrawingFrame bT;
	
	public ButtonController(DrawingFrame jF)
	{  
	   bT = jF;
	   
	   Button b1 = new Button("line");
	   Button b2 = new Button("circle");
	   Button b3 = new Button("rect");
	   Button b4 = new Button("clear All");
	   
	   jF.getButtonPanel().add(b1);
	   jF.getButtonPanel().add(b2);
	   jF.getButtonPanel().add(b3);
	   jF.getButtonPanel().add(b4);
	   
	   ActionListener listener = new LocalButtonHandler();
	   b1.addActionListener(listener);
	   b2.addActionListener(listener);
	   b3.addActionListener(listener);
	   b4.addActionListener(listener);
	}
	
	private class LocalButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
		   if(ae.getActionCommand().equals("line")){ // set shape line
		      bT.setCurrShape(new Shape().LINE);
	       }
		   else if(ae.getActionCommand().equals("circle")){ // set shape circle
		      bT.setCurrShape(new Shape().CIRCLE);
		   }
		   else if(ae.getActionCommand().equals("rect")){ // set shape rectangle
              bT.setCurrShape(new Shape().RECT);
           }
		   else if(ae.getActionCommand().equals("clear All")){ // set clear All
		      bT.removeAll();
           }
		}
	}
}
