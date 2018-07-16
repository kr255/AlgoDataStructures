package com.elementary.sort.java;

public class Insertion {

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
	public static void sort(Comparable[] a) {
		
		int N = a.length;
		for(int i=1; i < N; i++)
		{
			for(int j=i; j > 0 && less(a[j], a[j-1]); j--)
			{
				exchange(a, j, j-1);
			}
		}

	}
	/*
	 * ShellSort implementation
	 */
	public static void shellsort(Comparable[] a) {
		
		int N = a.length;
		int h = 1;
		while(h < N/3)
		{
			h=3*h+1;
		}
		while(h>=1)
		{
			for(int i = h; i < N; i++)
			{
				for(int j = i; j >=h  && less(a[j], a[j-h]); j=j-h)
				{
					exchange(a, j, j-h);
				}
			}
			h=h/3;
		}


	}
	/*
	 * insertion sort without the adjacent compare.
	 * the compare is given during the test
	 * unlike actual shellsort that calculates the h-sort
	 */
	public static void shellsorttwo(Comparable a[], int h)
	{
		int N = a.length;
		for(int i = h; i < N; i++)
		{
			for(int j = i; j>=h && less(a[j], a[j-h]); j=j-h)
			{
				exchange(a, j, j-h);
			}
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
		

		int loop[] = {701,301,132,57,23,10, 4, 1};
		String arrc[] = {"s","h","e","l","l","s","o","r","t","e","x","a","m","p","l","e"};
		
		for(Integer i : loop)
			shellsorttwo(arrc, i);
		for(String a : arrc)
		{
			System.out.print(a);
		}
		System.out.println();
		

	}

}
