/*
Ryan Shen
10/24/22
MathOrLit
This program strengthens your literature and mathematics skills. 
*/
import java.util.Calendar;
import java.util.Date;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class MathOrLit
{
	Scanner console = new Scanner(System.in);
	public static void main(String [] args)
	{
		MathOrLit mo1 = new MathOrLit();
		mo1.runner();
	}
	public void runner()
	{
		System.out.println("\n\n\n");
		int num1 = (int)(Math.random()*9-1);
		int num2 = (int)(Math.random()*9-1);
		System.out.print("Would you like to practice Math(1) or lit(2)? ");
		int prefer = console.nextInt();
		if (prefer == 1)
		{
			boolean finish = false;
			while(!finish)
			{
			Date date = new Date();
			System.out.println("You have ten seconds to finish 4 math problems. press'1' to start: ");
			console.next();
			
			long first = date.getTime();
			boolean tracker = true;
			
			if (add())
			{
				System.out.print("Correct. Great job!");
			}
			else
			{
				System.out.print("Incorrect.");
				tracker = false;
			}
			if (subtract())
			{
				System.out.print("Correct. Great job!");
			}
			else
			{
				System.out.print("Incorrect.");
				tracker = false;
			}
			if (multiply())
			{
				System.out.print("Correct. Great job!");
			}
			else
			{
				System.out.print("Incorrect.");
				tracker = false;
			}
			if (square())
			{
				System.out.println("Correct. Great job!");
			}
			else
			{
				System.out.println("Incorrect.");
				tracker = false;
			}
			
			Date date2 = new Date();
			long last = date2.getTime();
			double time = (last-first)/1000.0;
			System.out.printf("%s%.3f%s\n","It took you ",time," seconds to respond");
			if (time>10) 
			{
				System.out.println("You lose:( Try again!\n");
			}
			if (tracker == false)
			{
				System.out.println("You lose:( Try again!\n");
			}
					else
					{
							System.out.println("You win!");
							finish = true;
					}
			}	
		}
		else
		{
			System.out.print("how man sentences would you like to enter? ");
			int numSentences = console.nextInt();
			System.out.print("\t" + lit(numSentences));
		}
		System.out.print("\n\n\n");
	}
	public boolean add()
	{
		int num1 = (int)(Math.random() * 9 + 1);
		int num2 = (int)(Math.random() * 9 + 1);
		
		int sum = num1+num2;
		System.out.print("\n\n");
		System.out.println("What is "+num1+"+"+num2+"? ");
		int ans1 = console.nextInt();
		System.out.print("\n\n");
		if (ans1==sum)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean subtract()
	{
		int num1 = (int)(Math.random()*9+1);
		int num2 = (int)(Math.random()*9+1);
		int difference = num1 - num2;
		System.out.print("\n\n");
		System.out.println("What is "+num1+"-"+num2+"? ");
		System.out.print("\n\n");
		int ans1 = console.nextInt();
		if (ans1==difference)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean multiply()
	{
		int num1 = (int)(Math.random()*9+1);
		int num2 = (int)(Math.random()*9+1);
		int product = num1 * num2;
		System.out.print("\n\n");
		System.out.println("What is "+num1+"*"+num2+"? ");
		System.out.print("\n\n");
		int ans1 = console.nextInt();
		if (ans1==product)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean square()
	{
		int num1 = (int)(Math.random()*9+1);
		int squares = (int)(Math.pow(num1,2));
		System.out.print("\n\n");
		System.out.println("What is "+num1+"^2");
		System.out.print("\n\n");
		int ans1 = console.nextInt();
		if (ans1==squares)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String lit(int num)
	{
		String essay = "";
		console.nextLine();
		for (int i=1;i<=num;i++)
		{
			System.out.print("Enter sentence #"+i+": ");
			essay = essay + " " + console.nextLine();
		}
		return essay;
	}
}
