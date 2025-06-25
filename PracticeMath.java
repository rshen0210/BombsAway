/*
Ryan Shen
11/4/22
PracticeMath
This code asks the user for three different types of math questions and asks the user for the correct answer.
*/
import java.util.Scanner;
public class PracticeMath
{
	Scanner kb;
	public PracticeMath()
	{
		kb = new Scanner(System.in);
	}
	public static void main(String [] args)
	{
		PracticeMath pm = new PracticeMath();
		pm.runner();
	}
	public void runner()
	{
		//ask questions and run other methods from here
		System.out.print("\n\n\n");
		System.out.print("Would you like to practice LCM(1), reduceFraction(2), Pythagorean(3)? ");
		int prefer = kb.nextInt();
		if (prefer == 1)
		{
			LCM();
		}
		if (prefer == 2)
		{
			reduceFrac();
		}
		if (prefer == 3)
		{
			pythagorean();
		}
		System.out.print("\n\n\n");
	}
	public void LCM()
	{
		int num1 = (int)(Math.random()*39+12);
		int num2 = (int)(Math.random()*39+12);
		int gcd = 1;
		
		System.out.print("What is the LCM of "+num1+" and "+num2+"? ");
		int userLCM = kb.nextInt();
		
		for (int i = 1; (i <= num1) && (i <= num2); i++)
		{
			if ((num1 % i == 0) && (num2 % i == 0))
			{
				gcd = i;
			}
		}
		
		int compLCM = (num1 * num2) / gcd;
		
		if (userLCM == compLCM)
		{
			System.out.println("Correct!");
		}
		else
		{
			System.out.println("Incorrect.");
		}
	}
	public void reduceFrac()
	{
		int frac1 = (int)(Math.random()*39+12);
		int frac2 = (int)(Math.random()*39+12);
		int gcd = 1;
		System.out.print("What is "+frac1+" divided by "+frac2+"? ");
		int userFrac = kb.nextInt();
		int userFrac2 = kb.nextInt();
		for (int i = 1; (i <= frac1) && (i <= frac2); i++)
		{
			if ((frac1 % i == 0) && (frac2 % i == 0))
			{
				gcd = i;
			}
		}
		int num1 = frac1/gcd;
		int num2 = frac2/gcd;
		if (userFrac == num1 && userFrac2 == num2)
		{
			System.out.println("Correct!");
		}
		else
		{
			System.out.println("Incorrect.");
		}
	}
	public void pythagorean()
	{
		int side1 = (int)(Math.random()*19+2);
		int side2 = (int)(Math.random()*19+2);
		System.out.print("2 sides of a right triangle are "+side1+" & "+side2+". What is the hypotenuse? ");
		double userHypo = kb.nextDouble();
		double hypo = Math.sqrt((side1*side1)+(side2*side2));
		hypo = ((int)(hypo*10.0))/10.0;
		if (userHypo == hypo)
		{
			System.out.println("Correct!");
		}
		else
		{
			System.out.println("Incorrect.");
		}
	}
}
