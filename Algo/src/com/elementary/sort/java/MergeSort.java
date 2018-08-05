package com.elementary.sort.java;

public class MergeSort {

	private static int THRESHOLD = 25;
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	public static void sort(Comparable a[], Comparable aux[])
	{
		int N = a.length;
		//aux = new Comparable[N];
		sort(a, aux, 0, N-1);
	}
	public static void BUsort(Comparable a[], Comparable aux[])
	{
		int N = a.length;
		//aux = new Comparable[N];
		for(int i = 1; i < N; i = 2*i)
		{
			for(int j=0; j < N - i; j+=2*i)
			{
				merge(a, aux, j, j+i-1, Math.min(j+(2*i)-1, N-1));
			}
		}
	}
	private static void sort(Comparable a[], Comparable aux[], int low, int high)
	{
//		if(high - low <= THRESHOLD)
//			Insertion.sort(a);
//		else
//		{
			if(high <= low)
				return;
			int mid = low + (high - low) /2;
			sort(a, aux, low, mid);
			sort(a, aux, mid+1, high);
			if(!less(a[mid+1], a[mid]) || a[mid] == a[mid+1])
			{
				return;
			}
			merge(a, aux, low, mid, high);
		}
		
	//}
	
	private static void merge(Comparable a[], Comparable aux[], int low, int mid, int high)
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
		long startTime = System.nanoTime();
//		String array[] = {"f","ex","ag","ss","yg","q","du","es","s","t","i","o","n"};
//		String aux[] = new String[array.length]; 
		Integer array[] = {25,20568,3,4,001,5,9,2,6,5,3,5,9,54,45,54,54,8,45,4,654,65,4,654,65,4,547,324,15432,1,684,23,46,465,4,64,6547,86,76,54,025,654,68,476,54,897,654,65,4,54,54,54,87,52};
		Integer aux[] = new Integer[array.length];
		BUsort(array, aux);
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		for(Integer i : array)
		{
			System.out.print(i + " ");
		}
		System.out.println("\nTOTAL TIME = " + totalTime);
	}
}
