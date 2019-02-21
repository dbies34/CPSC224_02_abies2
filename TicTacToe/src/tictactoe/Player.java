/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author ddbie
 */
public class Player {
    private String name;
    private int pNum;
    private int wins;
    private int losses;
    
    public Player(String name, int pNum){
        this.name = name;
        this.pNum = pNum;
        wins = 0;
        losses = 0;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void incrementWins(){
        wins++;
    }
    
    public void incrementLosses(){
        losses++;
    }
    
    public void resetStats(){
        wins = 0;
        losses = 0;
    }
    
    public int getWins(){
        return wins;
    }
    
    public int getLosses(){
        return losses;
    }

    public String getName(){
        return name;
    }
    
    public int getPNum(){
        return pNum;                
    }
}
