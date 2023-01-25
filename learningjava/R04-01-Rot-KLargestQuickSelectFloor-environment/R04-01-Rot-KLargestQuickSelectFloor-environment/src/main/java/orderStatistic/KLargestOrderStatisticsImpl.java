package orderStatistic;

import java.util.Arrays;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{
	private Util tools = new Util();

	@Override
	public T[] getKLargest(T[] array, int k) {
		this.orderStatistics(array,k);
		T[] retorno = Arrays.copyOf(array, k);
		int index = 0;
		for (int i = k; k >= 1; i--) {
			retorno[index] = orderStatistics(array, i);
			index++;
		}
		return retorno;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 .* a ideia de algum algoritmo de ordenacao visto em sala Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		if (array.length == 0 || k > array.length) return null;
		
		int left = 0;
		int rigth = array.length;
		int middle = (left + rigth) / 2;

		while (middle != k) {
			particion(array, left, rigth);
			if (middle != k) {
				if (k > middle) {
					left = middle + 1;
				}else if (k < middle){
					rigth = middle - 1;
				}
			}
		}

		return array[array.length - k];
	}

	private void particion(T[] array, int left, int rigth) {
		T pivot = array[left];
		int i = left;

		for (int j = left + 1; j < rigth; j++) {
			if (array[j].compareTo(pivot) == -1) {
				i += 1;
				tools.swap(array, i, j);
			}
		}

		tools.swap(array, left, i);
	}
}
