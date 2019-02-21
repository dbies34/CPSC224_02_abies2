// TicTactoe.java
// Drew Bies, Patrick
// username: abies2

package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ddbie
 */
public class TicTacToe extends JFrame{

    private PlayerPanel playerOne;
    private PlayerPanel playerTwo;
    private BoardPanel board;
    private ControlPanel controlPanel;
    private JLabel lblTurn;
    
    Player player1 = new Player("Player One", 1);
    Player player2 = new Player("Player Two", 2);
    
    public TicTacToe() {
        // set title for window
        setTitle("Tic Tac Toe");
        setSize(500, 500);
        // let the window close on pressing exit button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create new border layout
        setLayout(new BorderLayout());
        
        // create the custom panels
        playerOne = new PlayerPanel(player1);
        playerTwo = new PlayerPanel(player2);
        board = new BoardPanel();
        controlPanel = new ControlPanel();
        lblTurn = new JLabel("");
        
        // add components to the window
        add(playerOne, BorderLayout.NORTH);
        add(playerTwo, BorderLayout.AFTER_LAST_LINE);
        //add(board);
        add(controlPanel);
        add(lblTurn, BorderLayout.SOUTH);
        
        // get rid of empty spaces and set visible
        //pack();
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new TicTacToe();
        
    }
    
}
