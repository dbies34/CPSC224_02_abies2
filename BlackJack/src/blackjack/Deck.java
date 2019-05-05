// Deck.java

package blackjack;

import java.util.Random;

/**
 *
 * @author ddbie
 */
public class Deck {
    private int numOfCards;
    private int totalNumOfCards;
    public Card cards[];

    public Deck(int numOfDecks){
        numOfCards = 0;
        totalNumOfCards = numOfDecks * 52;
        cards = new Card[totalNumOfCards];
    }
    
    public boolean addCard(Card card){
        if(numOfCards < totalNumOfCards){
            cards[numOfCards++] = card;
            return true;
        }else{
            System.out.println("card not added: " + card.toString());
            return false;
        }
    }
    
    public Card drawCard(){
        return cards[--numOfCards];
    }
    
    // shuffles the cards num amount of times
    public void shuffleDeck(int num){
        Random rand = new Random();
        int r; Card temp;
        
        for(int j = 0; j < num; j++){
            for(int i = 0; i < numOfCards; i++){
                r = rand.nextInt(numOfCards);
                temp = cards[i];
                cards[i] = cards[r];
                cards[r] = temp;
            }
        }
    }
    
    public boolean isEmpty(){
        return numOfCards <= 0;
    }
    
    // returns actual number of cards
    public int getNumOfCards(){
        return numOfCards;
    }
}
