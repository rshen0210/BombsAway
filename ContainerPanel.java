import java.awt.*; import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*;

public class ContainerPanel
{
	public ContainerPanel()
	{
		
	}
	public static void main(String[] args)
	{
		ContainerPanel cp = new ContainerPanel();
		cp.run();
	}
	
	public void run()
	{
		JFrame frame = new JFrame("ContainerPanel.java");
		frame.setSize(1000, 1000);
		ContainerMainPanel pc = new ContainerMainPanel();
		frame.setContentPane(pc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ContainerMainPanel extends JPanel
{
	CardLayout c2;
	JPanel helpPanel;
	public ContainerMainPanel()
	{
		c2 = new CardLayout();
		setLayout(c2);
		StartPanel sp = new StartPanel(c2, this);
		add(sp, "start");
		PlayPanel pp = new PlayPanel(c2, this);
		add(pp, "play");
		
	}
	public void paintComponent(Graphics g)
	{
		
	}
	/*public void addPanels()
	{
		BombsAway ba = new BombsAway();
		//Instanciate more panels here
		helpPanel = new JPanel(); // panel where help and how to play is found.
		this.add(ba);
		// Add more panels here
	}
	
	public void changePanels()
	{
		
		
	}*/

		
		
}
class StartPanel extends JPanel implements ActionListener
{
	private CardLayout c2;
	private ContainerMainPanel primaryPanel;
	
	public StartPanel(CardLayout c2In, ContainerMainPanel primaryPan)
	{
		c2 = c2In;
		primaryPanel = primaryPan;
		
		setLayout(new FlowLayout());
		
		JButton ily = new JButton("I love you");
		ily.addActionListener(this);
		add(ily);

	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String cmd = evt.getActionCommand();
		if(cmd.equals("I love you"))
		{
			c2.show(primaryPanel, "play");
		}
	}
	
}

class PlayPanel extends JPanel implements ActionListener
{
	private CardLayout c2;
	private ContainerMainPanel primaryPanel;
	
	public PlayPanel(CardLayout c2In, ContainerMainPanel primaryPan)
	{
		setLayout(new FlowLayout());
		JButton ily = new JButton("I love tu");
		add(ily);
	}
	public void actionPerformed(ActionEvent evt)
	{
		String cmd  = evt.getActionCommand();
		if(cmd.equals("I love tu"))
		{
			c2.show(primaryPanel, "start");
		}
	}
}
	
