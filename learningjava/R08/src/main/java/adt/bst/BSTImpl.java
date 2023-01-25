package adt.bst;

import java.util.ArrayList;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return recursiveHeight(this.root);
	}
	
	private int recursiveHeight(BTNode<T> node) {
		if (node.isEmpty()) return -1;
		return 1 + Math.max(recursiveHeight(node.getLeft()), recursiveHeight(node.getRight()));
	}
	
	//private int recursiveHeight() {

	@Override
	public BSTNode<T> search(T element) {
		return recursiveSearch(this.root, element);
	}

	private BSTNode<T> recursiveSearch(BTNode<T> node, T element) {
		if (node.isEmpty()) return new BSTNode<>();
		if (element.compareTo(node.getData()) == 0) return (BSTNode<T>) node;
		if (element.compareTo(node.getData()) == -1) return (BSTNode<T>) recursiveSearch(node.getLeft(), element);
		else return (BSTNode<T>) recursiveSearch(node.getRight(), element); 
	}
	
	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			BSTNode<T> root = (BSTNode<T>) new BSTNode.Builder<T>().data(element).left(new BTNode<T>()).right(new BTNode<T>()).parent(new BTNode<T>()).build();
			this.root = root;
		} else {
			this.recursiveInsert(this.root, element);
		}
	}
	
	private void recursiveInsert(BSTNode<T> node, T element) {
		if (element.compareTo(node.getData()) == -1) {
			if (node.getLeft().isEmpty()) {
				BSTNode<T> newNode = (BSTNode<T>) new BSTNode.Builder<T>().data(element).left(new BTNode<T>()).right(new BTNode<T>()).parent(node).build();
				node.setLeft(newNode);
				return;
			}
			
			this.recursiveInsert((BSTNode<T>) node.getLeft(), element);
		} else {
			if (node.getRight().isEmpty()) {
				BSTNode<T> newNode = (BSTNode<T>) new BSTNode.Builder<T>().data(element).left(new BTNode<T>()).right(new BTNode<T>()).parent(node).build();
				node.setRight(newNode);
				return;
			}
			
			this.recursiveInsert((BSTNode<T>) node.getRight(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if (isEmpty()) return null;
		else return recursiveMaximun(this.root);
	}
	
	private BSTNode<T> recursiveMaximun(BSTNode<T> node) {
		if (node.getRight().isEmpty()) return node;
		else return recursiveMaximun((BSTNode<T>) node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		if (isEmpty()) return null;
		return recursiveMinimum(this.root);
	}
	
	private BSTNode<T> recursiveMinimum(BSTNode<T> node) {
		if (node.getLeft().isEmpty()) return node;
		else return recursiveMinimum((BSTNode<T>) node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		return this.recursiveSucessor(search(element));
	}
	
	private BSTNode<T> recursiveSucessor(BSTNode<T> node) {
		if (node.isEmpty()) return null;
		if (this.maximum().equals(node)) return null;
		if (!node.getRight().isEmpty()) return recursiveMinimum((BSTNode<T>) node.getRight());
		else {
			BSTNode<T> aux = (BSTNode<T>) node.getParent();
			
			while (!aux.isEmpty() && aux.getData().compareTo(node.getData()) == -1) aux = (BSTNode<T>) aux.getParent();
			
			return aux;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		return recursivePredecessor(search(element));
	}
	
	private BSTNode<T> recursivePredecessor(BSTNode<T> node) {
		if (node.isEmpty()) return null;
		if (this.minimum().equals(node)) return null;
		if (!node.getLeft().isEmpty()) return recursiveMaximun((BSTNode<T>) node.getLeft());
		else {
			BSTNode<T> aux = (BSTNode<T>) node.getParent();
			
			while (!aux.isEmpty() && aux.getData().compareTo(node.getData()) == 1) aux = (BSTNode<T>) aux.getParent();
			
			return aux;
		}
	}

	@Override
	public void remove(T element) {
		if (this.isEmpty() || element == null) return;
		recursiveRemove(search(element));
	}
	
	private void recursiveRemove(BSTNode<T> node) {
		if (node.isLeaf()) {
			
			if (node.equals(root)) {
				this.root = new BSTNode<>(); 
			} else {
				if (node.getData().compareTo(node.getParent().getData()) == -1) {
					node.getParent().setLeft(new BSTNode<>());
				} else {
					node.getParent().setRight(new BSTNode<>());
				}
			}
			
		} else if (node.hasOnlyRightChild()) {
			
			if (node.equals(root)) {
				this.root = (BSTNode<T>) node.getLeft();
				this.root.setParent(new BSTNode<>());
			} else {
				node.getLeft().setParent(node.getParent());
				if (node.getData().compareTo(node.getParent().getData()) == -1) {
					node.getParent().setLeft(node.getLeft());
				} else {
					node.getParent().setRight(node.getLeft());
				}
			}
			
		} else if (node.hasOnlyLeftChild()) {
			
			if (node.equals(root)) {
				this.root = (BSTNode<T>) node.getRight();
				this.root.setParent(new BSTNode<>());
			} else {
				node.getRight().setParent(node.getParent());
				if (node.getData().compareTo(node.getParent().getData()) == -1) {
					node.getParent().setLeft(node.getRight());
				} else {
					node.getParent().setRight(node.getRight());
				}
			}
			
		} else {
			BSTNode<T> sucessor = recursiveSucessor(node);
			recursiveRemove(sucessor);
			node.setData(sucessor.getData());
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> pOrder = new ArrayList<T>();
		preOrder(this.root, pOrder);
		T[] array = (T[]) new Comparable[pOrder.size()];
		for (int i = 0; i < pOrder.size(); i++) {
			array[i] = pOrder.get(i);
		}
		return array;
	}
	
	private void preOrder(BTNode<T> node, ArrayList array) {
		if (!node.isEmpty()) {
			array.add(node.getData());
			preOrder(node.getLeft(), array);
			preOrder(node.getRight(), array);
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> pOrder = new ArrayList<T>();
		order(this.root, pOrder);
		T[] array = (T[]) new Comparable[pOrder.size()];
		for (int i = 0; i < pOrder.size(); i++) {
			array[i] = pOrder.get(i);
		}
		return array;
	}
	
	private void order(BTNode<T> node, ArrayList array) {
		if (!node.isEmpty()) {
			order(node.getLeft(), array);
			array.add(node.getData());
			order(node.getRight(), array);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> pOrder = new ArrayList<T>();
		postOrder(this.root, pOrder);
		T[] array = (T[]) new Comparable[pOrder.size()];
		for (int i = 0; i < pOrder.size(); i++) {
			array[i] = pOrder.get(i);
		}
		return array;
	}
	
	private void postOrder(BTNode<T> node, ArrayList array) {
		if (!node.isEmpty()) {
			order(node.getLeft(), array);
			order(node.getRight(), array);
			array.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(this.root);
	}

	private int size(BTNode<T> node) {
		int result = 0;
		
		if (!node.isEmpty()) { 
			result = 1 + size(node.getLeft())
					+ size(node.getRight());
		}
		
		return result;
	}
}
