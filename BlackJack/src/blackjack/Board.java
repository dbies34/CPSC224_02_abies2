/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author ddbie
 */

public class Board extends JPanel implements ActionListener{
    
    private final int CARD_WIDTH = 200;
    private final int CARD_HEIGHT = 250;
    private final int NUM_OF_DECKS = 2;
    private final int PLAYER_XCOR = 730;
    private final int PLAYER_YCOR = 700;
    private final int DECK_XCOR = 1470;
    private final int DECK_YCOR = 100;
    private final int DEALER_XCOR = 730;
    private final int DEALER_YCOR = 300;
    
    
    private Deck deck;
    private Player player1;
    private Player dealer;
    
    private Image cardBack;
    
    
    
    
    public Board(){
        initBoard();
        //game();
        
    }
    
    private void initBoard(){
        Color dark_green = new Color(0,115,0);
        setBackground(dark_green); 
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        deck = new Deck(NUM_OF_DECKS);
        
        loadCards();
        deck.shuffleDeck(2);
        
        addMouseListener(new MyMouseListener());
        
        player1 = new Player("Player One", 100);
        dealer = new Player("House", 0);
        for(int i = 0; i < 2; i++){
            player1.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());
        }
    }
    
    private void game(){
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
            p1.clearHand();
            p2.clearHand();
            Boolean hit1 = true;
            Boolean hit2 = true;
            p1.addCard(deck.drawCard());
            p2.addCard(deck.drawCard());
            p1.addCard(deck.drawCard());
            p2.addCard(deck.drawCard());
            while(hit1 == true){ //Player 1's turn
                System.out.println("Player 1:");
                p1.hand.displayHand();
                System.out.println("Would you like to hit?: 1/0");
                op = scn.nextInt();
                hit1 = op == 1;
                if (hit1 == true){
                    p1.addCard(deck.drawCard());
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
                hit2 = op == 1;
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
                cont = op == 1;
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
        Image tempImage;
        for(int i = 0; i < 52; i++){
            divider1 = cardNames[i].indexOf('_');
            divider2 = cardNames[i].lastIndexOf('_');
            name = cardNames[i].substring(0, divider1);
            suit = cardNames[i].substring(divider1 + 1, divider2);
            stringValue = cardNames[i].substring(divider2 + 1, cardNames[i].length() - 4);
            ImageIcon tempIcon = new ImageIcon("src/card_faces/" + cardNames[i]);
            tempImage = tempIcon.getImage();
            
            for(int j = 0; j < NUM_OF_DECKS; j++){
                Card newCard = new Card(tempImage, Integer.parseInt(stringValue), suit, name);
                deck.addCard(newCard);
            }
        }
        
        ImageIcon temp = new ImageIcon("src/card_backs/red_back.png");
        cardBack = temp.getImage();
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawHand(g, player1.hand, PLAYER_XCOR, PLAYER_YCOR);
        drawHand(g, dealer.hand, DEALER_XCOR, DEALER_YCOR);
        drawDeck(g);
    }
    
    public void drawHand(Graphics g, Hand hand, int xcor, int ycor){
        for(int i = 0; i < hand.getNumOfCards(); i++){
            g.drawImage(hand.cards[i].getImage(), xcor + i * 40, ycor, CARD_WIDTH, CARD_HEIGHT, this);
        }
    }
    
    public void drawDeck(Graphics g){
        for(int i = 0; i < 10; i++){
            g.drawImage(cardBack, DECK_XCOR + i * 10, DECK_YCOR, CARD_WIDTH, CARD_HEIGHT, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    private class hitBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("you hit");
        }
    }
    
    private class MyMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e){
            //JOptionPane.showMessageDialog(null, "mouse click at (" + e.getX() + ", " + e.getY() + ")");
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
