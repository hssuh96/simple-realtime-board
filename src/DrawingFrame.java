import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DrawingFrame extends JFrame {
   private ShapeContainer shapeContainer;
   private Panel buttonPanel;
   private Panel choicePanel;

   private int currentShape;
   private Color currentColor;

   private boolean fillState;

   private WhiteBoardService rmiModule;
   private String entity;

   public DrawingFrame(String title, WhiteBoardService rmi) {
      super(title);
      entity = title;

      currentShape = new Shape().LINE;
      currentColor = Color.BLACK;
      fillState = false;

      rmiModule = rmi;

      // add Button Panel
      buttonPanel = new Panel();
      new ButtonController(this);
      getContentPane().add("South", buttonPanel);

      // add Name Panel
      Panel namePanel = new Panel();
      Label programTitle = new Label("Paint Brush");
      namePanel.add(programTitle);
      getContentPane().add("North", namePanel);

      // add Choice menu
      choicePanel = new Panel();
      new ChoiceController(this);
      getContentPane().add("East", choicePanel);

      // add Shape Container
      shapeContainer = new ShapeContainer();
      getContentPane().add("West", shapeContainer);

      // add Window Listener
      addWindowListener(new LocalWindowListener());

      // add Mouse Controller
      new CanvasMouseController(this);

      setSize(500, 500);
      show();
   }

   public Container getShapeContainer() {
      return shapeContainer;
   }

   public Panel getButtonPanel() {
      return buttonPanel;
   }

   public Panel getChoicePanel() {
      return choicePanel;
   }

   public void setCurrShape(int shape) {
      currentShape = shape;
   }

   public int getCurrShape() {
      return currentShape;
   }

   public void setShapeContainer(ShapeContainer s) {
      getContentPane().add(s);
   }

   public void addShape(Point p1, Point p2) { // add shape
      //set shape
      Shape newShape = new Line(p1, p2);

      if (getCurrShape() == new Shape().CIRCLE) {
         newShape = new Circle(p1, p2);
      } else if (getCurrShape() == new Shape().RECT) {
         newShape = new Rectangular(p1, p2);
      }

      newShape.setColor(getCurrentColor()); // set color
      newShape.setFill(getFillState()); // set fill
      try {
         getShapeContainer().add(newShape); // add shape
         rmiModule.add(newShape, entity);
      } catch (RemoteException e) {
         e.printStackTrace();
      }
      repaint();
   }

   public void removeFrontShape() { // remove front shape
      try {
         rmiModule.removeFrontShape(entity);
      } catch (RemoteException e) {
         e.printStackTrace();
      }
      repaint();
   }

   public void removeAll() { // remove all shapes
      try {
         rmiModule.removeAll(entity);
      } catch (RemoteException e) {
         e.printStackTrace();
      }
      repaint();
   }

   public void setCurrentColor(Color c) {
      currentColor = c;
   }

   public Color getCurrentColor() {
      return currentColor;
   }

   public void setFillState(boolean b) {
      fillState = b;
   }

   public boolean getFillState() {
      return fillState;
   }

   public WhiteBoardService getRmiModule() {
      return rmiModule;
   }

   public void setRmiModule(WhiteBoardServiceImpl m) {
      rmiModule = m;
   }

   private class LocalWindowListener extends WindowAdapter { // close window
      public void windowClosing(WindowEvent e) {
         System.exit(0);
      }
   }
}
