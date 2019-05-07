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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private int pot = 0;
    
    private final Object[] wagerAmounts = {"1", "2", "5", "10", "25", "50", "100", "250", "500", "1000"};
    
    private JLabel status = new JLabel("Welcome to Blackjack!");
    private JLabel potText = new JLabel("Pot: " + pot);
    private JLabel playerTokens = new JLabel("          Player Tokens: " + 100);
    
    private Deck deck;
    
    private Player player1;
    private Player dealer;
    
    private Image cardBack;
    
    private Boolean turn1;
    private Boolean hit1;
    private Boolean advance;
    private Boolean turnD;
    private Boolean handOver = false;
   
    
    public Board(){
       initBoard(); 
    }
    
    private void initBoard(){
        Color dark_green = new Color(0,115,0);
        setBackground(dark_green); 
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        deck = new Deck(NUM_OF_DECKS);
        
        loadCards();
        deck.shuffleDeck(2);
        
        addMouseListener(new MyMouseListener());
        JButton hitButton = new JButton("HIT");
        hitButton.addActionListener(new hitBtnListener());
        add(hitButton);
        JButton stayButton = new JButton("STAY");
        stayButton.addActionListener(new stayBtnListener());
        add(stayButton);
    }
    public void initGame(){
        turn1 = true;
        hit1 = false;
        turnD = true;
        for(int i = 0; i < 2; i++){
            player1.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());
        }
    }
    
    public void game(){
        Boolean cont = true;
        player1 = new Player("Player One", 100);
        dealer = new Player("House", 0);
        status.setFont(new Font("Serif", Font.BOLD, 36));
        potText.setFont(new Font("Serif", Font.BOLD, 36));
        playerTokens.setFont(new Font("Serif", Font.BOLD, 36));
        add(status);
        add(potText);
        add(playerTokens);
        Boolean haveBet;
        while (cont){ //Game Loop
            handOver = false;
            haveBet = false;
            initGame();
            deck.shuffleDeck(1);
            while(turn1 == true){ //Player 1's turn
                //player1.hand.displayHand();
                if (haveBet == false){
                    status.setText("How much would you like to wager?");
                    String wagerS = (String)JOptionPane.showInputDialog(null, "Wager Amount:", "Wager", JOptionPane.PLAIN_MESSAGE, null, wagerAmounts, "1");
                    int wager = Integer.parseInt(wagerS);
                    if (wager >= player1.getChips()){
                        JOptionPane.showMessageDialog(this, "Warning: You are going all in!");
                        wager = player1.getChips();
                    }
                    player1.removeChips(wager);
                    pot += wager;
                    potText.setText("Pot: " + pot);
                    status.setText("Dealer Bets " + wager + "!");
                    playerTokens.setText("          Player Tokens: " + player1.getChips());
                    try {
                            Thread.sleep(1500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    pot += wager;
                    potText.setText("Pot: " + pot);
                    haveBet = true;
                }
                if (player1.hasBlackjack()){
                    turn1 = false;
                    status.setText("BlackJack!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                status.setText("Would you like to hit?");
                advance = false;
                while (!advance){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (hit1 == true){
                    player1.addCard(deck.drawCard());
                    repaint();
                    hit1 = false;
                } 
                if (player1.hasBlackjack()){
                    turn1 = false;
                    status.setText("BlackJack!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (player1.hasBust()){
                    turn1 = false;
                    status.setText("Bust!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            }
            while(turnD == true){ //Player 2's turn
                if (dealer.hand.getTotal() < 17){
                    dealer.hand.addCard(deck.drawCard());
                    status.setText("Dealer Hit!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    repaint();
                } 
                if (dealer.hasBlackjack()){
                    turnD = false;
                    status.setText("Dealer Got Blackjack!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (dealer.hasBust()){
                    turnD = false;
                    status.setText("Dealer Bust!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    repaint();
                    turnD = false;
                }
        }
        handOver = true;
        repaint();
       if ((player1.hand.getTotal() > dealer.hand.getTotal() && !player1.hasBust()) || !player1.hasBust() && dealer.hasBust()){
           JOptionPane.showMessageDialog(null, "Player Wins! You won " + pot + " tokens!");
           status.setText("Player Wins!");
           player1.addChips(pot);
           playerTokens.setText("          Player Tokens: " + player1.getChips());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
       }
       else if ((dealer.hand.getTotal() > player1.hand.getTotal() && !dealer.hasBust()) || !dealer.hasBust() && player1.hasBust()){
           JOptionPane.showMessageDialog(null, "Dealer Wins!");
           status.setText("Dealer Wins!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
       }
       else {
           JOptionPane.showMessageDialog(null, "Push! Dealer Wins!");
           status.setText("Push! Dealer Wins!");
       }
       pot = 0;
       potText.setText("Pot: " + pot);
       if (player1.getChips() < 1){
                JOptionPane.showMessageDialog(this, "Sorry, you are out of chips.  Please \nleave the table and come back later!");
                System.exit(0);
            }
       int n = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
       if (n == 0){
           cont = true;
       } else{
           System.exit(0);
       }
       dealer.hand.clearHand();
       player1.hand.clearHand();
       repaint();
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
        if (handOver){
            drawHand(g, dealer.hand, DEALER_XCOR, DEALER_YCOR-1);
        }else{
            drawHand(g, dealer.hand, DEALER_XCOR, DEALER_YCOR);
        }
        drawDeck(g);
    }
    
    public void drawHand(Graphics g, Hand hand, int xcor, int ycor){
        for(int i = 0; i < hand.getNumOfCards(); i++){
            if (i == 0 && (ycor == DEALER_YCOR)){
                g.drawImage(cardBack, xcor + i * 40, ycor, CARD_WIDTH, CARD_HEIGHT, this);
            }else {
                g.drawImage(hand.cards[i].getImage(), xcor + i * 40, ycor, CARD_WIDTH, CARD_HEIGHT, this);
            }
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
            hit1 = true;
            advance = true;
        }
    }
    
    private class stayBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            turn1 = false;
            advance = true;
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
