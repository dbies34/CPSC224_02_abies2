// Blackjack.java
// Drew Bies, Patrick S.


package blackjack;

import javax.swing.*;

/**
 *
 * @author ddbie
 */
public class Blackjack extends JFrame {
    
    public Blackjack(){
        Board b = new Board();
        add(b);
        pack();
        
        setTitle("Blackjack");
        setResizable(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        blackjack.setVisible(true);
    }
    
    
}
    
