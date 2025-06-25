public class Program1
{
	int num = 0;
	public static void main(String [] Args)
	{
		Program1 p1 = new Program1();
		p1.runner();
		p1.bobJoe();
		p1.printer();
	}
	public void runner()
	{
		num = 1;
	}
	public void bobJoe()
	{
		num = 5;
	}
	public void printer()
	{
		System.out.println(num);
	}
}
