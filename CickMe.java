/*
 * Ryan Shen
 * 3/5/23
 * ClickMe
 * This code prints to draggable objects.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ClickMe {

 JFrame frame;   // JFrame and JPanel must be global object instances
 MyPanel panel;
 
 public ClickMe() {
 }
 
 public static void main(String[] args) {
  ClickMe sjf = new ClickMe();
  sjf.Run();
 }

 public void Run() {
  frame = new JFrame("ClickMe.java");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  // Create JPanel and add to frame
  
  panel = new MyPanel();
  frame.getContentPane().add(panel, BorderLayout.CENTER);
  frame.addMouseListener(panel);
  frame.addMouseMotionListener(panel);
  
  frame.setSize(500, 500);
  frame.setVisible(true);
  
 }
}

class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

 private int xloc, yloc, xloc2, yloc2;
 private int width, height;
 private boolean dragging;
 private boolean dragging1;
 private int xMouse, yMouse;
 private Rectangle rect;
 private Rectangle rect1;
 
 public MyPanel() {
  xloc = 100;
  yloc = 200;
  xloc2 = 300;
  yloc2 = 200;
  dragging = false;
  dragging1 = false;
  xMouse = 0;
  yMouse = 0;
 }
 
 public void paintComponent(Graphics g) 
 {
	 super.paintComponent(g); 
	 width = getWidth();   
	 height = getHeight();  
	 
	 setBackground(Color.white);
	 
	 g.setColor(Color.blue);
	 g.fillRect(xloc, yloc, 50, 50);
	 g.setColor(Color.RED);
	 g.fillRect(xloc2,yloc2,50,50);
	 int yoffset = 24;
	 rect1 = new Rectangle(xloc2, yloc2+yoffset, 50, 50);
	 rect = new Rectangle(xloc, yloc+yoffset, 50, 50);
 }
 public void mousePressed (MouseEvent e) {
  xMouse = e.getX();
  yMouse = e.getY();
  if (rect.contains(e.getX(), e.getY())) dragging = true;
  g.setColor(Color.GREEN);
  g.fillRect(xloc,yloc,50,50);
  if (rect1.contains(e.getX(), e.getY())) dragging1 = true;
  g.setColor(Color.GREEN);
  g.fillRect(xloc2,yloc2,50,50);
 }
 public void mouseReleased (MouseEvent e) {
  dragging = false;
 }
 public void mouseClicked (MouseEvent e) {}
 public void mouseEntered (MouseEvent e) 
 {
 }
 public void mouseExited (MouseEvent e) 
 {
 }
 public void mouseDragged (MouseEvent e) {
  if (dragging) {
   xloc = xloc + (e.getX() - xMouse);
   yloc = yloc + (e.getY() - yMouse);
   xMouse = e.getX();  // reset mouse to new location
   yMouse = e.getY();
   repaint(); // repaint when dragging
  }
  if (dragging1)
  {
	  xloc2 = xloc2 + (e.getX() - xMouse);
	  yloc2 = yloc2 + (e.getY() - yMouse);
	  xMouse = e.getX();  // reset mouse to new location
	  yMouse = e.getY();
	  repaint(); // repaint when dragging
  }
 }
 public void mouseMoved (MouseEvent e) {}
}
