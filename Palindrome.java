/*
Ryan Shen
1/9/22
Palindrome
This code asks for user input and outputs all of the palindromes in their text.
*/

import java.util.Scanner;
public class Palindrome
{
	public static void main(String [] args)
	{
		Palindrome pal = new Palindrome();
		pal.runner();
	}
	public void runner()
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("\n\n\n");
		System.out.print("Would you like to run Palindrome(1), FindAll(2), Largest(3)? :");
		int prefer = kb.nextInt();
		
		System.out.print("Please enter your String(s) followed by an enter: ");
		kb.nextLine();
		String text = kb.nextLine();
		
		if (prefer == 1)
		{
			System.out.print("\n\n");
					
			System.out.print("Size of palindrome: ");
			
			int size = kb.nextInt();
			
			System.out.print("\n\n");
			System.out.println("Here are your palindromes from your list: ");
			System.out.println(findPalindrome(size, text));
		}
		else if (prefer == 2)
		{
			findAll(text);
		}
		else
		{
			largest(text);
		}
		System.out.print("\n\n\n");
	}
	public String findPalindrome(int size, String str1)
	{
		String sizedStrings = "";
		String arr = "";
		String str = deleteSpace(str1);
		for (int x=0;x<=str.length()-size;x++)
		{
			int y = size-1;
			sizedStrings = str.substring(x,x+size);
			String reverseStrings = "";
			while (y >= 0)
			{
				reverseStrings += sizedStrings.charAt(y);
				y--;
			}
			
			if (sizedStrings.equals(reverseStrings))
			{
				arr += sizedStrings + " ";
			}
		}
		return arr;
	}
	public void findAll(String str)
    {
        int counter = 0;
        String finstr2 = "";
        for(int k = 2; k<=str.length(); k++)
        {
            for(int i = 0; i <= str.length()-k; i++)
            {
                String str2 = str.substring(i,i+k);
                String str3= "";
                for (int j = str2.length()-1; j >= 0; j--)
                {
                    str3 = str3 + str2.charAt(j); 
                }
                if (str3.equals(str2))
                {
                    if (!(str2.indexOf(" ")>=0))
                    {
                        if (finstr2.indexOf(str2)==-1)
                        {
                            finstr2 = finstr2 +str2+" ";
                            counter++;
                        }
                    }
                }
            }
        }
        System.out.println("You have "+ counter+ " palindrome(s)\n"+finstr2);
	}
	
	public void largest(String str1)
	{
		str1 = deleteSpace(str1);
		boolean bob = false;
		String front = "";
		String middle = "";
		String back = "";
		int counter=0;
		for (char j= 'a';j<'z';j++)
		{			
			for(int i=0;i<str1.length();i++)
			{
				if (j==str1.charAt(i))
				{
					counter++;
				}
			}
			if(counter%2==1 && bob==false)
			{
				middle = middle + "" + j;
				bob = true;
			}
			
			counter=counter/2;
			
			
			for(int k=0; k<counter;k++)
			{
				front = front + "" + j;
			}
			
			for(int l=0; l<counter;l++)
			{
				back = j+back;
			}
		}
		System.out.println("\n\n");
		System.out.println("Here is the largest palindrome with your words: ");
		System.out.println(front + middle + back);
	}
	public String deleteSpace(String str1)
	{
		String str = "";
		for (int y=0;y<str1.length();y++)
		{
			if (str1.charAt(y) == (char)(32))
			{
			}
			else
			{
				str += str1.charAt(y);
			}
		}
		return str;
	}
}
