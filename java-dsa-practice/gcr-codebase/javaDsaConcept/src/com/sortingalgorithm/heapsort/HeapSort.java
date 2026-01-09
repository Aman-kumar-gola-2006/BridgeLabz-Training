package com.sortingalgorithm.heapsort;
import java.util.Arrays;

public class HeapSort {

	  public static void heapSort(int[] salary) {

	        int n = salary.length;

	        // Build Max Heap
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapify(salary, n, i);
	        }

	        // Extract elements from heap
	        for (int i = n - 1; i > 0; i--) {

	            int temp = salary[0];
	            salary[0] = salary[i];
	            salary[i] = temp;

	            heapify(salary, i, 0);
	        }
	    }

	    private static void heapify(int[] arr, int n, int i) {

	        int largest = i;
	        int left = 2 * i + 1;
	        int right = 2 * i + 2;

	        if (left < n && arr[left] > arr[largest])
	            largest = left;

	        if (right < n && arr[right] > arr[largest])
	            largest = right;

	        if (largest != i) {

	            int temp = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = temp;

	            heapify(arr, n, largest);
	        }
	    }

	    public static void main(String[] args) {

	        int[] salaries = { 60000, 45000, 80000, 55000, 70000 };

	        System.out.println("Before Sorting: " + Arrays.toString(salaries));

	        heapSort(salaries);

	        System.out.println("After Sorting:  " + Arrays.toString(salaries));
	    }
	}
