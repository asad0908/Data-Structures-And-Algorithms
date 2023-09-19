package com.asad.dsa.algorithms.sorting;

/*
 * Merge sort is a recursive sorting algorithm
 * what it does is it when its called on an array which contains huge amount of
 * elements, it breaks the array into two parts (left and right) and recursively
 * calls itself on these parts which will further break the array into another half..
 * until there are only two elements remaining in the array.
 * Then it sorts that two elements and recursively climbs up sorting pairs till
 * the final array is sorted.
 */

public class MergeSort implements Sorting {
	
	@Override
	public void sort(int[] arr) {
		if(arr.length == 0) {
			return;
		}
		
		this.mergeSort(arr, 0, arr.length - 1);
	}
	
	private void mergeSort(int[] arr, int start, int end) {
		if(start < end) {
			//find the mid of the array
			int mid = start + (end - start) / 2;
			
			//recursively calls itself on the left part
			mergeSort(arr, start, mid);
			
			//recursively calls itself on the right part
			mergeSort(arr, mid + 1, end);
			
			//finally merge both the parts in a sorted fashion
			merge(arr, start, mid, end);
		}
	}
	
	private void merge(int[] arr, int start, int mid, int end) {
		int leftPartLength = mid - start + 1;
		int rightPartLength = end - mid;
		
		int[] leftPart = new int[leftPartLength + 1];
		int[] rightPart = new int[rightPartLength + 1];
		
		//copies the left part of the original array into leftPartArray
		for(int i = 0; i<leftPartLength; i++) {
			leftPart[i] = arr[i + start];
		}
		
		//copies the right part of the original array into rightPartArray
		for(int i = 0; i<rightPartLength; i++) {
			rightPart[i] = arr[i + mid + 1];
		}
		
		//A neat trick to do the magic... Dry run and check!
		//TODO: Can be done without this too!
		leftPart[leftPartLength] = Integer.MAX_VALUE;
		rightPart[rightPartLength] = Integer.MAX_VALUE;
		
		//compares the left and right part elements and place it in a sorted fashion
		int i = 0, j = 0;
		for(int k = start; k<=end; k++) {
			if(leftPart[i] <= rightPart[j]) {
				arr[k] = leftPart[i];
				i++;
			}else {
				arr[k] = rightPart[j];
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {6,5,3,2,4,7,1,8};
		Sorting sortAlgo = new MergeSort();
		sortAlgo.sort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}
}
