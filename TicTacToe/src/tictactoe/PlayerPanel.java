/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author ddbie
 */
public class PlayerPanel extends JPanel {
    
    JLabel lblPlayerName;
    JTextField txtPlayerName;
    JLabel lblPlayerWins;
    JTextField txtPlayerWins;
    JLabel lblPlayerLosses;
    JTextField txtPlayerLosses;
    
    public PlayerPanel(Player player){
        setLayout(new GridLayout(0,2));
        //setSize(50, 50);
        
        //JPanel players = new JPanel();
        
        
        lblPlayerName = new JLabel("Name:");
        txtPlayerName = new JTextField();
        lblPlayerWins = new JLabel("Wins:");
        txtPlayerWins = new JTextField();
        lblPlayerLosses = new JLabel("Losses:");
        txtPlayerLosses = new JTextField();
        
        txtPlayerWins.setEditable(false);
        txtPlayerLosses.setEditable(false);
        txtPlayerName.setColumns(8);
        
        
        
        setBorder(BorderFactory.createTitledBorder(getPlayerTitle(player.getPNum())));
        
        add(lblPlayerName);
        add(txtPlayerName);
        add(lblPlayerWins);
        add(txtPlayerWins);
        add(lblPlayerLosses);
        add(txtPlayerLosses);
        
        
        
        
   
    }
    
    public static String getPlayerTitle(int playerNum){
        String playerNumString = String.valueOf(playerNum);
        char xo;
        if(playerNum == 1){
            xo = 'X';
        } else{
            xo = 'O';
        }
        return "Player " + playerNumString + " (" + xo + "):";
    }
    
    public void updateStats(Player player){
        txtPlayerWins.setText(Integer.toString(player.getWins()));
        txtPlayerLosses.setText(Integer.toString(player.getLosses()));
        txtPlayerName.setEditable(true);
    }
    
    public void updateName(Player player){
        player.setName(txtPlayerName.getText());
        //txtPlayerName.setEditable(false);
    }
    
}