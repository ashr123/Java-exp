class A
{
	void foo(A a, B b)
	{
		System.out.println("#1");
		goo(a, b);
	}
	
	void goo(A a1, A a2)
	{
		System.out.println("#2");
	}
}

class B extends A
{
	void foo(C c, A a)
	{
		System.out.println("#3");
		goo(a, c);
	}
	
	void goo(C c, B b)
	{
		System.out.println("#4");
	}
}

class C extends B
{
	void foo(C c, B b)
	{
		System.out.println("#5");
		goo(c, b);
	}
	
	void goo(A a, B b)
	{
		System.out.println("#6");
		goo(b, a);
	}
	
	void goo(B b, C c)
	{
		System.out.println("#7");
		goo(c, b);
	}
}




public class Exp
{
	public static void main(String[] args)
	{
		//System.out.println(/*(char)*/('z'-'a'));
		A a=new C();
		B b=new C();
		C c=new C();
		System.out.println(null instanceof C);
		a.foo(null, null);
	}
}