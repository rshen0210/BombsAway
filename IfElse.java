import java.util.Scanner;
public class IfElse
{
	public static void main(String [] Args)
	{
		IfElse ie = new IfElse();
		ie.runner();
	}
	public void runner()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want packages?Yes(1) No(2) ");
		int want = scanner.nextInt();
		
		if (want == 1) {
			System.out.println("What packages do you want? ");
			String park = scanner.nextLine();
			scanner.nextLine();
			System.out.println("You wanted packages, and these packages were " + park);
		}
		else {
			System.out.println("You didn't want packages. ");
		}
	}
}
		
		
