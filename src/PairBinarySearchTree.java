public class PairBinarySearchTree extends BinaryTree
{
	public PairBinarySearchTree()
	{
		super();
	}
	
	public boolean contains(Object element)
	{
		if (!(element instanceof Pair))
			return false;
		return root.contains(element);
	}
	
	public void insert(Object toInsert)
	{
		if (!(toInsert instanceof Pair))
			throw new IllegalArgumentException();
		if (isEmpty())
			root=new PairBinarySearchNode(toInsert);
		else
			root.insert(toInsert);
	}
	
	public void remove(Object toRemove)
	{
		if ((!isEmpty()) & (toRemove instanceof Pair))
			root=((PairBinarySearchNode)root).remove(toRemove);
	}
}