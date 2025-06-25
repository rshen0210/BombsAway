/*
 * Ryan Shen
 * 4/3/23
 * FoodMenu.java
 * This code creates a food menu
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JScrollBar;
public class RadioAndScroll extends JFrame  {
    
    public RadioAndScroll()
    {
	  super("RadioAndScroll");
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
        RadioAndScroll jmbe2 = new RadioAndScroll();
    }
}

class Practice2 extends JPanel implements ActionListener,AdjustmentListener
{ 
	JRadioButton radio111, radioOne, radioTwo, radio222, radioThree, radio333, radioTres;
	JLabel m1 = new JLabel("111");
	JLabel m2 = new JLabel("TWO");
	JLabel m3 = new JLabel("333");
	JPanel pa = new JPanel();
	JPanel pa1 = new JPanel();
	JPanel pa2 = new JPanel();
	JPanel pa3 = new JPanel();
	JPanel paOne = new JPanel();
	JPanel paTwo = new JPanel();
	JPanel paThree = new JPanel();
	JPanel paUno = new JPanel();
	JPanel paDos = new JPanel();
	JPanel paTres = new JPanel();
	JScrollBar scrollBar, scrollBar1;
	JLabel scrollScore = new JLabel("Horizontal ");
	JLabel scrollScore1 = new JLabel("Vertical ");
	
	
	public Practice2() {
		runIt2();
		setLayout(new GridLayout(1,1));
	}
	public void runIt2() {
		pa.setLayout(new GridLayout(3,3));
		paUno.setLayout(new GridLayout(2,1));
		paDos.setLayout(new GridLayout(1,1));
		paTres.setLayout(new GridLayout(1,1));
		paOne.setLayout(new GridLayout(2,1,30,0));
		paTwo.setLayout(new GridLayout(2,1,30,0));
		paThree.setLayout(new GridLayout(3,1,30,0));
		
		pa1.setBackground(Color.green);
		pa2.setBackground(Color.yellow);
		pa3.setBackground(Color.red);
		
		pa1.add(m1);
		pa2.add(m2);
		pa3.add(m3);
		// making buttongroups
		ButtonGroup oneGroup = new ButtonGroup();
		ButtonGroup twoGroup = new ButtonGroup();
		ButtonGroup threeGroup = new ButtonGroup();
		
		//making radios for first group
        radio111 = new JRadioButton("111");
        oneGroup.add(radio111); 
        radio111.setSelected(true);
		radio111.addActionListener(this);
		
		radioOne = new JRadioButton("One");
		oneGroup.add(radioOne); 
		radioOne.addActionListener(this);
		
		//adding first group radios
		paOne.add(radio111);
		paOne.add(radioOne);
		
		//making radios for second group
		
        radio222 = new JRadioButton("222");
        twoGroup.add(radio222); 
		radio222.addActionListener(this);
		
		radioTwo = new JRadioButton("Two");
		twoGroup.add(radioTwo); 
		radioTwo.setSelected(true);
		radioTwo.addActionListener(this);
		
		//adding second group radios
		paTwo.add(radio222);
		paTwo.add(radioTwo);
		
		//making radios for third group
		radio333 = new JRadioButton("333");
		radio333.setSelected(true);
        threeGroup.add(radio333); 
		radio333.addActionListener(this);
		
		radioThree = new JRadioButton("Three");
		threeGroup.add(radioThree); 
		radioThree.addActionListener(this);
		
		radioTres = new JRadioButton("Tres");
		threeGroup.add(radioTres); 
		radioTres.addActionListener(this);
		
		//adding third group radios
		paThree.add(radio333);
		paThree.add(radioThree);
		paThree.add(radioTres);
		
		//Making Scrollbar
		
		scrollBar = new JScrollBar(JScrollBar.VERTICAL, 15, 25, 0, 200);
		//scrollBar.setPreferredSize(new Dimension(400, 450));
		scrollBar.addAdjustmentListener( this );
		
		scrollBar1 = new JScrollBar(JScrollBar.HORIZONTAL, 15, 25, 0, 200);
		//scrollBar1.setPreferredSize(new Dimension(400, 450));
		scrollBar1.addAdjustmentListener( this );
		
		paUno.add(scrollScore1);
		paUno.add(scrollScore);
		
		paDos.add(scrollBar);
		paTres.add(scrollBar1);
		
		//adding to pa
		add(pa);
		pa.add(paOne);
		pa.add(pa1);
		pa.add(paUno);
		pa.add(paTwo);
		pa.add(pa2);
		pa.add(paDos);
		pa.add(paThree);
		pa.add(pa3);
		pa.add(paTres);
	}
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if ( radio111.isSelected() ) {
			m1.setText("111");
		}
		if ( radioOne.isSelected() ) {
			m1.setText("ONE");
		}
		
		if ( radio222.isSelected() ) {
			m2.setText("222");
		}
		
		if ( radioTwo.isSelected() ) {
			m2.setText("TWO");
		}
		
		if ( radio333.isSelected() ) {
			m3.setText("333");
		}
		
		if ( radioThree.isSelected() ) {
			m3.setText("THREE");
		}
		
		if ( radioTres.isSelected() ) {
			m3.setText("Tres");
		}
	}
	public void adjustmentValueChanged(AdjustmentEvent e) {
		int value1 = scrollBar.getValue();
		int value2 = scrollBar1.getValue();
		scrollScore.setText("Horizontal "+value2);
		scrollScore1.setText("Vertical "+value1);
    }
}
