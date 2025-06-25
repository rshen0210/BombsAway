/*
Ryan Shen
12/2/22
ThreeWords
This code asks for three strings from the user, and outputs multiple recurring letters in 
alphabetical order.
*/
import java.util.Scanner;
public class ThreeWords2
{
	public static void main(String [] args)
	{
		ThreeWords2 tw = new ThreeWords2();
		tw.runner();
	}
	public void runner()
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("\n\n\n");
		System.out.print("Please enter all three strings: ");
		String wd0 = kb.next();
		String wd1 = kb.next();
		String wd2 = kb.next();
		order(wd0, wd1, wd2);
		System.out.print("\n\n\n");
	}
	public void order(String wd0, String wd1, String wd2)
	{
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String str4 = "";
		String str5 = "";
		for (int x = 0;x<=wd0.length()-1;x++)
		{
			for (int y = 0;y<=wd1.length()-1;y++)
			{
				if (wd0.charAt(x)==wd1.charAt(y))
				{
					for (int z = 0;z<=str1.length()-1;z++)
					{
						if (wd0.charAt(x) != str1.charAt(z))
						{
							str1+=wd1.charAt(y);
						}
					}
				}
				else
				{
					str2 += wd0.charAt(x);
				}
			}
		}
		System.out.print(str1);
		for (int x = 0;x<=str1.length()-1;x++)
		{
			for (int y = 0;y<=wd2.length()-1;y++)
			{
				if (str1.charAt(x)==wd2.charAt(y))
				{
					for (int z = 0;z<=str3.length()-1;z++)
					{
						if (str1.charAt(x) != str3.charAt(z))
						{
							str3+=wd2.charAt(y);
						}
					}
				}
				else
				{
					str4+=wd2.charAt(y);
				}
			}
		}
		for (int x = 0;x<=str2.length()-1;x++)
		{
			for (int y = 0; y<=wd2.length()-1;y++)
			{
				if (str2.charAt(x)==wd2.charAt(y))
				{
					str4+=wd2.charAt(y);
				}
				else
				{
					str5+=wd2.charAt(y);
				}
			}
		}
		System.out.println("Letter(s) that appear in all three words: ");
		System.out.println(str3.toLowerCase());
		System.out.println("Letter(s) that appear in two words: ");
		System.out.println(str4.toLowerCase());
		System.out.println("Letter(s) that appear in only one word: ");
		System.out.println(str5.toLowerCase());
	}
}
