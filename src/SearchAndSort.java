public class SearchAndSort
{
	public static int linearSearch(int[] array, int key)
	{
		if (array==null)
			throw new RuntimeException();
		int output=-1;//Default (not found) value
		for (int i=0; i<array.length; i++)
			if (key==array[i])
				output=i;
		return output;
	}
	
	//Assumes that: a!=null
	public static int binarySearch(int[] a, int key)
	{
		if (a==null)
			throw new RuntimeException();
		int output=-1;//Default (not found) value
		boolean found=false;
		int low=0, high=a.length-1;
		while (low<=high & !found)
		{
			int middle=(low+high)/2;
			if (a[middle]==key)
			{
				output=middle;
				found=true;
			}
			else
				if (key<a[middle])
					high=middle-1;
				else
					low=middle+1;
		}
		return output;
	}
	
	public static void insertionSort(int[] a)
	{
		if (a==null)
			throw new RuntimeException();
		for (int i=1; i<a.length; i++)
			insert(a, i);
	}
	
	//Assumes that a!=null, 0<=i<a.length
	private static void insert(int[] a, int i)
	{
		//Inserts the element at index i into its
		//Corrects position to the left
		int value=a[i];
		//Shifts the larger elements to the right
		while (i>0 && a[i-1]>value)
		{
			a[i]=a[i-1];
			i--;
		}
		a[i]=value;
	}
	
	public static void selectionSort(int[] array)
	{
		if (array==null)
			throw new RuntimeException();
		for (int i=0; i<array.length-1; i++)
		{
			int minInd=minIndex(array, i);
			swap(array, i, minInd);
		}
	}
	
	//Assumes a!=null & from<a.length
	public static int minIndex(int[] a, int from)
	{
		int minIndex=from;
		for (int i=from+1; i<a.length; i++)
			if (a[i]<a[minIndex])
				minIndex=i;
		return minIndex;
	}
	
	//Swaps element a[i] with a[j]
	public static void swap(int[] a, int i, int j)
	{
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	
	public static void printArray(int[] a)
	{
		for (int element : a)
			System.out.print(element+" ");
		System.out.println();
	}
}