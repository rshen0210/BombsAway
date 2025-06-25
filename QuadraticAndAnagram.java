/*
Ryan Shen
1/11/22
QuadraticAndAnagram
This code asks the user for their preference between a quadratic solver and anagram. Then outputs the answer.
*/
import java.util.Scanner;

public class QuadraticAndAnagram
{
	public static void main(String [] args)
	{
		QuadraticAndAnagram qaa = new QuadraticAndAnagram();
		qaa.runner();
	}
	public void runner()
	{
		System.out.println("\n\n\n");
		Scanner kb = new Scanner(System.in);
		System.out.print("Would you like to run quadratic(1) or anagram(2)? ");
		int choice = kb.nextInt();
		
		if (choice == 1)
		{
			System.out.println("Enter the coefficients of the equation, y - k = a(x-h)^2");
			System.out.print("What is a, h, k? ");
			double aa = kb.nextDouble();
			double hh = kb.nextDouble();
			double kk = kb.nextDouble();
			quadratic(aa, hh, kk);
		}
		else 
		{
			System.out.print("Please enter your word: ");
			String word = kb.next();
			anagram(word);
		}
		
		System.out.print("\n\n\n");
	}
	public void quadratic(double aa, double hh, double kk)
	{
		kk = -1*kk;
		if (kk / aa < 0)
		{
			System.out.println("The roots are imaginary");
		}
		else if (kk / aa > 0)
		{
			double posroot = hh + Math.sqrt(kk/aa);
			double negroot = hh - Math.sqrt(kk/aa);
			System.out.printf("%s%.2f%s%.2f\n", "The roots are ", negroot, " and ", posroot);
		}
		else
		{
			System.out.printf("%s%.2f\n", "The root is ", hh);
		}
		System.out.printf("%s%.2f\n", "The axis of symmetry is x = ", hh);
	}
	public void anagram(String word)
	{
		String word1 = word;
		String randChar = "!@#$%^&*()";
		String password = "";
		int length = word.length();
		for (int i=0;i<length;i++)
		{
			int randNum = (int)(Math.random()*word.length());
			password += ""+word.charAt(randNum);
			word = word.substring(0,randNum) + word.substring(randNum+1);
		}
		for (int i=0;i<3;i++)
		{
			int randint = (int)(Math.random()*randChar.length());
			password += ""+randChar.charAt(randint);
			randChar = randChar.substring(0,randint) + randChar.substring(randint+1);
		}
				
		System.out.println("Here is your new password with all the letters from " + word1 + ":");
		System.out.println(password);
	}
}
