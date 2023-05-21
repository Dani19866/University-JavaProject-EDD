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
public class LinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    // Ready: 2
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

    // Ready: 1
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    public int getSize() {
        return this.size;
    }
    
    public Node<T> getHead(){
        return this.firstNode;
    }
    //</editor-fold>

    // Ready: 3
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

    // Ready: 3
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

    // Ready: 4
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

    // Ready: 1
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
}