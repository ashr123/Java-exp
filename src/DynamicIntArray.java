public class DynamicIntArray
{
	//-------------------- constants --------------------
	private static final int DEFAULT_CAPACITY=16;
	
	//--------------------fields--------------------
	private int[] data;
	private int size;
	private int incrementSize;
	
	//--------------------constructors--------------------
	//Constructs an empty DynamicIntArray with specified initial capacity
	public DynamicIntArray(int initialCapacity)
	{
		if (initialCapacity<=0)
			throw new IllegalArgumentException("Non-positive initial capacity");
		data=new int[initialCapacity];
		incrementSize=initialCapacity;
		size=0;
	}
	
	//Constructs an empty DynamicArray with DEFAULT_CAPACITY
	public DynamicIntArray()
	{
		this(DEFAULT_CAPACITY);
	}
	
	//--------------------methods--------------------
	//Returns the number of elements in this dynamic int array
	public int size()
	{
		return size;
	}
	
	//Indicates whether other dynamic int array is "equal to" this (logically)
	public boolean equals(DynamicIntArray other)
	{
		if (other==null || size()!=other.size())
			return false;
		for (int i=0; i<size(); i++)
			if (get(i)!=other.get(i))
				return false;
		return true;
	}
	
	//Adds the specified element to the end.
	public void add(int element)
	{
		data[size++]=element;
		ensureCapacity();
	}
	
	private void ensureCapacity()
	{
		if (size()>=data.length)
		{
			int[] newData=new int[data.length+incrementSize];
			for (int i=0; i<data.length; i++)
				newData[i]=data[i];
			data=newData;
		}
	}
	
	//Returns the element at the specified position
	public int get(int index)
	{
		rangeCheck(index);
		return data[index];
	}
	
	//Throws an exception if the given index is not in range
	private void rangeCheck(int index)
	{
		if (index<0 || index>=size())
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
	}
	
	//Replaces an element in the array with element
	//Returns the previous element
	public int set(int index, int element)
	{
		rangeCheck(index);
		int prev=data[index];
		data[index]=element;
		return prev;
	}
	
	//Inserts an element in the array, size increase by 1
	public void insert(int index, int element)
	{
		rangeCheck(index);
		for (int i=size(); i>=index+1; i--)
			data[i]=data[i-1];
		data[index]=element;
		size++;
		ensureCapacity();
	}
	
	public boolean contains(int element)
	{
		boolean output=false;
		for (int i=0; i<size() && !output; i++)
			if (get(i)==element)
				output=true;
		return output;
	}
	
	//Returns a String representing this object
	public String toString()
	{
		String output="[";
		for (int index=0; index<size()-1; index++)
			output+=get(index)+", ";
		output+=get(size()-1)+"]";
		return output;
	}
}