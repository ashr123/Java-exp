public class Pair
{
	private Comparable key;
	private Object value;
	
	public Pair(Comparable key, Object value)
	{
		this.key=key;
		this.value=value;
	}
	
	public Comparable getKey()
	{
		return key;
	}
	
	public Object getValue()
	{
		return value;
	}
	
	public boolean equals(Object other)
	{
		if (!(other instanceof Pair))
			return false;
		Pair otherPair=(Pair)other;
		Comparable otherKey=otherPair.getKey();
		Object otherValue=otherPair.getValue();
		return getKey().equals(otherKey);
	}
	
	public String toString()
	{
		return key+" = "+value;
	}
}