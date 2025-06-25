/*
Ryan Shen
11/16/22
SeparateNumbers
This code separates the user's words and letters from the user's inputted numbers.
*/

import java.util.Scanner;

public class SeparateNumbers
{
	public static void main(String [] args)
	{
		SeparateNumbers sn = new SeparateNumbers();
		sn.runner();
	}
	public void runner()
	{
		System.out.print("\n\n\n");
		Scanner kb = new Scanner(System.in);
		System.out.print("Would you like to run Part1(1), Part 2(2), or Part3(3)? ");
		int prefer = kb.nextInt();
		if (prefer == 1)
		{
			System.out.print("What is your input? ");
			kb.nextLine();
			String userIn = kb.nextLine();
			System.out.print("\n\n");
			System.out.println("Non-integers: ");
			System.out.print(nonintegers(userIn));
			System.out.print("\n\n");
			System.out.println("Integers: ");
			System.out.println(integer(userIn));
		}
		else if (prefer == 2)
		{
			System.out.print("Please enter your number: ");
			int num1 = kb.nextInt();
			String num = ""+num1;
			System.out.print("\n\n");
			System.out.println("Here is your output: ");
			System.out.print(Part2(num,num1));
		}
		else
		{
			System.out.print("Please enter your number: ");
			int num3 = kb.nextInt();
			System.out.print("Please enter your word: ");
			kb.nextLine();
			String word = kb.next();
			wordMethod(num3, word);
		}
		System.out.print("\n\n\n");
	}
	public String integer(String str)
	{
		String integers = "";
		
		if (str.length() == 0)
		{
			return integers;
		}
		char ch = str.charAt(0);
		int ascii = ch;
		if (ascii >= 48 && ascii <= 56)
		{
			integers += str.charAt(0);
		}
		return integers+=integer(str.substring(1));
	}
	public String nonintegers(String str)
	{
		String nonintegers = "";
		
		if (str.length() == 0)
		{
			return nonintegers;
		}
		char ch = str.charAt(0);
		int ascii = ch;
		if (ascii <= 48 || ascii >= 56)
		{
			nonintegers += str.charAt(0);
		}
		return nonintegers+=nonintegers(str.substring(1));
	}
	public String Part2(String num, int num1)
	{
		if (num.length()==0)
		{
			return "";
		}
		else if (num1%10==0)
		{
			return "\n"+Part2(num.substring(0,num.length()-1), num1/10);
		}
		else
		{
			return "" + num.charAt(num.length()-1)+Part2(num,num1-1);
		}
	}
	public void wordMethod(int num2, String str1)
	{
        String wd = "" + num2;
        int strToInt = 0;
        int highestInt = 0;
        for(int i=0; i<wd.length(); i++)
        {
            String charToNum = "" + wd.charAt(i); 
            strToInt = Integer.parseInt(charToNum);
            if(strToInt > highestInt) highestInt = strToInt;
        }
        wd = reverseStr(wd);
        int revNum = Integer.parseInt(wd);
        for(int k = 0; k < highestInt; k++)
        {
            for(int n = 1; n <= wd.length(); n++)
            {
                if((revNum/(Math.pow(10, n-1)))%(10) >= highestInt-k) System.out.print(str1.charAt(n-1));
                else System.out.print(" ");
            }
            System.out.print("\n");
        }
	}
    public String reverseStr(String word)
    {
        if(word.length() == 0) return "";
        else return "" + word.charAt(word.length()-1) + reverseStr(word.substring(0, word.length()-1));
    }
}
