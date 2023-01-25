package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {
	private Util tools = new Util();

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean has_swap = true; 
		
		while (has_swap) {
			has_swap = false;
			
			for (int index = 0; index < array.length - 1; index++) { 
				if (array[index].compareTo(array[index+1]) == 1) {
					tools.swap(array, index, index+1);
					has_swap = true;
				}
			}
		}
	}
	
}
