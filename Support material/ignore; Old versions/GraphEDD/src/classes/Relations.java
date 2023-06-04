/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Daniel
 */
public class Relations {
    private int user1;
    private int user2;
    private int time;

    public Relations(int x, int y, int z) {
        this.user1 = x;
        this.user2 = y;
        this.time = z;
    }
    
    public int getUser1(){
        return this.user1;
    }
    
    public int getUser2(){
        return this.user2;
    }
    
    public int getTime(){
        return this.time;
    }
}
