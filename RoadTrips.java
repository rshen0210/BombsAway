/*
Ryan Shen
9/23/22
RoadTrips
This code gives you the precise amount of money you need to spend for your next roadtrip.
*/

import java.util.Scanner;

public class RoadTrips
{
	public static void main (String [] Args)
	{
		RoadTrips rt = new RoadTrips();
		rt.runner();
	}
	
	public void runner()
	{
		Scanner console = new Scanner(System.in);
		System.out.println("\n\n");
		System.out.print("Would you like a roadtrip(1) or a flight(2)? ");
		int like = console.nextInt();
		if (like == 1) {
			System.out.print("How many people on the trip? ");
			int people = console.nextInt();
		
			System.out.print("How many miles on your trip? ");
			double miles = console.nextDouble();
			
			System.out.print("What is your mileage per gallon? ");
			double mileage = console.nextDouble();
			
			System.out.print("Price per gallon? ");
			double gallon = console.nextDouble();
			
			System.out.print("Snacks per passenger? ");
			double snacks = console.nextDouble();
			
			System.out.print("Toll(s)? ");
			double toll = console.nextDouble();
			
			System.out.print("Hotel(s)? ");
			double hotel = console.nextDouble();
			
			System.out.print("Meals per person? ");
			double meals = console.nextDouble();
			
			System.out.print("Anything else? Yes(1) No(2)? ");
			int anything = console.nextInt();
		
			if (anything == 1) {
				System.out.println("What is the item? ");
				String item = console.nextLine();
				console.nextLine();
				System.out.println("How much? ");
				double amount = console.nextDouble();
				double cost = ((miles/mileage)*gallon);
				double price = (snacks * people);
				double mpp = (meals * people);
				double tax = ((cost + price + toll + hotel + mpp + amount)*0.075);
				double grand = (cost + price + toll + hotel + mpp + amount + tax);
			
				System.out.println("\n");
				System.out.println("Here are your totals: ");
				System.out.println("\n");
				System.out.printf("%-27s=%14d\n","Number of passenger(s)",people);
				System.out.printf("%-27s=%5s%9.2f\n","Gas cost","$", cost);
				System.out.printf("%-27s=%5s%9.2f\n","Total Snacks","$", price);
				System.out.printf("%-27s=%5s%9.2f\n","Total for tolls","$", toll);
				System.out.printf("%-27s=%5s%9.2f\n","Total for hotels","$", hotel);
				System.out.printf("%-27s=%5s%9.2f\n","Total for meals","$", mpp);
				System.out.printf("%-27s=%5s%9.2f\n",item,"$", amount);
				System.out.printf("%-27s=%5s%9.2f\n","Total tax","$", tax);
				System.out.printf("%-27s=%5s%9.2f\n","Grand Total","$", grand);
				System.out.println("\n\n");
				
			}
			else {
				double cost = ((miles/mileage)*gallon);
				double price = (snacks * people);
				double mpp = (meals * people);
				double taxes = ((cost + price + toll + hotel + mpp)*0.075);
				double grands = (cost + price + toll + hotel + mpp + taxes);
				
				System.out.println("\n");
				System.out.println("Here are your totals: ");
				System.out.println("\n");
				System.out.printf("%-27s=%14d\n","Number of passenger(s)",people);
				System.out.printf("%-27s=%5s%9.2f\n","Gas cost","$", cost);
				System.out.printf("%-27s=%5s%9.2f\n","Total Snacks","$", price);
				System.out.printf("%-27s=%5s%9.2f\n","Total for tolls","$", toll);
				System.out.printf("%-27s=%5s%9.2f\n","Total for hotels","$", hotel);
				System.out.printf("%-27s=%5s%9.2f\n","Total for meals","$", mpp);
				System.out.printf("%-27s=%5s%9.2f\n","Total tax","$", taxes);
				System.out.printf("%-27s=%5s%9.2f\n","Grand Total","$", grands);
				System.out.println("\n\n");
			}
		}
		else {
			System.out.print("How many people on the flight? ");
			int persons = console.nextInt();
			
			System.out.print("How much for each flight? ");
			double price = console.nextDouble();
			
			System.out.print("Total cost for luggage? ");
			double cost = console.nextDouble();
			
			System.out.print("Snacks per passengers? ");
			double snacks = console.nextDouble();
			
			double taxes = ((price + cost + snacks)*0.075);
			double grand = (price + cost + snacks + taxes);
			
			System.out.println("Here are your totals: ");
			System.out.println("\n");
			System.out.printf("%-27s=%14d\n","Number of passenger(s)",persons);
			System.out.printf("%-27s=%5s%9.2f\n","Total for flights","$", price);
			System.out.printf("%-27s=%5s%9.2f\n","Total for luggage","$", cost);
			System.out.printf("%-27s=%5s%9.2f\n","Total for snacks","$", snacks);
			System.out.printf("%-27s=%5s%9.2f\n","Total tax","$", taxes);
			System.out.printf("%-27s=%5s%9.2f\n","Grand Total","$", grand);
			System.out.println("\n\n");
		}
	}
}
		
