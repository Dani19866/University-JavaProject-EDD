package utils;

import java.util.EmptyStackException;

/**
 * Represents a basic stack data structure using an array.
 *
 * @param <T> The type of elements in the stack.
 */
public class Stack<T> {

    /**
     * An array that stores the elements of the stack.
     */
    private Object[] elements;
    /**
     * The index of the top element in the stack.
     */
    private int top;

    /**
     * Creates an empty stack with the specified capacity.
     *
     * @param capacity The maximum capacity of the stack.
     */
    public Stack(int capacity) {
        this.elements = new Object[capacity];
        this.top = -1;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return The number of elements in the stack.
     */
    public int size() {
        return this.top + 1;
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param element The element to be pushed.
     * @throws IllegalStateException if the stack is full.
     */
    public void push(T element) {
        if (this.top == this.elements.length - 1) {
            throw new IllegalStateException("Stack is full");
        }

        this.top++;
        this.elements[top] = element;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T poppedElement = (T) this.elements[top];
        this.elements[top] = null;
        this.top--;

        return poppedElement;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (T) this.elements[top];
    }
}
