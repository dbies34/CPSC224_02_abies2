/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ica4_dice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ddbie
 */
public class ICA4_Dice extends JFrame{

    private JLabel lblDie1;
    private JLabel lblDie2;
    private JPanel diePanel;
    private JPanel buttonPanel;
    private JButton btnRoll;
    
    ImageIcon[] dieArray = new ImageIcon[6];
    
    public ICA4_Dice(){
        // set title
        setTitle("Dice Simulator");
        // let window close on exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager.
        setLayout(new BorderLayout());

        makeDieArray();
        // Build the panels.
        buildDiePanel();
        buildButtonPanel();
        
        ImageIcon icon = new ImageIcon("Die1.png");
        lblDie1.setIcon(icon);
        
        // add panels to the window
        add(diePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        
        btnRoll.doClick();
        
        // pack and set the window visible
        pack();
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new ICA4_Dice();
    }
    
    // loads dieArray with dice pictures
    private void makeDieArray(){
        for(int i = 0; i < 6; i++){
            dieArray[i] = new ImageIcon("Die" + String.valueOf(i) + ".png");
        }
    }
    
    private void buildDiePanel(){
        diePanel = new JPanel();
        
        lblDie1 = new JLabel("die 1");
        lblDie1.setIcon(dieArray[0]);
        lblDie2 = new JLabel("die 2");
        lblDie2.setIcon(dieArray[1]);
        
        diePanel.add(lblDie1);
        diePanel.add(lblDie2);
    }
    
    private void buildButtonPanel(){
        btnRoll = new JButton("Roll the dice");
        buttonPanel = new JPanel();
        
        btnRoll.addActionListener(new ButtonListener());
        buttonPanel.add(btnRoll);
        pack();
    }
    
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            // two random numbers for the two dice
            int rand1 = (int) (Math.random() * 6);
            int rand2 = (int) (Math.random() * 6);
            
            
            lblDie1.setIcon(dieArray[rand1]);
            lblDie2.setIcon(dieArray[rand2]);
            
            
            lblDie1.setText("die 1: " + rand1);
            lblDie2.setText("die 2: " + rand2);
            
            pack();
        }
    }
}
