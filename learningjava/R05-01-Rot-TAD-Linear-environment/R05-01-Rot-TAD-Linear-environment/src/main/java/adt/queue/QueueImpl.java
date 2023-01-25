package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1; 
	}

	@Override
	public T head() {
		if (isEmpty()) return null;
		return this.array[0];
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1 ? true : false;
	}

	@Override
	public boolean isFull() {
		return this.tail == this.array.length - 1 ? true : false;
	}

	private void shiftLeft() {
		if (this.tail == 0) {
			this.array[0] = this.array[1];
		}else {
			for (int i = 0; i < this.tail; i++) {
				this.array[i] = this.array[i+1];
			}
		}
		this.array[this.tail + 1] = null;
	} 

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) throw new QueueOverflowException(); 
		this.tail += 1;
		this.array[this.tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) throw new QueueUnderflowException();
		T element = this.array[0];
		shiftLeft();
		return element;
	}

}
