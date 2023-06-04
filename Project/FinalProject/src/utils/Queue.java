package utils;

import java.util.NoSuchElementException;
import linkedlist.Node;

/**
 * Represents a basic queue data structure using a linked list.
 *
 * @param <T> The type of elements in the queue.
 */
public class Queue<T> {
    
    /**
     * The front node of the queue.
     */
    private Node<T> front;
    /**
     * The rear node of the queue.
     */
    private Node<T> rear;
    /**
     * The number of elements in the queue.
     */
    private int size;

    /**
     * Creates an empty queue.
     */
    public Queue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    public int size() {
        return this.size;
    }

    /**
     * Adds an element to the rear of the queue.
     *
     * @param element The element to be added.
     */
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);

        if (isEmpty()) {
            this.front = this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }

        this.size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return The element at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T removedElement = this.front.data;
        this.front = front.next;

        if (this.front == null) {
            this.rear = null;
        }

        this.size--;

        return removedElement;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return The element at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return this.front.data;
    }
}
