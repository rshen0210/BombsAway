/*
Ryan Shen
10/19/22
FactorialSumDivisors
This code asks for user input and outputs the factorial, divisor, or sum of the input.
*/
import java.util.Scanner;
public class FactorialSumDivisors
{
	public static void main(String [] args)
	{
		FactorialSumDivisors fsd = new FactorialSumDivisors();
		fsd.runner();
	}
	public void runner()
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Would you like to use factorial(1), divisor(2), or sum(3)? ");
		int choice = console.nextInt();
		if (choice == 1)
		{
			System.out.print("Enter an integer: ");
			int number1 = console.nextInt();
			Factorial fac = new Factorial(); fac.factorialMethod(number1);
		}
		else if (choice == 2)
		{
			System.out.print("Enter dividend and divisor: ");
			int number1 = console.nextInt();
			int number2 = console.nextInt();
			Divisor div = new Divisor(); div.divisorMethod(number1, number2);		
		}
		else 
		{
			System.out.print("Enter 1st number: ");
			int number1 = console.nextInt();
			System.out.print("Enter last number: ");
			int number2 = console.nextInt();
			Sum su = new Sum(); su.sumMethod(number1, number2);
		}
	}
}
class Factorial
{
	public void factorialMethod(int num1)
	{
		//use a loop to find the factorial
		//print factorial output
		int sum = 1;
		for (int i=1;i<=num1;i++)
		{
			sum=sum*i;
		}
		System.out.println(sum);
	}
}
class Divisor
{
	public void divisorMethod(int num1, int num2)
	{
		//use a loop to find sum of divisors
		//print divisors output
		for (int i=0;i<=num1;i+=num2)
		{
			System.out.print(i+" ");
		}
	}
}
class Sum
{
	public void sumMethod(int num1, int num2)
	{
		//use a loop to find sum
		//print sum output
		int sum = 0;
		for (int i=num1;i<=num2;i+=1)
		{
			sum = sum+i;
		}
		System.out.print(sum);
	}
}
