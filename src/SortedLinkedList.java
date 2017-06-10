public class SortedLinkedList extends LinkedList
{
	public SortedLinkedList()
	{
		super();
	}
	
	public void add(Object element)
	{
		if (!(element instanceof Comparable))
			throw new ClassCastException();
		int index=searchFor((Comparable)element);
		super.add(index, element);
	}
	
	private int searchFor(Comparable element)
	{
		int index=0;
		int size=size();
		boolean found=false;
		while (!found && index<size)
			if (element.compareTo(get(index))<0)
				found=true;
			else
				index++;
		return index;
	}
	
	public void add(int index, Object element)
	{
		if (!(element instanceof Comparable))
			throw new ClassCastException();
		if (searchFor((Comparable)element)!=index)
			throw new IllegalArgumentException();
		super.add(index, element);
		
	}
	
	public Object set(int index, Object element)
	{
		//Works just like super.set(index, element)
		//if element is comparable and the operation
		//preserves the invariant (the list is always
		// sorted).
		return null;
	}
	
	public void addFirst(Object element)
	{
		//Works just like super.add(element)
		//if element is comparable and the operation
		//preserves the invariant (the list is always
		// sorted).
	}
}