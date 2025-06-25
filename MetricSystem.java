/*
Ryan Shen
9/28/22
MetricSystem
This code converts metric units to standard.
*/
import java.util.Scanner;
public class MetricSystem
{
	public static void main(String [] Args)
	{
		MetricSystem ms = new MetricSystem();
		ms.runner();
	}
	public void runner()
	{
		System.out.println("\n\n");
		Scanner console = new Scanner(System.in);
		System.out.print("Enter your distance in miles(1), feet(2), or inches(3)? ");
		int choice = console.nextInt();
		System.out.print("Enter your distance: ");
		double distance = console.nextDouble();
		System.out.println("\n\n");
		System.out.println("Your distance converted is "+standardToMetric(distance, choice)+" meters");
		System.out.println("Your distance converted is "+metricToStandard(distance, choice)+" meters");
	}
	public double standardToMetric(double num, int type)
	{
		if (type == 1)
		{
			double convert = num * 1609.3;
			return convert;
		}
		else if (type == 2)
		{
			double convert2 = num * 0.3048;
			return convert2;
		}
		else
		{
			double convert3 = num * 0.0254;
			return convert3;
		}
	}
	public double metricToStandard(double num, int type)
	{
		if (type == 1)
		{
			
}
