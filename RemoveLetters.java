/*
 * Ryan Shen
 * 1/23/23
 * RemoveLetters
 * This code is a game that creates a 10 by 10 grid and asks the user for input. 
*/

import java.util.Scanner;
public class RemoveLetters
{
	int p1total = 100;
	int p2total = 100;
	int p1totalTurns = 5;
	int p2totalTurns = 5;
	boolean turn1 = true;
	boolean turn2 = false;
	Scanner kb = new Scanner(System.in);
	public static void main(String [] args)
	{
		RemoveLetters rl = new RemoveLetters();
		rl.runner();
	}
	public void runner()
	{
		System.out.println("\n\n\n");
		char [][] arr = new char[10][10];
		char [][] arr1 = new char[10][10];
		
		grid(arr, arr1);
		while(p1totalTurns > 0 || p2totalTurns > 0)
		{
			System.out.println("\n");
			printGrid(arr, arr1);
			System.out.println("\n");
			if (p1totalTurns <= 0 || turn2 == true)
			{
				System.out.print("P1: You have "+p1total+" letters. You have "+p1totalTurns+" turns left.");
				System.out.print("P2: You have "+p2total+" letters. You have "+p2totalTurns+" turns left. Would you like to delete a row/column(1) or a letter(2)? ");
				int choice = kb.nextInt();
				turn2 = false;
				turn1 = true;
				if (choice == 1)
				{
					p2totalTurns -= 2;
					System.out.print("\nWhich row/column would you like to remove? ");
					String row = kb.next();
					p2total -= removeRowAndColumn(arr1, row);
				}
				else
				{
					System.out.print("\nWhich letter would you like to remove? ");
					char let = kb.next().charAt(0);
					p2totalTurns -= 1;
					p2total -= removeLetters(arr1, let);
				}
			}
			else if (p2totalTurns <= 0 || turn1 == true)
			{
				System.out.print("P2: You have "+p2total+" letters. You have "+p2totalTurns+" turns left.");
				System.out.print("P1: You have "+p1total+" letters. You have "+p1totalTurns+" turns left. Would you like to delete a row/column(1) or a letter(2)? ");
				int choice = kb.nextInt();
				turn2 = true;
				turn1 = false;
				if (choice == 1)
				{
					p1totalTurns -= 2;
					System.out.print("\nWhich row/column would you like to remove? ");
					String row = kb.next();
					p1total -= removeRowAndColumn(arr, row);
				}
				else
				{
					System.out.print("\nWhich letter would you like to remove? ");
					char let = kb.next().charAt(0);
					p1totalTurns -= 1;
					p1total -= removeLetters(arr, let);
				}
			}
		}
		System.out.print("\n");
		printGrid(arr, arr1);
		System.out.print("\n");
		System.out.println("P1: You have "+p1total+" letters. You have 0 turns left.");
		System.out.println("P2: You have "+p2total+" letters. You have 0 turns left.");
		if (p1total > p2total)
		{
			System.out.print("\n\nP2 wins!");
		}
		else if (p1total < p2total)
		{
			System.out.print("\n\nP1 wins!");
		}
		else
		{
			System.out.print("\n\nYou tied!");
		}
		System.out.print("\n\n\n");
	}
	public void grid(char [][] arr, char [][] arr1)
	{
		for (int i = 0;i<10;i++)
		{
			for (int x = 0;x<10;x++)
			{
				arr[i][x] = (char)(Math.random()*26+65);
			}
		}
		for (int i = 0;i<10;i++)
		{
			for (int x = 0;x<10;x++)
			{
				arr1[i][x] = (char)(Math.random()*26+65);
			}
		}
	}
	public int removeRowAndColumn(char [][] arr, String row)
	{
		int count = 0;
		
		if (row.substring(0,1).equals("R"))
		{
			for (int i = 0;i<=10;i++)
			{
				for (int x = 0;x<10;x++)
				{
					if (i == Integer.parseInt(row.substring(1)))
					{
						arr[i-1][x] = '-';
						count++;
					}
				}
			}
		}
		else
		{
			for (int i = 0;i<10;i++)
			{
				for (int x = 0;x<=10;x++)
				{
					if (x == Integer.parseInt(row.substring(1)))
					{
						arr[i][x-1] = '-';
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public int removeLetters(char [][] arr, char let)
	{
		int count = 0;
		for (int i = 0;i<arr.length;i++)
		{
			for (int x = 0;x<arr[i].length;x++)
			{
				if (arr[i][x] == let)
				{
					arr[i][x] = '-';
					count++;
				}
			}
		}
		return count;
	}
	public void printGrid(char [][] arr, char[][] arr1)
	{
		for (int i = 0;i<10;i++)
		{
			if (i == 0)
			{
				System.out.println("   1 2 3 4 5 6 7 8 9 10\t\t   1 2 3 4 5 6 7 8 9 10");
			}
			if (i < 9)
			System.out.print(i+1+"  ");
			else 
			System.out.print(i+1+" ");
			for (int x = 0;x<10;x++)
			{
				System.out.print(arr[i][x]+" ");
			}
			System.out.print("\t\t");
			if (i < 9)
			System.out.print(i+1+"  ");
			else 
			System.out.print(i+1+" ");
			for (int x = 0;x<10;x++)
			{
				System.out.print(arr1[i][x]+" ");
			}
			System.out.println();
		}
	}
}
