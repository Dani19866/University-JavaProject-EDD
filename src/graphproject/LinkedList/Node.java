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
    T data;
    Node next;

    // <editor-fold defaultstate="collapsed" desc="Constructor">   
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Getters">   
    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Setters">   
    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    // </editor-fold> 
}
