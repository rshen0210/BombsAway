public class Quizzy 
{
	public static void main(String [] args)
	{
		int num = 5;
		double value = 6.7;
		String str = new String("apple");
		also(str);
		num = another(value);
		also(num + "!");
	}
	public static void also(String what)
	{
		System.out.println("Here's " + what);
	}
	public static int another(double amt)
	{
		amt = 2*amt;
		return (int)(amt);
	}
}
