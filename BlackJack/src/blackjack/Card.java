// Card.java


package blackjack;

import java.awt.*;

/**
 *
 * @author ddbie
 */
public class Card {
    
    private Image image;
    
    private int value;
    // ace = 1 or 11, jack = 10, queen = 10, king = 10
    
    //private char suit;   
    // diamonds = d, hearts = h, clubs = c, spades = s
    
    public Card(){
        image = null;
        value = -1;
    }
    
    public Card(Image image, int value){
        this.image = image;
        this.value = value;
    }
    
    public void setImage(Image image){
        this.image = image;
    }
    
    public void setValue(int value){
        this.value = value;
    }
    
    public Image getImage(){
        return image;
    }
    
    public int getValue(){
        return value;
    }
}
