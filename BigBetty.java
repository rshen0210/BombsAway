import java.awt.*; import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*;

public class BigBetty {
    
    public BigBetty() // makes the frame
	{
		JFrame frame = new JFrame("BombsAway.java");
		frame.setSize(1000, 800);
		Manager pc = new Manager();
		frame.setContentPane(pc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
    public static void main(String [] args)
    {
        BigBetty bb = new BigBetty();
    }
    class Manager extends JPanel
    {
        Home ho;
        CardLayout c2;
        public Manager() // sets the cardlayout and adds cards
		{
			c2 = new CardLayout();
			setLayout(c2);
            
            ho = new Home(c2, this);
            add(ho, "home");
        }
    }
    class Home extends JPanel implements MouseListener, MouseMotionListener
    {
        private CardLayout c2;
		private Manager primaryPanel;
		
		public Home(CardLayout c2In, Manager primaryPan) // adds listeners and initializes variables
		{
			c2 = c2In;
			primaryPanel = primaryPan;
            addMouseMotionListener(this);
            addMouseListener(this);
        }
        public void paintComponent(Graphics g)
        {
            Image background = new ImageIcon("bigbackground.jpeg").getImage();
            g.drawImage(background, 0, 0, 1000, 800, null);

        }
        public void mouseClicked(MouseEvent e)
        {

        }
        public void mouseDragged(MouseEvent e)
        {

        }
        public void mouseEntered(MouseEvent e)
        {}
        public void mouseExited(MouseEvent e)
        {
        }
        public void mouseMoved(MouseEvent e)
        {
        }
        public void mousePressed(MouseEvent e)
        {
        }
        public void mouseReleased(MouseEvent e)
        {

        }

    }
}