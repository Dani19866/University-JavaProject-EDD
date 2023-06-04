package utils;

import java.util.EmptyStackException;

/**
 * Represents a basic stack data structure using an array.
 *
 * @param <T> The type of elements in the stack.
 */
public class Stack<T> {
    private Object[] elements; // Array to store the elements
    private int top; // Index of the top element

    /**
     * Creates an empty stack with the specified capacity.
     *
     * @param capacity The maximum capacity of the stack.
     */
    public Stack(int capacity) {
        elements = new Object[capacity];
        top = -1;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return The number of elements in the stack.
     */
    public int size() {
        return top + 1;
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param element The element to be pushed.
     * @throws IllegalStateException if the stack is full.
     */
    public void push(T element) {
        if (top == elements.length - 1) {
            throw new IllegalStateException("Stack is full");
        }

        top++;
        elements[top] = element;
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

        T poppedElement = (T) elements[top];
        elements[top] = null;
        top--;

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

        return (T) elements[top];
    }
}