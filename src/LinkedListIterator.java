import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator implements Iterator
{
	private Link nextLink;
	
	public LinkedListIterator(Link start)
	{
		nextLink=start;
	}//Creates a new  LinkedListIterator Object
	
	@Override
	public boolean hasNext()
	{
		return nextLink!=null;
	}//Checks if there's more links left
	
	@Override
	public Object next()//Moves to the next link and returns the previous link's data
	{
		if (!hasNext())
			throw new NoSuchElementException();
		
		Object nextElement=nextLink.getData();
		nextLink=nextLink.getNext();
		return nextElement;
	}
	
	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}