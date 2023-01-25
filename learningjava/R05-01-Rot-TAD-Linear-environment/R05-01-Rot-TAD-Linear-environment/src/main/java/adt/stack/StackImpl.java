package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		if (isEmpty()) return null;
		return this.array[this.top];
	} 

	@Override
	public boolean isEmpty() {
		return this.top == -1 ? true : false;
	}

	@Override
	public boolean isFull() {
		return this.top == array.length -1 ? true : false;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		this.top += 1;
		this.array[this.top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		T element = this.array[this.top];
		this.array[this.top] = null;
		this.top -= 1;
		return element;
	}

}
