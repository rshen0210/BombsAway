/*
 * Ryan Shen
 * 1/18/23
 * SortAndMedian
 * This code sorts 5 numbers and gives information on the set
*/

import java.util.Scanner;

public class SortAndMedian
{
	int nums = 0;
	public static void main(String [] args)
	{
		SortAndMedian sam = new SortAndMedian();
		sam.runner();
	}
	public void runner()
	{
		System.out.print("\n\n\n");
		Scanner kb = new Scanner(System.in);
		System.out.println("How many numbers would you like? ");
		nums = kb.nextInt();
		double [] num = new double [nums];
		System.out.println("What are your " + nums + " numbers? ");
		for (int i = 0;i<nums;i++)
		{
			num[i] = kb.nextInt();
		}
		sort(num);
		median(num);
		mode(num);
		System.out.println("The mean is: "+mean(num));
		standardDev(num);
		
		System.out.print("\n\n\n\n");
	}
	public void sort(double [] num)
	{
		double max = 0.0;
		double min = 0.0;
		
		for (int x=0;x<nums-1;x++)
		{
			for (int i=0;i<nums-1;i++)
			{
				max = Math.max(num[i],num[i+1]);
				min = Math.min(num[i],num[i+1]);
				num[i+1] = max;
				num[i] = min;
			}
		}
		System.out.print("Sorted: ");
		for (int i = 0;i<nums;i++)
		{
			System.out.print(num[i]);
			if (i<nums-1)
			{
				System.out.print(", ");
			}
		}
		System.out.print("\n");
	}
	public void median(double [] num)
	{
		int middle = num.length / 2;
		if (num.length % 2 == 1)
		{
			System.out.println("The median is: " + num[middle]);
		}
		else
		{
			double median1 = (num[middle-1] + num[middle])/2;
			System.out.println("The median is: " + median1);
		}
	}
	public void mode(double [] num)
	{
		int count = 0; 
        String mode = ""; 
        int high = 0;
        boolean ifPlural = false;
		for(int pp = 0; pp<num.length; pp++){
            count = 0;
            for(int w = 0; w<num.length; w++){
                if(num[w] == num[pp]) count++;
            }
            if(count > high){
                high = count; mode = "" + num[pp]; 
                ifPlural = false;
            }
            else if(count == high && mode.indexOf(""+num[pp]) == -1) {
                mode = mode + ", " + num[pp]; ifPlural = true;
            }
        }
        if(ifPlural)
        System.out.println("The modes are: " + mode);
        else 
        System.out.println("The mode is: " + mode);
	}
	public double mean(double [] num)
	{
		double total = 0;
		for (int i = 0;i<num.length;i++)
		{
			total += num[i];
		}
		double mean = total/num.length;
		return mean;
	}
	public void standardDev(double [] num)
	{
		double total = 0;
		for (int i=0;i<num.length;i++)
		{
			total += (Math.pow(num[i]-mean(num), 2));
		}
		double total1 = Math.sqrt(total/num.length-1);
		System.out.println("Standard Dev = "+total1);
	}
}
