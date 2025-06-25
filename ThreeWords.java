/*
Ryan Shen
12/2/22
ThreeWords
This code asks for three strings from the user, and outputs multiple recurring letters in 
alphabetical order.
*/
import java.util.Scanner;

public class ThreeWords 
{
	Scanner in;
	
	public ThreeWords() 
	{
		in = new Scanner(System.in);
	}
	
	public static void main (String[] args) 
	{
		ThreeWords tw = new ThreeWords();
		tw.runner();
	}

	public void runner() 
	{
		System.out.print("\n\n\n");

		String word1;
		String word2;
		String word3;
		String word4;
		String word5;
		int amount;
		
		System.out.println("Please enter how many strings you would like to enter: ");
		amount = in.nextInt();
		if (amount == 1)
		{
			System.out.println("Please enter 1 string: ");
			word1 = in.next();
			System.out.println("\nOutput:");
			letters(word1, "", "", "", "", amount);
		}
		else if(amount == 2)
		{
			System.out.println("Please enter 2 strings: ");
			word1 = in.next();
			word2 = in.next();
			System.out.println("\nOutput:");
			letters(word1, word2, "", "", "", amount);
		}
		else if(amount == 3)
		{
			System.out.println("Please enter 3 strings: ");
			word1 = in.next();
			word2 = in.next();
			word3 = in.next();
			System.out.println("\nOutput:");
			letters(word1, word2, word3, "", "", amount);
		}
		else if(amount == 4)
		{
			System.out.println("Please enter 4 strings: ");
			word1 = in.next();
			word2 = in.next();
			word3 = in.next();
			word4 = in.next();
			System.out.println("\nOutput:");
			letters(word1, word2, word3, word4, "", amount);
		}
		else
		{
			System.out.println("Please enter 5 strings: ");
			word1 = in.next();
			word2 = in.next();
			word3 = in.next();
			word4 = in.next();
			word5 = in.next();
			System.out.println("\nOutput:");
			letters(word1, word2, word3, word4, word5, amount);
		}
		
		System.out.print("\n\n\n");
	}
	public void letters(String w1, String w2, String w3, String w4, String w5, int amount) 
	{
		String five = "";
		String four = "";
		String three = "";
		String two = "";
		String one = "";

		boolean match1 = false;
		boolean match2 = false;
		boolean match3 = false;
		boolean match4 = false;
		boolean match5 = false;

		for (int i = 97; i<= 122; i++) 
		{
			if (amount == 1)
			{
				for (int j = 0; j < w1.length(); j++) 
				{
					if ((char) i == w1.charAt(j) || (char)(i-32) == w1.charAt(j) && !match1) 
					{
						match1 = true;
					}
				}
			}
//----------------------------------------------------------------------------------------------
			else if (amount == 2)
			{
				for (int j = 0; j < w1.length(); j++) 
				{
					if ((char) i == w1.charAt(j) || (char)(i-32) == w1.charAt(j) && !match1) 
					{
						match1 = true;
					}
				}
				for (int k = 0; k < w2.length(); k++) 
				{
					if ((char) i == w2.charAt(k) || (char)(i-32) == w2.charAt(k) && !match2) 
					{
						match2 = true;
					}
				}
			}
//----------------------------------------------------------------------------------------------
			else if (amount == 3)
			{
				for (int j = 0; j < w1.length(); j++) 
				{
					if ((char) i == w1.charAt(j) || (char)(i-32) == w1.charAt(j) && !match1) 
					{
						match1 = true;
					}
				}
				for (int k = 0; k < w2.length(); k++) 
				{
					if ((char) i == w2.charAt(k) || (char)(i-32) == w2.charAt(k) && !match2) 
					{
						match2 = true;
					}
				}
				for (int l = 0; l < w3.length(); l++) 
				{
					if ((char) i == w3.charAt(l) || (char)(i-32) == w3.charAt(l) && !match3) 
					{
						match3 = true;
					}
				}
			}
//----------------------------------------------------------------------------------------------
			else if (amount == 4)
			{
				for (int j = 0; j < w1.length(); j++) 
				{
					if ((char) i == w1.charAt(j) || (char)(i-32) == w1.charAt(j) && !match1) 
					{
						match1 = true;
					}
				}
				for (int k = 0; k < w2.length(); k++) 
				{
					if ((char) i == w2.charAt(k) || (char)(i-32) == w2.charAt(k) && !match2) 
					{
						match2 = true;
					}
				}
				for (int l = 0; l < w3.length(); l++) 
				{
					if ((char) i == w3.charAt(l) || (char)(i-32) == w3.charAt(l) && !match3) 
					{
						match3 = true;
					}
				}
				for (int m = 0; m < w4.length(); m++)
				{
					if ((char) i == w4.charAt(m) || (char)(i-32) == w4.charAt(m) && !match4) 
					{
						match4 = true;
					}
				}
			}
//----------------------------------------------------------------------------------------------
			else
			{
				for (int j = 0; j < w1.length(); j++) 
				{
					if ((char) i == w1.charAt(j) || (char)(i-32) == w1.charAt(j) && !match1) 
					{
						match1 = true;
					}
				}
				for (int k = 0; k < w2.length(); k++) 
				{
					if ((char) i == w2.charAt(k) || (char)(i-32) == w2.charAt(k) && !match2) 
					{
						match2 = true;
					}
				}
				for (int l = 0; l < w3.length(); l++) 
				{
					if ((char) i == w3.charAt(l) || (char)(i-32) == w3.charAt(l) && !match3) 
					{
						match3 = true;
					}
				}
				for (int m = 0; m < w4.length(); m++)
				{
					if ((char) i == w4.charAt(m) || (char)(i-32) == w4.charAt(m) && !match4) 
					{
						match4 = true;
					}
				}
				for (int n = 0; n < w5.length(); n++)
				{
					if ((char) i == w5.charAt(n) || (char)(i-32) == w5.charAt(n) && !match5) 
					{
						match5 = true;
					}
				}
			}
			
			
			if (amount == 1)
			{
				if (match1)
				{
					one += (char) i +", ";
					match1 = false;
				}
			}
			
			else if (amount == 2)
			{
				if (match1 && match2)
				{
					two += (char) i +", ";
					match2 = false;
					match1 = false;
				}
				else if (match1 || match2)
				{
					one += (char) i + ", ";
					match1 = false;
					match2 = false;
				}
			}
			else if (amount == 3)
			{
				if (match3 && match2  && match1) 
				{
					three += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
				}
				else if ((match1 && match2) || (match2 && match3) || (match1 && match3)) 
				{
					two += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
				}
				else if (match1 || match2 || match3) 
				{
					one += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
				}
			}
			else if (amount == 4)
			{
				if (match4 && match3 && match2  && match1) 
				{
					four += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
					match4 = false;
				}
				else if ((match1 && match2 && match3) || (match2 && match3 && match4) || (match1 && match3 && match4) || (match4 && match1 && match2) || (match4 && match2 && match3))
				{
					three += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
					match4 = false;
				}
				else if ((match1 && match2) || (match2 && match3) || (match3&& match1) || (match4 && match1) || (match4 && match2) || (match4 && match3)) 
				{
					two += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
					match4 = false;
				}
				else if (match1 || match2 || match3 || match4)
				{
					one += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
					match4 = false;
				}
			}
			else 
			{
				if (match5 && match4 && match3 && match2  && match1) 
				{
					five += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
					match4 = false;
					match5 = false;
				}
				else if ((match1 && match2 && match3 && match4) || (match1 && match2 && match3 && match5) || (match1 && match2 && match4 && match5) || (match1 && match3 && match4 && match5) || (match2 && match3 && match4 && match5))
				{
					four += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
					match4 = false;
					match5 = false;
				}
				else if ((match1 && match2 && match3) || (match1 && match2 && match4) || (match1 && match3 && match4) || (match1 && match3 && match5) || (match1 && match4 && match5) || (match2 && match3 && match4) || (match2 && match3 && match5) || (match2 && match4 && match5) || (match3 && match4 && match5))
				{
					three += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
					match4 = false;
					match5 = false;
				}
				else if ((match1 && match2) || (match2 && match3) || (match3&& match1) || (match4 && match1) || (match4 && match2) || (match4 && match3) || (match1 && match5) || (match2 && match5) || (match3 && match5) || (match4 && match5))
				{
					two += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
					match4 = false;
					match5 = false;
				}
				else if (match1 || match2 || match3 || match4)
				{
					one += (char) i + ", ";
					match1 = false;
					match2 = false;
					match3 = false;
					match4 = false;
					match5 = false;
				}
			}
		}

		if (one == "") 
		{
			one = "none";
		}
		if (two == "") 
		{
			two = "none";
		}
		if (three == "") 
		{
			three = "none";
		}
		if (four == "")
		{
			four = "none";
		}
		if (five == "")
		{
			five = "none";
		}
		
		System.out.println("Letter(s) that appear in all five words:");
		if (five.charAt(five.length()-2) == ',') 
		{
			five = five.substring(0, five.length()-2);
		}
		System.out.println(five);
		
		System.out.println("\nLetter(s) that appear in all four words:");
		if (four.charAt(four.length()-2) == ',') 
		{
			four = four.substring(0, four.length()-2);
		}
		System.out.println(four);
		
		System.out.println("\nLetter(s) that appear in all three words:");
		if (three.charAt(three.length()-2) == ',') 
		{
			three = three.substring(0, three.length()-2);
		}
		System.out.println(three);

		System.out.println("\nLetter(s) that appear in two words:");
		if (two.charAt(two.length()-2) == ',') 
		{
			two = two.substring(0, two.length()-2);
		}
		System.out.println(two);

		System.out.println("\nLetter(s) that appear in only one word:");
		if (one.charAt(one.length()-2) == ',') 
		{
			one = one.substring(0, one.length()-2);
		}
		System.out.println(one);
		
	}
}
