import java.lang.Iterable;
//"Set" like group
public interface Set extends Iterable
{
	//Returns the number of elements in this set (its cardinality).
	public int size();
	
	//Adds the specified element to this set if it is not already present.
	public boolean add(Object element);
	
	//Returns true if this set contains the specified element.
	public boolean contains(Object element);
	
	//Removes the specified element from this set if it is present
	//public boolean remove(Object element);
	
	//Returns true if this set contains no elements.
	public boolean isEmpty();
}