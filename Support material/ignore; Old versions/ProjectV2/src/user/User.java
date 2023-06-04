/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 * Class to create a user
 * 
 * This is important to create a nodes (vertex) for graph
 * 
 * @author Daniel
 */
public class User {
    public int id;
    public String user;

    /**
     * 
     * @param x ID of user
     * @param y Username of user
     */
    public User(int x, String y) {
        this.id = x;
        this.user = y;
    }
}
