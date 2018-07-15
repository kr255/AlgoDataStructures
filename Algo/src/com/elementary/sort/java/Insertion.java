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
		
		String arr[] = {"asd", "aab", "abc", "qwe"};
		sort(arr);
		for(String a : arr)
		{
			System.out.println(a);
		}
	}

}
