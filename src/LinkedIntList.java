public class LinkedIntList
{
	//----------------------fields----------------------
	private LinkInt first;
	
	//----------------------constructors----------------------
	public LinkedIntList()
	{
		first=null;
	}
	
	//----------------------methods----------------------
	public boolean isEmpty()
	{
		return first==null;
	}
	
	//Adds element to the beginning of this LinkedIntList
	public void addFirst(int element)
	{
		if (isEmpty())
			first=new LinkInt(element);
		else
			first=new LinkInt(element, first);
	}
	
	//Returns the data contains in LinkInt with "index" index (we start counting from zero)
	public int get(int index)
	{
		//Saves this input value for future use in the exception
		int inputIndex=index;
		if (isEmpty())
			throw new IndexOutOfBoundsException("index = "+index);
		if (index<0)
			throw new IllegalArgumentException();
		LinkInt current=first;
		while (index>0)
		{
			if (current.getNext()==null)
				throw new IndexOutOfBoundsException("index = "+inputIndex);
			current=current.getNext();
			index--;
		}
		return current.getData();
	}
	
	//Returns a String representing this object
	public String toString()
	{
		String output="[";
		LinkInt current=first;
		while (current.getNext()!=null)
		{
			output+=current.toString()+", ";
			current=current.getNext();
		}
		output+=current.toString()+"]";
		return output;
	}
	
	//Removes the first LinkInt which contains toRemove, if such one exists
	public boolean remove(int toRemove)
	{
		LinkInt current=first;
		LinkInt prev=current;
		while (current!=null)
		{
			if (current.getData()==toRemove)
			{
				if (first==current)
					first=first.getNext();
				else
					prev.setNext(current.getNext());
				return true;
			}
			else
			{
				prev=current;
				current=current.getNext();
			}
		}
		return false;
	}
}