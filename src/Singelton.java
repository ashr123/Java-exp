public class Singelton
{
	private static Singelton ourInstance=new Singelton();
	
	public static Singelton getInstance()
	{
		return ourInstance;
	}
	
	private Singelton()
	{
	}
}