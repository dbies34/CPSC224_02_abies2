/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author ddbie
 */
public class Player {
    public Hand hand;
    
    private int chips;
    
    private String name;
    
    public Player(){
        hand = new Hand();
        chips = 0;
        name = null;
    }
    
    public Player(String name, int chips){
        hand = new Hand();
        this.chips = chips;
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public int getScore(){
        return hand.getTotal();
    }
    
    public int getChips(){
        return chips;
    }
    
    public void setChips(int chips){
        this.chips = chips;
    }
    
    public void removeChips(int num){
        chips -= num;
    }
    
    public void addChips(int num){
        chips += num;
    }
    
    public boolean isBankrupt(){
        return chips <= 0;
    }
    
    public boolean hasBlackjack(){
        return hand.isBlackjack();
    }
    
    public boolean hasBust(){
        return hand.isBust();
    }
}
