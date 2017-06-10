public class Sets
{
	public static Set union(Set setA, Set setB)
	{
		Set unionSet=new SetAsLinkedList(setA);
		/*Iterator iterB = setB.iterator();
		while(iterB.hasNext())
			unionSet.add(iterB.next());*/
		for (Object e : setB)
			unionSet.add(e);
		return unionSet;
	}
	
	public static Set intersection(Set setA, Set setB)
	{
		Set intersectionSet=new SetAsLinkedList();
		for (Object e : setA)
			if (setB.contains(e))
				intersectionSet.add(e);
		return intersectionSet;
	}
	
//	public static Set subtraction(Set setA, Set setB)
//	{
//		Set subtractSet=new SetAsLinkedList(setA);
//		for (Object e : setB)
//			subtractSet.remove(e);
//		return subtractSet;
//	}
}