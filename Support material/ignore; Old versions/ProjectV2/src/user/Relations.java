/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 * Class for create a relation of nodes with weight
 * @author Daniel
 */
public class Relations {
    public int userOrigin;
    public int userDestination;
    public int weight;

    /**
     * @param x ID of user origin
     * @param y ID of user destination
     * @param z Weight of relation
     */
    public Relations(int x, int y, int z) {
        this.userOrigin = x;
        this.userDestination = y;
        this.weight = z;
    }
}
