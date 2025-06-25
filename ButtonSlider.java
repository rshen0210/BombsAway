/*
 * Ryan Shen
 *3/24/23
 *ButtonSlider.java
 *This code gives you a great option between two different interactable frames.  
*/


import java.awt.*; 
import javax.swing.*;
import java.awt.event.*; 
import javax.swing.event.*;
import java.util.Scanner;

public class ButtonSlider extends JFrame {
	
	Scanner in;
	
	public static void main( String[] args ) {
		ButtonSlider pL2 = new ButtonSlider();
	}

	public ButtonSlider() {

		super("ButtonSlider.java");

		in = new Scanner(System.in);
		int choice = 0;
		
		System.out.print("\n\n\n");

		System.out.print("Would you like to run Pillsbury(1) or PetCounter(2)? ");
		choice = in.nextInt();
		
		if (choice == 1) {
			System.out.println("You chose Pillsbury");
		}
		else if (choice == 2) {
			System.out.println("You chose PetCounter\n");
		}
		
		if (choice == 1) {
			setSize( 900, 500);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLocation(80,50);
			setResizable(true);

			PillsburyLayoutP2 pillsPanel2 = new PillsburyLayoutP2();
			setContentPane( pillsPanel2 ); 
			setVisible(true);
		}
		else if (choice == 2) {
			PetRunnerLayout pet = new PetRunnerLayout();
			setContentPane( pet ); 
			setVisible(true);
		}
		
		System.out.print("\n\n\n");
	}
}

class PillsburyLayoutP2 extends JPanel {
	
	private boolean pressed1, pressed2;
	private JButton button1, button2, button3, button4;
	private int counter;
	private JSlider slider;
	private int sliderValue;
	private int bellyCount;
	private int helloCount;

	public PillsburyLayoutP2() {
		bellyCount = 0;
		helloCount = 0;

		pressed1 = pressed2 = false;

		setBackground( Color.BLUE );
		setLayout( new FlowLayout( FlowLayout.LEFT, 0, 0) );

		button1 = new JButton("Press my belly."); 
		button1.setPreferredSize(new Dimension(130, 50));
		Button1Handler b1handler = new Button1Handler(); 
		button1.addActionListener( b1handler ); 
		add( button1 ); 

		button2 = new JButton("Hello");
		button2.setPreferredSize(new Dimension(100, 50));
		Button2Handler b2handler = new Button2Handler();
		button2.addActionListener( b2handler );
		add( button2 );

		button3 = new JButton("Press my belly.");
		button3.setPreferredSize(new Dimension(130, 50));
		Button1Handler b3handler = new Button1Handler();
		button3.addActionListener( b1handler );
		add( button3 );

		button4 = new JButton("Hello");
		button4.setPreferredSize(new Dimension(100, 50));
		Button2Handler b4handler = new Button2Handler();
		button4.addActionListener( b2handler );
		add( button4 );

		slider = new JSlider (JSlider.HORIZONTAL, 10, 125, 10); 
		slider.setBackground(Color.white);
		slider.setInverted(true);
		slider.setMajorTickSpacing(20); 
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setForeground(Color.WHITE);
		slider.setLabelTable( slider.createStandardLabels(115) ); 

		slider.setPaintLabels(true);
		SliderHandler sHandler = new SliderHandler();
		add(slider); 
		slider.addChangeListener( sHandler ); 
		sliderValue = 10;

	}

	public void paintComponent(Graphics g) {

		super.paintComponent (g);

		Font f = new Font("Serif", Font.BOLD, sliderValue);
		Font h = new Font("Arial", Font.PLAIN, 20);
		g.setFont(f);
		g.drawString ("Move the slider to see",100, 250 );
		g.drawString("the font size change", 100, 250+sliderValue);

		if (helloCount == 4) {
			g.setFont(h);
			g.drawString("Stop saying Hello", 200, 150);
			helloCount = 0;
		}
		if (bellyCount == 5) {
			g.setFont(h);
			
			if (pressed1 == false) {
				g.drawString("Stop pressing my belly", 100, 150);
			}
			
			bellyCount = 0;

		}
		if (pressed1 && bellyCount != 5) {
			Image pills = new ImageIcon("Pillbury-Doughboy1.jpg").getImage();
			g.setFont(h);
			g.drawString("Hee Hee", 150, 150);
			g.drawImage(pills, -50, 315, 200, 150, this);
			g.drawString("You're wonderful", 150, 460);
			pressed1 = false;
		}

		if (pressed2 && helloCount != 4) {
			g.setFont( h );
			g.drawString("You say", 200, 150);
			pressed2 = false;
		}
	}

	class Button1Handler implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if ( command.equals ("Press my belly.") ) {
				pressed1 = true;
				button1.setText ("reset");

				bellyCount++;
				
				if (bellyCount == 5) {
					pressed1 = false;
				}
			}
			else {
				button1.setText("Press my belly.");
			}
			repaint();
		}
	}

	class Button2Handler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String command2 = e.getActionCommand();
			if ( command2.equals ("Hello") ) {
				pressed2 = true;
				button2.setText ("Goodbye");
				helloCount++;
				if (helloCount == 4) {
					pressed2 = false;
				}
			}
			else {
				button2.setText("Hello");
			}
			repaint();
		}
	}

	class SliderHandler implements ChangeListener {
		public void stateChanged(ChangeEvent e) { // event handler for JSliderBar (stateChanged)
			sliderValue = slider.getValue();
			repaint();
		}
	}
}

class PetRunnerLayout extends JPanel {

	int clicks;
	JLabel click;

	public PetRunnerLayout() {
		clicks = 0;

		JFrame frame = new JFrame ("ButtonSlider.java");

		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(80, 50);
		frame.setBackground(Color.white);

		ButtonHandler bh = new ButtonHandler();

		click = new JLabel("Total clicks: 0");
		click.setHorizontalAlignment(JLabel.CENTER);
		add(click);

		JButton ba2=new JButton("Goldfish");
		ba2.addActionListener(bh);
		add(ba2);

		JButton ba3=new JButton("Hamster");
		ba3.addActionListener(bh);
		ba3.setPreferredSize(new Dimension(233, 1));
		add(ba3);

		JButton ba4=new JButton("Dog");
		ba4.addActionListener(bh);
		ba4.setPreferredSize(new Dimension(233, 1));
		add(ba4);

		JButton ba5=new JButton("Cat");
		ba5.addActionListener(bh);
		ba5.setPreferredSize(new Dimension(233, 1));
		add(ba5);

		frame.setLayout(new BorderLayout());
		frame.add(click, BorderLayout.NORTH);
		frame.add(ba2, BorderLayout.SOUTH);
		frame.add(ba3, BorderLayout.EAST);
		frame.add(ba4, BorderLayout.WEST);
		frame.add(ba5, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.requestFocus();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clicks++;
			click.setText("Total Clicks: " + clicks);
			String command2 = e.getActionCommand();
			if ( command2.equals ("Dog") ) {

				System.out.println("Dog");
			}
			if ( command2.equals ("Cat") ) {

				System.out.println("Cat");
			}
			if ( command2.equals ("Hamster") ) {

				System.out.println("Hamster");
			}
			if ( command2.equals ("Goldfish") ) {

				System.out.println("Goldfish");
			}
			repaint();
		}
	}
}
