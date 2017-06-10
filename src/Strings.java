public class Strings
{
	//Returns the number of times char c appears in s
	public static int countCharInString(String s, char c)
	{
		int output=0;
		for (int i=0; i<s.length(); i++)
			if (s.charAt(i)==c)
				output++;
		return output;
	}
	
	//Returns the decimal representation of the positive number represented by s (base 8/10/16)
	public static int toInt(String s)
	{
		int base; // 8,10 or 16
		int first;// index of the first digit
		int value=0, power=1;
		
		if (s.length()==1 || s.charAt(0)!='0')
		{
			first=0;
			base=10;
		}
		else
			if (s.charAt(1)!='x') // octal numbers start with 0
			{
				first=1;
				base=8;
			}
			else//Starting with 0x represents hexadecimal numbers
			{
				first=2;
				base=16;
			}
		for (int i=s.length()-1; i>=first; i=i-1)
		{
			value=value+toInt(s.charAt(i))*power;
			power=power*base;
		}
		return value;
	}
	
	public static int toInt(char c)
	{
		// default means c is not a char answer
		int value=-1;
		if ('0'<=c && c<='9')
			value=c-'0';
		else
			if ('A'<=c && c<='F')
				value=c-'A'+10;
		return value;
	}
	
	/*
	//A compact implementation of the last function
	public static int toInt(char c)
	{
		return "012345679ABCDEF".indexOf(c);
	}
	*/
}