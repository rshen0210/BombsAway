/*
 * Ryan Shen
 * 2/3/23
 * BabyNames
 * This code reads txt files, appends to them, and orders them.
*/


import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException; 
import java.io.IOException; import java.util.Scanner; import java.util.Arrays;


public class BabyNames
{
	Scanner input = new Scanner(System.in);
	String gender = "";
	String newName = "";
	int num = 11;
	int choice = 0;
	String value = "";
	String nums;
	int count = 0;
	
	
	public static void main(String [] args)
	{
		BabyNames bn = new BabyNames();
		bn.runner();
	}
	public void runner()
	{
		boolean stop = false;
		System.out.println("\n\n\n");
		System.out.println("Here is the current list: ");
		readIt();
		input = new Scanner(System.in);
		System.out.print("Would you like to sort this file(1 by name), yes(2 by gender), no(3)?: ");
		int choice1 = input.nextInt();
		
		if (choice1 == 1)
		{
			System.out.println("Here is the list sorted by name: ");
			readIt();
		}
		
		while (!stop)
		{
			input = new Scanner(System.in);
			System.out.print("Would you like to add to this list, yes(1), no(2)? ");
			choice = input.nextInt();
			if (choice == 1)
			{
				System.out.print("What is your new name: ");
				newName = input.next();
				System.out.print("Gender? ");
				gender = input.next();
				System.out.println("Here is the new list: ");
				appendIt();
				readIt();
				num++;
			}
			else
			stop = true;
		}
	}
	public void appendIt()
	{
		PrintWriter pw = null; 
		File outFile = new File("BabyNames1.txt");
		String outFileName = new String("BabyNames1.txt");
		try
		{
			pw = new PrintWriter( new FileWriter(outFile, true) ); 
		}
		catch ( IOException e)
		{ 
			System.err.println("Cannot append to " + outFileName + " outputfile.");
			System.exit(1);
		}
		if (choice == 1)
		pw.println(num +")   "+newName+"     "+gender);
		pw.close();
	}
    public void readIt()
    {
		File inFile = new File ("BabyNames1.txt"); 
		String inFileName = "BabyNames1.txt"; 
		value = ""; 
		nums = "";
		input = null; 
		System.out.println("\n\n\n");
		try
		{ 
			input = new Scanner ( inFile );
		}
		catch ( FileNotFoundException e ) 
		{ 
			System.err.println("Cannot find " + inFileName + " file.");  
			System.exit(1);
		}
		System.out.println("\tName\t\tGender");
		while( input.hasNext() )
		{
			value = input.next();
			if (value.length() == 3)
			System.out.printf("%s%15s\t%s",value, input.next(), input.next());
			if (value.length() == 2)
			System.out.printf("%s%16s\t%s",value, input.next(), input.next());
			System.out.println();
			count++;
		}
		input.close();
		
		String [] arr = new String[count];
		String [] names = new String[count];
		String name = "";
		
		try
		{
			input = new Scanner( inFile );
		}
		catch ( FileNotFoundException e ) 
		{ 
			System.err.println("Cannot find " + inFileName + " file.");  
			System.exit(1);
		}
		int i = 0;
		while( input.hasNext() )
		{
			nums = input.next();
			arr[i] = input.next() + "\t" +input.next();
			i++;
		}
		Arrays.sort(arr);
		for (int j = 0;j<names.length;j++)
		{
			System.out.print(arr[j]);
		}
		System.out.println("\n\n\n");
	}
}
