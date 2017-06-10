import java.util.Scanner;

public class PrimesArray
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.print(primesDArray(s.nextInt()));
		s.close();
		//System.out.println(primes.contains(new Integer(7)));
		//System.out.println(primes.contains(new Integer(0)));
	}
	
	//Returns an array of all primes till n (with 0's at the end)
	public static DynamicArray primesDArray(int n)
	{
		DynamicArray primes=new DynamicArray();
		for (int number=2; number<=n; number++)
		{
			boolean isPrime=true;
			for (int i=0; i<primes.size() && isPrime && (Integer)primes.get(i)*(Integer)primes.get(i)<=number; i++)
				if (number%(Integer)primes.get(i)==0)
					isPrime=false;
			if (isPrime)
				primes.add(new Integer(number));
		}
		return primes;
	}
}