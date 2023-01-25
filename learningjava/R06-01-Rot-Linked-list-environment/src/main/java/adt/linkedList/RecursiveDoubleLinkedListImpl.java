package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		
	}

	@Override
	public void insertFirst(T element) { 
		if (super.isEmpty()) {
			super.insert(element);
			this.previous = new RecursiveDoubleLinkedListImpl();
		} else {
			RecursiveDoubleLinkedListImpl item = new RecursiveDoubleLinkedListImpl(); 
			item.data = super.data;
			item.next = super.next;
			super.data = element; 
			this.previous = new RecursiveDoubleLinkedListImpl();
			super.next = item;
		}
	}

	@Override
	public void removeFirst() { 
		if (super.isEmpty()) throw new IllegalArgumentException("Lista vazia");
		else {
			super.data = next.data;
			next = next.next;
		}
	}

	@Override
	public void removeLast() {
		if (next.isEmpty()) {
			super.data = null;
			super.next = null;
		} else {
			
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}

