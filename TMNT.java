/*
Ryan Shen
2/27/23
TMNT.java
This code asks the user to play Checkers or display image.
*/

import java.awt.*;   // for classes Graphics, Color, Font, Image

import java.awt.event.* ; // for classes KeyListener, MouseListener

import javax.swing.* ; // for classes JFrame, JPanel, JLabel

import java.io.*  ; // for classes File, IOException, ImageIO

import java.util.Scanner;

public class TMNT extends JFrame
{
	public TMNT () 
	{
		super ("TMNT");
		Scanner kb = new Scanner(System.in);
		System.out.print("Would you like poster(1) or play checkers(2)? ");
		int option = kb.nextInt();
		if (option == 1)
		{
			setSize( 1200, 700);    
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
			setLocation(0,0);
			setResizable(true);
			Panel pan = new Panel();   
			setContentPane(pan);  
			setVisible(true); 
		}
		if (option == 2)
		{
			System.out.println("\n\n");
			setSize( 600, 600);    
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
			setLocation(800,0);
			setResizable(true);
			Panel2 pan = new Panel2();   
			setContentPane(pan);  
			setVisible(true); 	
		}	
	}
	
	public static void main (String[] args) 
	{
		TMNT si = new TMNT();
	}
}
  
class Panel extends JPanel
{  
	Scanner kb = new Scanner(System.in);
	int choice = 1;
	int amount = 0;
	int enemy = 0;
	int option = 0;
	public Panel()
	{
		System.out.print("Would you like Leonardo(1), Michelangelo(2), Raphael(3), or Donatello(4)? ");
		choice = kb.nextInt();
		System.out.print("How many would you like (1-5): ");
		amount = kb.nextInt();
		System.out.print("How many enemies would you like(1-5) ");
		enemy = kb.nextInt();
	}
	public void paintComponent(Graphics g)
	{  
		super.paintComponent(g);
		Image joe = new ImageIcon("Background.jpg").getImage();
		Image bob = new ImageIcon("Logo.png").getImage();
		Image april = new ImageIcon("April.gif").getImage();
		Image splinter = new ImageIcon("Splinter.gif").getImage();
		
		Image donatello = new ImageIcon("Donatello.gif").getImage();
		Image raphael = new ImageIcon("Raphael.gif").getImage();
		Image michelangelo = new ImageIcon("Michelangelo.gif").getImage();
		Image leonardo = new ImageIcon("Leonardo.gif").getImage();
		
		g.drawImage(joe, 0, 0, 1200, 700, null);
		g.drawImage(bob, 500, 40, 200, 160, null);
		g.drawImage(april, 20, 450, 90, 220, null);
		g.drawImage(splinter, 130, 495, 100, 170, null);
		if (choice == 1)
		{
			for (int i = 0;i < amount;i++)
			{
				g.drawImage(leonardo, 240, 495-(i*150), 160, 170, null);
			}
		}
		else if (choice == 2)
		{
			for (int i = 0;i < amount;i++)
			{
				g.drawImage(michelangelo, 240, 495-(i*150), 160, 170, null);
			}
		}
		else if (choice == 3)
		{
			for (int i = 0;i < amount;i++)
			{
				g.drawImage(raphael, 240, 495-(i*150), 160, 170, null);
			}
		}
		else
		{
			for (int i = 0;i < amount;i++)
			{
				g.drawImage(donatello, 240, 495-(i*150), 160, 170, null);
			}
		}
		Image shredder = new ImageIcon("Shredder.gif").getImage();
		Image rhino = new ImageIcon("Rhino.gif").getImage();
		Image krang = new ImageIcon("Krang.gif").getImage();
		Image footSoldier = new ImageIcon("FootSoldier.gif").getImage();
		Image bebop = new ImageIcon("Bebop.gif").getImage();
		
		if (enemy > 0)
		g.drawImage(shredder, 1070, 450, 110, 220, null);
		if (enemy > 1)
		g.drawImage(rhino, 930, 495, 120, 170, null); 
		if (enemy > 2)
		g.drawImage(krang, 790, 520, 120, 145, null);
		if (enemy > 3)
		g.drawImage(footSoldier, 650, 500, 120, 165, null);
		if (enemy > 4)
		g.drawImage(bebop, 510, 500, 120, 160, null);
		
		Image logo2 = new ImageIcon("Logo2.png").getImage();
		g.drawImage(logo2, 10, 10, 200, 100, null);
		g.drawImage(logo2, 990, 10, 200, 100, null);
	} 
}
class Panel2 extends JPanel
{  
	Scanner kb = new Scanner(System.in);
	String color = "";
	int character = 4;
	int num1,num2,num3,num4;
	Scanner scan;
	Image red, black, board;
	boolean first;
	boolean isRedTurn;
	int [] [] redBoard = {{1,0,1,0,1,0,1,0},{0,1,0,1,0,1,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
	int [] [] blackBoard = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}, {1,0,1,0,1,0,1,0}, {0,1,0,1,0,1,0,1}};
	public Panel2() {
		System.out.println("\n\n");
		first = true;
		scan = new Scanner(System.in);
		red = new ImageIcon("Krang.gif").getImage();
		board = new ImageIcon("CheckerBoard.jpg").getImage();
		isRedTurn = true;
		System.out.print("Which character would you like to play? April(1), "+
		"Splinter(2), Logo1(3), Logo2(4)? ");
		character = kb.nextInt();
		if (character == 1)
		{
			black = new ImageIcon("April.gif").getImage();
		}
		else if (character == 2)
		{
			black = new ImageIcon("Splinter.gif").getImage();
		}
		else if (character == 3)
		{
			black = new ImageIcon("Logo.png").getImage();
		}
		else
		{
			black = new ImageIcon("Logo2.png").getImage();
		}
	}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(board, 0, 0, 600, 600, null);  
        if(!first)
        {
			if (character == 1)
			color = (isRedTurn ? "Krang" : "April");
			else if (character == 2)
			color = (isRedTurn ? "Krang" : "Splinter");
			else if (character == 3)
			color = (isRedTurn ? "Krang" : "Logo");
			else if (character == 4)
			color = (isRedTurn ? "Krang" : "Logo2");
			System.out.println(color + ", it's your turn. Move which piece? Type coordinate (row col) of old and then new. \nType 1000 to exit.");
        	num1 = scan.nextInt();
        	
        	if(num1==1000)
        	{
        		System.out.println("\n\n");
        		System.exit(0); 
        		
        	} 
        	
        	num2 = scan.nextInt();
       		num3 = scan.nextInt();
        	num4 = scan.nextInt();
        
			System.out.println("");
			
        	if (isRedTurn){
				redBoard[num1-1][num2-1] = 0;
				redBoard[num3-1][num4-1] = 1;
			}else{
				blackBoard[num1-1][num2-1] = 0;
				blackBoard[num3-1][num4-1] = 1;
			}
        	
        	isRedTurn = !isRedTurn;
     	}
        for(int i = 0;i<8;i++)
        {
			for(int j = 0;j<8;j++)
			{
				if(redBoard[i][j]==1) g.drawImage(red, 52+ j*63, 52 +i*64, 50, 50, null);  
				if(blackBoard[i][j]==1) g.drawImage(black, 52+ j*63, 52 +i*64, 50, 50, null);
			}
		
		}  

        first = false; 
    	repaint();
	}
}
