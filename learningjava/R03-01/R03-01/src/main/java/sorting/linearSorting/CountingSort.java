package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] theArray, int leftIndex, int rightIndex) {
		if (theArray.length == 0) return;
		else {
			int max = Integer.MIN_VALUE;
			for (int value : theArray) {
				if (value > max) {
					max = value;
				}
			}
			
			 int[] counts = new int[max + 1];
			    for (int item : theArray) {
			        counts[item] += 1;
			    }

			    // overwrite counts to hold the next index an item with
			    // a given value goes. so, counts[4] will now store the index
			    // where the next 4 goes, not the number of 4's our
			    // array has.
			    int numItemsBefore = 0;
			    for (int i = 0; i < counts.length; i++) {
			        int count = counts[i];
			        counts[i] = numItemsBefore;
			        numItemsBefore += count;
			    }

			    // output array to be filled in
			    Integer[] sortedArray = new Integer[theArray.length];

			    // run through the input array
			    for (int item : theArray) {

			        // place the item in the sorted array
			        sortedArray[ counts[item] ] = item;

			        // and, make sure the next item we see with the same value
			        // goes after the one we just placed
			        counts[item] += 1;
			    }
			    
			    theArray = sortedArray;
			    
			    for (int b : sortedArray) {
			    	System.out.print(b+"   ");
			    }
			    System.out.println();
		}
		
	}

}
