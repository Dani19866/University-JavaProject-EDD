/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 * The ListNode class represents a node in a linked list. Each node contains a
 * key and weight value, as well as a reference to the next node in the list.
 * This class is used in the List class to store connections (edges) between
 * nodes.
 *
 * @author Daniel
 */
public class ListNode {

    /**
     * The key represents the identifier or ID associated with the node.
     */
    public int key;
    /**
     * The weight represents the weight or value associated with the connection
     * (edge) to another node.
     */
    public int weight;
    /**
     * The next field is a reference to the next node in the linked list. It is
     * used to establish the connection between nodes.
     */
    public ListNode next;

    /**
     * Constructs a new ListNode with the specified key and weight, and
     * initializes the next reference to null.
     *
     * @param key the identifier or ID associated with the node.
     * @param weight the weight or value associated with the connection (edge)
     * to another node.
     */
    public ListNode(int key, int weight) {
        this.key = key;
        this.weight = weight;
        this.next = null;
    }
}
