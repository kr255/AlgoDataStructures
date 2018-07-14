package com.elementary.sort.java;

public class Selection {

	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	private static void exchange(Comparable a[], int i, int j)
	{
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	public static void sort(Comparable a[])
	{
		int N = a.length;
		for(int i = 0; i<N; i++)
		{
			int min = i;
			for(int j=i+1; j< N; j++)
			{
				if(less(a[j], a[min]))
				{
					min = j;
				}
			}
			exchange(a, i, min);
		}
	}
	public static boolean isSorted(Comparable a[])
	{
		for(int i=1; i < a.length; i++)
		{
			if(less(a[i], a[i-1])) 
				return false;	
		}
		return true;
		
	}
	public static void main(String[] args) {
		
		Integer a[] = {5,0,4,3};
		sort(a);
		for(Integer i : a)
		{
			System.out.println(i);
		}
			
		System.out.println(isSorted(a));


	}
}
