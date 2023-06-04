/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import utils.Relations;
import utils.User;

/**
 * A generic linked list data structure.
 *
 * @param <T> The type of elements stored in the linked list.
 * @author Daniel
 */
public class LinkedList<T> {

    /**
     * The first node of the linked list.
     */
    public Node<T> pFirst;
    /**
     * The last node of the linked list.
     */
    public Node<T> pLast;
    /**
     * The number of elements in the linked list.
     */
    public int size;

    /**
     * Creates an empty linked list.
     */
    public LinkedList() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param datum The element to add.
     */
    public void addLast(T datum) {
        Node<T> newNode = new Node(datum);

        if (size == 0) {
            this.pFirst = this.pLast = newNode;
        } else {
            this.pLast.next = newNode;
            this.pLast = newNode;
        }

        this.size++;
    }

    /**
     * Adds an element to the beginning of the linked list.
     *
     * @param datum The element to add.
     */
    public void addFirst(T datum) {
        Node<T> newNode = new Node(datum);

        if (this.size == 0) {
            this.pFirst = this.pLast = newNode;
        } else {
            newNode.next = this.pFirst;
            this.pFirst = newNode;
        }

        this.size++;
    }

    /**
     * Adds an element at the specified position in the linked list.
     *
     * @param datum The element to add.
     * @param position The position at which to add the element.
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    public void add(T datum, int position) {
        if (position < 0 || position > (size - 1)) {
            throw new IndexOutOfBoundsException("Error in position... VALUE: " + position + ". SIZE: " + size);
        } else if (size == 0 || position == 0) {
            this.addFirst(datum);
        } else if (position == size - 1) {
            this.addLast(datum);
        } else {
            Node<T> newNode = new Node(datum);
            Node<T> aux = this.pFirst;

            for (int i = 0; i < position; i++) {
                aux = aux.next;
            }

            newNode.next = aux.next;
            aux.next = newNode;
            this.size++;
        }
    }

    /**
     * Deletes the last element from the linked list.
     */
    public void deleteLast() {
        if (this.size != 0) {
            LinkedList newList = new LinkedList();
            Node aux = this.pFirst;

            for (int i = 0; i < this.size - 1; i++) {
                newList.addLast(aux.data);
                aux = aux.next;
            }

            this.pFirst = newList.pFirst;
            this.pLast = newList.pLast;
            this.size = newList.size;
        }
    }

    /**
     * Deletes the first element from the linked list.
     */
    public void deleteFirst() {
        if (this.size != 0) {
            this.pFirst = this.pFirst.next;
            this.size--;
        }
    }

    /**
     * Deletes the element at the specified position from the linked list.
     *
     * @param position The position of the element to delete.
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    public void delete(int position) {
        if (position < 0 || position > (size - 1)) {
            throw new IndexOutOfBoundsException("Error in position... VALUE: " + position + ". SIZE: " + size);
        } else if (size == 0 || position == 0) {
            this.deleteFirst();
        } else if (position == size - 1) {
            this.deleteLast();
        } else {
            Node aux = this.pFirst;

            for (int i = 0; i < position - 1; i++) {
                aux = aux.next;
            }

            aux.next = aux.next.next;
            this.size--;
        }
    }

    /**
     * Retrieves the element at the specified position in the linked list.
     *
     * @param position The position of the element to retrieve.
     * @return The element at the specified position.
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    public T get(int position) {
        if (position < 0 || position > (size - 1)) {
            throw new IndexOutOfBoundsException("Error in position... VALUE: " + position + ". SIZE: " + size);
        } else {
            Node aux = pFirst;
            for (int i = 0; i < position; i++) {
                aux = aux.next;
            }

            return (T) aux.data;
        }
    }

    /**
     * Orders the elements in the linked list in ascending order. Only works for
     * Integer and Double elements.
     *
     * @throws UnsupportedOperationException if the element type is not
     * supported.
     */
    public void orderLowerToHigher() {
        if (this.size != 0 || this.size != 1) {
            Object type = this.pFirst.data.getClass();

            // String
            if (type == String.class) {
                System.out.println("[!] WARNING: String no is supported!");
                return;
            }

            // Integer
            if (type == Integer.class) {
                Node aux = this.pFirst;

                for (int i = 0; i < this.size; i++) {
                    Node<T> current = aux;

                    while (current.next != null) {
                        int x = (int) current.data;
                        T xTemp = current.data;
                        int y = (int) current.next.data;
                        T yTemp = current.next.data;

                        if (x > y) {
                            current.next.data = xTemp;
                            current.data = yTemp;
                        }

                        current = current.next;
                    }
                }
                return;
            }

            // Double
            if (type == Double.class) {
                Node aux = this.pFirst;

                for (int i = 0; i < this.size; i++) {
                    Node<T> current = aux;

                    while (current.next != null) {
                        double x = (double) current.data;
                        T xTemp = current.data;
                        double y = (double) current.next.data;
                        T yTemp = current.next.data;

                        if (x > y) {
                            current.next.data = xTemp;
                            current.data = yTemp;
                        }

                        current = current.next;
                    }
                }
            }
        }
    }

    /**
     * Displays the elements of the linked list.
     */
    public void helperShow() {
        Node<T> aux = this.pFirst;

        while (aux != null) {
            System.out.println(aux.data);
            aux = aux.next;
        }
    }

    /**
     * Displays the elements in case that linkedList is type User.
     */
    public void helperShowUser() {
        Node<T> aux = this.pFirst;

        while (aux != null) {
            User user = (User) aux.data;
            System.out.println("ID: " + user.id + " || Username: " + user.user);

            aux = aux.next;
        }
    }

    /**
     * Displays the elements in case that linkedList is type Relations.
     */
    public void helperShowRelations() {
        Node<T> aux = this.pFirst;

        while (aux != null) {
            Relations relation = (Relations) aux.data;
            System.out.println("User 1: " + relation.userOrigin + " || User 2: " + relation.userDestination + " || Time: " + relation.weight);

            aux = aux.next;
        }
    }
}
