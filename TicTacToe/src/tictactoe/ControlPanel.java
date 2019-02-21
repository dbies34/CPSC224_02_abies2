/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ddbie
 */
public class ControlPanel extends JPanel {
    
    private JButton btnNewGame;
    private JButton btnResetGame;
    private JButton btnExitGame;
    private ButtonGroup bg;
    
    public ControlPanel(){
        // one row, three columns
        setLayout(new GridLayout(1, 3));
        
        btnNewGame = new JButton("New Game");
        btnResetGame = new JButton("Reset");
        btnExitGame = new JButton("Exit");
        
        // intialize action listeners
        btnNewGame.addActionListener(new btnNewGameListener());
        btnResetGame.addActionListener(new btnResetGameListener());
        btnExitGame.addActionListener(new btnExitGameListener());
        
        // control button group
        bg = new ButtonGroup();
        bg.add(btnNewGame);
        bg.add(btnResetGame);
        bg.add(btnExitGame);
        
        // add buttons
        add(btnNewGame);
        add(btnResetGame);
        add(btnExitGame);
    }
    
    private class btnNewGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want a new game? Wins and Losses will reset.", "New Game?", JOptionPane.YES_NO_OPTION);
            // 0 = confirm , 1 = no
            if(input == 0){
                //player1.resetStats();
                //player2.resetStats();
            }
        }
    }
    
    private class btnResetGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset? Wins and Losses will reset.", "Reset Game?", JOptionPane.YES_NO_OPTION);
            // 0 = confirm , 1 = no
            if(input == 0){
                //player1.resetStats();
                //player2.resetStats();
            }
        }
    }
    
    private class btnExitGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit? Wins and Losses will be lost.", "Exit?", JOptionPane.YES_NO_OPTION);
            // 0 = confirm , 1 = no
            if(input == 0)
                System.exit(0);
        }
    }
}
