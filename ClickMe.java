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

	JFrame frame; 
	MyPanel panel;

	public ClickMe () {
	}

	public static void main(String[] args) {
		ClickMe sjf = new ClickMe();
		sjf.Run();
	}

	public void Run() {
		frame = new JFrame("ClickMe.java");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new MyPanel();
		
		frame.getContentPane().add(panel, BorderLayout.CENTER); // add panel to frame
		frame.addMouseListener(panel);
		frame.addMouseMotionListener(panel);
		frame.setSize(500, 500); // explicitly set size in pixels
		frame.setVisible(true); // set to false to make invisible

	}

} 

class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

	private int temp=0,xloc, yloc,x2loc,y2loc,x3loc,y3loc,x4loc,y4loc,xMouse, yMouse, xc1,yc1,xc2,yc2,xc3,yc3,xc4,yc4;
	private String p1,p2,p3,p4;
	private boolean squ1 = false, squ2 = false, squ3 = false, squ4= false,sq1 = false, sq2= false,sq3=false,sq4=false,dragging,dragging2,dragging3,dragging4;
	private Rectangle rect,Redrect,Yellowrect,Blackrect; 

	Rectangle [][] rects = new Rectangle[4][4];

	public MyPanel() {
		
		xloc =20; yloc = 10;
		x2loc = 80; y2loc = 10;
		x3loc = 140; y3loc=10;
		x4loc = 200; y4loc = 10;
		
		dragging = false;
		dragging2 = false;
		dragging3 = false;
		dragging4 = false;

		xMouse = yMouse = 0;

		temp = (int)(Math.random()*4+65);
		yc1=temp-64;
		p1=(char)(temp)+"";
		xc1=(int)(Math.random()*4+1);
		p1+=xc1;
		
		temp = (int)(Math.random()*4+65);
		yc2=temp-64;
		p2=(char)(temp)+"";
		xc2=(int)(Math.random()*4+1);
		p2+=xc2;
		
		temp = (int)(Math.random()*4+65);
		yc3=temp-64;
		p3=(char)(temp)+"";
		xc3=(int)(Math.random()*4+1);
		p3+=xc3;
		
		temp = (int)(Math.random()*4+65);
		yc4=temp-64;
		p4=(char)(temp)+"";
		xc4=(int)(Math.random()*4+1);
		p4+=xc4;

		System.out.print("\n\n\n");
		System.out.println("Please put the boxes in the following locations\nBlue - "+p1+", Red - "+p2+", Yellow - "+p3+", Black - "+p4);
		System.out.print("\n\n\n");

		int wloc=70;
		int wyloc=70;
		int yoffset = 24;
		int xoffset = 4;

		for(int i=0; i<4; i++){
			for(int k =0; k<4; k++){
				rects[k][i]= new Rectangle(wloc+xoffset, wyloc+yoffset, 60, 60);
				wloc+=60;
			}
			wyloc+=60;
			wloc=70;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // execute the superclass method first
		
		setBackground(Color.white);

		for(int i = 70; i<370;i+=60)
		{
			g.setColor(Color.BLACK); //lines will be black
			g.drawLine(i, 70, i, 310); //draws vertical lines
			g.drawLine(70, i, 310, i); //draws horizontal lines
		}

		String l1="A",l2="B",l3="C",l4="D";
		g.drawString(l1,55,105);
		g.drawString(l2,55,165);
		g.drawString(l3,55,225);
		g.drawString(l4,55,285);

		String n1="1",n2="2",n3="3",n4="4";
		g.drawString(n1,100,325);
		g.drawString(n2,160,325);
		g.drawString(n3,220,325);
		g.drawString(n4,280,325);


		if(sq1==false){
			// Draw blue rectangle
			g.setColor(Color.blue);
			g.fillRect(xloc, yloc, 50, 50);
		}
		else if(sq1==true){
			g.setColor(Color.green);
			g.fillRect(xloc, yloc, 50, 50);
		}
		
		if(sq2==false){
			g.setColor(Color.RED);
			g.fillRect(x2loc, y2loc, 50, 50);
		}
		else if(sq2==true){
			g.setColor(Color.green);
			g.fillRect(x2loc, y2loc, 50, 50);
		}
		
		if(sq3==false){
			g.setColor(Color.YELLOW);
			g.fillRect(x3loc, y3loc, 50, 50);
		}
		else if(sq3==true){
			g.setColor(Color.green);
			g.fillRect(x3loc, y3loc, 50, 50);
		}

		if(sq4==false){
			g.setColor(Color.BLACK);
			g.fillRect(x4loc, y4loc, 50, 50);
		}
		else if(sq4==true){
			g.setColor(Color.green);
			g.fillRect(x4loc, y4loc, 50, 50);
		}

	
		int yoffset = 24;
		int xoffset = 4;

		rect = new Rectangle(xloc+xoffset, yloc+yoffset, 50, 50);
		Redrect = new Rectangle(x2loc+xoffset, y2loc+yoffset,50,50);
		Yellowrect = new Rectangle(x3loc+xoffset, y3loc+yoffset,50,50);
		Blackrect = new Rectangle(x4loc+xoffset, y4loc+yoffset,50,50);

	}

	public void mousePressed (MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();

		if (rect.contains(e.getX(), e.getY())) dragging = true;
		else if(Redrect.contains(e.getX(), e.getY())) dragging2 = true;
		else if(Yellowrect.contains(e.getX(), e.getY())) dragging3 = true;
		else if(Blackrect.contains(e.getX(), e.getY())) dragging4 = true;

	}
	public void mouseReleased (MouseEvent e) {

		dragging = false;
		dragging2 = false;
		dragging3 = false;
		dragging4 = false;

		if(rects[xc1-1][yc1-1].contains(rect)) squ1=true;
		if(rects[xc2-1][yc2-1].contains(Redrect)) squ2=true;
		if(rects[xc3-1][yc3-1].contains(Yellowrect)) squ3=true;
		if(rects[xc4-1][yc4-1].contains(Blackrect)) squ4=true;

		if(squ1==true&&squ2==true&&squ3==true&&squ4==true)System.exit(0);

	}
	public void mouseClicked (MouseEvent e) {}
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited (MouseEvent e) {}
	
	public void mouseDragged (MouseEvent e) {
		if (dragging) {
			xloc = xloc + (e.getX() - xMouse);
			yloc = yloc + (e.getY() - yMouse);
			xMouse = e.getX(); 
			yMouse = e.getY();
			repaint();
		}
		else if(dragging2){
			x2loc = x2loc + (e.getX() - xMouse);
			y2loc = y2loc + (e.getY() - yMouse);
			xMouse = e.getX(); 
			yMouse = e.getY();
			repaint(); 
		}
		else if(dragging3){
			x3loc = x3loc + (e.getX() - xMouse);
			y3loc = y3loc + (e.getY() - yMouse);
			xMouse = e.getX();
			yMouse = e.getY();
			repaint();
		}
		else if(dragging4){
			x4loc = x4loc + (e.getX() - xMouse);
			y4loc = y4loc + (e.getY() - yMouse);
			xMouse = e.getX(); 
			yMouse = e.getY();
			repaint();
		}
			
	}
	public void mouseMoved (MouseEvent e) {
		if(rect.contains(e.getX(), e.getY())) sq1=true;
		else if(!(rect.contains(e.getX(), e.getY()))) sq1=false;

		if(Redrect.contains(e.getX(), e.getY())) sq2 = true;
		else if(!(Redrect.contains(e.getX(), e.getY()))) sq2=false;

		if(Yellowrect.contains(e.getX(), e.getY())) sq3 = true;
		else if(!(Redrect.contains(e.getX(), e.getY()))) sq3=false;

		if(Blackrect.contains(e.getX(), e.getY())) sq4 = true;
		else if(!(Redrect.contains(e.getX(), e.getY()))) sq4=false;

		repaint();
	}

} 
