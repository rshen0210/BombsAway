/*
 * Ryan Shen
 * 3/17/23
 * AllHandlers.java
 * This code tests keyboard and mouse inputs.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AllHandlers 
{
	JFrame frame;
	DrawingPanel canvas;
	public static void main (String[] args) 
	{
		AllHandlers kt = new AllHandlers();
		kt.run();
	}
	public void run()
	{
		frame = new JFrame("AllHandlers");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
		canvas = new DrawingPanel();
		frame.getContentPane().add(canvas);
		frame.add(canvas, BorderLayout.CENTER);
		frame.addMouseListener(canvas);
		frame.addMouseMotionListener(canvas);
		frame.setVisible(true);
	}
}
class DrawingPanel extends JPanel implements KeyListener, MouseListener, MouseMotionListener
{
	private int carX;
	private int carY;
	private boolean swap;
	private Timer cartimer;
	boolean mred;
	boolean dred1;
	boolean ered1;
	boolean ered;
	boolean cred1;
	boolean pred;
	boolean rred;
	boolean lred;
	boolean nred;
	boolean cred;
	boolean kred;
	int xMouse;
	int yMouse;
	Rectangle [][] rects = new Rectangle[3][4];
	public DrawingPanel() 
	{
		carX = 10;
		carY = 400;
		swap = false;
		addKeyListener(this);
		CarMover carmover = new CarMover();
		cartimer = new Timer(1, carmover);
		cartimer.start();
		
		mred = false;
		dred1 = false;
		ered1 = false;
		ered = false;
		cred1 = false;
		pred = false;
		rred = false;
		lred = false;
		nred = false;
		cred = false;
		kred = false;
		int wloc=20;
		int wyloc=100;
		int yoffset = 24;
		int xoffset = 4;

		for(int i=0; i<1; i++){
			for(int k =0; k<4; k++){
				rects[i][k]= new Rectangle(wloc+xoffset, wyloc+yoffset, 125, 40);
				wloc+=125;
			}
		}
		wloc = 20;
		wyloc = 175;
		for(int i=1; i<2; i++){
			for(int k =0; k<4; k++){
				rects[i][k]= new Rectangle(wloc+xoffset, wyloc+yoffset, 125, 40);
				wloc+=125;
			}
		}
		wloc = 20;
		wyloc = 340;
		for(int i=2; i<3; i++){
			for(int k =0; k<4; k++){
				rects[i][k]= new Rectangle(wloc+xoffset, wyloc+yoffset, 125, 40);
				wloc+=125;
			}
		}
	}
	class CarMover implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			// car XY location
			carX++;
			if (carX > 490) carX = 60;
			repaint();
			grabFocus();
		}
	}
	class CarMover1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			carX--;
			if (carX < 60) carX = 490;
			repaint();
			grabFocus();
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.blue);
		int [] arrx = {carX, carX+50, carX, carX-50};
		int [] arry = {carY+50, carY, carY-50, carY};
		g.drawPolygon(arrx, arry, 4);
		g.fillPolygon(arrx, arry, 4);
		
		for (int i = 20;i<=520;i+=125)
		{
			g.drawLine(i, 100, i, 140);
		}
		g.drawLine(20, 100, 520, 100);
		g.drawLine(20, 140, 520, 140);
		
		for (int i = 20;i<= 520;i+=125)
		{
			g.drawLine(i, 175, i, 215);
		}
		g.drawLine(20, 175, 520, 175);
		g.drawLine(20, 215, 520, 215);
		
		for (int i = 20;i<=520;i+=125)
		{
			g.drawLine(i, 300, i, 340);
		}
		g.drawLine(20, 300, 520, 300);
		g.drawLine(20, 340, 520, 340);
		
		int xspot = 20;
		
		g.setColor(Color.black);
		if (mred)
		g.setColor(Color.red);
		g.drawString("Moved",40+xspot, 125);
		g.setColor(Color.black);
		if (dred1)
		g.setColor(Color.red);
		g.drawString("Dragged", 165+xspot, 125);
		g.setColor(Color.black);
		if (ered1)
		g.setColor(Color.red);
		g.drawString("Entered", 290+xspot, 125);
		g.setColor(Color.black);
		if (ered)
		g.setColor(Color.red);
		g.drawString("Exited", 415+xspot, 125);
		g.setColor(Color.black);
		if (cred1)
		g.setColor(Color.red);
		g.drawString("Clicked",40+xspot, 200);
		g.setColor(Color.black);
		if (pred)
		g.setColor(Color.red);
		g.drawString("Pressed", 165+xspot, 200);
		g.setColor(Color.black);
		if (rred)
		g.setColor(Color.red);
		g.drawString("Released", 290+xspot, 200);
		g.setColor(Color.black);
		if (lred)
		g.setColor(Color.red);
		g.drawString("Letter", 40+xspot, 325);
		g.setColor(Color.black);
		if (nred)
		g.setColor(Color.red);
		g.drawString("Number", 165+xspot, 325);
		g.setColor(Color.black);
		if (cred)
		g.setColor(Color.red);
		g.drawString("Character", 290+xspot, 325);
		g.setColor(Color.black);
		if (kred)
		g.setColor(Color.red);
		g.drawString("KeyCode", 415+xspot, 325);
		
	}
	public void keyTyped(KeyEvent e) 
	{
		char c = e.getKeyChar();
		if (c == 'q' || c == 'Q') {
			mred = false;
			dred1 = false;
			ered1 = false;
			ered = false;
			cred1 = false;
			pred = false;
			rred = false;
			lred = false;
			nred = false;
			cred = false;
			kred = false;
			repaint();
		}
		switch(c) {
			case '1':
			nred = true;
			cred = true;
			break;
			case '2':
			nred = true;
			cred = true;
			break;
			case '3':
			nred = true;
			cred = true;
			break;
			case '4':
			nred = true;
			cred = true;
			break;
			case '5':
			nred = true;
			cred = true;
			break;
			case '6':
			nred = true;
			cred = true;
			break;
			case '7':
			nred = true;
			cred = true;
			break;
			case '8':
			nred = true;
			cred = true;
			break;
			case '9':
			nred = true;
			cred = true;
			break;
			case '0':
			nred = true;
			cred = true;
			break;
		}
		for (int i = 97;i<=122;i++)
		{
			if (c == i && c!= 113)
			{
				cred = true;
				lred = true;
			}
		}
	}
	public void keyPressed(KeyEvent e) 
	{
		int c = e.getKeyCode();
		switch(c) {
		case 17:
			cartimer.stop();
			if (swap == false) {
				CarMover1 carmove1 = new CarMover1();
				cartimer = new Timer(1, carmove1);
				swap = true;
				cartimer.start();
			}
			else if (swap) {
				CarMover carmove = new CarMover();
				cartimer = new Timer(1, carmove);
				swap = false;
				cartimer.start();
			}
			break;
		}
		
	}
	public void keyReleased(KeyEvent e) 
	{
		int code = e.getKeyCode();
		if(!((code >= 44 && code<=111)|| code == 151 || code == 152 || code == 153 || code == 160 || code == 161
				|| code == 162 || code == 192 || code == 222 || code == 512 || code == 513 || code == 515 || code == 517
				||code == 519 || code == 520 || code == 521 || code == 522 || code == 523)){
			kred = true;
		} 
	}
	public void mousePressed (MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
		pred = true;
	}
	public void mouseReleased (MouseEvent e) {
		rred = true;
	}
	public void mouseClicked (MouseEvent e) {
		cred1 = true;
	}
	public void mouseEntered (MouseEvent e) 
	{
		ered1 = true;
	}
	public void mouseExited (MouseEvent e) 
	{
		ered = true;
	}
	public void mouseDragged (MouseEvent e) {
		dred1 = true;
	}
	public void mouseMoved (MouseEvent e) 
	{
		mred = true;
	}
}
