/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author ddbie
 */

public class Board extends JPanel implements ActionListener{
    
    private final int CARD_WIDTH = 200;
    private final int CARD_HEIGHT = 250;
    
    private int playerXCor;
    private int playerYCor;
    private int deckXCor;
    private int deckYCor;
    private int dealerXCor;
    private int dealerYCor;
    
    
    public Board(){
        initBoard();
    }
    
    private void initBoard(){
        Color dark_green = new Color(0,115,0);
        setBackground(dark_green); 
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        loadCards();
        
        addMouseListener(new MyMouseListener());
    }
    
    private void loadCards(){
        File cardFile = new File("src/card_faces/");
        if(!cardFile.exists()){
            JOptionPane.showMessageDialog(this, "ERROR: could not find card image file.");
            System.exit(1);
        }
        String cardNames[] = cardFile.list();
        // card png names go by: name_suit_value.png
        String name, suit, stringValue;
        int divider1, divider2;
        for(int i = 0; i < 52; i++){
            divider1 = cardNames[i].indexOf('_');
            divider2 = cardNames[i].lastIndexOf('_');
            name = cardNames[i].substring(0, divider1);
            suit = cardNames[i].substring(divider1 + 1, divider2);
            stringValue = cardNames[i].substring(divider2 + 1, cardNames[i].length() - 4);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    private class MyMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e){
            
        }
        
        @Override
        public void mousePressed(MouseEvent e){}
        
        @Override
        public void mouseReleased(MouseEvent e){}
        
        @Override
        public void mouseExited(MouseEvent e){}
        
        @Override
        public void mouseEntered(MouseEvent e){}
    }
}
