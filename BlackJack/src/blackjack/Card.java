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
    
    private String suit;   
    // diamonds, hearts, clubs, spades
    
    private String name;
    // ace, two, three,.., jack, queen, king
    
    public Card(){
        image = null;
        value = -1;
        suit = null;
        name = null;
    }
    
    public Card(Image image, int value, String suit, String name){
        this.image = image;
        this.value = value;
        this.suit = suit;
        this.name = name;
    }
    
    // setters
    public void setImage(Image image){
        this.image = image;
    }
    
    public void setValue(int value){
        this.value = value;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setSuit(String suit){
        this.suit = suit;
    }
    
    // getters
    public Image getImage(){
        return image;
    }
    
    public int getValue(){
        return value;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSuit(){
        return suit;
    }
    
    @Override
    public String toString(){
        return name + " of " + suit;
    }
}
