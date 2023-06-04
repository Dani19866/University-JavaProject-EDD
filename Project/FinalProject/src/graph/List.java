/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import utils.User;
import utils.Utils;

/**
 * The List class represents a node in a graph and stores connections (edges) to
 * other nodes. Each List instance represents a user in the graph and contains
 * information about the user as well. The connections are stored using a linked
 * list structure, where each node in the list represents an edge to another
 * user. This class provides methods to add and remove edges from the list of
 * connections.
 *
 * @author Daniel
 */
public class List {

    /**
     * The chain represents the connections (edges) of the node. It uses
     * ListNode objects to store the connections in a linked list structure.
     */
    public ListNode chain;
    /**
     * The user field represents information about the user associated with the
     * node. It stores an instance of the User class.
     */
    public User user;

    /**
     * Constructs a new List instance with the specified user and initializes
     * the chain to null.
     *
     * @param user the User object representing the user associated with the
     * node.
     */
    public List(User user) {
        this.user = user;
        this.chain = null;
    }

    /**
     * Adds an edge to the list of connections with the specified destination
     * user and weight. Creates a new ListNode object with the destination
     * user's ID and weight, and adds it to the end of the chain.
     *
     * @param destination the User object representing the destination user of
     * the edge.
     * @param weight the weight of the edge.
     */
    public void addEdgeInList(User destination, int weight) {
        ListNode edge = new ListNode(destination.id, weight);
        ListNode aux = chain;

        if (chain == null) {
            chain = edge;
        } else {
            while (aux.next != null) {
                aux = aux.next;
            }

            aux.next = edge;
        }

    }

    /**
     * Removes the edge with the specified destination from the list of
     * connections. If the chain is empty, it throws an error. If the first node
     * in the chain has the specified destination, it updates the chain to skip
     * the first node. Otherwise, it searches for the node with the given
     * destination and removes it from the chain.
     *
     * @param destination the ID of the destination user of the edge to be
     * removed.
     */
    public void delEdgeInList(int destination) {
        if (chain == null) {
            Utils.errorEmptyRelation();
        } else if (chain.key == destination) {
            chain = chain.next;
        } else {
            ListNode prev = chain;
            ListNode curr = chain.next;

            while (curr != null) {
                if (curr.key == destination) {
                    prev.next = curr.next;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }
}
