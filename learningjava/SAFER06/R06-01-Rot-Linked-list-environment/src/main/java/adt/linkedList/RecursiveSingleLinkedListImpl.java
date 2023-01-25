package adt.linkedList;

import java.util.ArrayList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
		
	}


	@Override
	public boolean isEmpty() {
		return (this.data == null);
	}

	@Override
	public int size() {
		if (isEmpty()) return 0;
		else return 1 + this.next.size();
	}

	@Override
	public T search(T element) {
		if (isEmpty()) return null;
		else {
			if (this.data.equals(element)) return this.data;
			else return this.next.search(element);
		}
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl();
		} else {
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (this.data.equals(element)) {
				this.data = this.next.data;
				this.next = this.next.next;
			}else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		ArrayList result = new ArrayList<T>();
		to_array(result,this);
		return (T[]) result.toArray(); 
	}
	
	private void to_array(ArrayList list, RecursiveSingleLinkedListImpl node) {
		if (!node.isEmpty()){
			list.add(node.data);
			to_array(list,node.next);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
