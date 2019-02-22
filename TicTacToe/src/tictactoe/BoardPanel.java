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
public class BoardPanel extends JFrame {
    
    JButton[][] buttonArray = new JButton[3][3];
    public BoardPanel(){
        // set layout to 3 by 3 grid
        setLayout(new GridLayout(3, 3));
        
        
    }
    
    public void buildButtonPanel(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                buttonArray[i][j] = new JButton();
                //buttonArray[i][j].set // set font size
            }
        }
    }
}
