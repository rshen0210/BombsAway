/*
Ryan Shen
1/17/23
WinterWonderland
This code creates a winter wonderland after asking for user input.
*/

import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
public class WinterWonderland extends JFrame
{
	public WinterWonderland()
	{
		super ("Winter Wonderland");
		setSize( 800, 800);    
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
		setLocation(200,100);
		setResizable(true);
		Panel pan = new Panel();   
		setContentPane(pan);  
		setVisible(true); 
	}
	public static void main(String [] args)
	{
		WinterWonderland ww = new WinterWonderland();
	}
}
class Panel extends JPanel
{
	String color = "";
	int choice = 0;
	int x10 = 0;
	Scanner kb = new Scanner(System.in);
	public Panel()
	{
		System.out.println("\n\n\n");
		System.out.print("What background color would you like: ");
		color = kb.nextLine();
		System.out.print("How many snowmen would you like(1-4)? ");
		x10 = kb.nextInt();
		System.out.print("Would you like a moonlit night, yes(1), no(2)? ");
		choice = kb.nextInt();
		color = color.toUpperCase();
		if (color.equals("BLUE"))
		setBackground(Color.BLUE);
		else if (color.equals("YELLOW"))
		setBackground(Color.YELLOW);
		else if (color.equals("RED"))
		setBackground(Color.RED);
		else if (color.equals("BLACK"))
		setBackground(Color.BLACK);
		else if (color.equals("GREEN"))
		setBackground(Color.GREEN);
		else if (color.equals("GRAY"))
		setBackground(Color.GRAY);
		else if (color.equals("PINK"))
		setBackground(Color.PINK);
		else if (color.equals("ORANGE"))
		setBackground(Color.ORANGE);
		else if (color.equals("MAGENTA"))
		setBackground(Color.MAGENTA);
		else if (color.equals("WHITE"))
		setBackground(Color.WHITE);
		System.out.println("\n\n\n");
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (choice == 1)
		{
			((Graphics2D)g).setStroke(new BasicStroke(5));
			g.drawArc(30, 0, 180, 150, 180, -90);
			g.drawArc(30, 0, 180, 150, 180, 90);
			g.fillArc(30, 0, 180, 150, 180, -90);
			g.fillArc(30, 0, 180, 150, 180, 90);
			if (color.equals("BLUE"))
			g.setColor(Color.BLUE);
			else if (color.equals("YELLOW"))
			g.setColor(Color.YELLOW);
			else if (color.equals("RED"))
			g.setColor(Color.RED);
			else if (color.equals("BLACK"))
			g.setColor(Color.BLACK);
			else if (color.equals("GREEN"))
			g.setColor(Color.GREEN);
			else if (color.equals("GRAY"))
			g.setColor(Color.GRAY);
			else if (color.equals("PINK"))
			g.setColor(Color.PINK);
			else if (color.equals("ORANGE"))
			g.setColor(Color.ORANGE);
			else if (color.equals("MAGENTA"))
			g.setColor(Color.MAGENTA);
			else if (color.equals("WHITE"))
			g.setColor(Color.WHITE);
			
			g.drawArc(75, 0, 90, 150, 180, 90);
			g.drawArc(75, 0, 90, 150, 180, -90);
			g.fillArc(75, 0, 90, 150, 180, 90);
			g.fillArc(75, 0, 90, 150, 180, -90);
		}
		((Graphics2D)g).setStroke(new BasicStroke(1));
		for(int i = 0; i<800;i+=30) 
		{
			g.setColor(Color.BLACK);    //lines will be black
			g.drawLine(i, 0, i, 800);   //draws vertical lines
			g.drawLine(0, i, 800, i);   //draws horizontal lines
		}
		g.setColor(Color.WHITE);
		int [] xc = {150, 155, 165, 160, 165, 155, 150, 145, 135, 140, 135, 145};
		int [] xc7 = {120, 125, 135, 130, 135, 125, 120, 115, 105, 110, 105, 115};
		int [] xc3 = {240, 245, 255, 250, 255, 245, 240, 235, 225, 230, 225, 235};
		int [] xc1 = {330, 335, 345, 340, 345, 335, 330, 325, 315, 320, 315, 325};
		int [] xc5 = {300, 305, 315, 310, 315, 305, 300, 295, 285, 290, 285, 295};
		int [] xc2 = {450, 455, 465, 460, 465, 455, 450, 445, 435, 440, 435, 445};
		int [] xc6 = {480, 485, 495, 490, 495, 485, 480, 475, 465, 470, 465, 475};
		int [] xc4 = {390, 395, 405, 400, 405, 395, 390, 385, 375, 380, 375, 385};
		int [] yc = {30, 38, 38, 45, 52, 52, 60, 52, 52, 45, 38, 38};
		int [] yc1 = {90, 98, 98, 105, 112, 112, 120, 112, 112, 105, 98, 98};
		int [] yc2 = {150, 158, 158, 165, 172, 172, 180, 172, 172, 165, 158, 158};
		int [] yc3 = {180, 188, 188, 195, 202, 202, 210, 202, 202, 195, 188, 188};
		g.drawPolygon(xc, yc, 12);
		g.fillPolygon(xc, yc, 12);
		g.drawPolygon(xc1, yc, 12);
		g.fillPolygon(xc1, yc, 12);
		g.drawPolygon(xc2, yc, 12);
		g.fillPolygon(xc2, yc, 12);
		g.drawPolygon(xc3, yc1, 12);
		g.fillPolygon(xc3, yc1, 12);
		g.drawPolygon(xc4, yc1, 12);
		g.fillPolygon(xc4, yc1, 12);
		g.drawPolygon(xc5, yc2, 12);
		g.fillPolygon(xc5, yc2, 12);
		g.drawPolygon(xc6, yc2, 12);
		g.fillPolygon(xc6, yc2, 12);
		g.drawPolygon(xc7, yc3, 12);
		g.fillPolygon(xc7, yc3, 12);
		drawSnowman(g, x10);
	}
	public void drawSnowman(Graphics g2, int x)
	{
		g2.setColor(Color.BLACK);
		for (int i =0;i<x;i++)
		{
			g2.drawOval(480-(i*150), 300, 50, 50);
			g2.drawOval(490-(i*150),315,10,10);
			g2.drawOval(510-(i*150),315, 10, 10);
			g2.drawOval(465-(i*150), 350, 80, 80);
			g2.drawOval(465-(i*150), 430, 80, 80);
			g2.drawOval(500-(i*150), 365, 10, 10);
			g2.drawOval(500-(i*150), 385, 10, 10);
			g2.drawOval(500-(i*150), 405, 10, 10);
			
			g2.setColor(Color.WHITE);
			g2.fillOval(480-(i*150), 300, 50, 50);
			g2.fillOval(465-(i*150), 350, 80, 80);
			g2.fillOval(465-(i*150), 430, 80, 80);
			g2.setColor(Color.BLACK);
			g2.fillOval(490-(i*150),315,10,10);
			g2.fillOval(510-(i*150),315, 10, 10);
			g2.drawLine(498-(i*150),330,512-(i*150),329);
			g2.drawLine(465-(i*150),400, 435-(i*150), 445);
			g2.drawLine(545-(i*150),400, 575-(i*150), 445);
			g2.fillOval(500-(i*150), 365, 10, 10);
			g2.fillOval(500-(i*150), 385, 10, 10);
			g2.fillOval(500-(i*150), 405, 10, 10);
		}
	}
}
