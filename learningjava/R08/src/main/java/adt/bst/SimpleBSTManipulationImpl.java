package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		if (tree1.size() != tree2.size()) return false; 
		return equalsNode(tree1.getRoot(), tree2.getRoot());
	}
	
	private boolean equalsNode(BTNode<T> node1, BTNode<T> node2) {
		boolean resp = node1.equals(node2);
		
		if (!node1.isEmpty() && !node2.isEmpty()) {
			resp = resp && this.equalsNode(node1.getLeft(), node2.getLeft()) && this.equalsNode(node1.getRight(), node2.getRight());
		}
		
		return resp;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		if (tree1.size() != tree2.size()) return false; 
		return checkSimilarity((BST<T>) tree1.getRoot().getLeft(), (BST<T>) tree2.getRoot().getLeft()) && checkSimilarity((BST<T>) tree1.getRoot().getRight(), (BST<T>) tree2.getRoot().getRight());
	}
	
	private boolean checkSimilarity(BST<T> node1, BST<T> node2) {
		if (node1.size() != node2.size()) return false;
		return checkSimilarity((BST<T>) node1.getRoot().getLeft(), (BST<T>) node2.getRoot().getLeft()) && checkSimilarity((BST<T>) node1.getRoot().getRight(), (BST<T>) node2.getRoot().getRight());
	}


	@Override
	public T orderStatistic(BST<T> tree, int k) {
		if (tree.isEmpty() || k > tree.size()) return null;
		return this.statistic(tree,tree.minimum().getData() ,0, k);
	}

	private T statistic(BST<T> tree, T order, int i, int k) {
		i += 1;
		if (i == k) return order;
		order = tree.sucessor(order).getData();
		return this.statistic(tree, order, i, k);
	}
}
