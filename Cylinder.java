import java.util.Scanner;
public class Cylinder
{
	private double radius, height, volume, SurfaceArea;
	public Cylinder()
	{
		radius = 0; height = 0; volume = 0; SurfaceArea = 0;
	}
	public static void main(String [] args)
	{
		Cylinder cy = new Cylinder();
		cy.runner();
	}
	public void runner()
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the radius(a double): ");
		radius = console.nextDouble();
		System.out.print("Enter the height(a double): ");
		height = console.nextDouble();
		findSAandV(radius, height);
		System.out.println("Cylinder information");
		System.out.printf("%s%15s%19.4f\n","radius","=",radius);
		System.out.printf("%s%15s%19.4f\n","height","=",height);
		System.out.printf("%s%15s%19.4f\n","volume","=",volume);
		System.out.printf("%s%9s%19.4f\n","surface area","=",SurfaceArea);
	}
	public void findSAandV(double radius, double height)
	{
		volume = Math.PI*(radius*radius)*height;
		SurfaceArea = (2*radius*height*Math.PI)+(2*Math.PI*(radius*radius));
	}
}
