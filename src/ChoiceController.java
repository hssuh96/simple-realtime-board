import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceController {
	private DrawingFrame bT;
	
	public ChoiceController(DrawingFrame jF)
	{	
		bT = jF;
		
		Choice ColorChooser = new Choice();
		ColorChooser.add("black");
        ColorChooser.add("red");
        ColorChooser.add("green");
        ColorChooser.add("blue");
        
        Choice FillChooser = new Choice();
        FillChooser.add("empty");
        FillChooser.add("fill");
        
		jF.getChoicePanel().add(ColorChooser);
		jF.getChoicePanel().add(FillChooser);
		
		ItemListener colorListener = new LocalColorChoiceHandler();
		ItemListener fillListener = new LocalFillChoiceHandler();
		ColorChooser.addItemListener(colorListener);
		FillChooser.addItemListener(fillListener);
	}
	
	private class LocalColorChoiceHandler implements ItemListener{
		public void itemStateChanged(ItemEvent arg0) {
		   if(arg0.getItem().equals("black")){ // set color black
		      bT.setCurrentColor(Color.BLACK);
		   }
		   else if(arg0.getItem().equals("red")){ // set color red
		      bT.setCurrentColor(Color.RED);
		   }
		   else if(arg0.getItem().equals("green")){ // set color red
              bT.setCurrentColor(Color.GREEN);
           }
		   else if(arg0.getItem().equals("blue")){ // set color blue
              bT.setCurrentColor(Color.BLUE);
           }
		}
	}
		
	private class LocalFillChoiceHandler implements ItemListener{
		public void itemStateChanged(ItemEvent arg0) {
		   if(arg0.getItem().equals("fill")){ // set fill
              bT.setFillState(true);
           }
           else if(arg0.getItem().equals("empty")){ // set empty
              bT.setFillState(false);
           }
		}
	}
}
