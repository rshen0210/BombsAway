/*
Ryan Shen
12/7/22
SentenceStats
This code gives the user the statistics on the sentence they entered.
*/
import java.util.Scanner;

public class SentenceStats
{
	public static void main(String [] args)
	{
		SentenceStats ss = new SentenceStats();
		ss.runner();
	}
	public void runner()
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.print("\n\n\n");
		
		System.out.println("Please enter a sentence: ");
		String sentence = kb.nextLine();
		
		System.out.println("Length of sentence: "+sentence.length() + " chars");
		System.out.println("Number of words: "+words(sentence));
		commonChar(sentence.toLowerCase());
		shortestChar(removePunct(sentence.toLowerCase()));
		
		System.out.print("\n\n\n");
	}
	public int words(String sentence)
	{
		int count = 0;
		for (int i = 0;i<sentence.length();i++)
		{
			if ((int) sentence.charAt(i) == 32)
			{
				count++;
			}
		}
		return count+1;
	}
	public void commonChar(String sentence)
	{
		String newword = "";
		char letter = (char) 97;
		int max = 0;
		int count = 0;
		
		for (int x = 97;x<=122;x++)
		{
			char e = (char) x;
			for (int i = 0;i<sentence.length();i++)
			{
				if (sentence.charAt(i)== e)
				{
					count++;
				}
			}
			if (count > max)
			{
				letter = e;
				newword = letter+"";
				max = count;
			}
			else if (count == max)
			{
				letter = e;
				newword += " " + letter;
			}
			count = 0;
		}
		System.out.println("The most common letter is: "+newword+" - "+max);
	}
	public void shortestChar(String sentence)
	{
		int word = 0;
		int least = 100000000;
		int count = 0;
		String str = "";	
		String word1 = "";
		String shortestWord = "";
		
		
		for (int i = 0;i<sentence.length();i++)
		{
			if (i == (sentence.length()-1))
			{
				str += word+1;
				word = 0;
			}
			else if ((int) sentence.charAt(i) != 32)
			{
				word++;
			}
			else 
			{
				str += word +" ";
				word *= 0;
			}
		}

		for (int i = 0;i<str.length();i++)
		{
			String x = ""+str.charAt(i);
			if ((int) str.charAt(i) == 32)
			{
			}
			else if (Integer.parseInt(x) <  least)
			{
				least = Integer.parseInt(x);
			}
		}
		
		for (int i = 0;i<sentence.length();i++)
		{
			if (i == sentence.length()-1)
			{
				word1 += sentence.charAt(i);
				if (word1.length() == least)
				{
					shortestWord += word1;
				}
			}
			else if ((int) sentence.charAt(i) != 32)
			{
				word1 += sentence.charAt(i);
			}
			else if ((int) sentence.charAt(i) == 32)
			{
				if (word1.length() == least)
				{
					shortestWord += word1 + " ";
				}
				word1 = "";
			}
		}
		System.out.println("Shortest word(s): " + shortestWord);
	}
	public String removePunct(String sentence)
	{
		String sentence2 = "";
		for (int i = 0;i<sentence.length();i++)
		{
			if (sentence.charAt(i) == (char) 39)
			{
				sentence2 += sentence.charAt(i);
			}
			else
			{
				String sentence1 = ""+sentence.charAt(i);
				sentence1.replaceAll("\\p{P}", "");
				sentence2 += sentence.charAt(i);
			}
		}
		return sentence2;
	}
}
