/*
Ryan Shen
10/3/22
CramersRule
This code solves simple systems of equations.
*/
import java.util.Scanner;
public class CramersRule
{
	public static void main(String [] Args)
	{
		CramersRule cr = new CramersRule();
		cr.runner();
	}
	public void runner()
	{
		System.out.print("\n\n\n");
		Scanner console = new Scanner(System.in);
		System.out.print("Would you like to enter your own coefficients(1) or random(2): ");
		int choice = console.nextInt();
		if (choice == 2)
		{
			int a1 = ranNum();
			int b1 = ranNum();
			int c1 = ranNum();
			int a2 = ranNum();
			int b2 = ranNum();
			int c2 = ranNum();
			System.out.println(a1+"x + "+b1+"y = "+c1);
			System.out.println(a2+"x + "+b2+"y = "+c2);
			
			double a3 = (a1*b2)-(b1*a2);
			double b3 = (b1*c2)-(c1*b2);
			double c3 = (a1*c2)-(c1*a2);
			
			double x1 = b3/a3;
			double y1 = c3/a3;
			System.out.print("\n");
			
			System.out.println("What is the solution? ");
			double x2 = console.nextDouble();
			double y2 = console.nextDouble();
			double x3 = (int)(x2*100)/100.0;
			double y3 = (int)(y2*100)/100.0;
			
			if (a3 == 0 || c3 == 0)
			{
				if (b3 == 0)
				{
					if (x3 == 9999 && y3 == 9999);
						System.out.println("Correct!");
				}
				if (b3!=0)
				{
					if (x3 == -9999 && y3 == -9999);
					{
						System.out.println("Correct!");
					}
				}
			}
			if (x3 == x1 && y3 == y1)
			{
				System.out.println("Correct!");
			}
			if (x3 != x1 || y3 != y1)
			{
				System.out.println("Incorrect");
			}
			System.out.print("\n\n\n");
		}
		
		if (choice == 1)
		{
			System.out.print("Please enter ax + by = c: ");
			int a1 = console.nextInt();
			int b1 = console.nextInt();
			int c1 = console.nextInt();
			System.out.print("Please enter ax + by = c: ");
			int a2 = console.nextInt();
			int b2 = console.nextInt();
			int c2 = console.nextInt();
			double a3 = (a1*b2)-(b1*a2);
			double b3 = (b1*c2)-(c1*b2);
			double c3 = (a1*c2)-(c1*a2);
			
			double x1 = b3/a3;
			double y1 = c3/a3;
			
			System.out.print("\n");
			
			System.out.println("The solutions are: ");
			
			if (a3 == 0)
			{
				if (b3 == 0)
				{
					System.out.println("Infinite Solutions");
				}
				else
				{
					System.out.println("No Solutions");
				}
			}
			else
			{
				System.out.printf("%s%.2f","X = ",x1);
				System.out.printf("%s%.2f\n"," Y = ",y1);
			}
			System.out.print("\n\n\n");
		}
	}
	public int ranNum()
	{
		int num = 0;
		while(num==0)
		{
			num = (int)(Math.random()*19-9);
		}
		return num;
	}
}
