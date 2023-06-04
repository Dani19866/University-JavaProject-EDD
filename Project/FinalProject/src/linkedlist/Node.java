/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author Daniel
 * @param <T>
 */
public class Node<T> {
    /**
     * Data saved in node 
     */
    public T data;
    /**
     * Next node of this
     * Uses in LinkedList, Queue, Stack, etc
     */
    public Node<T> next;
    
    /**
     * Create a node with data
     * @param datum Data saved in node
     */
    public Node(T datum){
        this.data = datum;
        this.next = null;
    }
}
