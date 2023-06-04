/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

import user.Relations;
import user.User;

/**
 * Flex linkedList to create a list of all types
 *
 * Its flex because have functions to work with User and Relations classes
 *
 * @author Daniel
 * @param <T> Defines class type (Integer, String, User, Relations, etc)
 */
public class LinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor for create list without initial data
     *
     */
    public LinkedList() {
        this.lastNode = null;
        this.firstNode = null;
        this.size = 0;
    }

    /**
     * Constructor for create list with initial data
     *
     * @param value Set value. Is the initial value
     */
    public LinkedList(T value) {
        Node<T> n = new Node(value);
        this.firstNode = n;
        this.lastNode = n;
        this.size++;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Return head of linkedList
     *
     * @return Return head of linkedList
     */
    public Node<T> getHead() {
        return this.firstNode;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Additives">
    /**
     * Add value in the last position
     *
     * @param value Value to add
     */
    public void addLast(T value) {
        Node<T> newNode = new Node(value);

        this.size++;
        if (isEmpty()) {
            this.firstNode = this.lastNode = newNode;
        } else {
            this.lastNode.setNext(newNode);
            this.lastNode = newNode;
        }
    }

    /**
     * Add value in the first position
     *
     * @param value Value to add
     */
    public void addFirst(T value) {
        Node<T> newNode = new Node(value);

        this.size++;
        if (isEmpty()) {
            this.firstNode = this.lastNode = newNode;
        } else {
            newNode.setNext(this.firstNode);
            this.firstNode = newNode;
        }
    }

    /**
     * Add values in a determinate position
     *
     * @param value Value of data
     * @param position Position in list
     */
    public void add(T value, int position) {
        // Invalid position: -1, -100, -44
        if (position < 0) {
            throw new IndexOutOfBoundsException("Position is lower than 0");
        } // Invalid position (Size = 10): 11, 15, 20
        else if (position > this.size - 1) {
            throw new IndexOutOfBoundsException("Position is higher that size list");
        } // If list is empty
        else if (this.isEmpty() || position == 0) {
            this.addFirst(value);
        } // If is the last position
        else if (position == this.size - 1) {
            this.addLast(value);
        } // Search position
        else {
            Node<T> n = new Node(value);

            // 1. Firts, take a head of the list to for to the specific position. Second,
            // count the position
            Node<T> aux = this.firstNode;
            int count = 0;

            // 2. For all the list to go to the specific position
            while (count < position - 1) {
                aux = aux.getNextNode();
                count++;
            }

            // 3. Update chain
            n.setNext(aux.getNextNode());
            aux.setNext(n);
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Removers">
    /**
     * Delete last value (node) of list (chain)
     */
    public void deleteLast() {
        if (this.isEmpty()); else {
            LinkedList<T> newList = new LinkedList<>();
            Node aux = this.firstNode;

            for (int i = 0; i < this.size - 1; i++) {
                newList.addLast((T) aux.getData());
                aux = aux.getNextNode();
            }

            this.firstNode = newList.firstNode;
            this.lastNode = newList.lastNode;
            this.size--;
        }
    }

    /**
     * Delete first value (node) of list (chain)
     */
    public void deleteFirst() {
        if (this.isEmpty()); else {
            this.firstNode = this.firstNode.getNextNode();
            this.size--;
        }
    }

    /**
     * Function to eliminate a data (node reality) of list (chain)
     *
     * @param position Position to eliminate
     */
    public void delete(int position) {
        if (this.isEmpty())
            ; else {
            // Position < 0: Error
            if (position < 0) {
                throw new IndexOutOfBoundsException("Position is lower than 0");
            } // Position > size - 1: Error
            else if (position > this.size - 1) {
                throw new IndexOutOfBoundsException("Position is higher that size list");
            } // Position = 0: Firts
            else if (position == 0) {
                this.deleteFirst();
            } // Position = Size - 1: Last
            else if (position == this.size - 1) {
                this.deleteLast();
            } // Position ex: 7
            else {
                Node<T> aux = this.firstNode;

                for (int i = 0; i < position - 1; i++) {
                    aux = aux.getNextNode();
                }

                aux.setNext(aux.getNextNode().getNextNode());
                this.size--;
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Features">
    /**
     * Returns whether the list is empty or not.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (this.firstNode == null);
    }

    /**
     * Returns the element at a specific position in the list.
     *
     * @param position The position of the element to return.
     * @return The element at the specified position, or null if the position is
     * invalid.
     */
    public T get(int position) {
        if (position < 0 || position >= this.size) {
            throw new IndexOutOfBoundsException("Position invalid: '" + position + "'");
        }

        Node<T> currentNode = this.firstNode;
        for (int i = 0; i < position; i++) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode.getData();
    }

    /**
     * Verify if back to front is equals front to back
     *
     * @return Return true/false if class is palindrome
     */
    public boolean getPalindrome() {
        LinkedList<T> compareer = new LinkedList<>();
        Node<T> aux = this.firstNode;

        // Algorithm
        while (aux != null) {
            compareer.addFirst(aux.getData());
            aux = aux.getNextNode();
        }
        compareer.lastNode.setNext(null);

        // Algorithm
        boolean returned = true;
        aux = this.firstNode;
        Node<T> aux2 = compareer.firstNode;
        while (aux != null) {
            if (aux.getData() != aux2.getData()) {
                returned = false;
                break;
            }

            aux2 = aux2.getNextNode();
            aux = aux.getNextNode();
        }

        return returned;
    }

    /**
     * Order list to lower at higher numbers. Finish with string type
     */
    public void order() {
        // List empty
        if (this.isEmpty()); // List with 1 item
        else if (this.size == 1); // List with +1 item
        else {
            // String
            if (this.firstNode.getData().getClass() == String.class) {

            } // Integer
            else if (this.firstNode.getData().getClass() == Integer.class) {
                Node<T> aux = this.firstNode;

                for (int i = 0; i < this.size; i++) {
                    Node<T> current = aux;

                    while (current.getNextNode() != null) {
                        int x = (int) current.getData();
                        T xTemp = current.getData();
                        int y = (int) current.getNextNode().getData();
                        T yTemp = current.getNextNode().getData();

                        if (x > y) {
                            current.getNextNode().setData(xTemp);
                            current.setData(yTemp);
                        }

                        current = current.getNextNode();
                    }
                }

            } // Double
            else if (this.firstNode.getData().getClass() == Double.class) {
                Node<T> aux = this.firstNode;

                for (int i = 0; i < this.size; i++) {
                    Node<T> current = aux;

                    while (current.getNextNode() != null) {
                        double x = (double) current.getData();
                        T xTemp = current.getData();
                        double y = (double) current.getNextNode().getData();
                        T yTemp = current.getNextNode().getData();

                        if (x > y) {
                            current.getNextNode().setData(xTemp);
                            current.setData(yTemp);
                        }

                        current = current.getNextNode();
                    }
                }

            } // Error
            else {
                throw new ClassCastException("Only work with string, integer and double");
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Helpers">
    /**
     * This is for view the data in list IN CONSOLE
     *
     */
    public void helperShow() {
        Node<T> aux = this.firstNode;

        while (aux != null) {
            T value = aux.getData();
            System.out.println(value);

            aux = aux.getNextNode();
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Flex user class functions">
    /**
     * Searches for a user in the linked list.
     *
     * @param user The user to search for.
     * @return {@code true} if the user is found, {@code false} otherwise.
     */
    public boolean searchUser(User user) {
        Node<T> aux = this.firstNode;

        while (aux != null) {
            User compareer = (User) aux.getData();
            // ------------------------------
            if (compareer.id == user.id && compareer.user.equals(user.user)) {
                return true;
            }
            // ------------------------------
            aux = aux.getNextNode();
        }

        return false;
    }

    /**
     * Searches for a user in the linked list and returns its index position.
     *
     * @param user The user to search for.
     * @return The index position of the user if found, or -1 if not found.
     */
    public int searchIndex(User user) {
        Node<T> aux = this.firstNode;
        int position = 0;

        while (aux != null) {
            User compareer = (User) aux.getData();
            // ------------------------------
            if (compareer.id == user.id && compareer.user.equals(user.user)) {
                return position;
            }
            position++;
            // ------------------------------
            aux = aux.getNextNode();
        }

        return position;
    }

    /**
     * Searches for a user with the given ID in the linked list and returns the
     * corresponding user name.
     *
     * @param id The ID of the user to search for.
     * @return The user name corresponding to the given ID, or {@code null} if
     * not found.
     */
    public String searchUserWithID(int id) {
        Node<T> users = this.firstNode;
        while (users != null) {
            User user = (User) users.getData();
            if (user.id == id) {
                return user.user;
            }
            users = users.getNextNode();
        }
        return null;
    }

    public User searchUserWithSource(int id){
        Node<T> aux = firstNode;
        User user = new User(-1, null);
        
        for (int i = 0; i < id; i++) {
            user = (User) aux.getData();
            aux = aux.getNextNode();
        }
        
        return user;
    }
    // <editor-fold defaultstate="collapsed" desc="Helpers">
    public void helperShowUser() {
        Node<T> aux = this.firstNode;

        while (aux != null) {
            User user = (User) aux.getData();
            System.out.println("ID: " + user.id + " || Username: " + user.user);

            aux = aux.getNextNode();
        }
    }
    // </editor-fold>
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Flex relations class functions">
    // <editor-fold defaultstate="collapsed" desc="Helpers">
    public void helperShowRelations() {
        Node<T> aux = this.firstNode;

        while (aux != null) {
            Relations relation = (Relations) aux.getData();
            System.out.println("User 1: " + relation.userOrigin + " || User 2: " + relation.userDestination + " || Time: " + relation.weight);

            aux = aux.getNextNode();
        }
    }
    // </editor-fold>
    // </editor-fold>
}
