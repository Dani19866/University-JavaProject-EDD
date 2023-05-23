/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Daniel
 */
public class User {
    private int id;
    private String user;

    public User(int x, String y) {
        this.id = x;
        this.user = y;
    }

    public void setId(int x) {
        this.id = x;
    }

    public void setUser(String x) {
        this.user = x;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getUser(){
        return this.user;
    }
}
