package com.elementary.sort.java;

public class MergeSort {

	private static Comparable aux[];
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	public static void sort(Comparable a[])
	{
		int N = a.length;
		aux = new Comparable[N];
		sort(a, 0, N-1);
	}
	private static void sort(Comparable a[], int low, int high)
	{
		if(high <= low)
			return;
		int mid = low + (high - low) /2;
		sort(a, low, mid);
		sort(a, mid+1, high);
		if(less(a[mid+1], a[mid]) || a[mid+1] == a[mid])
		{
			merge(a, low, mid, high);
		}
		//merge(a, low, mid, high);
	}
	private static void merge(Comparable a[], int low, int mid, int high)
	{
		int i = low, j = mid +1;
		for(int k = low; k<=high; k++)
		{
			aux[k] = a[k];
		}
		for(int k = low; k<=high; k++)
		{
			if(i > mid)
				a[k] = aux[j++];
			else if (j > high)
				a[k] = aux[i++];
			else if(less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	public static void main(String[] args) {
		
//		Integer array[] = {2,5,9,4};
//		sort(array);
//		for(Integer i : array)
//		{
//			System.out.print(i + " ");
//		}
		//String array[] = {"q","u","e","s","t","i","o","n"};

		String array[] = {"e","i","n","o","q","s","t","u"};
		sort(array);
		for(String i : array)
		{
			System.out.print(i + " ");
		}
	}
}
