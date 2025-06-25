/*
Ryan Shen
2/10/23
Olympics.java
This code allows the user to edit Olympics records
*/

import java.io.FileWriter; import java.io.PrintWriter;
import java.io.File; import java.io.FileNotFoundException; 
import java.io.IOException; import java.util.Scanner; import java.util.Arrays;

public class Olympics
{
	Scanner input = new Scanner(System.in);
	String [] countries = new String[88];
	int [][] medals = new int[88][3];
	String value = "";
	
	public static void main(String [] args)
	{
		Olympics oly = new Olympics();
		oly.runner();
	}
	public void runner()
	{
		System.out.println("\n\n\n");
		String country = "";
		int gCount = 0;
		int sCount = 0;
		int bCount = 0;
		value = "";
		int i = 0;
		System.out.print("Would you like to make a change, yes(1), no(2)? ");
		int choice = input.nextInt();
		if (choice == 1)
		{
			System.out.print("Country: ");
			input.nextLine();
			country = input.nextLine();
			System.out.print("Gold: ");
			gCount = input.nextInt();
			System.out.print("Silver: ");
			sCount = input.nextInt();
			System.out.print("Bronze: ");
			bCount = input.nextInt();
		}
		readIt();
		input.nextLine();
		while (input.hasNextLine())
		{
			value = input.nextLine();
			medals[i][2] = Integer.parseInt(value.substring(value.lastIndexOf("	")+1));
			value = value.substring(0,value.lastIndexOf("	"));
			
			value.trim();
			
			medals[i][1] = Integer.parseInt(value.substring(value.lastIndexOf("	")+1));
			value = value.substring(0,value.lastIndexOf("	"));
			
			value.trim();
			
			medals[i][0] = Integer.parseInt(value.substring(value.lastIndexOf("	")+1));
			value = value.substring(0,value.lastIndexOf("	"));
			
			value.trim();
			
			countries[i] = value.trim();
			i++;
		}
		input.close();
		if (choice == 1)
		{
			writeOlympic(country, gCount, sCount, bCount);
		}
		
		runIt();
		System.out.println("\n\n\n");
	}
	public void readIt()
    {
		File inFile = new File ("olympics.txt"); 
		String inFileName = "olympics.txt"; 
		input = null; 
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
	public void runIt()
	{
		String [] countries1 = new String[88];
		String outFileName = new String ("total.txt");    
		File outFile = new File("total.txt");
		PrintWriter makesOutput = null;
		try 
		{    
			makesOutput = new PrintWriter( outFile ); 
		}
		catch (FileNotFoundException e) 
		{ 
			System.err.println("Cannot create " +  outFileName + " file to be written to.");   
			System.exit(1);
		}
		for (int i = 0;i<countries.length;i++)
		{
			int total = medals[i][2]+medals[i][1]+medals[i][0];
			countries1[i] = countries[i] + "\t"+total;
		}
		Arrays.sort(countries1);
		for (int i = 0;i<countries.length;i++)
		{
			makesOutput.println(countries1[i]);
		}
		makesOutput.close();
	}
	public void writeOlympic(String country, int gCount, int sCount, int bCount)
	{
		String outFileName1 = new String ("olympics.txt");
		File outFile1 = new File("olympics.txt");
		PrintWriter maker = null;
		try 
		{    
			maker = new PrintWriter( outFile1 ); 
		}
		catch (FileNotFoundException e) 
		{ 
			System.err.println("Cannot create " +  outFileName1 + " file to be written to.");   
			System.exit(1);
		}
		
		for (int i = 0;i<countries.length;i++)
		{
			if (countries[i].equals(country))
			{
				medals[i][0] = gCount;
				medals[i][1] = sCount;
				medals[i][2] = bCount;
			}
		}
		maker.println("Country			Gold	Silver	Bronze");
		for (int i = 0;i<countries.length;i++)
		{
			maker.println(countries[i]+"\t\t"+medals[i][0]+"\t"+medals[i][1]+"\t"+medals[i][2]);
		}
		maker.close();
	}
}
