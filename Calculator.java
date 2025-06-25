import java.awt.*;  import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*; import java.util.Scanner;
 
public class Calculator {
 
    JButton[] arrayBtn;
    JTextArea firstBox ;
    JTextArea sign ;
    JTextArea secondBox ;
    JTextArea product ;
    JTextArea equal ;
    JTextArea CalcBox ;
    JTextArea LayBox ;
    JButton clear;
    boolean change;
    boolean multiply;
    boolean addition; 
    boolean subtract;
    boolean divide;
    String one;
    String two;
    int total1;
    int total2;
    public Calculator()
    {
		firstBox = null;
		sign = null;
		secondBox = null;
		product = null;
		equal = null;
		change = false;
		multiply = false;
		divide = false;
		addition = false;
		subtract = false;
		one = "";
		total1 = 0;
		total2 = 0;
		two = "";
	}
     
    public static void main(String[] args) 
    {
		Calculator GLS = new Calculator();
		Scanner kb = new Scanner(System.in);
		System.out.print("\n\n\n");
		System.out.print("Would you like to run Calc1(1) or Calc2(2)? ");
		int choice = kb.nextInt();
		System.out.print("Here is your calculator");
		System.out.print("\n\n\n");
		if (choice == 2)
		GLS.runIt();
		else
		GLS.runIt2();
		 
    }
    
    public void runIt()
    {       
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.setSize(600, 600);
        JPanel pa2 = new JPanel(new GridLayout(3,3));
        JPanel pa = new JPanel(new GridLayout(3,4,2,2));
        JPanel pa1 = new JPanel(new GridLayout(2,2,2,2));
        frame.setContentPane(pa2);
        pa2.setBackground(Color.black);
        pa.setBackground(Color.black);
        pa1.setBackground(Color.black);
        GridLayout grid = new GridLayout(3,3,2,2);
        pa2.setLayout(grid);
         
		firstBox = new JTextArea();
		firstBox.setForeground(Color.red);
		firstBox.setText("0");
		firstBox.setEditable(false);
		pa2.add(firstBox);
			
        CalcBox = new JTextArea();
        CalcBox.setText("\n\n\n\n\n            Calculator 2");
        CalcBox.setEditable(false);
        pa2.add(CalcBox);
        
        LayBox = new JTextArea();
        LayBox.setText("\n\n\n\n\n            I heart Layouts!");
        LayBox.setEditable(false);
        pa2.add(LayBox);
        
        sign = new JTextArea();
        sign.setForeground(Color.red);
        sign.setText("x");
        sign.setEditable(false);
        pa2.add(sign);
        
        pa2.add(pa);
        pa2.add(pa1);
        
        secondBox = new JTextArea();
        secondBox.setForeground(Color.red);
        secondBox.setText("0");
        secondBox.setEditable(false);
        pa2.add(secondBox);
        
        equal = new JTextArea();
        equal.setText("=");
        equal.setEditable(false);
        pa2.add(equal);
        
        product = new JTextArea();
        product.setForeground(Color.red);
        product.setText("0");
        product.setEditable(false);
        product.setBackground(Color.yellow);
        pa2.add(product);
        
        
        
        
        arrayBtn = new JButton[15];
        String calcnum = "123=4567890+-/*";
        String calcnum1 = "";
        String calc = "";
        ButtonHandler2 bhandler = new ButtonHandler2();
        for(int i=0; i < 11; i++) {
			calcnum1 = ""+(calcnum.charAt(i));
            arrayBtn[i] = new JButton(calcnum1);
            arrayBtn[i].addActionListener(bhandler);
            pa.add(arrayBtn[i]);
            if (i == 6)
            {
				clear = new JButton("Cl");
				clear.addActionListener(bhandler);
				pa.add(clear);
			}
        }
        for (int i=11;i<15;i++)
        {
			calcnum1 = ""+(calcnum.charAt(i));
            arrayBtn[i] = new JButton(calcnum1);
            arrayBtn[i].addActionListener(bhandler);
            pa1.add(arrayBtn[i]);
		}
        frame.setVisible(true);
    }
    
