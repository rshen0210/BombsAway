/*
 * Ryan Shen
 * 1/30/23
 * Hangman
 * This code codes for a game called hangman
*/

import java.util.Scanner;
public class Hangman 
{
    public static void main(String[] args) 
    {
        Hangman hm = new Hangman();
        hm.runIt();
    }

    public void runIt() 
    {
        String[] words = { "QUIXOTIC", "JUKEBOX","FLAPJACK", "MAXIMIZE", "WHEEZILY", "EQUALIZE", "CHUTZPAH", "EXORCISE", "WHIZBANG","JEZEBEL","SQUEEZE"};
        int num = (int)(Math.random()*words.length);
        String word = words[num];
        runIt2(word);
    }
    
    public void runIt2(String word)
    {
		System.out.println("\n\n\n");
		boolean win = false;
		Scanner kb = new Scanner(System.in);
		String [] part = {"O","/","|","\\","|","_","/","\\","_"};
		String [] part2 = new String[word.length()];
		int tcount = 0;
		
		for (int i=0;i<word.length();i++)
		{
			part2[i] = "-";
		}
		
		int chances = 9;
		
        while (chances > 0 && win == false)
        {
			for (int i=0;i<word.length();i++)
			{
				System.out.print(part2[i]);
			}
			System.out.println();
			System.out.println("You have "+chances+" chances.");
			int hcount = 0;
			for (int i=0;i<word.length();i++)
			{
				if (part2[i] == "-")
				hcount++;
			}
			if (hcount == 0)
			win = true;
			if (win)
			{
				System.out.println("You won!");
			}
			else
			{
				System.out.print("Guess a letter to the word: ");
				String let = kb.next().toUpperCase();
				int count = 0;
				for (int i=0;i<word.length();i++)
				{
					if (let.equals(""+word.charAt(i)))
					{
						part2[i] = let;
						count++;
					}
				}
				if (count == 0)
				tcount++;
				System.out.println("There are "+count+" '"+let+"' in the word");
				System.out.println("   ____"); 
				System.out.print("  |    |");
				System.out.println(); 
				System.out.print("  |    "); 
				if (tcount >= 1)
				System.out.println(part[0]);
				else
				System.out.println();
				System.out.print("  |  "); 
				if (tcount >= 2)
				System.out.print(" "+part[1]);
				if (tcount >= 3)
				System.out.print(part[2]);
				if (tcount >= 4)
				System.out.println(part[3]);
				else
				System.out.println();
				System.out.print("  |    "); 
				if (tcount >= 5)
				System.out.println(part[4]);
				else
				System.out.println();
				System.out.print("  | "); 
				if (tcount >= 6)
				System.out.print(" "+part[5]);
				if (tcount >= 7)
				System.out.print(part[6]);
				if (tcount >= 8)
				System.out.print(" "+part[7]);
				if (tcount >= 9)
				System.out.println(part[8]);
				else
				System.out.println();
				System.out.println(" _|_"); 
				System.out.println("|   |______");
				System.out.println("|          |");
				System.out.println("|__________|"); 
				System.out.println("\n");
				chances--;
			}
		}
		if (chances == 0)
		{
			for (int i=0;i<word.length();i++)
			{
				System.out.print(part2[i]);
			}
			System.out.println();
			System.out.println("You have 0 chances.");
			System.out.println("The word was "+word);
		}
		System.out.print("\n\n\n");
	}
}
