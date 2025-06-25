/*
Ryan Shen
4/24/23
BombsAway.java
This is my java final project game
*/

import java.awt.*; import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*;

public class BombsAway // main class of the video game 
{
	boolean playPressed;
	boolean controlsPressed;
	boolean helpPressed;
	
	
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
		FlamePanel fp;
		HelpPanel hp;
		LevelOne lo;
		LevelTwo lt;
		LevelThree l3;
		CardLayout c2;
		
		public Manager() // sets the cardlayout and adds cards
		{
			c2 = new CardLayout();
			setLayout(c2);
			
			ho = new Home(c2, this);
			add(ho, "home");
			sp = new StartPanel(c2, this);
			add(sp, "start");
			fp = new FlamePanel(c2, this);
			add(fp, "flameShop");
			hp = new HelpPanel(c2, this);
			add(hp, "helpPanel");
			lo = new LevelOne(c2, this);
			add(lo, "one");
			lt = new LevelTwo(c2, this);
			add(lt,"two");
			l3 = new LevelThree(c2, this);
			add(l3,"three");
		}
	}
	
	
	class Home extends JPanel implements KeyListener, MouseListener, MouseMotionListener //  creates home panel for home page
	{
		private int mouseX, mouseY, yoffset, xoffset;
		private Rectangle rect, rect1, rect2;
		boolean inStart, inShop;
		
		private CardLayout c2;
		private Manager primaryPanel;
		
		public Home(CardLayout c2In, Manager primaryPan) // adds listeners and initializes variables
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			addMouseListener(this);
			addMouseMotionListener(this);
			addKeyListener(this);
			yoffset = 14;
			xoffset = 25;
			inStart = false;
			inShop = false;
			rect = new Rectangle(15,150,300+yoffset,150-xoffset);
			rect1 = new Rectangle(15, 250, 300+yoffset, 150-xoffset);
			rect2 = new Rectangle(900, 700, 45+yoffset, 45-xoffset);
		}
		public void paintComponent(Graphics g) // Where the game is drawn using images and many gifs. 
		{
			super.paintComponent(g);
			
			Image backg1 = new ImageIcon("BomberBackground.jpg").getImage(); //image for background of main screen
			Image logo1 = new ImageIcon("titleLogo.png").getImage(); //image for logo
			Image explosion = new ImageIcon("Explosion.gif").getImage(); //gif for explosion
			Image Spinner = new ImageIcon("SpinnerPlane.gif").getImage();
			Image Start = new ImageIcon("StartButtonD.png").getImage();
			Image flag = new ImageIcon("flag.gif").getImage();
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
			
			g.drawImage(flag, 720, 50, 50,50,this);
			g.drawImage(help, 900, 700, 45, 45, null);
			
			if (inShop)
			g.drawImage(flameShopA, 15, 250, 350, 175, null);
			else
			g.drawImage(flameShop, 15,250, 300, 150, null);
			
		}
		public void keyTyped (KeyEvent e) // required for keylistener to work
		{
		}
		public void keyReleased (KeyEvent e) // required for keylistener to work
		{
		}
		public void keyPressed (KeyEvent e) // required for keylistener to work
		{
		}
		public void mousePressed (MouseEvent e) // checks to see if mouse is pressing one of the buttons
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (rect.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "start");
			}
			if (rect1.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "flameShop");
			}
			if (rect2.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "helpPanel");
			}
		}
		public void mouseReleased (MouseEvent e) // required for mouselistener to work
		{
		}
		public void mouseClicked (MouseEvent e) // required for mouselistener to work
		{
		}
		public void mouseEntered (MouseEvent e) // required for mouselistener to work
		{
		}
		public void mouseExited (MouseEvent e) // required for mouselistener to work
		{
		}
		public void mouseDragged (MouseEvent e) // required for mousemotionlistener to work
		{
		}
		public void mouseMoved (MouseEvent e) // checking if the mouse is on the buttons.
		{
			if (rect.contains(e.getX(), e.getY())) {
				inStart = true;
			}
			else {
				inStart = false;
			}
			if (rect1.contains(e.getX(), e.getY())) {
				inShop = true;
			}
			else {
				inShop = false;
			}
			repaint();
		}
	}
	
	
	class StartPanel extends JPanel implements MouseListener, MouseMotionListener// levels panel which takes you to the difficulty
	{
		private int mouseX, mouseY, yoffset, xoffset;
		private Rectangle rect, rect1, rect2, rect3;
		private CardLayout c2;
		private Manager primaryPanel;
		private boolean inL1, inL2, inL3, inB;
		public StartPanel(CardLayout c2In, Manager primaryPan) // sets the layout and adds buttons
		{
			c2 = c2In;
			primaryPanel = primaryPan;
			addMouseListener(this);
			addMouseMotionListener(this);
			
			
			inL1 = false;
			inL2 = false;
			inL3 = false;
			inB = false;
			yoffset = 0;
			xoffset = 25;
			rect = new Rectangle(75, 75, 125+yoffset, 100-xoffset);
			rect1 = new Rectangle(350, 200, 300+yoffset, 100-xoffset);
			rect2 = new Rectangle(350, 350, 300+yoffset, 100-xoffset);
			rect3 = new Rectangle(350, 500, 300+yoffset, 100-xoffset);
		}
		public void paintComponent(Graphics g) // paints the background for the levels page, includes back button and level buttons
		{
			super.paintComponent(g);
			Image background2 = new ImageIcon("PlaneBackground.jpeg").getImage();
			Image Level1 = new ImageIcon("Level1.png").getImage();
			Image Level2 = new ImageIcon("Level2.png").getImage();
			Image Level3 = new ImageIcon("Level3.png").getImage();
			Image Level1W = new ImageIcon("Level1White.png").getImage();
			Image Level2W = new ImageIcon("Level2White.png").getImage();
			Image Level3W = new ImageIcon("Level3White.png").getImage();
			
			Image backButton = new ImageIcon("backButton.png").getImage();
			Image backButtonW = new ImageIcon("backWhite.png").getImage();
			
			g.drawImage(background2, 0,0,1000,800, null);
			if (inL1)
			g.drawImage(Level1, 350, 200, 350, 125, null);
			else
			g.drawImage(Level1W, 350, 200, 300, 100, null);
			if (inL2)
			g.drawImage(Level2, 350, 350, 350, 125, null);
			else
			g.drawImage(Level2W, 350, 350, 300, 100, null);
			if (inL3)
			g.drawImage(Level3, 350, 500, 350, 125, null);
			else
			g.drawImage(Level3W, 350, 500, 300, 100, null);
			if (inB)
			g.drawImage(backButton, 75, 75, 150, 125, null);
			else
			g.drawImage(backButtonW, 75, 75, 125, 100, null);
		}
		public void mousePressed (MouseEvent e) // checks to see if mouse is pressing one of the buttons
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if (rect.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "home");
			}
			if (rect1.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "one");
			}
			if (rect2.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "two");
			}
			if (rect3.contains(e.getX(), e.getY())) {
				c2.show(primaryPanel, "three");
			}
		}
		public void mouseReleased (MouseEvent e) // required for mouselistener to work
		{
		}
		public void mouseClicked (MouseEvent e) // required for mouselistener to work
		{
		}
		public void mouseEntered (MouseEvent e) // required for mouselistener to work
		{
		}
		public void mouseExited (MouseEvent e) // required for mouselistener to work
		{
		}
		public void mouseDragged (MouseEvent e) // required for mousemotionlistener to work
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
			repaint();
		}
		
	}
	class FlamePanel extends JPanel // flame shop where you can change the your flame cosmetics that are used in the game
	{
		private CardLayout c2;
		private Manager primaryPanel;
		public FlamePanel(CardLayout c2In, Manager primaryPan) // sets layouts and adds buttons
		{
			setLayout(new FlowLayout());
			JButton ily = new JButton("tu");
			add(ily);
		}
	}
	class HelpPanel extends JPanel // help page where instructions for the game is found
	{
		private CardLayout c2;
		private Manager primaryPan;
		public HelpPanel(CardLayout c2In, Manager primaryPan) // sets layouts and adds buttons
		{
			setLayout(new FlowLayout());
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			Image backW = new ImageIcon("WarBackground.gif").getImage();
			g.drawImage(backW, 0, 0, 1000, 800, this);
			
		}
	}
	class LevelOne extends JPanel implements KeyListener// panel for level one: Easy Level (simple plane level linear movement)
	{
		private CardLayout c2;
		private Manager primaryPan;
		private boolean left, right;
		private int planeY, planeX, tankX, tankY, planeSpeed, tankSpeed;
		private Timer tanktimer;
		private Timer planetimer;
		
		public LevelOne(CardLayout c2In, Manager primaryPan) // sets layout
		{
			setLayout(new FlowLayout());
			addKeyListener(this);
			planeX = 800;
			planeY = 50;
			planeSpeed = 10;
			
			tankX = 100;
			tankY = 500;
			tankSpeed = 10;
			
			right = true;
			left = false;
			
			TankMover tankmover = new TankMover();
			tanktimer = new Timer(tankSpeed, tankmover);
			tanktimer.start();
			
			PlaneMover planemover = new PlaneMover();
			planetimer = new Timer(planeSpeed, planemover);
			planetimer.start();
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			Image warB = new ImageIcon("militaryBase.jpeg").getImage();
			Image tanks = new ImageIcon("movingTanks.png").getImage();
			Image tanks2 = new ImageIcon("movingTanks1.png").getImage();
			Image planes = new ImageIcon("plane1.png").getImage();
			
			g.drawImage(warB, 0, 0, 1000, 800, null);
			if (right)
			g.drawImage(tanks, tankX, tankY, 300, 200, null);
			else
			g.drawImage(tanks2, tankX, tankY, 300, 200, null);
			g.drawImage(planes, planeX, planeY, 300, 200, null);
		}
		class PlaneMover implements ActionListener 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// car XY location
				planeX--;
				if (planeX < 0) planeX = 800;
				repaint();
				grabFocus();
			}
		} // end CarMover
		class TankMover implements ActionListener 
		{
			public void actionPerformed(ActionEvent e) 
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
		
		
		public void keyTyped (KeyEvent e) // required for keylistener to work
		{
		}
		public void keyReleased (KeyEvent e) // required for keylistener to work
		{
		}
		public void keyPressed (KeyEvent e) // required for keylistener to work
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
			}
		}
	}
	class LevelTwo extends JPanel // panel for level two: Medium Level (simple plane linear movement + increased bomb speed)
	{
		private CardLayout c2;
		private Manager primaryPan;
		public LevelTwo(CardLayout c2In, Manager primaryPan) // sets layout
		{
			setLayout(new FlowLayout());
			JButton ily = new JButton("tu");
			add(ily);
		}
	}
	class LevelThree extends JPanel // panel for level three: Hard Level (advanced plane teleportation movement + increased bomb speed)
	{
		private CardLayout c2;
		private Manager primaryPan;
		public LevelThree(CardLayout c2In, Manager primaryPan) // sets layout
		{
			setLayout(new FlowLayout());
			JButton ily = new JButton("tu");
			add(ily);
		}
	}
	
}
