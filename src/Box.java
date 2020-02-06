import java.util.Objects;

public class Box<T>
{
	private T value;

	public Box(T value)
	{
		this.value=value;
	}

	public static <T> Box<T> box(T value)
	{
		return new Box<>(value);
	}

	public T getValue()
	{
		return value;
	}

	public void setValue(T value)
	{
		this.value=value;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this==o)
			return true;
		if (o instanceof Box)
			return value.equals(((Box<?>) o).value);
		return value.equals(o); // for making boxing transparent
	}

	@Override
	public int hashCode()
	{
		return value.hashCode(); // for making boxing transparent
//		return Objects.hash(value);
	}

	@Override
	public String toString()
	{
		return "Box{value="+value+'}';
	}
}
