/*Ryan Shen
 *3/31/23
 *CardLayoutTrial.java
 *Practice with cardlayout
 */

import java.awt.*; import java.awt.event.*;
import javax.swing.*; import javax.swing.event.*;

public class CardLayoutTrial {
	public CardLayoutTrial()
	{
		JFrame frame = new JFrame("CardLayoutTrial.java");
		frame.setSize(700, 700);
		Practice pc = new Practice();
		frame.setContentPane(pc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		CardLayoutTrial clt = new CardLayoutTrial();
	}
	
	class Practice extends JPanel
	{
		private CardLayout cardLayout = new CardLayout();;
		private JPanel panel = new JPanel();
		private JLabel label;
		private JTextArea textColor, sentence1, sentence2;	
		private JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;

		public Practice()
		{
			setLayout(new BorderLayout());
			runIt();
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent (g);
		}
		public void runIt()
		{
			Font font = new Font ("Serif", Font.BOLD, 32);
				
			JPanel btnPanel = new JPanel();
			JButton btnPrev = new JButton("Previous");
			JButton btnNext = new JButton("Next");
			ButtonHandler handle = new ButtonHandler();
			btnPrev.addActionListener(handle);
			btnNext.addActionListener(handle);
			btnPanel.add(btnPrev);
			btnPanel.add(btnNext);
			add(btnPanel, BorderLayout.NORTH);

			panel.setLayout(cardLayout);

			JPanel panel1 = new JPanel();
			JButton btn1 = new JButton("Button 1");
			JButton btn2 = new JButton("Button 2");
			JButton btn3 = new JButton("Button 3");
			btn1.addActionListener(handle);
			btn2.addActionListener(handle);
			btn3.addActionListener(handle);
			panel1.add(btn1);
			panel1.add(btn2);
			panel1.add(btn3);
			label = new JLabel("<html>" + "Press a button"+ "</html>");
			label.setFont(font);
			label.setBackground(Color.BLUE);
			label.setOpaque(true);
			label.setPreferredSize(new Dimension(600,550));
			label.setHorizontalAlignment(JLabel.CENTER);				
			panel1.add(label);
		
			JPanel panel2 = new JPanel(new BorderLayout());	
			textColor = new JTextArea();
			textColor.setFont(font);
			textColor.setBackground(Color.red);
			textColor.setPreferredSize(new Dimension(10,5));
			textColor.setText("Red");
			textColor.setEditable(false);		
			JPanel east = new JPanel(new GridLayout(4,1));
			checkBox1 = new JCheckBox("Red");
			checkBox1.setPreferredSize(new Dimension(200,50));
			checkBox2 = new JCheckBox("Yellow");
			checkBox2.setPreferredSize(new Dimension(200,50));
			checkBox3 = new JCheckBox("Green");
			checkBox3.setPreferredSize(new Dimension(200,50));
			checkBox4 = new JCheckBox("Blue");
			checkBox4.setPreferredSize(new Dimension(200,50));
			CheckBoxListener cblistener = new CheckBoxListener();
			checkBox1.addActionListener(cblistener);
			checkBox2.addActionListener(cblistener);
			checkBox3.addActionListener(cblistener);
			checkBox4.addActionListener(cblistener);
			checkBox1.setSelected(true);
			checkBox2.setSelected(false);
			checkBox3.setSelected(false);
			checkBox4.setSelected(false);
			east.add(checkBox1);					
			east.add(checkBox2);					
			east.add(checkBox3);					
			east.add(checkBox4);					
			panel2.add(new JPanel(), BorderLayout.WEST);
			panel2.add(new JPanel(), BorderLayout.SOUTH);
			panel2.add(textColor, BorderLayout.CENTER);
			panel2.add(east, BorderLayout.EAST);					
				
			JPanel panel3 = new JPanel(new BorderLayout());
			JPanel center = new JPanel(new GridLayout(2,1,10,10));
			sentence1 = new JTextArea();
			font = new Font ("Serif", Font.BOLD, 20);
			sentence1.setFont(font);
			sentence1.setBackground(Color.green);
			sentence1.setText("");
			sentence1.setEditable(true);
			sentence2 = new JTextArea();
			sentence2.setFont(font);
			sentence2.setBackground(Color.red);
			sentence2.setText("");
			sentence2.setEditable(true);
			JButton btnSwitch = new JButton("Switch");
			btnSwitch.addActionListener(handle);
			center.add(sentence1);
			center.add(sentence2);
			panel3.add(new JPanel(), BorderLayout.WEST);
			panel3.add(new JPanel(), BorderLayout.EAST);
			panel3.add(center, BorderLayout.CENTER);			
			panel3.add(btnSwitch, BorderLayout.SOUTH);
			
			panel.add(panel1, "link1");
			panel.add(panel2, "link2");
			panel.add(panel3, "link3");

			add(panel, BorderLayout.CENTER);	
		}	
		class ButtonHandler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if(command.equals("Next"))
				{
					cardLayout.next(panel);
					label.setText("<html>" + "Press a button"+ "</html>");
					textColor.setBackground(Color.red);
					textColor.setText("Red");
					checkBox1.setSelected(true);
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
					checkBox4.setSelected(false);
					sentence1.setText("");
					sentence2.setText("");					
				}
				else if(command.equals("Previous"))
				{
					cardLayout.previous(panel);
					label.setText("<html>" + "Press a button"+ "</html>");
					textColor.setBackground(Color.red);
					textColor.setText("Red");
					checkBox1.setSelected(true);
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
					checkBox4.setSelected(false);
					sentence1.setText("");
					sentence2.setText("");		
				}
				else if(command.equals("Button 1"))
				{
					label.setText("<html>" + "Button 1"+ "</html>");
				}
				else if(command.equals("Button 2"))
				{
					label.setText("<html>" + "Button 2"+ "</html>");
				}
				else if(command.equals("Button 3"))
				{
					label.setText("<html>" + "Button 3"+ "</html>");
				}
				else if(command.equals("Switch"))
				{
					String temp = sentence1.getText();
					sentence1.setText(sentence2.getText());
					sentence2.setText(temp);
				}
			}
		}		
		class CheckBoxListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if (cmd.equals("Red")) {
					textColor.setBackground(Color.red);
					textColor.setText("Red");
					checkBox1.setSelected(true);
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
					checkBox4.setSelected(false);
				}
				else if (cmd.equals("Yellow")) {
					textColor.setBackground(Color.yellow);
					textColor.setText("Yellow");
					checkBox1.setSelected(false);
					checkBox2.setSelected(true);
					checkBox3.setSelected(false);
					checkBox4.setSelected(false);
				}
				else if (cmd.equals("Green")) {
					textColor.setBackground(Color.green);
					textColor.setText("Green");
					checkBox1.setSelected(false);
					checkBox2.setSelected(false);
					checkBox3.setSelected(true);
					checkBox4.setSelected(false);
				}
				else if (cmd.equals("Blue")) {
					textColor.setBackground(Color.blue);
					textColor.setText("Blue");
					checkBox1.setSelected(false);
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
					checkBox4.setSelected(true);
				}
			}
		}
	}
}
