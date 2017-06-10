import java.util.Iterator;

public class LinkedList implements List
{
	//--------------------fields--------------------
	private Link first;
	private Link last;
	
	//--------------------constructors--------------------
	public LinkedList()//constructs a new linked list with no links
	{
		first=null;
		last=null;
	}
	
	//--------------------methods--------------------
	public void sortBy(Comparator comp)//Sorts the list according to the comp's instance.
	{
		//throw new UnsupportedOperationException();
		boolean isSorted=false;
		Link temp1 = first;
		if (temp1==last)//there's at most one link
			return;
		while (!isSorted)
		{
			isSorted=true;
			temp1 = first;
			for (int j=0; j<size()-1; j++)
			{
				if (comp.compare(temp1.getData(), temp1.getNext().getData())>0)
				{
					isSorted=false;
					temp1.getNext().setData(temp1.setData(temp1.getNext().getData()));
				}
				temp1=temp1.getNext();
			}
		}
	}
	
	public String toString()//Returns the linked list's description
	{
		//throw new UnsupportedOperationException();
		String output="[";
		Link current=first;
		while (current!=last)
		{
			output+=current+", ";
			current=current.getNext();
		}
		return output+current+"]";
	}
	
	public boolean equals(Object other)//Checks if this linked list is equals to other's linked list
	{
		//throw new UnsupportedOperationException();
		if (!(other instanceof LinkedList) || size()!=((LinkedList)other).size())
			return false;
		Iterator thisI=iterator(), otherI=((LinkedList)other).iterator();
		while (thisI.hasNext())
			if (!thisI.next().equals(otherI.next()))
				return false;
		return true;
	}
	
	public void add(int index, Object element)//Adds a new link to the linked list after a given index
	{
		rangeCheck(index);
		nullCheck(element);
		if (index==0)
		{
			first=new Link(element, first);
			if (last==null)
				last=first;
		}
		else
		{
			Link prev=null;
			Link curr=first;
			for (int i=0; i<index; i=i+1)
			{
				prev=curr;
				curr=curr.getNext();
			}
			Link toAdd=new Link(element, curr);
			prev.setNext(toAdd);
			if (index==size())
				last=toAdd;
		}
	}
	
	public void add(Object element)//Adds a new link to the linked list to the beginning of the list
	{
		nullCheck(element);
		if (isEmpty())
		{
			first=new Link(element);
			last=first;
		}
		else
		{
			Link newLast=new Link(element);
			last.setNext(newLast);
			last=newLast;
		}
	}
	
	@Override
	public int size()//Returns the size of the list
	{
		//throw new UnsupportedOperationException();
		int count=isEmpty() ? 0 : 1;
		Link temp=first;
		while (temp!=last)
		{
			count++;
			temp=temp.getNext();
		}
		return count;
	}
	
	@Override
	public boolean contains(Object element)//Checks if a given object is in the list.
	{
		//throw new UnsupportedOperationException();
//		nullCheck(element);
		for (Object d : this)
			if (d.equals(element))
				return true;
		return false;
	}
	
	@Override
	public boolean isEmpty()//Checks if the list is empty
	{
		//throw new UnsupportedOperationException();
		return first==null && last==null;
	}
	
	@Override
	public Object get(int index)//Returns the i's link's data
	{
		//throw new UnsupportedOperationException();
		rangeCheck(index);
		Link temp=first;
		for (int i=0; i<index; i++)
			temp=temp.getNext();
		return temp.getData();
	}
	
	@Override
	public Object set(int index, Object element)//Changes the i's link data and returns the previous data
	{
		//throw new UnsupportedOperationException();
		rangeCheck(index);
		nullCheck(element);
		Link temp=first;
		for (int i=0; i<index; i++)
			temp=temp.getNext();
		return temp.setData(element);
	}
	
	@Override
	public Iterator iterator()//Returns a new iterator.
	{
		//throw new UnsupportedOperationException();
		return new LinkedListIterator(first);
	}
	
	//Throws an exception if the given index is not in range
	private void rangeCheck(int index)
	{
		if (index<0 || index>=size())
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
	}
	
	//Throws an exception if the given element is null
	private void nullCheck(Object element)
	{
		if (element==null)
			throw new NullPointerException();
	}
}