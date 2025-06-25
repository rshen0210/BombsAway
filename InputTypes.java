import java.util.Scanner;
public class InputTypes
{
	public static void main (String [] Args)
	{
		InputTypes in = new InputTypes();
		in.runner();
	}
	
	public void runner()
	{
		Scanner console = new Scanner(System.in);
		System.out.println("\n\n");
		System.out.print("What is your birthday? ");
		String birthday = console.nextLine();
		
		System.out.print("What is your weight in pounds? ");
		double weight = console.nextDouble();
		
		System.out.print("What is your height in inches? ");
		double height = console.nextDouble();
		
		System.out.print("What is your name? ");
		String name = console.nextLine();
		console.nextLine();
		
		System.out.print("Where were you born? ");
		String born = console.nextLine();

		System.out.print("What school did you attend? ");
		String school = console.nextLine();
		
		System.out.print("How many movies have you made? ");
		int movie = console.nextInt();
		
		System.out.print("What is your favorite movie? ");
		console.nextLine();
		String favorite = console.nextLine();
		
		System.out.println("\n\n");
		System.out.print("Your name is " + name +"and you grew up in " +
		born + ".\n");
		System.out.print("You were born on " + birthday +", weigh ");
		System.out.printf("%.2f kilograms, and are ", (weight*0.453582));
		System.out.printf("%d'%.2f tall.\n", (int)(height/12.0) , (height%12.0));
		System.out.println("You attended " + school + " and made " + movie + " movies.");
		System.out.println("Your favorite movie is " + favorite + ".");
		System.out.println("\n\n");
		
	}
}
