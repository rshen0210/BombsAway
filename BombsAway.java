/*
Ryan Shen
4/24/23
BombsAway.java
This is my java final project game
*/

import java.awt.*; import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*;
import java.util.Scanner;
import java.io.File;
import java.applet.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.util.TimerTask;
import java.util.ArrayList;
import java.awt.geom.AffineTransform;

public class BombsAway // main class of the video game 
{
	
	public BombsAway() // makes the frame
	{
		JFrame frame = new JFrame("BombsAway.java");
		frame.setSize(1000, 800);
		Manager pc = new Manager();
		frame.setContentPane(pc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String [] args) // creates an instance of the BombsAway class
	{
		BombsAway ba = new BombsAway();
	}
	
	class Manager extends JPanel // manages the panels using cardlayout
	{
		Home ho;
		StartPanel sp;
		HelpPanel hp;
		LevelTwo lt;
		InstructLevelOne pop;
		InstructLevelTwo bob;
		InstructLevelThree dob;
		InstructLevelFour bod;
		CardLayout c2;
		
		public Manager() // sets the cardlayout and adds cards
		{
			c2 = new CardLayout();
			setLayout(c2);
			
			ho = new Home(c2, this);
			add(ho, "home");
			sp = new StartPanel(c2, this);
			add(sp, "start");
			hp = new HelpPanel(c2, this);
			add(hp, "helpPanel");
			pop = new InstructLevelOne(c2, this);
			add(pop,"pop");
			bob = new InstructLevelTwo(c2, this);
			add(bob,"bob");
			dob = new InstructLevelThree(c2, this);
			add(dob, "dob");
			bod = new InstructLevelFour(c2, this);
			add(bod, "bod");
		}
	}
	
	
	class Home extends JPanel implements MouseListener, MouseMotionListener //  creates home panel for home page and declares variables
	{
		private int mouseX, mouseY, yoffset, xoffset;
		private Rectangle rect, rect2;
		boolean inStart, inShop;
		
		private CardLayout c2;
		private Manager primaryPanel;
		
		public Home(CardLayout c2In, Manager primaryPan) // adds listeners and initializes variables
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			addMouseListener(this);
			addMouseMotionListener(this);
			yoffset = 14;
			xoffset = 25;
			inStart = false;
			inShop = false;
			rect = new Rectangle(15,150,300+yoffset,150-xoffset);
			rect2 = new Rectangle(900, 700, 45+yoffset, 45+xoffset);
			
		}
			
		public void paintComponent(Graphics g) // Where the game is drawn using images and many gifs. 
		{
			super.paintComponent(g);
			
			
			Image backg1 = new ImageIcon("BomberBackground.jpg").getImage(); //image for background of main screen
			Image logo1 = new ImageIcon("titleLogo.png").getImage(); //image for logo
			Image explosion = new ImageIcon("Explosion.gif").getImage(); //gif for explosion
			Image Spinner = new ImageIcon("SpinnerPlane.gif").getImage();
			Image Start = new ImageIcon("StartButtonD.png").getImage();
			Image help = new ImageIcon("questionmark.png").getImage();
			Image flameShop = new ImageIcon("shopD.png").getImage();
			
			Image StartA = new ImageIcon("StartButton.png").getImage();
			Image flameShopA = new ImageIcon("shop.png").getImage();
			
			g.drawImage(backg1, 0, 0, 1000, 800, null);
			g.drawImage(logo1, 15, 25, 450, 200, null);
			g.drawImage(explosion, 400, 400, 50, 50, this);
			g.drawImage(Spinner, 400, 50, 300, 150, this);
			
			if (inStart)
			g.drawImage(StartA, 15, 150, 350, 175, null);
			else
			g.drawImage(Start, 15, 150, 300, 150, null);
			g.drawImage(help, 900, 700, 45, 45, null);
			
		}
		public void mousePressed (MouseEvent e) // activates when mouse is pressing (using this for switching panels)
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (rect.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "start");
			}
			if (rect2.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "helpPanel");
			}
		}
		public void mouseReleased (MouseEvent e) // is activated when the user releases left click
		{
		}
		public void mouseClicked (MouseEvent e) // checls for the clicking of the mouse
		{
		}
		public void mouseEntered (MouseEvent e) // checks and is activated when the mouse enteres the frame.
		{
		}
		public void mouseExited (MouseEvent e) // is activated when the mouse exits the frame.
		{
		}
		public void mouseDragged (MouseEvent e) // is activated when the mouse holds down left click and is moved
		{
		}
		public void mouseMoved (MouseEvent e) // checking if the mouse is hovering over the buttons
		{
			if (rect.contains(e.getX(), e.getY())) {
				inStart = true;
			}
			else {
				inStart = false;
			}
			repaint();
		}
	}
	
	
	class StartPanel extends JPanel implements MouseListener, MouseMotionListener// levels panel which takes you to the difficulty
	{
		private int mouseX, mouseY, yoffset, xoffset;
		private Rectangle rect, rect1, rect2, rect3, rect4;
		private CardLayout c2;
		private Manager primaryPanel;
		private boolean inL1, inL2, inL3, inL4,inB;
		public StartPanel(CardLayout c2In, Manager primaryPan) // sets the layout and adds buttons
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			addMouseListener(this);
			addMouseMotionListener(this);
			
			
			inL1 = false;
			inL2 = false;
			inL3 = false;
			inL4 = false;
			inB = false;
			yoffset = 0;
			xoffset = 25;
			rect = new Rectangle(75, 75, 125+yoffset, 100-xoffset);
			rect1 = new Rectangle(350, 100, 300+yoffset, 100-xoffset);
			rect2 = new Rectangle(350, 200, 300+yoffset, 100-xoffset);
			rect3 = new Rectangle(350, 350, 300+yoffset, 100-xoffset);
			rect4 = new Rectangle(350, 500, 300+yoffset, 100-xoffset);
		}
		public void paintComponent(Graphics g) // paints the background for the levels page, includes level buttons and a back button
		{
			super.paintComponent(g);
			Image background2 = new ImageIcon("PlaneBackground.jpeg").getImage();
			Image Level1 = new ImageIcon("Level1.png").getImage();
			Image Level2 = new ImageIcon("Level2.png").getImage();
			Image Level3 = new ImageIcon("Level3.png").getImage();
			Image Level4 = new ImageIcon("Level4.png").getImage();
			Image Level1W = new ImageIcon("Level1White.png").getImage();
			Image Level2W = new ImageIcon("Level2White.png").getImage();
			Image Level3W = new ImageIcon("Level3White.png").getImage();
			Image Level4W = new ImageIcon("Level4White.png").getImage();
			
			Image backButton = new ImageIcon("backButton.png").getImage();
			Image backButtonW = new ImageIcon("backWhite.png").getImage();
			
			g.drawImage(background2, 0,0,1000,800, null);
			if (inL1)
			g.drawImage(Level1, 350, 50, 350, 125, null);
			else
			g.drawImage(Level1W, 350, 50, 300, 100, null);
			if (inL2)
			g.drawImage(Level2, 350, 200, 350, 125, null);
			else
			g.drawImage(Level2W, 350, 200, 300, 100, null);
			if (inL3)
			g.drawImage(Level3, 350, 350, 350, 125, null);
			else
			g.drawImage(Level3W, 350, 350, 300, 100, null);
			if (inL4)
			g.drawImage(Level4, 350, 500, 350, 125, null);
			else
			g.drawImage(Level4W, 350, 500, 300, 100, null);
			if (inB)
			g.drawImage(backButton, 75, 75, 150, 125, null);
			else
			g.drawImage(backButtonW, 75, 75, 125, 100, null);
		}
		public void mousePressed (MouseEvent e) // checks to see if mouse is pressing one of the switch panel buttons
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (rect.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "home");
			}
			if (rect1.contains(e.getX(), e.getY())) {
				LevelOne l1 = new LevelOne(c2, primaryPanel);
				primaryPanel.add(l1, "one");
				c2.show(primaryPanel, "one");
			}
			if (rect2.contains(e.getX(), e.getY())) {
				LevelTwo l2 = new LevelTwo(c2, primaryPanel);
				primaryPanel.add(l2, "two");
				c2.show(primaryPanel, "two");
			}
			if (rect3.contains(e.getX(), e.getY())) {
				LevelThree l3 = new LevelThree(c2, primaryPanel);
				primaryPanel.add(l3, "three");
				c2.show(primaryPanel, "three");
			}
			if (rect4.contains(e.getX(), e.getY())) {
				LevelFour l4 = new LevelFour(c2, primaryPanel);
				primaryPanel.add(l4, "four");
				c2.show(primaryPanel, "four");
			}
		}
		public void mouseReleased (MouseEvent e) // checks for when the mouse is released
		{
		}
		public void mouseClicked (MouseEvent e) // checks for the clicking of a mouse
		{
		}
		public void mouseEntered (MouseEvent e) // is activated when the mouse enters the frame
		{
		}
		public void mouseExited (MouseEvent e) // is activated when the mouse exits the frame
		{
		}
		public void mouseDragged (MouseEvent e) // is activated when the user drags by holding left click and moving the mouse
		{
		}
		public void mouseMoved (MouseEvent e) // checking if the mouse is on the buttons.
		{
			if (rect.contains(e.getX(), e.getY())) inB = true;
			else
			inB = false;
			if (rect1.contains(e.getX(), e.getY())) inL1 = true;
			else
			inL1 = false;
			if (rect2.contains(e.getX(), e.getY())) inL2 = true;
			else
			inL2 = false;
			if (rect3.contains(e.getX(), e.getY())) inL3 = true;
			else
			inL3 = false;
			if (rect4.contains(e.getX(), e.getY())) inL4 = true;
			else
			inL4 = false;
			repaint();
		}
		
	}
	class InstructLevelOne extends JPanel implements MouseListener, MouseMotionListener // paints the page for level one instructions and adds a few buttons
	{
		private CardLayout c2;
		private Manager primaryPanel;
		private boolean inB;
		private Rectangle rect1;
		private int mouseX, mouseY;
		public InstructLevelOne(CardLayout c2In, Manager primaryPan) // initializes level one's instruction page variables and adds its personalized listeners
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			
			addMouseListener(this);
			addMouseMotionListener(this);
			setLayout(new FlowLayout());
			inB = false;
			rect1 = new Rectangle(75, 75, 125, 100);
		}
		public void paintComponent(Graphics g) // this is the paint component for the help page, paints background
		{
			super.paintComponent(g);
			
			Image backW = new ImageIcon("WarBackground.png").getImage();
			Image backButton = new ImageIcon("backButton.png").getImage();
			Image backButtonW = new ImageIcon("backWhite.png").getImage();
			
			g.drawImage(backW, 0, 0, 1000, 800, this);
			if (inB)
			g.drawImage(backButton, 75, 75, 150, 125, null);
			else
			g.drawImage(backButtonW, 75, 75, 125, 100, null);
		}
		public void mousePressed (MouseEvent e) // checks to see if mouse is pressing one of the switch panel buttons
		{
		}
		public void mouseReleased (MouseEvent e) // checks for when the mouse is released
		{
		}
		public void mouseClicked (MouseEvent e) // checks for the clicking of a mouse
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (rect1.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "helpPanel");
			}
			
		}
		public void mouseEntered (MouseEvent e) // is activated when the mouse enters the frame
		{
		}
		public void mouseExited (MouseEvent e) // is activated when the mouse exits the frame
		{
		}
		public void mouseDragged (MouseEvent e) // is activated when the user drags by holding left click and moving the mouse
		{
		}
		public void mouseMoved (MouseEvent e) // checking if the mouse is on the buttons.
		{
			if (rect1.contains(e.getX(), e.getY())) {
				inB = true;
			}
			else inB = false;
			repaint();
		}
	}
	class InstructLevelTwo extends JPanel implements MouseListener, MouseMotionListener // this paints the screen of the level two instructions page
	{
		private CardLayout c2;
		private Manager primaryPanel;
		private boolean inB;
		private Rectangle rect1;
		private int mouseX, mouseY;
		public InstructLevelTwo(CardLayout c2In, Manager primaryPan) // initializes variables and adds listeners
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			
			addMouseListener(this);
			addMouseMotionListener(this);
			setLayout(new FlowLayout());
			inB = false;
			rect1 = new Rectangle(75, 75, 125, 100);
		}
		public void paintComponent(Graphics g) // this is the paint component for the help page, paints background
		{
			super.paintComponent(g);
			
			Image backW2 = new ImageIcon("WarBackground2.png").getImage();
			Image backButton = new ImageIcon("backButton.png").getImage();
			Image backButtonW = new ImageIcon("backWhite.png").getImage();
			
			g.drawImage(backW2, 0, 0, 1000, 800, this);
			if (inB)
			g.drawImage(backButton, 75, 75, 150, 125, null);
			else
			g.drawImage(backButtonW, 75, 75, 125, 100, null);
		}
		public void mousePressed (MouseEvent e) // checks to see if mouse is pressing one of the switch panel buttons
		{
		}
		public void mouseReleased (MouseEvent e) // checks for when the mouse is released
		{
		}
		public void mouseClicked (MouseEvent e) // checks for the clicking of a mouse
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (rect1.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "helpPanel");
			}
			
		}
		public void mouseEntered (MouseEvent e) // is activated when the mouse enters the frame
		{
		}
		public void mouseExited (MouseEvent e) // is activated when the mouse exits the frame
		{
		}
		public void mouseDragged (MouseEvent e) // is activated when the user drags by holding left click and moving the mouse
		{
		}
		public void mouseMoved (MouseEvent e) // checking if the mouse is on the buttons.
		{
			if (rect1.contains(e.getX(), e.getY())) {
				inB = true;
			}
			else inB = false;
			repaint();
		}
	}
	class InstructLevelThree extends JPanel implements MouseListener, MouseMotionListener // paints the page for level one instructions and adds a few buttons
	{
		private CardLayout c2;
		private Manager primaryPanel;
		private boolean inB;
		private Rectangle rect1;
		private int mouseX, mouseY;
		public InstructLevelThree(CardLayout c2In, Manager primaryPan) // initializes level one's instruction page variables and adds its personalized listeners
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			
			addMouseListener(this);
			addMouseMotionListener(this);
			setLayout(new FlowLayout());
			inB = false;
			rect1 = new Rectangle(75, 75, 125, 100);
		}
		public void paintComponent(Graphics g) // this is the paint component for the help page, paints background
		{
			super.paintComponent(g);
			
			Image backW = new ImageIcon("Level3Instruct.png").getImage();
			Image backButton = new ImageIcon("backButton.png").getImage();
			Image backButtonW = new ImageIcon("backWhite.png").getImage();
			
			g.drawImage(backW, 0, 0, 1000, 800, this);
			if (inB)
			g.drawImage(backButton, 75, 75, 150, 125, null);
			else
			g.drawImage(backButtonW, 75, 75, 125, 100, null);
		}
		public void mousePressed (MouseEvent e) // checks to see if mouse is pressing one of the switch panel buttons
		{
		}
		public void mouseReleased (MouseEvent e) // checks for when the mouse is released
		{
		}
		public void mouseClicked (MouseEvent e) // checks for the clicking of a mouse
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (rect1.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "helpPanel");
			}
			
		}
		public void mouseEntered (MouseEvent e) // is activated when the mouse enters the frame
		{
		}
		public void mouseExited (MouseEvent e) // is activated when the mouse exits the frame
		{
		}
		public void mouseDragged (MouseEvent e) // is activated when the user drags by holding left click and moving the mouse
		{
		}
		public void mouseMoved (MouseEvent e) // checking if the mouse is on the buttons.
		{
			if (rect1.contains(e.getX(), e.getY())) {
				inB = true;
			}
			else inB = false;
			repaint();
		}
	}
	class InstructLevelFour extends JPanel implements MouseListener, MouseMotionListener // paints the page for level one instructions and adds a few buttons
	{
		private CardLayout c2;
		private Manager primaryPanel;
		private boolean inB;
		private Rectangle rect1;
		private int mouseX, mouseY;
		public InstructLevelFour(CardLayout c2In, Manager primaryPan) // initializes level one's instruction page variables and adds its personalized listeners
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			
			addMouseListener(this);
			addMouseMotionListener(this);
			setLayout(new FlowLayout());
			inB = false;
			rect1 = new Rectangle(75, 75, 125, 100);
		}
		public void paintComponent(Graphics g) // this is the paint component for the help page, paints background
		{
			super.paintComponent(g);
			
			Image backW = new ImageIcon("Level4Instruct.png").getImage();
			Image backButton = new ImageIcon("backButton.png").getImage();
			Image backButtonW = new ImageIcon("backWhite.png").getImage();
			
			g.drawImage(backW, 0, 0, 1000, 800, this);
			if (inB)
			g.drawImage(backButton, 75, 75, 150, 125, null);
			else
			g.drawImage(backButtonW, 75, 75, 125, 100, null);
		}
		public void mousePressed (MouseEvent e) // checks to see if mouse is pressing one of the switch panel buttons
		{
		}
		public void mouseReleased (MouseEvent e) // checks for when the mouse is released
		{
		}
		public void mouseClicked (MouseEvent e) // checks for the clicking of a mouse
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (rect1.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "helpPanel");
			}
			
		}
		public void mouseEntered (MouseEvent e) // is activated when the mouse enters the frame
		{
		}
		public void mouseExited (MouseEvent e) // is activated when the mouse exits the frame
		{
		}
		public void mouseDragged (MouseEvent e) // is activated when the user drags by holding left click and moving the mouse
		{
		}
		public void mouseMoved (MouseEvent e) // checking if the mouse is on the buttons.
		{
			if (rect1.contains(e.getX(), e.getY())) {
				inB = true;
			}
			else inB = false;
			repaint();
		}
	}
	class HelpPanel extends JPanel implements MouseListener, MouseMotionListener// help page where instructions for the game is found
	{
		private CardLayout c2;
		private Manager primaryPanel;
		private boolean inL1, inL2, inL3, inL4, inB;
		private Rectangle rect1;
		private Rectangle rect2;
		private Rectangle rect3;
		private Rectangle rect4;
		private Rectangle rect5;
		private int mouseX, mouseY;
		public HelpPanel(CardLayout c2In, Manager primaryPan) // sets layouts and adds buttons
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			
			addMouseListener(this);
			addMouseMotionListener(this);
			
			setLayout(new FlowLayout());
			rect1 = new Rectangle(75, 200, 300, 100);
			rect2 = new Rectangle(75, 300, 300, 100);
			rect4 = new Rectangle(75, 400, 300, 100);
			rect5 = new Rectangle(75, 500, 300, 100);
			rect3 = new Rectangle(700, 50, 125, 100);
			inL1 = false;
			inL2 = false;
			inL3 = false;
			inL4 = false;
			inB = false;
		}
		public void paintComponent(Graphics g) // this is the paint component for the help page, paints background
		{
			super.paintComponent(g);
			
			Image firstBack = new ImageIcon("firstBackground.png").getImage();
			Image backW2 = new ImageIcon("WarBackground2.png").getImage();
			Image backW = new ImageIcon("WarBackground.png").getImage();
			Image Level1W = new ImageIcon("Level1White.png").getImage();
			Image Level2W = new ImageIcon("Level2White.png").getImage();
			Image Level3W = new ImageIcon("Level3White.png").getImage();
			Image Level4W = new ImageIcon("Level4White.png").getImage();
			
			Image Level1 = new ImageIcon("Level1.png").getImage();
			Image Level2 = new ImageIcon("Level2.png").getImage();
			Image Level3 = new ImageIcon("Level3.png").getImage();
			Image Level4 = new ImageIcon("Level4.png").getImage();
			Image backButton = new ImageIcon("backButton.png").getImage();
			Image backButtonW = new ImageIcon("backWhite.png").getImage();
			
			g.drawImage(firstBack, 0, 0, 1000, 800, null);
			if (inL1)
			g.drawImage(Level1, 75, 200, 350, 125, null);
			else
			g.drawImage(Level1W, 75, 200, 300, 100, null);
			if (inL2)
			g.drawImage(Level2, 75, 300, 350, 125, null);
			else
			g.drawImage(Level2W, 75, 300, 300, 100, null);
			
			if (inL3)
			g.drawImage(Level3, 75, 400, 350, 125, null);
			else
			g.drawImage(Level3W, 75, 400, 300, 100, null);
			if (inL4)
			g.drawImage(Level4, 75, 500, 350, 125, null);
			else
			g.drawImage(Level4W, 75, 500, 300, 100, null);
			
			
			if (inB)
			g.drawImage(backButton, 700, 50, 150, 125, null);
			else
			g.drawImage(backButtonW, 700, 50, 125, 100, null);
		}
		public void mousePressed (MouseEvent e) // checks to see if mouse is pressing one of the switch panel buttons
		{
		}
		public void mouseReleased (MouseEvent e) // checks for when the mouse is released
		{
		}
		public void mouseClicked (MouseEvent e) // checks for the clicking of a mouse
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (rect1.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "pop");
			}
			if (rect2.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "bob");
			}
			if (rect4.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "dob");
			}
			if (rect5.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "bod");
			}
			if (rect3.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "home");
			}
		}
		public void mouseEntered (MouseEvent e) // is activated when the mouse enters the frame
		{
		}
		public void mouseExited (MouseEvent e) // is activated when the mouse exits the frame
		{
		}
		public void mouseDragged (MouseEvent e) // is activated when the user drags by holding left click and moving the mouse
		{
		}
		public void mouseMoved (MouseEvent e) // checking if the mouse is on the buttons.
		{
			if (rect1.contains(e.getX(), e.getY())) {
				inL1 = true;
			}
			else inL1 = false;
			if (rect2.contains(e.getX(), e.getY())) {
				inL2 = true;
			}
			else inL2 = false;
			if (rect3.contains(e.getX(), e.getY())) {
				inB = true;
			}
			
			if (rect4.contains(e.getX(), e.getY())) {
				inL3 = true;
			}
			else inL3 = false;
			if (rect5.contains(e.getX(), e.getY())) {
				inL4 = true;
			}
			else inL4 = false;
			
			if (rect3.contains(e.getX(), e.getY())) {
				inB = true;
			}
			
			
			else inB = false;
			repaint();
		}
		
	}
	class LevelOne extends JPanel implements KeyListener, MouseMotionListener, MouseListener // panel for level one: Easy Level (simple plane level linear movement)
	{
		private CardLayout c2;
		private Manager primaryPanel;
		private boolean left, right, planeDrop, bombDrop, explode, inHome, win, lose;
		private int planeY, planeX, tankX, tankY, planeSpeed, tankSpeed, bombSpeed, bulletSpeed;
		private int xoffset, yoffset, plane2Y, plane2X, mouseX, mouseY;
		private int baseHealth, planeHealth, plane2Health;
		ArrayList<Bullet> bulletlist = new ArrayList<Bullet>();
		ArrayList<BombMover> bomblist = new ArrayList<BombMover>();
		private Timer tanktimer;
		private Timer planetimer;
		private Timer bombtimer;
		private Timer timeInterval;
		private Timer timer;
		private Timer timer2;
		private Timer timer3;
		private Rectangle planeRect;
		private Rectangle planeRect2;
		private Rectangle rect1;
		private Rectangle rect2;
		Image warB, tanks, tanks2, planes, planes2, bombs, bullet, explosion, health1, health2, health3, health4, health5, health6;
		Image healthBar1, healthBar2, healthBar3;
		
		public LevelOne(CardLayout c2In, Manager primaryPan) // sets layout and instatiates variables
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			
			setLayout(new FlowLayout());
			addKeyListener(this);
			addMouseListener(this);
			addMouseMotionListener(this);
			
			warB = new ImageIcon("militaryBase.png").getImage();
			tanks = new ImageIcon("movingTanks.png").getImage();
			tanks2 = new ImageIcon("movingTanks1.png").getImage();
			planes = new ImageIcon("plane1.png").getImage();
			planes2 = new ImageIcon("plane2.png").getImage();
			bombs = new ImageIcon("bombs.png").getImage();
			bullet = new ImageIcon("bullet.png").getImage();
			explosion = new ImageIcon("Explosion.gif").getImage();
			health1 = new ImageIcon("Health1.png").getImage();
			health2 = new ImageIcon("Health2.png").getImage();
			health3 = new ImageIcon("Health3.png").getImage();
			health4 = new ImageIcon("Health4.png").getImage();
			health5 = new ImageIcon("Health5.png").getImage();
			health6 = new ImageIcon("Health6.png").getImage();
			healthBar1 = new ImageIcon("PlaneHealth1.png").getImage();
			healthBar2 = new ImageIcon("PlaneHealth2.png").getImage();
			healthBar3 = new ImageIcon("BaseHealth.png").getImage();
			
			yoffset = 20;
			xoffset = 25;
			
			planeX = 800;
			planeY = 50;
			planeSpeed = 10;
			planeRect = new Rectangle(planeX+xoffset, planeY+yoffset, 240, 100);
			
			plane2X = 300;
			plane2Y = 200;
			planeRect2 = new Rectangle(plane2X+xoffset, plane2Y+yoffset, 240, 100);
			
			tankX = 100;
			tankY = 500;
			tankSpeed = 3;
			
			bombSpeed = 10;
			
			bulletSpeed = 1;
			
			baseHealth = 3;
			
			plane2Health = 5;
			planeHealth = 5;
			
			right = true;
			left = false;
			
			explode = true;
			
			inHome = false;
			win = false;
			lose = false;
			
			rect1 = new Rectangle(300, 500, 400, 75);
			
			TankMover tankmover = new TankMover();
			tanktimer = new Timer(tankSpeed, tankmover);
			tanktimer.start();
			
			PlaneMover planemover = new PlaneMover();
			planetimer = new Timer(planeSpeed, planemover);
			planetimer.start();
			
			
			BombDrop bombdrop = new BombDrop(100, 1);
			timer = new Timer(2000, bombdrop);
			timer.start();
			
			BombDrop bombdrop2 = new BombDrop(250, 2);
			timer2 = new Timer(3000, bombdrop2);
			timer2.start();
			
			timer3 = new Timer(2300, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e)
				{
					explode = false;
				}
			});
			
		}
		private void win(Graphics g) // paints the background for when you win
		{
			Image win = new ImageIcon("Fireworks.gif").getImage();
			Image winText = new ImageIcon("winText.png").getImage();
			Image warB = new ImageIcon("militaryBase.png").getImage();
			Image toHome = new ImageIcon("toHome.png").getImage();
			Image toHomeW = new ImageIcon("toHomeW.png").getImage();
			timer3.start();
			g.drawImage(warB, 0, 0, 1000, 800, null);
			if (explode)
			{
				g.drawImage(win, 0, 0, 1000, 800, this);
				g.drawImage(winText,275, 350,450, 100, null);
			}
			else
			timer3.stop();
			
			if (inHome)
			g.drawImage(toHome, 300, 500, 450, 100, null);
			else
			g.drawImage(toHomeW, 300, 500, 400, 75, null);
			stopTimers();
		}
		private void lose(Graphics g) // paints the background for when you lose
		{
			Image fighterPlane = new ImageIcon("fighterPlane.png").getImage();
			Image toHome = new ImageIcon("toHome.png").getImage();
			Image toHomeW = new ImageIcon("toHomeW.png").getImage();
			Image losing = new ImageIcon("youLost.png").getImage();
			g.drawImage(fighterPlane, 0, 0, 1000, 800, null);
			g.drawImage(losing, 200, 300, 600, 200, null);
			if (inHome)
			g.drawImage(toHome, 300, 500, 450, 100, null);
			else
			g.drawImage(toHomeW, 300, 500, 400, 75, null);
			stopTimers();
		}
		private void stopTimers() // stops all the timers at the end of the game
		{
			timer.stop();
			timer2.stop();
			planetimer.stop();
			tanktimer.stop();
			for (BombMover b : bomblist)
			{
				b.stopBomb();
			}
			for (Bullet x : bulletlist)
			{
				x.stopBullet();
				x.fireTimer.stop();
				x.fireTimer2.stop();
			}
		}
		public void paintComponent(Graphics g) //paints background for level 1 and aids with animations
		{
			super.paintComponent(g);
			
			
			
			
			if (planeHealth <= 0 && plane2Health <= 0)
			{
				win = true;
				win(g);
			}
			else if (baseHealth <= 0)
			{
				lose = true;
				lose(g);
			}
			else
			{
				if (planeHealth <= 0)
				{
					g.drawImage(health6, 10,125,400, 25, null);
					timer.stop();
				}
				
				if (plane2Health <= 0)
				{
					timer2.stop();
				}
				
				g.drawImage(warB, 0, 0, 1000, 800, null);
				g.drawImage(healthBar2, 0, 10, 400, 75, null);
				g.drawImage(healthBar1, 600, 10, 400, 75, null);
				if (planeHealth <= 0)
				{
					g.drawImage(health6, 0,100,400, 25, null);
				}
				else if (planeHealth == 5)
				{
					g.drawImage(health1, 0,100,400, 25, null);
				}
				else if (planeHealth == 4)
				{
					g.drawImage(health2, 0,100,400, 25, null);
				}
				else if (planeHealth == 3)
				{
					g.drawImage(health3, 0,100,400, 25, null);
				}
				else if (planeHealth == 2)
				{
					g.drawImage(health4, 0,100,400, 25, null);
				}
				else if (planeHealth == 1)
				{
					g.drawImage(health5, 0,100,400, 25, null);
				}
				
				
				if (plane2Health <= 0)
				{
					g.drawImage(health6, 600,100,400, 25, null);
				}
				else if (plane2Health == 5)
				{
					g.drawImage(health1, 600,100,400, 25, null);
				}
				else if (plane2Health == 4)
				{
					g.drawImage(health2, 600,100,400, 25, null);
				}
				else if (plane2Health == 3)
				{
					g.drawImage(health3, 600,100,400, 25, null);
				}
				else if (plane2Health == 2)
				{
					g.drawImage(health4, 600,100,400, 25, null);
				}
				else if (plane2Health == 1)
				{
					g.drawImage(health5, 600,100,400, 25, null);
				}
				
				if (baseHealth == 1)
				{
					g.drawImage(health6, 300,700,400, 25, null);
				}
				else if (baseHealth == 2)
				{
					g.drawImage(health3, 300,700,400, 25, null);
				}
				else if (baseHealth == 3)
				{
					g.drawImage(health1, 300,700,400, 25, null);
				}
				
				if (right) 
				{
					g.drawImage(tanks, tankX, tankY, 300, 200, null);
				}
				else
				{
					g.drawImage(tanks2, tankX, tankY, 300, 200, null);
				}
				if (planeHealth > 0) 
				{
					g.drawImage(planes, planeX, planeY, 300, 200, null);
				}
				if (plane2Health > 0) 
				{
					g.drawImage(planes2, plane2X, plane2Y, 300, 200, null);
				}
				
				
				for (Bullet x : bulletlist)
				{
					if (x.fire)
					{
						g.drawImage(bullet, x.bulletX, x.bulletY, 100, 200, null);
						x.bulletRect.setLocation(x.bulletX, x.bulletY);
						if (planeHealth > 0 && planeRect.intersects(x.bulletRect))
						{
							planeHealth--;
							x.fireAnimate = true;
							x.fireTimer.start();
							
							x.stopBullet();
						}
						if (plane2Health > 0 && planeRect2.intersects(x.bulletRect))
						{
							plane2Health--;
							x.fireAnimate2 = true;
							x.fireTimer2.start();
							
							x.stopBullet();
						}
					}
					if (x.fireAnimate)
					{
						g.drawImage(explosion, planeX, planeY+70, 250, 75, this);
					}
					if (x.fireAnimate2) 
					{
						g.drawImage(explosion, plane2X, plane2Y+70, 250, 75, this);
					}
				}
				for (BombMover b : bomblist)
				{
					if (b.bombDrop)
					{
						g.drawImage(bombs, b.bombX, b.bombY, 75, 175, null);
						b.bombRect.setLocation(b.bombX,b.bombY);
						for (int i = 0;i<bulletlist.size();i++)
						{
							Bullet x = bulletlist.get(i);
							if (x.fire) {
								if (b.bombRect.intersects(x.bulletRect))
								{
									g.drawImage(explosion, b.bombX, b.bombY, 400, 400, this);
									b.stopBomb();
									x.stopBullet();
									bulletlist.remove(i);
									i--;
								}
							}
						}
					}
				}
			}
		}
		class BombDrop implements ActionListener // times how often the bomb is dropped
		{
			int bombHeight;
			int whichPlane;
			public BombDrop(int _bombHeight, int _whichPlane) // initilizes the variables whichPlane and bombHeight
			{
				whichPlane = _whichPlane;
				bombHeight = _bombHeight;
			}
			public void actionPerformed(ActionEvent e) { // is used just to set the bomb drop as true
				BombMover bomb;
				if (whichPlane == 1)
				{
					bomb = new BombMover(bombHeight, planeX);
				}
				else {
					bomb = new BombMover(bombHeight, plane2X);
				}
				bomblist.add(bomb);
			}
		}
		
		class PlaneMover implements ActionListener // moves plane in one direction
		{
			public void actionPerformed(ActionEvent e) // this helps with the planes movement left and right
			{
				// car XY location
				planeX--;
				plane2X++;
				
				if (planeX < 0) planeX = 800;
				planeRect.setLocation(planeX+xoffset, planeY+yoffset);
				repaint();
				
				if (plane2X > 800) plane2X = 0; 
				planeRect2.setLocation(plane2X+xoffset, plane2Y+yoffset);
				repaint();
				
				grabFocus();
			}
		} // end CarMover
		class TankMover implements ActionListener //moves tanks left and right
		{
			public void actionPerformed(ActionEvent e) //moves the tank and resets its location
			{
				if (right) {
					// car XY location
					tankX++;
					if (tankX > 800) tankX = 0;
					repaint();
					grabFocus();
				}
				if (left) {
					tankX--;
					if (tankX < 0) tankX = 800;
					repaint();
					grabFocus();
				}
			}
		} // end CarMover
		class BombMover implements ActionListener // moves the bombs for plane 1
		{
			public int bombY, bombX;
			public boolean bombDrop;
			Rectangle bombRect;
			Timer bombtimer;
			public BombMover(int bombHeight, int bombPlace) // this constructor just instantiates the timer and sets values of integers/booleans
			{
				bombX = bombPlace+30;
				bombY = bombHeight;
				bombDrop = true;
				bombtimer = new Timer(bombSpeed, this);
				bombRect = new Rectangle(bombX+xoffset, bombY+yoffset, 75, 175);
				bombtimer.start();
			}
			public void actionPerformed(ActionEvent e) // this is performed every time the bombmover class is called
			{
				bombY++;
				if (bombY > 600) {
					baseHealth--;
					stopBomb();
				}
				repaint();
				grabFocus();
			}
			public void stopBomb() // this is just a method that stops the bomb and makes it disappear
			{
				bombDrop = false;
				bombtimer.stop();
				bombX = -100;
				bombY = -100;
			}
		}
		
		class Bullet implements ActionListener //moves the bullet from the tank
		{
			public static int numberOfBullets = 0;
			public int bulletX, bulletY, bulletId;
			public boolean fire, fireAnimate, fireAnimate2;
			Timer bullettimer, fireTimer, fireTimer2;
			Rectangle bulletRect;
			public Bullet() // instantiating variables and setting base values
			{
				numberOfBullets++;
				bulletId = numberOfBullets;
				bulletY = 500;
				bulletX = tankX+50;
				fire = true;
				fireAnimate = false;
				fireAnimate2 = false;
				bulletRect = new Rectangle(bulletX-xoffset, bulletY, 100, 200);
				Bullet thisBullet = this;
				fireTimer = new Timer(500, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e)
					{
						fireAnimate = false;
						fireTimer.stop();
						bulletlist.remove(thisBullet);
					}
				});
				fireTimer2 = new Timer(500, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e)
					{
						fireAnimate2 = false;
						fireTimer2.stop();
						bulletlist.remove(thisBullet);
					}
				});
				bullettimer = new Timer(bulletSpeed, this);
				bullettimer.start();
			}
			public void actionPerformed(ActionEvent e) // this method makes the bullet move
			{
				bulletY--;
				if (bulletY < -150) {
					bulletlist.remove(this);
					stopBullet();
				}
				repaint();
				grabFocus();
			}
			public void stopBullet() // this method makes the bullet stop
			{
				fire = false;
				bullettimer.stop();
				bulletX = 3000;
				bulletY = 3000;
			}
			@Override
			public boolean equals(Object x) // required for the remove function to work with arraylists
			{
				return (((Bullet)x).bulletId == bulletId);
			}
		}
		public void keyTyped (KeyEvent e) // listens for when a key is typed and is required for keylistener to work
		{
		}
		public void keyReleased (KeyEvent e) // listens for the releasement of a key and is required for keylistener to work
		{
		}
		public void keyPressed (KeyEvent e) // listens for when a key is pressed down (this method is also used to move the tank)
		{
			if (baseHealth > 0)
			{	
				int c = e.getKeyCode();
				switch (c) {
				case KeyEvent.VK_RIGHT:
					right = true;
					left = false;
					tanktimer.stop();
					TankMover tankmover1 = new TankMover();
					tanktimer = new Timer(tankSpeed, tankmover1);
					if (right) tanktimer.start();
					break;
					
				case KeyEvent.VK_LEFT:
					left = true;
					right = false;
					tanktimer.stop();
					TankMover tankmover2 = new TankMover();
					tanktimer = new Timer(tankSpeed, tankmover2);
					if (left) tanktimer.start();
					break;
				case KeyEvent.VK_UP:
					if (bulletlist.size() < 2) 
					{
						Bullet bullet = new Bullet();
						bulletlist.add(bullet);
					}
				}
			}
		}
		public void mousePressed (MouseEvent e) // checks to see if mouse is pressing one of the switch panel buttons
		{
		}
		public void mouseReleased (MouseEvent e) // checks for when the mouse is released
		{
		}
		public void mouseClicked (MouseEvent e) // checks for the clicking of a mouse
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (win || lose) {
				if (rect1.contains(e.getX(), e.getY())) {
					c2.show(primaryPanel, "start");
				}
			}
			
		}
		public void mouseEntered (MouseEvent e) // is activated when the mouse enters the frame
		{
		}
		public void mouseExited (MouseEvent e) // is activated when the mouse exits the frame
		{
		}
		public void mouseDragged (MouseEvent e) // is activated when the user drags by holding left click and moving the mouse
		{
		}
		public void mouseMoved (MouseEvent e) // checking if the mouse is on the buttons.
		{
			if (win || lose) {
				if (rect1.contains(e.getX(), e.getY())) {
					inHome = true;
				}
				else inHome = false;
			}
			
			repaint();
		}
		
		
	}
	class LevelTwo extends JPanel implements KeyListener, MouseListener, MouseMotionListener// panel for level two: Medium Level (same tank movements but can only shoot at a certain plane)
	{
		private CardLayout c2;
		private Manager primaryPanel;
		private boolean right1, left, right2, left2, bombdrop, win, lose, explode1, inHome;
		private int mouseX, mouseY, plane1X, plane1Y, planeSpeed, planeHealth1;
		private int bomb1X, bomb1Y, bombspeed;
		private int tank1X, tank1Y, tankspeed, tankHealth, yoffset, xoffset;
		ArrayList<BombMover2> bomblist2 = new ArrayList<BombMover2>();
		ArrayList<Bullet> bulletlist = new ArrayList<Bullet>();
		private Timer planetimer, tanktimer, timer3, bombtimer, timer4, timer5;
		private Rectangle tankRect, planeRect, rect1;
		Image warB, plane1, plane1Reflect, tank1, tank1Reflect, bomb, explosion, health1, health2, health3, health4, health5, health6, planeHealthBar;
		Image missile, shield;
		public LevelTwo(CardLayout c2In, Manager primaryPan) // sets layout and initializes variables
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			
			setLayout(new FlowLayout());
			addMouseMotionListener(this);
			addMouseListener(this);
			addKeyListener(this);
			
			xoffset = 20;
			yoffset = 25;
			
			right1 = true;
			left = false;
			bombdrop = false;
			win = false;
			lose = false;
			explode1 = true;
			
			tankHealth = 5;
			tankspeed = 5;
			tank1X = 500;
			tank1Y = 600;
			tankRect = new Rectangle(tank1X+xoffset, tank1Y+yoffset, 200, 100);
			
			right2 = true;
			left2 = false;
			
			plane1X = 25;
			plane1Y = 100;
			planeSpeed = 3;
			planeHealth1 = 3;
			planeRect = new Rectangle(plane1X+xoffset, plane1Y+yoffset, 250, 150);
			
			bombspeed = 2;
			bomb1X = 400;
			bomb1Y = 400;
			rect1 = new Rectangle(300, 500, 400, 75);
			inHome = false;
			
			PlaneMover planemover = new PlaneMover();
			planetimer = new Timer(planeSpeed, planemover);
			planetimer.start();
///////////////// Need movements to be randomized and unpredictable, also in the midst of fixing tank barrel and it's rotation
			TankMover tankmover = new TankMover();
			tanktimer = new Timer(tankspeed, tankmover);
			tanktimer.start();
			
			warB = new ImageIcon("background2.png").getImage();
			plane1 = new ImageIcon("bob.png").getImage();
			plane1Reflect = new ImageIcon("bob1.png").getImage();
			tank1 = new ImageIcon("tanky1.png").getImage();
			tank1Reflect = new ImageIcon("tanky2.png").getImage();
			bomb = new ImageIcon("bomber.png").getImage();
			explosion = new ImageIcon("Explosion.gif").getImage();
			health1 = new ImageIcon("Health1.png").getImage();
			health2 = new ImageIcon("Health2.png").getImage();
			health3 = new ImageIcon("Health3.png").getImage();
			health4 = new ImageIcon("Health4.png").getImage();
			health5 = new ImageIcon("Health5.png").getImage();
			health6 = new ImageIcon("Health6.png").getImage();
			planeHealthBar = new ImageIcon("planeHealth.png").getImage();
			missile = new ImageIcon("missile.png").getImage();
			shield = new ImageIcon("Shield.png").getImage();
			
			timer3 = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if (left2) {
						right2 = true;
						left2 = false;
					}
					else {
						left2 = true;
						right2 = false;
					}
					int randomInt = randInt();
					timer3.setInitialDelay(randomInt);
					timer3.restart();
				}
			});
			timer3.start();
			
			timer4 = new Timer(2300, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e)
				{
					explode1 = false;
				}
			});
			
			timer5 = new Timer(3000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e)
				{
					int legY = 500;
					int legX = tank1X-plane1X; 
					double _angle = Math.atan(1.00*legY/legX);
					if (_angle < 0) {
						_angle += 3.1415926;
					}
					_angle = 3.1415926 - _angle;
					Bullet newBullet = new Bullet(_angle);
					bulletlist.add(newBullet);
				}
			});
			timer5.start();
		}
		private void lose(Graphics g)
		{
			Image losePage = new ImageIcon("losePage.gif").getImage();
			Image toHome = new ImageIcon("toHome.png").getImage();
			Image toHomeW = new ImageIcon("toHomeW.png").getImage();
			Image losing = new ImageIcon("youLost.png").getImage();
			g.drawImage(losePage, 0, 0, 1000, 800, this);
			g.drawImage(losing, 200, 300, 600, 200, null);
			if (inHome)
			g.drawImage(toHome, 300, 500, 450, 100, null);
			else
			g.drawImage(toHomeW, 300, 500, 400, 75, null);
		}
		private void win(Graphics g)
		{
			Image toHome = new ImageIcon("toHome.png").getImage();
			Image toHomeW = new ImageIcon("toHomeW.png").getImage();
			Image win = new ImageIcon("Fireworks.gif").getImage();
			Image winText = new ImageIcon("winText.png").getImage();
			Image winPage = new ImageIcon("winPage.jpeg").getImage();
			g.drawImage(winPage, 0, 0, 1000, 800, null);
			timer4.start();
			if (explode1)
			{
				g.drawImage(win, 0, 0, 1000, 800, this);
				g.drawImage(winText,275, 350,450, 100, null);
			}
			else
			timer4.stop();
			if (inHome)
			g.drawImage(toHome, 300, 500, 450, 100, null);
			else
			g.drawImage(toHomeW, 300, 500, 400, 75, null);
		}
		public void paintComponent(Graphics g) // paints the background for level 2 and helps with movement of plane and tank
		{
			Graphics2D g2d = (Graphics2D) g;
			AffineTransform oldXForm = g2d.getTransform();
			

			
			if (tankHealth <= 0)
			{
				win = true;
				win(g);
			}
			else if (planeHealth1 <= 0)
			{
				lose = true;
				lose(g);
			}
			else {
				g.drawImage(warB, 0, 0, 1000, 800, null);
				g.drawImage(planeHealthBar, 0, 25, 300, 50, null);
				
				if (tankHealth <= 0)
				{
					g.drawImage(health6, 350, 700, 300, 25, null);
				}
				else if (tankHealth == 1)
				{
					g.drawImage(health5, 350, 700, 300, 25, null);
				}
				else if (tankHealth == 2)
				{
					g.drawImage(health4, 350, 700, 300, 25, null);
				}
				else if (tankHealth == 3)
				{
					g.drawImage(health3, 350, 700, 300, 25, null);
				}
				else if (tankHealth == 4)
				{
					g.drawImage(health2, 350, 700, 300, 25, null);
				}
				else if (tankHealth == 5)
				{
					g.drawImage(health1, 350, 700, 300, 25, null);
				}
				
				
				if (planeHealth1 <= 0)
				{
					g.drawImage(health6, 0, 75, 300, 25, null);
				}
				else if (planeHealth1 == 1)
				{
					g.drawImage(health5, 0, 75, 300, 25, null);
				}
				else if (planeHealth1 == 2)
				{
					g.drawImage(health3, 0, 75, 300, 25, null);
				}
				else if (planeHealth1 == 3)
				{
					g.drawImage(health1, 0, 75, 300, 25, null);
				}
				
				if (right1)
				g.drawImage(plane1, plane1X, plane1Y, 250, 150, null);
				else
				g.drawImage(plane1Reflect, plane1X, plane1Y, 250, 150, null);
				
				if (right2)
				g.drawImage(tank1, tank1X, tank1Y, 200, 100, null);
				else
				g.drawImage(tank1Reflect, tank1X, tank1Y, 200, 100, null);
				
				
				for (BombMover2 x : bomblist2)
				{
					if (x.fire1)
					{
						g.drawImage(bomb, x.bomb1X, x.bomb1Y, 100, 200, null);
						x.bombRect1.setLocation(x.bomb1X, x.bomb1Y);
						if (tankHealth > 0 && tankRect.intersects(x.bombRect1)) // need to check health here as well
						{
							tankHealth--;
							x.fireAnimate1 = true;
							x.fireTimer1.start();
							
							x.stopBomb2();
						}
						/*if (plane2Health > 0 && planeRect2.intersects(x.bulletRect)) // used for the case where a second tank is added
						{
							plane2Health--;
							x.fireAnimate2 = true;
							x.fireTimer2.start();
							
							x.stopBullet();
						}*/
					}
					if (x.fireAnimate1)
					{
						g.drawImage(explosion, tank1X, tank1Y+70, 250, 75, this);
					}
					/*if (x.fireAnimate2) // for second plane case
					{
						g.drawImage(explosion, plane2X, plane2Y+70, 250, 75, this);
					}*/
				}
				
				for (Bullet x : bulletlist)
				{
					if (x.fire)
					{
						g.drawImage(shield, (int)(x.bulletX)- 100, (int)(x.bulletY)-100, 200, 100, this);
						x.bulletRect.setLocation((int)(x.bulletX), (int)(x.bulletY));
						planeRect.setLocation(plane1X, plane1Y);
						if (planeHealth1 > 0 && planeRect.intersects(x.bulletRect)) // need to check health here as well
						{
							planeHealth1--;
							x.fireAnimate1 = true;
							x.fireTimer1.start();
							
							x.stopBullet();
						}
						g2d.rotate(-x.angle, (int)(x.bulletX), (int)(x.bulletY));
						g.drawImage(missile, (int)(x.bulletX), (int)(x.bulletY), 100, 20, null);
					}
					g2d.setTransform(oldXForm);
					if (x.fireAnimate1)
					{
						g.drawImage(explosion, plane1X, plane1Y+70, 250, 75, this);
					}
				}
				
				tankShooting(g2d);
			}
		}
		public int randInt()
		{
			int randomInt;
			randomInt = 1000 * (int)(Math.random()*6+1);
			return randomInt;
		}
		public void tankShooting(Graphics2D g2d) // will be using this method to paint the turret on the tank and make it adjustable for the angle
		{
			Image tankBarrel = new ImageIcon("tankBarrel.png").getImage();
			int legY = 500;
			int legX = tank1X-plane1X; 
			double _angle = Math.atan(1.00*legY/legX);
			if (_angle < 0) {
				_angle += 3.1415926;
			}
			_angle = 3.1415926 - _angle;
			g2d.rotate(-_angle, tank1X+80, tank1Y);
			g2d.drawImage(tankBarrel, tank1X+80, tank1Y, 75, 30, null);
		}
		class Bullet implements ActionListener //
		{
			double bulletX, bulletY;
			Timer bullettimer, fireTimer1;
			double angle;
			boolean fire, fireAnimate1;
			Rectangle bulletRect;
			public Bullet(double _angle)
			{
				Bullet thisBullet = this;
				bulletX = tank1X+80;
				bulletY = tank1Y;
				angle = _angle;
				fireAnimate1 = false;
				bullettimer = new Timer(3, this);
				bullettimer.start();
				fire = true;
				bulletRect = new Rectangle((int)bulletX, (int)bulletY, 100, 50);
				fireTimer1 = new Timer(500, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e)
					{
						fireAnimate1 = false;
						fireTimer1.stop();
						bulletlist.remove(thisBullet);
					}
				});
			}
			public void actionPerformed(ActionEvent e)
			{
				bulletX += Math.cos(angle);
				bulletY -= Math.sin(angle);
				if (bulletX >= 1100 || bulletY <= -100 || bulletX <= -100)
				{
					stopBullet();
				}
			}
			private void stopBullet()
			{
				bullettimer.stop();
				fire = false;
			}
		}
				
		class PlaneMover implements ActionListener //moves tanks left and right
		{
			public void actionPerformed(ActionEvent e) //moves the tank and resets its location
			{
				if (right1) {
					// car XY location
					plane1X++;
					if (plane1X > 800) plane1X = 0;
					repaint();
					grabFocus();
				}
				if (left) {
					plane1X--;
					if (plane1X < 0) plane1X = 800;
					repaint();
					grabFocus();
				}
			}
		}
		class TankMover implements ActionListener //moves tanks left and right
		{
			public void actionPerformed(ActionEvent e) //moves the tank and resets its location
			{
				if (right2) {
					// car XY location
					tank1X++;
					if (tank1X > 800) tank1X = 0;
					repaint();
					grabFocus();
				}
				if (left2) {
					tank1X--;
					if (tank1X < 0) tank1X = 800;
					repaint();
					grabFocus();
				}
				tankRect.setLocation(tank1X+xoffset, tank1Y+yoffset);
			}
		}
		class BombMover2 implements ActionListener //
		{
			public static int numberOfBombs = 0;
			public int bomb1X, bomb1Y, bombId;
			public boolean fire1, fireAnimate1, fireAnimate3;
			Timer bombtimer1, fireTimer1, fireTimer3;
			Rectangle bombRect1;
			public BombMover2()
			{
				numberOfBombs++;
				bombId = numberOfBombs;
				bomb1Y = 25;
				bomb1X = plane1X+50;
				fire1 = true;
				fireAnimate1 = false;
				fireAnimate3 = false;
				bombRect1 = new Rectangle(bomb1X, bomb1Y, 100, 150);
				BombMover2 thisBomb = this;
				fireTimer1 = new Timer(500, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e)
					{
						fireAnimate1 = false;
						fireTimer1.stop();
						bomblist2.remove(thisBomb);
					}
				});
				/*fireTimer3 = new Timer(500, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e)
					{
						fireAnimate3 = false;
						fireTimer3.stop();
						bomblist2.remove(thisBomb);
					}
				});*/
				bombtimer1 = new Timer(bombspeed, this);
				bombtimer1.start();
			} 
			public void actionPerformed(ActionEvent e) //
			{
				bomb1Y++;	
				if (bomb1Y > 1000) {
					bomblist2.remove(this);
					stopBomb2();
				}
				repaint();
				grabFocus();
			}
			public void stopBomb2()
			{
				fire1 = false;
				bombtimer1.stop();
				bomb1X = 3000;
				bomb1Y = 3000;
			}
			@Override
			public boolean equals(Object x)
			{
				return (((BombMover2)x).bombId == bombId);
			}
		}
		public void keyTyped (KeyEvent e) // listens for when a key is typed and is required for keylistener to work
		{
		}
		public void keyReleased (KeyEvent e) // listens for the releasement of a key and is required for keylistener to work
		{
		}
		public void keyPressed (KeyEvent e) // listens for when a key is pressed down (this method is also used to move the tank)
		{
			int c = e.getKeyCode();
			switch (c) {
			case KeyEvent.VK_RIGHT:
				right1 = true;
				left = false;
				planetimer.stop();
				PlaneMover planemover = new PlaneMover();
				planetimer = new Timer(planeSpeed, planemover);
				if (right1) planetimer.start();
				break;
				
			case KeyEvent.VK_LEFT:
				left = true;
				right1 = false;
				planetimer.stop();
				PlaneMover planemover1 = new PlaneMover();
				planetimer = new Timer(planeSpeed, planemover1);
				if (left) planetimer.start();
				break;
			case KeyEvent.VK_DOWN:
				
				if (bomblist2.size() < 2)
				{
					BombMover2 bombmover45 = new BombMover2();
					bomblist2.add(bombmover45);
				}
			}
			
		}
		public void mousePressed (MouseEvent e) // checks to see if mouse is pressing one of the switch panel buttons
		{
		}
		public void mouseReleased (MouseEvent e) // checks for when the mouse is released
		{
		}
		public void mouseClicked (MouseEvent e) // checks for the clicking of a mouse
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (win || lose) {
				if (rect1.contains(e.getX(), e.getY())) {
					c2.show(primaryPanel, "start");
				}
			}
		}
		public void mouseEntered (MouseEvent e) // is activated when the mouse enters the frame
		{
		}
		public void mouseExited (MouseEvent e) // is activated when the mouse exits the frame
		{
		}
		public void mouseDragged (MouseEvent e) // is activated when the user drags by holding left click and moving the mouse
		{
		}
		public void mouseMoved (MouseEvent e) // checking if the mouse is on the buttons.
		{
			if (win || lose) {
				if (rect1.contains(e.getX(), e.getY())) {
					inHome = true;
				}
				else inHome = false;
			}
			
			repaint();
		}
	}
	class LevelThree extends LevelOne // panel for level three: (user switches to a submarine)
	{
		public LevelThree(CardLayout c2In, Manager primaryPan) // sets layout and adds some buttons
		{
			super(c2In, primaryPan);
			warB = new ImageIcon("oceanBackground.jpeg").getImage();
			
			tanks = new ImageIcon("submarine.png").getImage();
			tanks2 = new ImageIcon("submarine2.png").getImage();
			planes = new ImageIcon("boat1.png").getImage();
			planes2 = new ImageIcon("submarine.png").getImage();
			bombs = new ImageIcon("bomber1.png").getImage();
			explosion = new ImageIcon("Explosion.gif").getImage();
			bullet = new ImageIcon("subbullet.png").getImage();
			healthBar2 = new ImageIcon("TopBoatHealth.png").getImage();
			healthBar1 = new ImageIcon("LowerBoatHealth.png").getImage();
		}
	}
	class LevelFour extends LevelTwo // panel for level three: (user switches to a submarine)
	{
		
		public LevelFour(CardLayout c2In, Manager primaryPan) // sets layout and adds some buttons
		{
			super(c2In, primaryPan);
			warB = new ImageIcon("marsBackground.jpeg").getImage();
			
			plane1 = new ImageIcon("UFO.png").getImage();
			plane1Reflect = new ImageIcon("UFO.png").getImage();
			tank1 = new ImageIcon("rover1.png").getImage();
			tank1Reflect = new ImageIcon("rover.png").getImage();
			bomb = new ImageIcon("laser1.png").getImage();
			explosion = new ImageIcon("laserExplode.gif").getImage();
			planeHealthBar = new ImageIcon("planeHealth.png").getImage();
			missile = new ImageIcon("laser.png").getImage();
			shield = new ImageIcon("Shield.png").getImage();
		}
	}
	
}
