/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

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
        setLayout(new GridLayout(3, 2));
        
        
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
    
    public void displayWins(int wins){
        txtPlayerWins.setText(String.valueOf(wins));
    }
    
    public void displayLosses(int losses){
        txtPlayerLosses.setText(String.valueOf(losses));
    }
    
    public void displayName(String name){
        txtPlayerName.setText(name);
    }
}
 