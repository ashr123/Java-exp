public class PairBinarySearchNode extends BinaryNode
{
	public PairBinarySearchNode(Object data)
	{
		super(data);
	}

	public void insert(Object toInsert)
	{
		if (!(toInsert instanceof Pair))
			throw new ClassCastException();
		Pair pairToInsert=(Pair)toInsert;
		Comparable keyToInsert=pairToInsert.getKey();
		Comparable myKey=((Pair)data).getKey();
		if (keyToInsert.compareTo(myKey)<0)
			if (left == null)
				left = new PairBinarySearchNode(toInsert);
			else
				left.insert(toInsert);
		else
			if (keyToInsert.compareTo(myKey)>0)
				if (right == null)
					right = new PairBinarySearchNode(toInsert);
				else
					right.insert(toInsert);
	}

	public BinaryNode remove(Object toRemove)
	{
		if (!(toRemove instanceof Pair))
			throw new ClassCastException();
		Pair pairToRemove=(Pair)toRemove;
		Comparable keyToRemove=pairToRemove.getKey();
		Comparable myKey=((Pair)data).getKey();
		if (keyToRemove.compareTo(myKey)<0)
		{
			if (left!=null)
				left=((PairBinarySearchNode)left).remove(toRemove);
		}
		else
			if (keyToRemove.compareTo(myKey)>0)
			{
				if (right!=null)
					right=((PairBinarySearchNode)right).remove(toRemove);
			}
			else
			{//need to remove the data in this node
				if (left==null || right==null)
				{//the base cases...
					if (left==null)
						return right;
					else
						return left;
				}
				else
				{//this node has two children
					data=((PairBinarySearchNode)right).findMin();
					right=((PairBinarySearchNode)right).remove(data);
				}
			}
		return this;
	} //remove

	public boolean contains(Object element)
	{
		if (!(element instanceof Pair))
			return false;
		Pair pairElement=(Pair)element;
		Comparable keyElement=pairElement.getKey();
		Comparable myKey=((Pair)data).getKey();
		int compareResult=keyElement.compareTo(myKey);
		if (compareResult==0)
			return true;
		else
			return compareResult<0 ? left!=null && left.contains(element) : right!=null && right.contains(element);
	}

	public Object findMin()
	{
		BinaryNode currNode=this;
		while (currNode.left!=null)
			currNode=currNode.left;
		return currNode.data;
	}
}