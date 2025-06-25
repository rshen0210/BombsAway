/*
Ryan Shen
11/14/22
MyFirstRecursion
This code asks the user for 4 different output answers.
*/
import java.util.Scanner;
public class MyFirstRecursion
{
	public static void main(String [] args)
	{
		MyFirstRecursion mfr = new MyFirstRecursion();
		mfr.runner();
	}
	public void runner()
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Would you like to add(1), factors(2), vowels(3), consonants(4)? ");
		int prefer = kb.nextInt();
		if (prefer == 1)
		{
			System.out.print("Please enter 2 numbers. The larger number first: ");
			int num1 = kb.nextInt();
			int num2 = kb.nextInt();
			System.out.println(add(num1, num2));
		}
		else if (prefer == 2)
		{
			System.out.print("Please enter an integer: ");
			int num = kb.nextInt();
			factors(num, 1);
		}
		else if (prefer == 3)
		{
			System.out.print("Please enter a word: ");
			kb.nextLine();
			String word = kb.nextLine();
			System.out.print("Here is your word with only vowels: " + vowels(word));
		}
		else
		{
			System.out.print("Please enter a word: ");
			kb.nextLine();
			String word1 = kb.nextLine();
			System.out.print("Here is your word with only consonants: " + consonants(word1));
		}
	}
	public int add(int n1, int n2)
	{
		if (n1 == n2)
		{
			return n1;
		}
		else
		{
			return n1 + add(n1-1, n2);
		}
	}
	public void factors(int num, int x)
	{
		if (x <= num)
		{
			if (num%x == 0)
			{
				System.out.print(x +", ");
			}
			factors(num, x + 1);
		}
	}
	public String vowels(String word) 
	{
        String allvowels = "";

        if(word.length()==0) 
        {
            return allvowels;
        }
        else if(word.charAt(0)=='a'||word.charAt(0)=='e'||word.charAt(0)=='i'||word.charAt(0)=='o'||word.charAt(0)=='u')
        {
            allvowels+=word.charAt(0);
        }
		allvowels+=vowels(word.substring(1));
		return allvowels;
    }
    public String consonants(String word) 
    {
        String allconsonants="";
        
        if(word.length()==0) 
        {
            return allconsonants;
        }
        else if(word.charAt(0)=='a'||word.charAt(0)=='e'||word.charAt(0)=='i'||word.charAt(0)=='o'||word.charAt(0)=='u')
        {
            
        }
        else 
        {
            allconsonants+=word.charAt(0);
        }
        return allconsonants+=consonants(word.substring(1));
    }
}
