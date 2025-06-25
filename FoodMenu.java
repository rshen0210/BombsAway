/*
 * Ryan Shen
 * 4/3/23
 * FoodMenu.java
 * This code creates a food menu
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class FoodMenu extends JFrame {
	

	public FoodMenu()
	{
		super("JMenuBarExample");
		setSize( 600, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(400,50);
		setResizable(true);
		Practice2 pc = new Practice2();
		setContentPane( pc );
		setVisible(true);
	}
	public static void main(String[] args)
	{
		// create an object of the class
		FoodMenu fm = new FoodMenu();
	}
}

class Practice2 extends JPanel implements ActionListener, AdjustmentListener
{
	
	JMenuBar b1,b2,b3,b4;
	JMenuItem m1, m2, m3, m4, s1, s2, s3, s4, d1, d2 ,d3 ,d4 , des1, des2, des3, des4; // Menu items
	JLabel l1,l2,l3,l4,fill1,fill2,fill3,fill4; // a label
	JPanel pa,fpan;
	String food1,food2,food3,food4;
	JMenu main,side,drink,dessert;
	JTextArea line1, line2, line3, line4, line5, line6;
	JTextField textF;
	JScrollBar scrollBar;
	double mainp,sidep,drinkp,dessertp, total;
	private JRadioButton redRadio, blueRadio, greenRadio;

	public Practice2()
	{
		runIt2();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent (g);
	}
	public void runIt2()
	{
		
		
		Font font = new Font("Arial", Font.PLAIN, 20);
		
		fpan = new JPanel();
		fpan.setSize(600,800);
		pa = new JPanel();
		pa.setSize(600,600);
		JPanel grid = new JPanel(new GridLayout(3,4,13,12));
		JPanel grid2 = new JPanel(new GridLayout(6,1));
		JPanel grid3 = new JPanel(new GridLayout(3,1));
		JPanel panboy = new JPanel(new GridLayout(3,1));
		pa.setSize(new Dimension(600,600));
		add(pa);
		
		b1 = new JMenuBar();
		b2 = new JMenuBar();
		b3 = new JMenuBar();
		b4 = new JMenuBar();
		
		l1 = new JLabel("Main Dish");
		l1.setFont(font);
		l2 = new JLabel("Side");
		l2.setFont(font);
		l3 = new JLabel("Drink");
		l3.setFont(font);
		l4 = new JLabel("Dessert");
		l4.setFont(font);
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2.setHorizontalAlignment(JLabel.CENTER);
		l3.setHorizontalAlignment(JLabel.CENTER);
		l4.setHorizontalAlignment(JLabel.CENTER);

		grid.add(l1);
		grid.add(l2);
		grid.add(l3);
		grid.add(l4);
		
		fill1 = new JLabel();
		fill1.setText("");
		fill2 = new JLabel();
		fill2.setText("");
		fill3 = new JLabel();
		fill3.setText("");
		fill4 = new JLabel();
		fill4.setText("");
		
		line1 = new JTextArea();
		line1.setEditable(false);
		line1.setFont(font);
		line2 = new JTextArea();
		line2.setEditable(false);
		line2.setFont(font);
		line3 = new JTextArea();
		line3.setEditable(false);
		line3.setFont(font);
		line4 = new JTextArea();
		line4.setEditable(false);
		line4.setFont(font);
		line5 = new JTextArea();
		line5.setEditable(false);
		line5.setFont(font);
		line6 = new JTextArea();
		line6.setEditable(false);
		line6.setFont(font);
		
		line1.setText("                                        $0.00 ");
		line2.setText("                                        $0.00 ");
		line3.setText("                                        $0.00 ");
		line4.setText("                                        $0.00 ");
		line5.setText("                                              ");
		line6.setText("Total(+tax)                        $0.00 ");
		
		grid2.add(line1);
		grid2.add(line2);
		grid2.add(line3);
		grid2.add(line4);
		grid2.add(line5);
		grid2.add(line6);


		MenuHandler mh = new MenuHandler();
		// create a menu
		main = new JMenu("-Select-");
		side = new JMenu("-Select-");
		drink = new JMenu("-Select-");
		dessert = new JMenu("-Select-");
		
		main.setFont(font);
		side.setFont(font);
		drink.setFont(font);
		dessert.setFont(font);

		// create menuitems
		m1 = new JMenuItem("Burrito"); m2 = new JMenuItem("Nachos");
		m3 = new JMenuItem("Tacos"); m4 = new JMenuItem("Torta");
		s1 = new JMenuItem("Chips"); s2 = new JMenuItem("Fries");
		s3 = new JMenuItem("Salad"); s4 = new JMenuItem("Beans");
		d1 = new JMenuItem("Fanta"); d2 = new JMenuItem("Coke");
		d3 = new JMenuItem("Horchada"); d4 = new JMenuItem("Lemonade");
		des1 = new JMenuItem("Ice Cream"); des2 = new JMenuItem("Churro");
		des3 = new JMenuItem("Flan"); des4 = new JMenuItem("Cookies");

		// add ActionListener to menuItems
		m1.addActionListener(mh); m2.addActionListener(mh);
		m3.addActionListener(mh); m4.addActionListener(mh);
		s1.addActionListener(mh); s2.addActionListener(mh);
		s3.addActionListener(mh); s4.addActionListener(mh);
		d1.addActionListener(mh); d2.addActionListener(mh);
		d3.addActionListener(mh); d4.addActionListener(mh);
		des1.addActionListener(mh); des2.addActionListener(mh);
		des3.addActionListener(mh); des4.addActionListener(mh);

		main.add(m1); main.add(m2);
		main.add(m3); main.add(m4);
		side.add(s1); side.add(s2);
		side.add(s3); side.add(s4);
		drink.add(d1); drink.add(d2);
		drink.add(d3); drink.add(d4);
		dessert.add(des1); dessert.add(des2);
		dessert.add(des3); dessert.add(des4);
		
		b1.add(main);
		b2.add(side);
		b3.add(drink);
		b4.add(dessert);
		
		line1.setBackground(Color.blue);
		line2.setBackground(Color.blue);
		line3.setBackground(Color.blue);
		line4.setBackground(Color.blue);
		line5.setBackground(Color.blue);
		line6.setBackground(Color.blue);


		grid.add(l1);
		grid.add(l2);
		grid.add(l3);
		grid.add(l4);
		grid.add(b1);
		grid.add(b2);
		grid.add(b3);
		grid.add(b4);
		grid.add(fill1);
		grid.add(fill2);
		grid.add(fill3);
		grid.add(fill4);
		
		ButtonGroup colorGroup = new ButtonGroup();
		redRadio = new JRadioButton("Red");
		//delete line below or you won't be able to select more than one button
		colorGroup.add(redRadio);
		redRadio.addActionListener(this);
		panboy.add(redRadio);
		blueRadio = new JRadioButton("Blue");
		//delete line below or you won't be able to select more than one button
		colorGroup.add(blueRadio);
		blueRadio.addActionListener(this);
		panboy.add(blueRadio);
		greenRadio = new JRadioButton("Green");
		//delete line below or you won't be able to select more than one button
		colorGroup.add(greenRadio);
		greenRadio.addActionListener(this);
		panboy.add(greenRadio);
		blueRadio.setSelected(true); // Set an initial selection.
		
		textF = new JTextField("0");
		textF.setEditable(true);
		
		scrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 25, 0, 200);
		scrollBar.setPreferredSize(new Dimension(15, 25));
		scrollBar.addAdjustmentListener( this );
		
		grid3.add(panboy);
		grid3.add(scrollBar);
		grid3.add(textF);

		pa.setLayout(new BorderLayout());
		pa.add(grid3,BorderLayout.EAST);
		pa.add(grid, BorderLayout.NORTH);
		pa.add(fpan,BorderLayout.CENTER);
		pa.add(grid2, BorderLayout.WEST);
		
		
		
	}

	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		
		if ( redRadio.isSelected() ) {
			line1.setBackground(Color.red);
			line2.setBackground(Color.red);
			line3.setBackground(Color.red);
			line4.setBackground(Color.red);
			line5.setBackground(Color.red);
			line6.setBackground(Color.red);
			//redRadio.setEnabled(false);
			//put line above inside actionPerformed so it's always selected
		}
		else if ( blueRadio.isSelected() ) {
			line1.setBackground(Color.blue);
			line2.setBackground(Color.blue);
			line3.setBackground(Color.blue);
			line4.setBackground(Color.blue);
			line5.setBackground(Color.blue);
			line6.setBackground(Color.blue);
		}
		else if ( greenRadio.isSelected() ) {
			line1.setBackground(Color.green);
			line2.setBackground(Color.green);
			line3.setBackground(Color.green);
			line4.setBackground(Color.green);
			line5.setBackground(Color.green);
			line6.setBackground(Color.green);
		}
	}

	class MenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			
			if (command.equals("Burrito")) {
				line1.setText("Burrito                              $12.99 ");
				main.setText("Burrito");
				mainp=12.99;
			}
			else if (command.equals("Nachos")) {
				line1.setText("Nachos                              $12.99 ");
				main.setText("Nachos");
				mainp=12.99;
			}
			else if (command.equals("Tacos")) {
				line1.setText("Tacos                                $12.99 ");
				main.setText("Tacos");
				mainp=12.99;
			}
			else if (command.equals("Torta")) {
				line1.setText("Torta                                $12.99 ");
				main.setText("Torta");
				mainp=12.99;
			}
			else if (command.equals("Chips")) {
				line2.setText("Chips                                $4.50 ");
				side.setText("Chips");
				sidep=4.50;
			}
			else if (command.equals("Fries")) {
				line2.setText("Fries                                  $4.50 ");
				side.setText("Fries");
				sidep=4.50;
			}
			else if (command.equals("Salad")) {
				line2.setText("Salad                                $4.50 ");
				side.setText("Salad");
				sidep=4.50;
			}
			else if (command.equals("Beans")) {
				line2.setText("Beans                                $4.50 ");
				side.setText("Beans");
				sidep=4.50;
			}
			else if (command.equals("Fanta")) {
				line3.setText("Fanta                                $2.50 ");
				drink.setText("Fanta");
				drinkp=2.50;
			}
			else if (command.equals("Coke")) {
				line3.setText("Coke                                 $2.50 ");
				drink.setText("Coke");
				drinkp=2.50;
			}
			else if (command.equals("Horchada")) {
				line3.setText("Horchada                           $2.50 ");
				drink.setText("Horchada");
				drinkp=2.50;
			}
			else if (command.equals("Lemonade")) {
				line3.setText("Lemonade                           $2.50 ");
				drink.setText("Lemonade");
				drinkp=2.50;
			}
			else if (command.equals("Ice Cream")) {
				line4.setText("Ice Cream                          $5.50 ");
				dessert.setText("Ice Cream");
				dessertp=5.50;
			}
			else if (command.equals("Churro")) {
				line4.setText("Churro                              $5.50 ");
				dessert.setText("Churro");
				dessertp=5.50;
			}
			else if (command.equals("Flan")) {
				line4.setText("Flan                                 $5.50 ");
				dessert.setText("Flan");
				dessertp=5.50;
			}
			else if (command.equals("Cookies")) {
				line4.setText("Cookies                             $5.50 ");
				dessert.setText("Cookies");
				dessertp=5.50;
			}
			
			total = (mainp+sidep+drinkp+dessertp)*0.085+mainp+sidep+drinkp+dessertp;
			total*=100;
			total=(int)total;
			total/=100;
			line6.setText("Total(+tax)                        $"+total+" ");

		}

	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		
		textF.setText(""+scrollBar.getValue());
		
	}

}

