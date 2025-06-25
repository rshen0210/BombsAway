/*
Ryan Shen
Translate.java
1.31.23
This code is about practicing translating things from English, Spanish, and French.
*/
import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException; 
import java.io.IOException; import java.util.Scanner; 

public class Translate 
{
	Scanner kb;
	Scanner input = null; 
	String value;
	String [] list;	
	public Translate()
	{
		 kb = new Scanner(System.in);
	}
    public static void main(String[] args) 
    {
        Translate hm = new Translate();
        hm.runner();
    }
    public void runner() 
    {
		boolean stop = false;
		String transwer = "";
		String answer = "";
		String random1 = "";
		String random2 = "";
		String random3 = "";
		String random4 = "";
		System.out.print("\n\n\n");
		System.out.print("What language would you like to practice, English(1), French(2), Spanish(3)? ");
		int which = kb.nextInt();
		System.out.print("What language would you like to translate to, English(1), French(2), Spanish(3)? ");
		int which2 = kb.nextInt();
		System.out.print("\n");
		String [] English = new String[100];
		String [] Spanish = new String[100];
		String [] French = new String[100];
		readIt();
		for(int i = 0; i < 100; i++)
		{
			value = input.next();
			value = value.toLowerCase();
			English[i]= value;
			value = input.next();
			value = value.toLowerCase();
			if(value.equals("la")||value.equals("de")||value.equals("un"))
			{
				value = value + input.next();
			}
			Spanish[i] = value;
			value = input.next();
			value = value.toLowerCase();
			if(value.equals("la")||value.equals("de")||value.equals("un"))
			{
				value = value + input.next();
			}
			French[i] = value;
		}
		input.close();
		String guess = "";
		while (stop == false)
		{
			int rand = (int)(Math.random()*25);
			int rand2 = (int)(Math.random()*25)+25;
			int rand3 = (int)(Math.random()*25)+50;
			int rand4 = (int)(Math.random()*25)+75;
			int answer1 = (int)(Math.random()*100);
			while(answer1 == rand||answer1 == rand2 || answer1 == rand3 || answer1 == rand4)
			{
				answer1 = (int)(Math.random()*100);
			}
			if (which == 1)
			{
				transwer = English[answer1];
				System.out.print("What is the definition of '"+transwer + "' in");
			}
			else if (which == 2)
			{
				transwer = Spanish[answer1];
				System.out.print("What is the definition of '"+transwer + "' in");
			}
			else if(which == 3)
			{
				transwer = French[answer1];
				System.out.print("What is the definition of '"+transwer + "' in");
			}
			if(which2 == 1)
			{
				answer = English[answer1];
				random1 = English[rand];
				random2 = English[rand2];
				random3 = English[rand3];
				random4 = English[rand4];
				System.out.print(" English?");
			}
			else if(which2 == 2)
			{
				answer = Spanish[answer1];
				random1 = Spanish[rand];
				random2 = Spanish[rand2];
				random3 = Spanish[rand3];
				random4 = Spanish[rand4];
				System.out.print(" French?");
			}
			else if(which2 == 3)
			{
				answer = French[answer1];
				random1 = French[rand];
				random2 = French[rand2];
				random3 = French[rand3];
				random4 = French[rand4];
				System.out.print(" Spanish?");
			}
			System.out.println();
			runIt(answer,random1,random2,random3,random4);
			int idk ;
			while(!(guess.equals(answer))&&stop == false)
			{
				System.out.print("Your answer? ");
				String inp = kb.next();
				inp = inp.toLowerCase();
				if(inp.equals("z"))
				{
					stop = true;
					System.out.print("Thank you for using Translate.java");
				}
				else
				{
					idk = inp.charAt(0);
					idk = idk-97;
					guess = list[idk];
					if(guess.equals(answer))
					System.out.println("Correct!"); 
					else
					System.out.println("Incorrect. Try again.");
				}
			}
			System.out.println();
		}
		System.out.print("\n\n");
    }
    public String [] runIt2(String [] words)
    {
		int index=0;
		String [] rWord = new String [5];
		String num = "01234";
		for(int i=0;i<5;i++)
		{
			index = (int)(Math.random()*(num.length()));
			rWord[i] = words[Integer.parseInt(""+num.charAt(index))];
			num = num.substring(0,index)+num.substring(index+1);
		}
		return rWord;
	}
	public void runIt(String ans,String str,String str2,String str3,String str4) 
    {
        list = new String[]{ans,str,str2,str3,str4};
		list = runIt2(list);

		System.out.print("a) "+list[0]+"\n");
		System.out.print("b) "+list[1]+"\n");
		System.out.print("c) "+list[2]+"\n");
		System.out.print("d) "+list[3]+"\n");
		System.out.print("e) "+list[4]+"\n");
		System.out.println();
    }
    public void readIt()
    {
		File inFile = new File ("English_French_Spanish.txt"); 
		String inFileName = "English_French_Spanish.txt"; 
		String value = ""; 
		String fin = "";
		try
		{ 
		 input = new Scanner ( inFile );
		}
		catch ( FileNotFoundException e ) 
		{ 
		 System.err.println("Cannot find " + inFileName + " file.");  
		 System.exit(1);
		}
	}
}