    class ButtonHandler2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("*")) {
				multiply = true;
				change = true;
				sign.setText("*");
			}
			if (command.equals("+"))
			{
				addition = true;
				change = true;
				sign.setText("+");
			}
			if (command.equals("-")) {
				subtract = true;
				change = true;
				sign.setText("-");
			}
			if (command.equals("/")) {
				divide = true;
				change = true;
				sign.setText("/");
			}
			if(command.equals("=")) 
			{
				if (multiply) {
					product.setText(""+(total1*total2));
				}
				if (divide) {
					
					product.setText(""+(total1/total2));
				}
				if (subtract) {
					product.setText(""+(total1-total2));
				}
				if (addition) {
					product.setText(""+(total1+total2));
				}
					
			}
			if (command.equals("Cl"))
			{
				one = "";
				two = "";
				firstBox.setText("0");
				secondBox.setText("0");
				product.setText("0");
				change = false;
				multiply = false;
				addition = false;
				subtract = false;
				divide = false;
			}
			if (!change) {
				if (command.equals("1"))
				one += "1";
				if (command.equals("2"))
				one += "2";
				if (command.equals("3"))
				one += "3";
				if (command.equals("4"))
				one += "4";
				if (command.equals("5"))
				one += "5";
				if (command.equals("6"))
				one += "6";
				if (command.equals("7"))
				one += "7";
				if (command.equals("8"))
				one += "8";
				if (command.equals("9"))
				one += "9";
				if (command.equals("0"))
				one += "0";
				if (!one.equals("")) {
					total1 = Integer.parseInt(one);
					firstBox.setText(one);
				}
				else
				firstBox.setText("0");
			}
			else {
				secondBox.setText("0");
				if (command.equals("1"))
				two += "1";
				if (command.equals("2"))
				two += "2";
				if (command.equals("3"))
				two += "3";
				if (command.equals("4"))
				two += "4";
				if (command.equals("5"))
				two += "5";
				if (command.equals("6"))
				two += "6";
				if (command.equals("7"))
				two += "7";
				if (command.equals("8"))
				two += "8";
				if (command.equals("9"))
				two += "9";
				if (command.equals("0"))
				two += "0";
				
				if (!two.equals("")) {
					total2 = Integer.parseInt(two);
					secondBox.setText(two);
				}
				else
				secondBox.setText("0");
			}
		}
	}
	public void runIt2()
    {       
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
         
        GridLayout grid = new GridLayout(5, 5,0,0);
        frame.setLayout(grid);
         
		firstBox = new JTextArea();
		firstBox.setText("0");
		firstBox.setEditable(false);
		frame.add(firstBox);
			
        
        sign = new JTextArea();
        sign.setText("+");
        sign.setEditable(false);
        frame.add(sign);
        
        secondBox = new JTextArea();
        secondBox.setText("0");
        secondBox.setEditable(false);
        frame.add(secondBox);
        
        equal = new JTextArea();
        equal.setText("=");
        equal.setEditable(false);
        frame.add(equal);
        
        product = new JTextArea();
        product.setText("0");
        product.setEditable(false);
        frame.add(product);
        
        
        
        
        arrayBtn = new JButton[20];
        String calcnum = "123x-456/+789  0   =";
        String calcnum1 = "";
        String calc = "";
        ButtonHandler3 bhandler = new ButtonHandler3();
        for(int i=0; i < 20; i++) {
			calcnum1 = ""+(calcnum.charAt(i));
            arrayBtn[i] = new JButton(calcnum1);
            arrayBtn[i].addActionListener(bhandler);
            frame.add(arrayBtn[i]);
        }
		
        frame.setVisible(true);
    }
    
    class ButtonHandler3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("x")) {
				multiply = true;
				change = true;
				sign.setText("x");
			}
			if (command.equals("+"))
			{
				addition = true;
				change = true;
				sign.setText("+");
			}
			if (command.equals("-")) {
				subtract = true;
				change = true;
				sign.setText("-");
			}
			if (command.equals("/")) {
				divide = true;
				change = true;
				sign.setText("/");
			}
			if(command.equals("=")) 
			{
				if (multiply) {
					product.setText(""+(total1*total2));
				}
				if (divide) {
					
					product.setText(""+(total1/total2));
				}
				if (subtract) {
					product.setText(""+(total1-total2));
				}
				if (addition) {
					product.setText(""+(total1+total2));
				}
					
			}
			if (!change) {
				if (command.equals("1"))
				one += "1";
				if (command.equals("2"))
				one += "2";
				if (command.equals("3"))
				one += "3";
				if (command.equals("4"))
				one += "4";
				if (command.equals("5"))
				one += "5";
				if (command.equals("6"))
				one += "6";
				if (command.equals("7"))
				one += "7";
				if (command.equals("8"))
				one += "8";
				if (command.equals("9"))
				one += "9";
				if (command.equals("0"))
				one += "0";
				if (!one.equals("")) {
					total1 = Integer.parseInt(one);
					firstBox.setText(one);
				}
				else
				firstBox.setText("0");
			}
			else {
				if (command.equals("1"))
				two += "1";
				if (command.equals("2"))
				two += "2";
				if (command.equals("3"))
				two += "3";
				if (command.equals("4"))
				two += "4";
				if (command.equals("5"))
				two += "5";
				if (command.equals("6"))
				two += "6";
				if (command.equals("7"))
				two += "7";
				if (command.equals("8"))
				two += "8";
				if (command.equals("9"))
				two += "9";
				if (command.equals("0"))
				two += "0";
				if (!two.equals("")) {
					total2 = Integer.parseInt(two);
					secondBox.setText(two);
				}
				else
				secondBox.setText("0");
			}
		}
	}
		
}
