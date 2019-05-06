// Blackjack.java
// Drew Bies, Patrick S.


package blackjack;

import javax.swing.*;

/**
 *
 * @author ddbie
 */
public class Blackjack extends JFrame {
    
    public Blackjack(Board board){
        add(board);
        pack();
        
        setTitle("Blackjack");
        setResizable(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        Board brd = new Board();
        Blackjack blackjack = new Blackjack(brd);
        blackjack.setVisible(true);
        brd.game();
        
    }
    
}
