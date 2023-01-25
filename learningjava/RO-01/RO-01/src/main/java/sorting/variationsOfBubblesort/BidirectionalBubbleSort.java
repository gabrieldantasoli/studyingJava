package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	private Util tools = new Util();

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = 0; i < rightIndex; i++) {
			if (array[i].compareTo(array[i+1]) == 1){
				tools.swap(array, i, i+1);
			}
		}
		rightIndex -= 1;
		for (int i = rightIndex; i > 0; i--) {
			if (array[i].compareTo(array[i-1]) == -1) {
				tools.swap(array, i-1, i);
			}
		}
		leftIndex += 1;
		if (leftIndex <= rightIndex) {
			sort(array,leftIndex,rightIndex);
		}
	}
}
