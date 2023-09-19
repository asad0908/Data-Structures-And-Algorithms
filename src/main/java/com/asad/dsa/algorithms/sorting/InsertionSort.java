package com.asad.dsa.algorithms.sorting;

/*
 * Insertion Sort
 * This algorithm basically inserts the element in its correct position in an
 * already sorted array. 
 * Imagine a series of cards with number 2,4,5,6,3 and then you want to insert 
 * number 3 in its right position so you pick the three number card and put it 
 * between 2 and 4 i.e 2,3,4,5,6 
 */

public class InsertionSort implements Sorting {
	
	@Override
	public void sort(int[] arr) {
		if(arr.length == 0) {
			return;
		}
		
		this.insertionSort(arr);
	}
	
	private void insertionSort(int[] arr) {
		//key is basically the number which we will put in its correct position
		int key, j;
		for(int i = 1; i<arr.length; i++) {
			key = arr[i];
			j = i - 1;
			
			//left shift all the numbers which are greater than the key
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			
			//put the key in its correct position
			arr[j+1] = key;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {6,5,3,1,4,2,8,7,10,25,15,17,23,66};
		Sorting sortAlgo = new InsertionSort();
		sortAlgo.sort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}
}
