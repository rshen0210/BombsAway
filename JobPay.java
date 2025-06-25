import java.util.Scanner;

public class JobPay
{
	public static void main (String [] Args)
	{
		JobPay jp = new JobPay();
		jp.runner();
	}
	public void runner()
	{
		Scanner console = new Scanner(System.in);
		System.out.print("What is it that you want to purchase? ");
		String buy = console.nextLine();
		
		System.out.print("How much does the " + buy + " cost that you want to buy (as an integer)? ");
		double cost = console.nextDouble();
		
		double hours = (((cost*100)/100)/6.0);
		
		System.out.printf("%s%.1f%s%s.","You'll have to work ",hours," hours at minimum wage of $9 per hour to buy this ",buy);
	}
}
		
