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
    private Node head;
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">   
    public LinkedList() {
        this.head = null;
    }
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Getters"> 
    public Node getHead() {
        return head;
    }
    // </editor-fold> 
}
