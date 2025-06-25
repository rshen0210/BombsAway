/*
 * Ryan Shen
 * 3/3/23
 * Flowers.java
 * Making a pretty set of flowers
 */



import java.awt.*; 
import javax.swing.*;
import java.awt.*; 
import javax.swing.*;
import java.util.Scanner;


public class Flowers extends JFrame
{      
	public Flowers()
	{  
		super ("Flower");

		setSize( 1200, 700);    
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);  

		setLocation(0,0);
		setResizable(true);
		Panel pan = new Panel();   
		setContentPane(pan);  

		setVisible(true); 
	} 

	public static void main (String [] args)   
	{  
		Flowers ninja = new Flowers(); //needed to run constructor
	}

}
class Panel extends JPanel
{  
	Scanner in;
	int flowerCount;
	int background;
	public Panel()
	{  
		Scanner in = new Scanner(System.in);
		System.out.print("\n\n\nHow many flowers would you like?(1-6) ");
		flowerCount = in.nextInt();
		System.out.print("Which background field would you like(1-4)? ");
		background = in.nextInt();

		System.out.println("Here is your field of flowers!\n\n\n");

	}
	public void paintComponent(Graphics g)
	{  
		super.paintComponent(g);

		if (background == 1)
		{
			Image backg1 = new ImageIcon("Field1.jpg").getImage();
			g.drawImage(backg1, 0, 0, 1200, 700, null);
		}
		if (background == 2)
		{
			Image backg2 = new ImageIcon("Field2.jpg").getImage();
			g.drawImage(backg2, 0, 0, 1200, 700, null);
		}

		if (background == 3)
		{
			Image backg3 = new ImageIcon("Field3.jpg").getImage();
			g.drawImage(backg3, 0, 0, 1200, 700, null);
		}

		if (background == 4)
		{
			Image backg4 = new ImageIcon("Field4.jpg").getImage();
			g.drawImage(backg4, 0, 0, 1200, 700, null);
		}

		((Graphics2D)g).setStroke(new BasicStroke(3));
		Color stem = new Color(200,100,50);
		g.setColor(stem);
		for (int i = 0; i < flowerCount; i++)
		{
			g.drawLine(100+200*i, 350, 100+200*i,625);
		}

		if (flowerCount >= 1)
		{
			g.setColor(Color.RED);
			g.fillOval(75, 300, 50, 50);
		}
		if (flowerCount >= 2)
		{
			g.setColor(Color.ORANGE);
			g.fillOval(275, 300, 50, 50);
		}

		if (flowerCount >= 3)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(475, 300, 50, 50);
		}
		if (flowerCount >= 4)
		{
			g.setColor(Color.BLUE);
			g.fillOval(675, 300, 50, 50);
		}
		if (flowerCount >= 5)
		{
			g.setColor(Color.PINK);
			g.fillOval(875, 300, 50, 50);
		}
		if (flowerCount >= 6)
		{
			g.setColor(Color.MAGENTA);
			g.fillOval(1075, 300, 50, 50);
		}

		Graphics2D g2d=(Graphics2D)g;

		if (flowerCount >= 1)
		{
			Image flower1 = new ImageIcon("sw_Luke.jpg").getImage();
			g2d.translate(25,255);
			g2d.rotate(-3.14159/6);
			g2d.drawImage(flower1, 0,0,55,75,null);
			g2d.translate(-20,-255);
			g2d.translate(-50,330);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,55,75,null);
			g2d.translate(-45,-330);
			g2d.translate(-20,400);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,55,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -105,-25,55,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -120,-125,55,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -50,-195,55,75,null);

		}
		if (flowerCount >= 2)
		{
			Image flower1 = new ImageIcon("sw_stormtrooper.jpg").getImage();
			g2d.translate(75,-265);
			g2d.rotate(-3.14159/6);
			g2d.drawImage(flower1, 0,0,55,75,null);
			g2d.translate(-20,-255);
			g2d.translate(-50,330);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,55,75,null);
			g2d.translate(-45,-330);
			g2d.translate(-20,400);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,55,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -105,-25,55,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -120,-125,55,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -50,-195,55,75,null);
		}

		if (flowerCount >= 3)
		{
			Image flower1 = new ImageIcon("sw_Leia.png").getImage();
			g2d.translate(3,-338);
			g2d.rotate(-3.14159/6);
			g2d.drawImage(flower1, 0,0,45,75,null);
			g2d.translate(-20,-255);
			g2d.translate(-50,330);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,45,75,null);
			g2d.translate(-45,-330);
			g2d.translate(-20,400);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,45,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -105,-25,45,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -120,-125,45,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -50,-195,45,75,null);
		}
		if (flowerCount >= 4)
		{
			Image flower1 = new ImageIcon("sw_darth.jpg").getImage();
			g2d.translate(-100,-367);
			g2d.rotate(-3.14159/6);
			g2d.drawImage(flower1, 0,0,45,75,null);
			g2d.translate(-20,-255);
			g2d.translate(-50,330);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,45,75,null);
			g2d.translate(-45,-330);
			g2d.translate(-20,400);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,45,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -105,-25,45,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -120,-125,45,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -50,-195,45,75,null);
		}
		if (flowerCount >= 5)
		{
			Image flower1 = new ImageIcon("hp_harry.png").getImage();
			g2d.translate(-198,-338);
			g2d.rotate(-3.14159/6);
			g2d.drawImage(flower1, 0,0,45,75,null);
			g2d.translate(-20,-255);
			g2d.translate(-50,330);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,45,75,null);
			g2d.translate(-45,-330);
			g2d.translate(-20,400);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,45,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -105,-25,45,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -120,-125,45,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -50,-195,45,75,null);
		}
		if (flowerCount >= 6)
		{
			Image flower1 = new ImageIcon("hp_hermoine.jpg").getImage();
			g2d.translate(-272,-265);
			g2d.rotate(-3.14159/6);
			g2d.drawImage(flower1, 0,0,52,75,null);
			g2d.translate(-20,-255);
			g2d.translate(-50,330);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,52,75,null);
			g2d.translate(-45,-330);
			g2d.translate(-20,400);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, 0,0,52,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -105,-25,52,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -120,-125,52,75,null);
			g2d.rotate(-3.14159/3);
			g2d.drawImage(flower1, -50,-195,52,75,null);
		}
	} 

}
