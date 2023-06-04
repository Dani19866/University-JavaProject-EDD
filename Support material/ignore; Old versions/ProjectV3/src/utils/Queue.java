package utils;

import java.util.NoSuchElementException;
import linkedList.Node;

/**
 * Represents a basic queue data structure using a linked list.
 *
 * @param <T> The type of elements in the queue.
 */
public class Queue<T> {
    private Node<T> front;  // Front of the queue
    private Node<T> rear;   // Rear of the queue
    private int size;       // Number of elements in the queue

    /**
     * Creates an empty queue.
     */
    public Queue() {
        front = rear = null;
        size = 0;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the rear of the queue.
     *
     * @param element The element to be added.
     */
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }

        size++;
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

        T removedElement = front.getData();
        front = front.getNextNode();

        if (front == null) {
            rear = null;
        }

        size--;

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

        return front.getData();
    }
}
