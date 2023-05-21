/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphproject.LinkedList;

/**
 *
 * @author Daniel
 */
public class Node<T> {

    private T data;
    private Node<T> next;

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Create a node with data
     *
     * @param value The value of node
     */
    public Node(T value) {
        this.data = value;
        this.next = null;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Change value data of node
     *
     * @param value The new value of node
     */
    public void setData(T value) {
        this.data = value;
    }

    /**
     * Set next node of the chain
     *
     * @param node Set next node to the chain
     */
    public void setNext(Node<T> node) {
        this.next = node;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Return data saved in node
     *
     * @return Data: String, int, double
     */
    public T getData() {
        return this.data;
    }

    /**
     * Returns the next node in the linked list.
     *
     * @return The next node in the linked list.
     */
    public Node<T> getNextNode() {
        return this.next;
    }
    //</editor-fold>
}
