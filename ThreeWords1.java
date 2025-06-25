/*
Ryan Shen
12/2/22
ThreeWords
This code asks for three strings from the user, and outputs multiple recurring letters in 
alphabetical order.
*/
import java.util.Scanner;
public class ThreeWords1
{
	public static void main(String [] args)
	{
		ThreeWords1 tw = new ThreeWords1();
		tw.runner();
	}
	public void runner()
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("\n\n\n");
		System.out.print("Please enter all three strings: ");
		String wd = kb.next();
		String wd1 = kb.next();
		String wd2 = kb.next();
		String str = wd+wd1+wd2;
		System.out.println("Letter(s) that appear in all three words: ");
		order(wd, wd1, wd2);
	}
	public void order(String wd, String wd1, String wd2)
	{
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String str4 = "";
		for (int i = 0;i<=wd.length()-1;i++)
		{
			for (int x = 0;x<=wd1.length()-1;x++)
			{
				if (wd.charAt(i) == wd1.charAt(x))
				{
					str2+=wd.charAt(x);					
				}
			}
		}
		for (int i = 0;i<=wd1.length()-1;i++)
		{
			for (int x = 0;x<=wd2.length()-1;x++)
			{
				if (wd1.charAt(i) == wd2.charAt(x))
				{
					str2+=wd.charAt(x);
				}
			}
		}
		for (int i = 0;i<=wd.length()-1;i++)
		{
			for (int x = 0;x<=wd2.length()-1;x++)
			{
				if (wd.charAt(i) == wd2.charAt(x))
				{
					str2+=wd.charAt(x);
				}
			}
		}
		for (int i = 0;i<=wd.length()-1;i++)
		{
			for (int x = 0;x<=wd1.length()-1;x++)
			{
				for (int y = 0;y<=wd2.length()-1;y++)
				{
					if ((wd.charAt(i) == wd1.charAt(x)) && (wd.charAt(i)==wd2.charAt(y)))
					{
						str1 +=wd.charAt(i);
					}
				}
			}
		}
		
		for (int i = 0;i<=str1.length()-1;i++)
		{
			for (int x = 0; x<= str1.length()-1;x++)
			{
				if ((x!=i)&&(str1.charAt(i)==str1.charAt(x)))
				{
					str1 = str1.substring(0,x)+str1.substring(x+1,str1.length());
				}
			}
		}
		
		System.out.println(str1.toLowerCase());
		System.out.println("Letter(s) that appear in only two words: ");
		
		for (int i = 0;i<=str1.length()-1;i++)
		{
			for (int x = 0;x<=str2.length()-1;x++)
			{
				if (str1.charAt(i)==str2.charAt(x))
				{
					str2 = str2.substring(0,x)+str2.substring(x+1,str2.length());
				}
			}
		}
		
		
		
		/*for (int i = 0;i<=str2.length()-1;i++)
		{
			for (int x = 0;x<= str2.length()-1;x++)
			{
				if ((x!=i)&&(str2.charAt(i)==str2.charAt(x)))
				{
					str4 = str2.substring(0,x)+str2.substring(x+1,str2.length());
				}
			}
		}*/
			
		System.out.println(str2.toLowerCase());
	}
}
