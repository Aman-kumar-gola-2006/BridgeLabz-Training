package com.sortingalgorithm.mergesort;


import java.util.*;
public class MergeSort {
     
	public static void merge(int []a, int l,int m,int r) {
		int n1=m-l+1;
		int n2=m-r;
		
		int L[]=new int[n1];
		int R[]=new int[n2];
		
		for(int i=0;i<n1;i++)
		{
		  L[i]=a[l+i];	
		}
		for(int i=0;i<n2;i++)
		{
		  R[i]=a[m+1+i];	
		}
		
		
		int i=0;
		int j=0;
		
		int k=l;
		
		while(i<n1 && j<n2)
		{
			if(L[i]<R[j]) {
				a[k]=L[i];
				i++;
			}
			else {
				a[k]=R[j];
				j++;
			}
			k++;
		}
		
		while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
		while (j < n2) {
            a[k] = L[j];
            j++;
            k++;
        }
		
	}
	
	 public static void mergeSort(int a[], int l,int r)
	   {
		   if(l<r)
		   {
			   int mid=l+(r-l)/2;
			   mergeSort(a, l, mid);
			   mergeSort(a, mid+1, r);
			   merge(a, l, mid, r);
			   
		   }
	   }
	 
	public static void display(int []a,int n)
	 {
		 System.out.println("Sorted Array:");
	        for (int i = 0; i < n; ++i) {
	            System.out.print(a[i] + " ");
	        }
	 }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Ask user for array size
		System.out.print("Enter number of elements: ");
		int n = sc.nextInt();

		int[] a = new int[n];

		// Take array elements from user
		System.out.println("Enter array elements:");
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int l=0;
		int r=n;
		
		mergeSort(a, l, r);
		
	}
	
}
