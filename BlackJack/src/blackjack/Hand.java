// Hand.java

package blackjack;

/**
 *
 * @author ddbie
 */
public class Hand {
    
    
    private final int MAX_NUM = 8;
    
    private int numOfCards;
    private int numOfAces;
    
    private Card cards[];
    
    public Hand(){
        numOfCards = 0;
        numOfAces = 0;
        cards = new Card[MAX_NUM];
    }
    
    public boolean addCard(Card card){
        if(numOfCards <= MAX_NUM){
            cards[numOfCards] = card;
            numOfCards++;
            if(card.getValue() == 1)
                numOfAces++;
            return true;
        }else{
            return false;
        }
    }
    
    public void clearHand(){
        while(numOfCards > 0){
            cards[numOfCards] = null;
            numOfCards--;
        }
        numOfAces = 0;
    }
    
    public boolean isBust(){
        return getTotal() > 21;
    }
    
    public boolean isBlackjack(){
        return getTotal() == 21;
    }
    
    public int getTotal(){
        int total = 0;
        
        for(int i = 0; i < numOfCards; i++){
            total += cards[i].getValue();
        }
        if(numOfAces > 0 && total + 10 <= 21)
            total += 10;
        
        return total;
    }
    
    public int getNumOfCards(){
        return numOfCards++;
    }
    
    public void displayHand(){
        for (int i = 0; i < numOfCards; i++){
            System.out.print(cards[i].toString() + " ");
        }
        System.out.println("");
    }
}
