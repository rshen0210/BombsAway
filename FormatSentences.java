/*
Ryan Shen
9/26/22
Format Sentences
This code formats any sentence you enter. 
*/
import java.util.Scanner;

public class FormatSentences
{
	public static void main(String [] Args)
	{
		FormatSentences fs = new FormatSentences();
		fs.runner();
	}
	public void runner()
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Printf(1) or Format(2)? ");
		int format = console.nextInt();
		
		if (format == 2) {
			System.out.print("Would you like left(1), center(2), or right(3)? ");
			int prefer = console.nextInt();
			System.out.print("How many spaces? ");
			int spaces = console.nextInt();
			System.out.print("Enter your sentence: ");
			console.nextLine();
			String sentence = console.nextLine();
			
			System.out.print("Would you like left(1), center(2), or right(3)? ");
			int preference = console.nextInt();
			System.out.print("How many spaces? ");
			int space = console.nextInt();
			System.out.print("Enter your sentence: ");
			console.nextLine();
			String line = console.nextLine();
			
			System.out.print("Would you like left(1), center(2), or right(3)? ");
			int choice = console.nextInt();
			System.out.print("How many spaces? ");
			int spacing = console.nextInt();
			System.out.print("Enter your sentence: ");
			console.nextLine();
			String lines = console.nextLine();
			
			
			System.out.println("\n");
			System.out.println("Here are your three sentences: ");
			
			System.out.println("0123456789012345678901234567890123456789");
			if (prefer == 1) 
			{
				System.out.println(Format.left(sentence,spaces));
			}	
			else if (prefer == 2)
			{
				System.out.println(Format.center(sentence,spaces));
			}
			else
			{
				System.out.println(Format.right(sentence,spaces));
			}
			System.out.println("0123456789012345678901234567890123456789");
			if (preference == 1) 
			{
				System.out.println(Format.left(line,space));
			}	
			else if (preference == 2)
			{
				System.out.println(Format.center(line,space));
			}
			else 
			{
				System.out.println(Format.right(line,space));
			}
			System.out.println("0123456789012345678901234567890123456789");
			if (choice == 1) 
			{
				System.out.println(Format.left(lines,spacing));
			}	
			else if (choice == 2)
			{
				System.out.println(Format.center(lines,spacing));
			}
			else  
			{
				System.out.println(Format.right(lines,spacing));
			}
		}
		else
		{
			System.out.print("Would you like left(1), center(2), or right(3)? ");
			int prefer1 = console.nextInt();
			System.out.print("How many spaces? ");
			int spaces1 = console.nextInt();
			System.out.print("Enter your sentence: ");
			console.nextLine();
			String sentence1 = console.nextLine();
			
			System.out.print("Would you like left(1), center(2), or right(3)? ");
			int prefer2 = console.nextInt();
			System.out.print("How many spaces? ");
			int spaces2 = console.nextInt();
			System.out.print("Enter your sentence: ");
			console.nextLine();
			String sentence2 = console.nextLine();
			
			System.out.print("Would you like left(1), center(2), or right(3)? ");
			int prefer3 = console.nextInt();
			System.out.print("How many spaces? ");
			int spaces3 = console.nextInt();
			System.out.print("Enter your sentence: ");
			console.nextLine();
			String sentence3 = console.nextLine();
			
			System.out.println("0123456789012345678901234567890123456789");
			if (prefer1 == 1)
			{
				System.out.printf("%s\n",sentence1);
			}
			else if (prefer1 == 2)
			{
				int length1 = sentence1.length();
				int spaces4 = (spaces1/2);
				String sentence4 = "%"+spaces4+"s";
				System.out.printf(sentence4,sentence1);
				System.out.print("\n");
			}
			else
			{
				int length2 = sentence1.length();
				String sentence5 = "%"+spaces1+"s";
				System.out.printf(sentence5,sentence1);
				System.out.print("\n");
			}
			
			System.out.println("0123456789012345678901234567890123456789");
			
			if (prefer2 == 1)
			{
				System.out.printf("%s\n",sentence2);
			}
			else if (prefer2 == 2)
			{
				int length3 = sentence2.length();
				int spaces5 = (spaces1/2);
				String sentence5 = "%"+spaces5+"s";
				System.out.printf(sentence5,sentence2);
				System.out.print("\n");
			}
			else
			{
				int length4 = sentence1.length();
				String sentence6 = "%"+spaces2+"s";
				System.out.printf(sentence6,sentence2);
				System.out.print("\n");
			}
			System.out.println("0123456789012345678901234567890123456789");
			if (prefer3 == 1)
			{
				System.out.printf("%s\n",sentence3);
			}
			else if (prefer3 == 2)
			{
				int length10 = sentence3.length();
				int spaces40 = (spaces3/2);
				String sentence40 = "%"+spaces40+"s";
				System.out.printf(sentence40,sentence3);
				System.out.print("\n");
			}
			else
			{
				int length20 = sentence3.length();
				String sentence50 = "%"+spaces3+"s";
				System.out.printf(sentence50,sentence3);
				System.out.print("\n");
			}
		}	
	}		
}
class Format
{

