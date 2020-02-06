import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public final class Exp
{
	public static void main(String[] args)
	{
		myFor(1, 11, i -> i+1,
		       i ->
		       {
			       myFor(1, 11, j -> j+1,
			              j -> System.out.print("\t"+i*j));
			       System.out.println();
		       });
		//		int p=4, q=4;
		//		System.out.println("ackerman("+p+", "+q+") = "+ackerman(p, q));
	}

	public static void myWhile(Supplier<Boolean> test, Runnable body)
	{
		if (test.get())
		{
			body.run();
			myWhile(test, body);
		}
	}

	public static <T extends Comparable<T>> void myFor(T from, T to, UnaryOperator<T> change,
	                                                   Consumer<T> body)
	{
		if (from.compareTo(to)<0)
		{
			body.accept(from);
			myFor(change.apply(from), to, change, body);
		}
	}

	public static long ackerman(long p, long q)
	{
		return p==0 ? q+1 :
		       q==0 ? ackerman(p-1, 1) :
		       ackerman(p-1, ackerman(p, q-1));
	}
}
