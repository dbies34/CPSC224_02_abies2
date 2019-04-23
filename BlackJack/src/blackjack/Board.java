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
import java.util.*;

/**
 *
 * @author ddbie
 */

public class Board extends JPanel implements ActionListener{
    
    private final int CARD_WIDTH = 200;
    private final int CARD_HEIGHT = 250;
    private final int NUM_OF_DECKS = 1;
    
    public Deck deck;
   
    
    private int playerXCor;
    private int playerYCor;
    private int deckXCor;
    private int deckYCor;
    private int dealerXCor;
    private int dealerYCor;
    
    
    public Board(){
        initBoard();
        game();
    }
    
    
    private void initBoard(){
        Color dark_green = new Color(0,115,0);
        setBackground(dark_green); 
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        deck = new Deck (NUM_OF_DECKS);
        loadCards();
       //deck.displayDeck();
       addMouseListener(new MyMouseListener());
   }
    
    public void game(){
        Scanner scn = new Scanner(System.in);
        Boolean cont = true;
        int op;
        Player p1 = new Player("Player 1", 0);
        Player p2 = new Player("Player 2", 0);
        while (cont){ //Game Loop
            JButton hitButton = new JButton("HIT");
            hitButton.addActionListener(new hitBtnListener());
            add(hitButton);
            deck.shuffleDeck(1);
            p1.hand.clearHand();
            p2.hand.clearHand();
            Boolean hit1 = true;
            Boolean hit2 = true;
            p1.hand.addCard(deck.drawCard());
            p2.hand.addCard(deck.drawCard());
            p1.hand.addCard(deck.drawCard());
            p2.hand.addCard(deck.drawCard());
            while(hit1 == true){ //Player 1's turn
                System.out.println("Player 1:");
                p1.hand.displayHand();
                System.out.println("Would you like to hit?: 1/0");
                op = scn.nextInt();
                if (op == 1){
                    hit1 = true;
                } else{
                    hit1 = false;
                }
                if (hit1 == true){
                    p1.hand.addCard(deck.drawCard());
                    System.out.println(p1.hand.getTotal());
                } 
                if (p1.hasBlackjack()){
                    hit1 = false;
                    System.out.println("Blackjack!");
                }
                if (p1.hasBust()){
                    hit1 = false;
                    System.out.println("Bust!");
                } 
            }
            while(hit2 == true){ //Player 2's turn
                System.out.println("Player 2:");
                p2.hand.displayHand();
                System.out.println("Would you like to hit?: 1/0");
                op = scn.nextInt();
                if (op == 1){
                    hit2 = true;
                } else{
                    hit2 = false;
                }
                if (hit2 == true){
                    p2.hand.addCard(deck.drawCard());
                    System.out.println(p2.hand.getTotal());
                } 
                if (p2.hasBlackjack()){
                    hit2 = false;
                    System.out.println("Blackjack!");
                }
                if (p2.hasBust()){
                    hit2 = false;
                    System.out.println("Bust!");
                } 
        }
       if ((p1.hand.getTotal() > p2.hand.getTotal() && !p1.hasBust()) || !p1.hasBust() && p2.hasBust()){
           System.out.println("Player 1 wins!");
       }
       else if ((p2.hand.getTotal() > p1.hand.getTotal() && !p2.hasBust()) || !p2.hasBust() && p1.hasBust()){
           System.out.println("Player 2 wins!");
       }
       System.out.println("Would you like to play again?: 1/0");
                op = scn.nextInt();
                if (op == 1){
                    cont = true;
                } else {
                    cont = false;
                }
    }        
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
            ImageIcon tempIcon = new ImageIcon(cardNames[i]);
            
            for(int j = 0; j < NUM_OF_DECKS; j++){
                Card newCard = new Card(tempIcon.getImage(), Integer.parseInt(stringValue), suit, name);
                deck.addCard(newCard);
                //System.out.println(newCard.toString());
            }
        }
        
    }
    

    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    private class hitBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("YOU HIT");
        }
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
