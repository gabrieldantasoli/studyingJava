package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		if (isEmpty()) return 0;
		int size = 0;
		SingleLinkedListNode aux = head;
		while (!aux.isNIL()) {
			size += 1;
			aux = aux.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		if (isEmpty()) return null;
		SingleLinkedListNode aux = head;
		while (!aux.isNIL()) {
			if (aux.data.equals(element)) return (T) aux.data;
			aux = aux.next;
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.head.data = element;
			this.head.next = new SingleLinkedListNode();
		}else {
			SingleLinkedListNode aux = head;
			while (!aux.isNIL()) {
				aux = aux.next;
			}
			aux.data = element;
			aux.next = new SingleLinkedListNode();
		}
	}

	@Override
	public void remove(T element) {
		if (head.data.equals(element)) head = head.next;
		else {
			SingleLinkedListNode aux = head;
			while (!aux.isNIL() && !aux.data.equals(element)) {
				aux = aux.next;
			}
			if (!aux.isNIL()) {
				aux.data = aux.next.data;
				aux.next = aux.next.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] retorno = (T[]) new Comparable[size()];
		int index = 0;
		SingleLinkedListNode aux = head;
		while (!aux.isNIL()) {
			retorno[index] = (T) aux.data;
			aux = aux.next;
			index += 1;
		}
		return retorno;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
