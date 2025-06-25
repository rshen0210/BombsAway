public class CodingBat
{
	public static void main(String [] args)
	{
		CodingBat cb = new CodingBat();
		cb.runner();
	}
	public void runner()
	{
		System.out.print("\n\n\n");
		System.out.println(changePi("boopi"));
		System.out.print("\n\n\n");
	}
	public String changePi(String str) 
	{
		if (str.length()<=1) return str;
		String firstTwo = str.substring(0,2);
		if (firstTwo.equals("pi")) return "3.14"+changePi(str.substring(2));
		return str.charAt(0)+changePi(str.substring(1));
	}
}
