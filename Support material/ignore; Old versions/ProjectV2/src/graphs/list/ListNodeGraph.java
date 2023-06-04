/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.list;

/**
 *
 * @author Daniel
 */
public class ListNodeGraph {
    public int key;
    public int weight;
    public ListNodeGraph next;
    
    public ListNodeGraph(int key, int weight){
        this.key = key;
        this.weight = weight;
        this.next = null;
    }
}
