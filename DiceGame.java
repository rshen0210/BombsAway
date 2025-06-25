/*
Ryan Shen
10/10/22
DiceGame
This code gives you an idea on how much money to gamble against a dealer
*/
import java.util.Scanner;
public class DiceGame
{
	int sides;
	double bet;
	double totMoney;
	public DiceGame()
	{}
	public DiceGame(int sid, double mon, double tot)
	{
		sides = sid; bet = mon; totMoney = tot;
	}
	public static void main (String [] Args)
	{
		DiceGame dg = new DiceGame();
		dg.runner();
	}
	public void runner()
	{
		System.out.print("\n\n\n");
		int sideInput; double moneyInput; double startingMoney;
		Scanner console = new Scanner(System.in);
		System.out.print("How much money would you like to start with? ");
		startingMoney = console.nextDouble();
		System.out.print("How much would you like to bet? ");
		moneyInput = console.nextDouble();
		System.out.print("How many sides on each die? ");
		sideInput = console.nextInt();
		System.out.print("\n\n");
		
		DiceGame game = new DiceGame(sideInput, moneyInput, startingMoney);
		game.output(game);	
	}
	public void output(DiceGame game2)
	{
		Scanner console = new Scanner(System.in);
		int num1 = rollDice(sides);
		int num2 = rollDice(sides);
		int num3 = rollDice(sides);
		int num4 = rollDice(sides);
		int roll1MeNo = num1 + num2 + num3 + num4;
		int num6 = rollDice(sides);
		int num7 = rollDice(sides);
		int num8 = rollDice(sides);
		int num9 = rollDice(sides);
		int roll1Dealer = num6 + num7 + num8 + num9;
		double game3 = game2.bet;
		int roll1MeYes = num1 + num2 + num3 + num4;
		
		System.out.println("You rolled " + num1 + " " + num2 + " " + num3 + " " + num4 + " = " + roll1MeNo);
		System.out.print("\n\n");
		System.out.print("Would you like to reroll your lowest for 10% of bet, yes(1), no(2)? ");
		int reroll1 = console.nextInt();
		
		System.out.print("\n\n");
		
		double lostCounter = 1;
		
		if (reroll1 == 2)
		{
			System.out.println("You rolled " + num1 + " " + num2 + " " + num3 + " " + num4 + " = " + roll1MeNo);
			System.out.println("Dealer rolled " + num6 + " " + num7 + " " + num8 + " " + num9 + " " + " = " + roll1Dealer);
			System.out.print("\n\n");
			
			System.out.print("Would you like to reroll the dealers highest for 20% of bet, yes(1), no(2)? ");
			int reroll2 = console.nextInt();
			
			if (reroll2 == 1)
			{
				roll1MeNo = num1 + num2 + num3 + num4;
				int max = findMax(num6,num7,num8,num9);
				System.out.print("\n\n");
				System.out.println("You rolled " + num1 + " " + num2 + " " + num3 + " " + num4 + " = " + roll1MeNo);
				if (max == num6)
				{
					num6 = rollDice(num6);
				}
				if (max == num7)
				{
					num7 = rollDice(num7);
				}
				if (max == num8)
				{
					num8 = rollDice(num8);
				}
				if (max == num9)
				{
					num9 = rollDice(num9);
				}
				int roll2DealerYes = num6 + num7 + num8 + num9;
				System.out.println("Dealer rolled " + num6 + " " + num7 + " " + num8 + " " + num9 + " " + " = " + roll2DealerYes);
				System.out.print("\n\n");
				if (roll1MeNo > roll2DealerYes)
				{
					game2.bet = game2.bet - game3*0.2;
					double moneyGain = game2.bet * 100.00/100.00;
					double total = game2.totMoney + game2.bet;
					System.out.printf("%s%.2f%s\n","You won $" , moneyGain , "!");
					System.out.printf("%s%.2f%s","You have a total of $" , total , ".");
				}
				else
				{
					game2.bet += game3*0.2;
					double moneyLost = game2.bet * 100.00/100.00;
					double total = game2.totMoney - game2.bet;
					System.out.printf("%s%.2f%s\n","You lost $", moneyLost, "!");
					System.out.printf("%s%.2f%s","You have a total of $", total, ".");
				}
				System.out.print("\n\n\n");
			}
			else //reroll2 == no(2)
			{
				System.out.println("You rolled " + num1 + " " + num2 + " " + num3 + " " + num4 + " = " + roll1MeNo);
				System.out.println("Dealer rolled " + num6 + " " + num7 + " " + num8 + " " + num9 + " " + " = " + roll1Dealer);
				
				if (roll1MeNo > roll1Dealer)
				{
					game2.bet = game2.bet - game3*0.2;
					double moneyGain = game2.bet * 100.00/100.00;
					double total = game2.totMoney + game2.bet;
					System.out.printf("%s%.2f%s\n","You won $" , moneyGain , "!");
					System.out.printf("%s%.2f%s","You have a total of $" , total , ".");
				}
				else
				{
					game2.bet += game3*0.2;
					double moneyLost = game2.bet * 100.00/100.00;
					double total = game2.totMoney - game2.bet;
					System.out.printf("%s%.2f%s\n","You lost $", moneyLost, "!");
					System.out.printf("%s%.2f%s","You have a total of $", total, ".");
				}
				System.out.print("\n\n\n");
			} 
		}
		else // roll1 == yes(1)
		{
			int min = findMin(num1,num2,num3,num4);
			if (min == num1)
			{
				num1 = rollDice(num1);
			}
			if (min == num2)
			{
				num2 = rollDice(num2);
			}
			if (min == num3)
			{
				num3 = rollDice(num3);
			}
			if (min == num4)
			{
				num4 = rollDice(num4);
			}
			roll1MeYes = num1 + num2 + num3 + num4;
			System.out.println("You rolled " + num1 + " " + num2 + " " + num3 + " " + num4 + " = " + roll1MeYes);
			System.out.println("Dealer rolled " + num6 + " " + num7 + " " + num8 + " " + num9 + " " + " = " + roll1Dealer);
			System.out.print("\n\n");
			
			System.out.print("Would you like to reroll the dealers highest for 20% of bet, yes(1), no(2)? ");
			int reroll2 = console.nextInt();
			
			if (reroll2 == 1)
			{
				int max = findMax(num6,num7,num8,num9);
				System.out.print("\n\n");
				System.out.println("You rolled " + num1 + " " + num2 + " " + num3 + " " + num4 + " = " + roll1MeYes);
				if (max == num6)
				{
					num6 = rollDice(num6);
				}
				if (max == num7)
				{
					num7 = rollDice(num7);
				}
				if (max == num8)
				{
					num8 = rollDice(num8);
				}
				if (max == num9)
				{
					num9 = rollDice(num9);
				}
				int roll2DealerYes = num6 + num7 + num8 + num9;
				System.out.println("Dealer rolled " + num6 + " " + num7 + " " + num8 + " " + num9 + " " + " = " + roll2DealerYes);
				System.out.print("\n\n");
				if (roll1MeNo > roll2DealerYes)
				{
					game2.bet = game2.bet - game3*0.2 - game3*0.1;
					double moneyGain = game2.bet * 100.00/100.00;
					double total = game2.totMoney + game2.bet;
					System.out.printf("%s%.2f%s\n","You won $" , moneyGain , "!");
					System.out.printf("%s%.2f%s","You have a total of $" , total , ".");
				}
				else
				{
					game2.bet = game2.bet + game3*0.2+game3*0.1;
					double moneyLost = game2.bet * 100.00/100.00;
					double total = game2.totMoney - game2.bet;
					System.out.printf("%s%.2f%s\n","You lost $", moneyLost, "!");
					System.out.printf("%s%.2f%s","You have a total of $", total, ".");
				}
				System.out.print("\n\n\n");
			}
			else //reroll2 == no(2)
			{
				System.out.println("You rolled " + num1 + " " + num2 + " " + num3 + " " + num4 + " = " + roll1MeYes);
				System.out.println("Dealer rolled " + num6 + " " + num7 + " " + num8 + " " + num9 + " " + " = " + roll1Dealer);
				
				if (roll1MeYes > roll1Dealer)
				{
					game2.bet = game2.bet - game3*0.1;
					double moneyGain = game2.bet * 100.00/100.00;
					double total = game2.totMoney + game2.bet;
					System.out.printf("%s%.2f%s\n","You won $" , moneyGain , "!");
					System.out.printf("%s%.2f%s","You have a total of $" , total , ".");
				}
				else
				{
					game2.bet += game3*0.1;
					double moneyLost = game2.bet * 100.00/100.00;
					double total = game2.totMoney - game2.bet;
					System.out.printf("%s%.2f%s\n","You lost $", moneyLost, "!");
					System.out.printf("%s%.2f%s","You have a total of $", total, ".");
				}
				System.out.print("\n\n\n");
			} 
		}
	}
	public int rollDice(int sides)
	{
		int num = (int)(Math.random()*sides+1);
		return num;
	}
	public int findMin(int x1, int x2, int x3, int x4)
	{
		return Math.min(Math.min(x1, x2),Math.min(x3,x4));
	}
	public int findMax(int x1, int x2, int x3, int x4)
	{
		return Math.max(Math.max(x1, x2),Math.max(x3,x4));
	}
}
