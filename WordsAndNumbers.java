/*
Ryan Shen
11/7/22
WordsAndNumbers
This code tests your guessing skills and how fast you can type characters.
*/
import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class WordsAndNumbers
{
	Scanner kb = new Scanner(System.in);
	public static void main(String [] args)
	{
		WordsAndNumbers wad = new WordsAndNumbers();
		wad.runner();
	}
	public void runner()
	{
		System.out.print("\n\n\n");
		System.out.print("Would you like to practice typing(1), numbers(2), or order of operations(3)? ");
		int prefer = kb.nextInt();
		if (prefer==1)
		{
			words();
		}
		else if (prefer==2)
		{
			nums();
		}
		else
		{
			orderOfOp();
		}
		System.out.print("\n\n\n");
	}
	public char letters()
	{
		int num1 = (int)(Math.random()*2+1);
		int num2 = (int)(Math.random()*26+65);
		int num3 = (int)(Math.random()*26+97);
		if (num1 == 1)
		{
			return (char)(num2);
		}
		else
		{
			return (char)(num3);
		}
	}
	public void words()
	{
		String word = letters()+""+letters()+""+letters()+""+letters()+""+letters()+""+letters()+""+letters();
		boolean correct = false;
		do
		{
			System.out.println("Please type the following characters: "+word);
			String userGuess = kb.next();
			if (userGuess.equals(word))
			{
				correct = true;
				System.out.println("That is correct!");
			}
			else
			{
				correct = false;
				System.out.print("That is incorrect! Try again.");
				System.out.print("\n\n");
			}
		}while(correct == false);
	}
	public void nums()
	{
		int guess = 1;
		int rand = (int)(Math.random()*100+1);
		boolean ok = false;
		System.out.println("I'm thinking of a number between 1-100. ");
		do
		{
			System.out.print("What is your guess? ");
			int guess1 = kb.nextInt();
			if (guess1 > rand)
			{
				System.out.println("Guess lower. You've guessed "+guess+" time(s)");
			}
			else if (guess1 < rand)
			{
				System.out.println("Guess higher. You've guessed "+guess+" time(s)");
			}
			else
			{
				ok = true;
				System.out.println("Correct. You've guessed "+guess+" time(s)");
			}
			guess++;
		}while(!ok);
	}
	public void orderOfOp()
	{
		boolean boo = false;
		do
		{
			int num1 = (int)(Math.random()*19+2);
			int num2 = (int)(Math.random()*19+2);
			int num3 = (int)(Math.random()*19+2);
			int num4 = (int)(Math.random()*19+2);
			int num5 = (int)(Math.random()*19+2);
			int num6 = (int)(Math.random()*19+2);
			double result5 = 0.0;
			String expression = ""+num1+" "+operator()+" "+num2+" "+operator()+" "+num3+" "+operator()+" "+num4+" "+operator()+" "+num5+" "+operator()+" "+num6;
			
			System.out.println("What is the value(nearest 10th) of the following: ");
			System.out.println(expression);
			double userIn = kb.nextDouble();
			
			ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
			
			try
			{
				Object result2 = engine.eval(expression);
				String result4 = ""+result2;
				result5 = ((int)(Double.parseDouble(result4))*10.0)/10.0;
			}
			catch (ScriptException e)
			{
				e.printStackTrace();
			}
			if (result5 == userIn)
				{
					System.out.println("Correct!");
					boo = true;
				}
			else
			{
				System.out.println("Incorrect.");
			}
		}while (boo == false);
	}
	public char operator()
	{
		char opp;
		if (((int)(Math.random()*4+1))==1)
		{
			opp = (char)(42);
			return opp;
		}
		else if (((int)(Math.random()*4+1))==2)
		{
			opp = (char)(43);
			return opp;
		}
		else if (((int)(Math.random()*4+1))==3)
		{
			opp = (char)(45);
			return opp;
		}
		else
		{
			opp = (char)(47);
			return opp;
		}
	}
}