    public Format()
    {
    }

    public static String center(double d, int i, int j)
    {
        String s = decimalPlaces(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String centerSigFigs(double d, int i, int j)
    {
        String s = sigFigFix(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String center(long l, int i)
    {
        String s = convert(l);
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String center(String s, int i)
    {
        if(i < s.length())
            return s;
        else
            return pad(' ', ((i - s.length()) + 1) / 2) + s + 
            pad(' ', (i - s.length()) / 2);
    }

    public static String left(double d, int i, int j)
    {
        String s = decimalPlaces(d, j);
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String leftSigFigs(double d, int i, int j)
    {
        String s = sigFigFix(d, j);
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String left(long l, int i)
    {
        String s = convert(l);
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String left(String s, int i)
    {
        if(i < s.length())
            return s;
        else
            return s + pad(' ', i - s.length());
    }

    public static String right(double d, int i, int j)
    {
        String s = decimalPlaces(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String rightSigFigs(double d, int i, int j)
    {
        String s = sigFigFix(d, j);
        if(i < s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String right(long l, int i)
    {
        String s = convert(l);
        if(i <= s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String right(String s, int i)
    {
        if(i < s.length())
            return s;
        else
            return pad(' ', i - s.length()) + s;
    }

    public static String decimalPlaces(double d, int i)
    {
        double d1 = d * Math.pow(10D, i);
        d1 = Math.round(d1);
        d1 /= Math.pow(10D, i);
        return convert(d1, i);
    }

    public static String sigFigFix(double d, int i)
    {
        String s = Double.toString(d);
        String s1;
        String s2;
        if(s.startsWith("-") || s.startsWith("+"))
        {
            s1 = s.substring(0, 1);
            s2 = s.substring(1);
        } else
        {
            s1 = "";
            s2 = s;
        }
        int j = s2.indexOf(101);
        if(j == -1)
            j = s2.indexOf(69);
        String s3;
        String s4;
        if(j == -1)
        {
            s3 = s2;
            s4 = "";
        } else
        {
            s3 = s2.substring(0, j);
            s4 = s2.substring(j);
        }
        int k = s3.indexOf(46);
        StringBuffer stringbuffer;
        StringBuffer stringbuffer1;
        if(k == -1)
        {
            stringbuffer = new StringBuffer(s3);
            stringbuffer1 = new StringBuffer("");
        } else
        {
            stringbuffer = new StringBuffer(s3.substring(0, k));
            stringbuffer1 = new StringBuffer(s3.substring(k + 1));
        }
        int l = stringbuffer.length();
        int i1 = stringbuffer1.length();
        if((l == 0 || stringbuffer.equals("0")) && i1 > 0)
        {
            l = 0;
            for(int j1 = 0; j1 < stringbuffer1.length(); j1++)
            {
                if(stringbuffer1.charAt(j1) != '0')
                    break;
                i1--;
            }

        }
        int k1 = l + i1;
        if(i > k1)
        {
            for(int l1 = k1; l1 < i; l1++)
                stringbuffer1.append('0');

        } else
        if(i < k1 && i >= l)
            stringbuffer1.setLength(
            stringbuffer1.length() - (i1 - (i - l)));
        else
        if(i < l)
        {
            stringbuffer1.setLength(0);
            for(int i2 = i; i2 < l; i2++)
                stringbuffer.setCharAt(i2, '0');

        }
        if(stringbuffer1.length() == 0)
            return s1 + stringbuffer + s4;
        else
            return s1 + stringbuffer + "." + stringbuffer1 + s4;
    }

    private static String convert(double d, int i)
    {
        int j = 0;
        StringBuffer stringbuffer = new StringBuffer("" + d);
        int k;
        for(k = stringbuffer.length(); j < k && 
        stringbuffer.charAt(j) != '.'; j++);
        int l;
        if(j == k)
        {
            stringbuffer.append(".");
            l = i;
        } else
        {
            int i1 = k - j - 1;
            l = i - i1;
        }
        for(int j1 = 0; j1 < l; j1++)
            stringbuffer.append("0");

        return stringbuffer.toString();
    }

    private static String convert(long l)
    {
        return "" + l;
    }

    private static String pad(char c, int i)
    {
        StringBuffer stringbuffer = new StringBuffer("");
        if(i < 1)
            return "";
        for(int j = 0; j < i; j++)
            stringbuffer.append(c);

        return stringbuffer.toString();
    }
}
