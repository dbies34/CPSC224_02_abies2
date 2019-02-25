/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ddbie
 */
public class BoardPanel extends JPanel {
    
    JButton[][] buttonArray = new JButton[3][3];
    public TicTacToe parent;
    public BoardPanel(TicTacToe p){
        parent = p;
        // set layout to 3 by 3 grid
        setLayout(new GridLayout(3, 3));
        buildButtonPanels();

        
        
    }
    
    public void buildButtonPanels(){
        JPanel buttons = new JPanel();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                buttonArray[i][j] = new JButton();
                //buttonArray[i][j].set // set font size
                JButton b = new JButton();
                b = buttonArray[i][j];
                b.addActionListener(new btnPlayListener());
                b.setEnabled(false);
                add(b);
            }
        }
        ///add(buttons, BorderLayout.CENTER);
    }
    private class btnPlayListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JButton source = (JButton)e.getSource();
            if (source.getText().equals("")){
                parent.runGame(source);
            }
        }
    }
}