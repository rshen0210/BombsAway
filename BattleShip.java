/*
 * Ryan Shen
 * 1/27/23
 * BattleShip
 * This code creates a game of battleship
*/
import java.util.Scanner;

public class BattleShip 
{
	Scanner kb = new Scanner(System.in);
    private char[][] grid;
	char [][] arr;
	int tcount;
	int xcoord;
	int ycoord;
	boolean aTrue;
	boolean bTrue;
	boolean cTrue;
	boolean dTrue;
	boolean eTrue;
	boolean fTrue;
    public BattleShip() 
    {
        grid = new char[10][10];
        arr = new char[10][10];
        tcount = 30;
        aTrue = false;
        bTrue = false;
        cTrue = false;
        dTrue = false;
        eTrue = false;
        fTrue = false;
    }
    
    public static void main(String[] args) 
    {
        BattleShip ship = new BattleShip();
        ship.run();
    }

    private void run() 
    {
		System.out.println("\n\n\n");
		
        for(int i = 0; i < grid.length; i++) 
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = '-';
                arr [i][j] = '-';
            }
        }
        for(int i = 0; i < 1; i++)
            addShip(5, 'B');

        for(int i = 0; i < 2; i++)
            addShip(4, (char)(i+56));
        
        for(int i = 0; i < 3; i++)
            addShip(3, (char)(i+49));
		
		while (tcount > 0 || (aTrue && bTrue && cTrue && dTrue && eTrue && fTrue))
		{
			if (tcount == 30)
			{
				printArr();
				System.out.println("\n");
				System.out.print("You have "+tcount+" torpedos left.\nWhere would you like to strike? ");
				ycoord = kb.nextInt();
				xcoord = kb.nextInt();
				System.out.println("\n");
			}
			else
			{
				hit(xcoord, ycoord);
				printArr();
				if (hit(xcoord,ycoord))
				{
					System.out.println("It's a hit!");
				}
				else
				{
					System.out.println("You missed!");
				}
				System.out.print("\n");
				System.out.println("You have "+tcount+" torpedos left.\nWhere would you like to strike? ");
				ycoord = kb.nextInt();
				xcoord = kb.nextInt();
				System.out.print("\n");
			}
			tcount--;
		}
		if (hit(xcoord,ycoord))
		{
			System.out.println("It's a hit!");
		}
		else
		{
			System.out.println("You missed!");
		}
        System.out.println("You have 0 torpedos left.");
        if (aTrue && bTrue && cTrue && dTrue && eTrue && fTrue)
        {
			System.out.println("You win!");
		}
		else
		{
			System.out.println("Game over!");
		}
        
        System.out.println("\n\n\n");
    }

    private void addShip(int length, char ch) 
    {
		char lett = ch;
        boolean ok = false;

        int xCoor = 0;
        int yCoor = 0;
        boolean vertical = false;
        while(!ok) 
        {
            ok = true;

            vertical = (int) (Math.random() * 2) == 0;
            
            if(vertical) 
            {
                xCoor = (int) (Math.random() * 10);
                yCoor = (int) (Math.random() * (10 - length + 1));

                for(int i = 0; i < length; i++) 
                {
                    if(grid[xCoor][yCoor + i] != '-') 
                    {
                        ok = false;
                        i = length;
                    }
                }
            } else {
                xCoor = (int) (Math.random() * (10 - length + 1));
                yCoor = (int) (Math.random() * (10));

                for(int i = 0; i < length; i++) 
                {
                    if(grid[xCoor + i][yCoor] != '-') 
                    {
                        ok = false;
                        i = length;
                    }
                }
            }
        }

        if(ok) 
        {
            if(vertical) 
            {
                for(int i = 0; i < length; i++)
                    grid[xCoor][yCoor + i] = lett;
            } 
            else 
            {
                for(int i = 0; i < length; i++)
                    grid[xCoor + i][yCoor] = lett;
            }
        }
    }
	
	public void printArr()
	{
		for (int i = 0;i<10;i++)
		{
			if (i == 0)
			{
				System.out.println("   1 2 3 4 5 6 7 8 9 10");
			}
			if (i < 9)
			System.out.print(i+1+"  ");
			else 
			System.out.print(i+1+" ");
			for (int x=0;x<10;x++)
			{
				System.out.print(arr[i][x]+" ");
			}
			System.out.print("\n");
		}
	}
	public boolean hit(int xcoord, int ycoord)
	{
		boolean hits = false;
		if (grid[ycoord-1][xcoord-1] != '-')
		{
			if (grid[ycoord-1][xcoord-1] == '1')
			{
				arr[ycoord-1][xcoord-1] = 'x';
				grid[ycoord-1][xcoord-1] = 'e';
				if (hitOrMiss('e') == 3)
				{
					aTrue = true;
				}
			}
			if (grid[ycoord-1][xcoord-1] == '2')
			{
				arr[ycoord-1][xcoord-1] = 'x';
				grid[ycoord-1][xcoord-1] = 'f';
				if (hitOrMiss('f') == 3)
				{
					bTrue = true;
				}
			}
			if (grid[ycoord-1][xcoord-1] == '3')
			{
				arr[ycoord-1][xcoord-1] = 'x';
				grid[ycoord-1][xcoord-1] = 'g';
				if (hitOrMiss('g') == 3)
				{
					cTrue = true;
				}
			}
			if (grid[ycoord-1][xcoord-1] == '8')
			{
				arr[ycoord-1][xcoord-1] = 'x';
				grid[ycoord-1][xcoord-1] = 'h';
				if (hitOrMiss('h') == 3)
				{
					dTrue = true;
				}
			}
			if (grid[ycoord-1][xcoord-1] == '9')
			{
				arr[ycoord-1][xcoord-1] = 'x';
				grid[ycoord-1][xcoord-1] = 'i';
				if (hitOrMiss('i') == 3)
				{
					eTrue = true;
				}
			}
			if (grid[ycoord-1][xcoord-1] == 'B')
			{
				arr[ycoord-1][xcoord-1] = 'x';
				grid[ycoord-1][xcoord-1] = 'j';
				if (hitOrMiss('j') == 3)
				{
					fTrue = true;
				}
			}
			hits = true;
		}
		else
		{
			arr[ycoord-1][xcoord-1] = 'o';
			hits = false;
		}
		return hits;
	}
	public int hitOrMiss(char character)
	{
		int count = 0;
		for (int i = 0;i<10;i++)
		{
			for (int j = 0;j<10;j++)
			{
				if (grid[i][j] == character)
				{
					count++;
				}
			}
		}
		return count;
	}
}	
