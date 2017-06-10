import java.util.Arrays;

public class RemoveDuplicates
{
	// simpler naive version with same structure as the one with sort
	// == two passes one to count and one to copy
	public static int[] removeDuplicates(int[] arr)
	{
		// pass one: count how many non duplicates
		int count=0;
		for (int i=0; i<arr.length; i=i+1)
			// is arr[i] already in the elements from arr[0] to arr[i-1]
			if (!containsLeftInArray(arr, i))
				count=count+1;
		// pass two: copy them
		int[] output=new int[count];
		int j=0;
		for (int i=0; i<arr.length; i=i+1)
			// is arr[i] already in the elements from arr[0] to arr[i-1]
			if (!containsLeftInArray(arr, i))
			{
				output[j]=arr[i];
				j=j+1;
			}
		return output;
	}
	
	// remove duplicates from an array of integers
	// naive (iterative) version: O(n^2)
	public static int[] removeDuplicatesCool(int[] arr)
	{
		int duplicatesFromHere=arr.length;
		// everything in the array starting index duplicatesFromHere is duplicates
		for (int i=0; i<duplicatesFromHere; i=i+1)
		{
			int j=i+1;
			while (j<duplicatesFromHere)
			{
				if (arr[i]!=arr[j])
					j=j+1;
				else
				{
					swap(arr, j, duplicatesFromHere-1);
					duplicatesFromHere=duplicatesFromHere-1;
				}
			}
		}
		
		int[] output=new int[duplicatesFromHere];
		for (int i=0; i<duplicatesFromHere; i=i+1)
			output[i]=arr[i];
		return output;
	}
	
	public static int[] mergeSort(int[] arr)
	{
		if (arr==null)
			throw new NullPointerException();
		if (arr.length<2)
			return arr;
		else
		{
			int[] arr1=splitLeft(arr);
			int[] arr2=splitRight(arr);
			int[] sorted1=mergeSort(arr1);
			int[] sorted2=mergeSort(arr2);
			return merge(sorted1, sorted2);
		}
	}
	
	public static int[] splitLeft(int[] arr)
	{
		int[] output=new int[arr.length/2];
		for (int i=0; i<arr.length/2; i=i+1)
			output[i]=arr[i];
		return output;
	}
	
	public static int[] splitRight(int[] arr)
	{
		int[] output=new int[arr.length-arr.length/2];
		for (int i=arr.length/2; i<arr.length; i=i+1)
			output[i-arr.length/2]=arr[i];
		return output;
	}
	
	public static int[] merge(int[] arr1, int[] arr2)
	{
		int ind=0, i1=0, i2=0, len1=arr1.length, len2=arr2.length;
		int[] output=new int[len1+len2];
		while (i1<len1 & i2<len2)
		{
			if (arr1[i1]<arr2[i2])
			{
				output[ind]=arr1[i1];
				i1=i1+1;
			}
			else
			{
				output[ind]=arr2[i2];
				i2=i2+1;
			}
			ind=ind+1;
		}
		for (int i=i1; i<len1; i=i+1)
		{
			output[ind]=arr1[i];
			ind=ind+1;
		}
		for (int i=i2; i<len2; i=i+1)
		{
			output[ind]=arr2[i];
			ind=ind+1;
		}
		return output;
	}
	
	// remove duplicates from an array of integers
	// less naive (iterative) version: cost = cost of the sort
	public static int[] removeDuplicates2(int[] arr)
	{
		//selection_sort(arr);
		arr=mergeSort(arr);
		// pass one: count how many non duplicates
		int count=0;
		for (int i=0; i<arr.length; i=i+1)
			// is arr[i] already in the elements from arr[0] to arr[i-1]
			if (!containsLeftInSortedArray(arr, i))
				count=count+1;
		// pass two: copy them
		int[] output=new int[count];
		int j=0;
		for (int i=0; i<arr.length; i=i+1)
			// is arr[i] already in the elements from arr[0] to arr[i-1]
			if (!containsLeftInSortedArray(arr, i))
			{
				output[j]=arr[i];
				j=j+1;
			}
		return output;
	}
	
	public static boolean containsLeftInArray(int[] arr, int index)
	{
		// is element in arr[index] also in arr[0 ... index-1]
		int element=arr[index];
		for (int i=index-1; i>=0; i=i-1)
			if (arr[i]==element)
				return true;
		return false;
	}
	
	public static boolean containsLeftInSortedArray(int[] arr, int index)
	{
		// is element in arr[index] also in sorted arr[0 ... index-1]
		return index>0 && arr[index]==arr[index-1];
	}
	
	static void selection_sort(int[] array)
	{
		
		for (int i=0; i<array.length; i=i+1)
			swap(array, i, find_min(array, i));
	}// selection_sort
	
	static int find_min(int[] array, int i)
	{
		// finds the index of the minimal value in "array"
		// from "i" (inclusive) till  array.length.
		// assumes that: "i" is in the range of the index.
		int min_index=i;
		for (int j=i+1; j<array.length; j=j+1)
			if (array[j]<array[min_index])
			{
				min_index=j;
			}
		return min_index;
	} // find_min
	
	static void swap(int[] a, int i, int j)
	{
		// swap the indexes i and j in the array a.
		// assumes that i,j are in the range of the index.
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
		return;
	}//swap
	
	public static void main(String[] args)
	{
		int[] a1={2, 2, 4, 2, 6, 5, 3, 2, 1, 4, 6, 5};
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(removeDuplicates(a1)));
		System.out.println(Arrays.toString(mergeSort(a1)));
		System.out.println(Arrays.toString(removeDuplicates2(a1)));
		
		int[] a2={2};
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.toString(removeDuplicates(a2)));
		System.out.println(Arrays.toString(removeDuplicates2(a2)));
		
		int[] a3={};
		System.out.println(Arrays.toString(a3));
		System.out.println(Arrays.toString(removeDuplicates(a3)));
		System.out.println(Arrays.toString(removeDuplicates2(a3)));
	}
}