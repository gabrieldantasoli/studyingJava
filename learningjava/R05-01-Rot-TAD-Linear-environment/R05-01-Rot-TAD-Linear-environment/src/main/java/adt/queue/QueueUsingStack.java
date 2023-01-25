package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		try {
			this.stack1.push(element);
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.stack1.isEmpty()) {
			throw new QueueUnderflowException();
		}else {
			T element;
			while (!this.stack1.isEmpty()) {
				try {
					this.stack2.push(this.stack1.top());
				} catch (StackOverflowException e) {
					e.getMessage();				
				} 
				try {
					this.stack1.pop();
				} catch (StackUnderflowException e) {
					e.getMessage();	
				}
			}
			element = stack2.top();
			try {
				stack2.pop();
			} catch (StackUnderflowException e) {
				e.getMessage();	
			}
			while (!this.stack2.isEmpty()) {
				try {
					this.stack1.push(this.stack2.top());
				} catch (StackOverflowException e) {
					e.getMessage();	
				}
				try {
					this.stack2.pop();
				} catch (StackUnderflowException e) {
					e.getMessage();	
				} 
			}
			return element;
		}
	}

	@Override
	public T head() {
		if (isEmpty()) return null;
		T element;
		while (!this.stack1.isEmpty()) {
			try {
				this.stack2.push(this.stack1.top());
			} catch (StackOverflowException e) {
				e.getMessage();				
			} 
			try {
				this.stack1.pop();
			} catch (StackUnderflowException e) {
				e.getMessage();	
			}
		}
		element = stack2.top();
		while (!this.stack2.isEmpty()) {
			try {
				this.stack1.push(this.stack2.top());
			} catch (StackOverflowException e) {
				e.getMessage();	
			}
			try {
				this.stack2.pop();
			} catch (StackUnderflowException e) {
				e.getMessage();	
			} 
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty() ? true : false;
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull() ? true : false;
	}

}
