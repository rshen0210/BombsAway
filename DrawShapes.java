/*
 * Ryan Shen
 * 2/13/23
 * DrawShapes.java
 * This code draws the first three letters of my name and a few shapes.
*/
import java.awt.*; import javax.swing.*;
public class DrawShapes extends JFrame
{      
	public DrawShapes()
	{  
		super ("DrawShapes");
		setSize( 600, 600);    
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
		setLocation(200,100);
		setResizable(true);
		Panel pan = new Panel();   
		setContentPane(pan);  
		setVisible(true); 
	} 
  
	public static void main (String [] args)   
	{  
		DrawShapes JoeBobKim = new DrawShapes(); //needed to run constructor
	}
}

class Panel extends JPanel
{  
	public Panel()
	{  
		setBackground(Color.YELLOW);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i = 0; i<600;i+=25) 
		{
			g.setColor(Color.BLACK);    //lines will be black
			g.drawLine(i, 0, i, 600);   //draws vertical lines
			g.drawLine(0, i, 600, i);   //draws horizontal lines
		}
		//you can delete the lines of code below or comment it out
		g.setColor(Color.RED);     //sets color blue
		
		((Graphics2D)g).setStroke(new BasicStroke(2));
		g.drawRect(300,75, 175, 100); //draws retangle
		g.fillRect(300,75, 175, 100); //fills rectangle
		g.drawOval(125,75, 75, 75);
		g.fillOval(125,75,75,75);
		g.drawOval(150,425,175,125);
		g.fillOval(150,425,175,125);
		((Graphics2D)g).setStroke(new BasicStroke(5));
		g.drawArc(425,450,125,100, 0,100);
		g.drawArc(425,450,125,100, 0,-100);
		g.drawLine(150,225,150,350);
		g.drawLine(150, 225, 225, 225);
		g.drawLine(150, 285, 225, 285);
		g.drawLine(150,285, 225, 350);
		g.drawLine(225, 225, 225, 285);
		g.drawLine(275, 250, 313, 300);
		g.drawLine(350, 250, 313, 300);
		g.drawLine(313,300, 313, 350);
		g.drawLine(438, 250, 400, 350);
		g.drawLine(438, 250, 475, 350);
		g.drawLine(420, 300, 450, 300);
		g.setColor(Color.BLUE);
		int [] arr1 = {25, 75, 75, 100, 100, 75, 75, 25, 25, 0, 0, 25};
		int [] arr2 = {100, 100, 125, 125, 175, 175, 200, 200, 175, 175, 125, 125};
		g.drawPolygon(arr1, arr2, 12);
		g.fillPolygon(arr1, arr2, 12);
		g.setColor(Color.GREEN);
		int [] arr3 = {75, 125, 175, 125};
		int [] arr4 = {250, 200, 250, 300};
		g.drawPolygon(arr3, arr4, 4);
		g.fillPolygon(arr3, arr4, 4);
		g.setColor(Color.RED);
		int [] arr5 = {25, 75, 125, 110, 40};
		int [] arr6 = {363, 325, 363, 425, 425};
		g.drawPolygon(arr5, arr6, 5);
		g.fillPolygon(arr5, arr6, 5);
	} 
}
