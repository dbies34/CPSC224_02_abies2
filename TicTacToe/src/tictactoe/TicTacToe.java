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
    private JPanel playersPanel;
    private BoardPanel board;
    private ControlPanel controlPanel;
    private JLabel lblTurn;
    
    Player player1 = new Player("Player One", 1);
    Player player2 = new Player("Player Two", 2);
    
    Boolean p1Turn = true;
    
    public TicTacToe() {
        // set title for window
        setTitle("Tic Tac Toe");
        setPreferredSize(new Dimension(500, 500));
        // let the window close on pressing exit button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create new border layout
        setLayout(new BorderLayout());
        
        // create the custom panels
        buildPlayerPanel();
        board = new BoardPanel(this);
        controlPanel = new ControlPanel(this);
        lblTurn = new JLabel("Welcome to Tic Tac Toe!");
        
        
        // add components to the window
        addComponents();
        
        // get rid of empty spaces and set visible
        pack();
        setVisible(true);
        
    }
    
    public void buildPlayerPanel(){
        playersPanel = new JPanel();
        
        playerOne = new PlayerPanel(player1);
        playerTwo = new PlayerPanel(player2);
        playerOne.txtPlayerName.setText("Player 1");
        playerTwo.txtPlayerName.setText("Player 2");
        
        playersPanel.setLayout(new GridLayout(1,2));
        
        playersPanel.add(playerOne);
        playersPanel.add(playerTwo);
        
        
        
        pack();
    }
    
    // adds the components to the window
    public void addComponents(){
        add(playersPanel, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2,1));
        bottom.add(controlPanel);
        bottom.add(lblTurn);
        
        add(bottom, BorderLayout.SOUTH);
    }
    
    public void reset(){
        player2.resetStats();
        player1.resetStats();
        playerOne.txtPlayerName.setText("Player 1");
        playerTwo.txtPlayerName.setText("Player 2");
        playerOne.txtPlayerName.setEditable(true);
        playerTwo.txtPlayerName.setEditable(true);
        playerOne.updateStats(player1);
        playerTwo.updateStats(player2);
        lblTurn.setText("Welcome to Tic Tac Toe!");
        clearBoard();
        freezeBoard();
        p1Turn = true;
    }
    
    public void clearBoard(){
        Component[] comp = board.getComponents();
        for (int i= 0; i < comp.length; i++){
            if (comp[i] instanceof JButton){
                JButton b = (JButton)comp[i];
                b.setText("");
                b.setEnabled(true);
            }
        }
    }
    
    public void startLbl(){
        lblTurn.setText(player1.getName() + "'s turn!");
    }
    
    public void updateNames(){
        playerOne.updateName(player1);
        playerTwo.updateName(player2);
        
    }
    
    public void runGame(JButton b){
        if (p1Turn){
            b.setText("X");
            lblTurn.setText(player2.getName() + "'s turn!");
        } else {
            b.setText("O");
            lblTurn.setText(player1.getName() + "'s turn!");
        }
        if (isGameWon()){
            freezeBoard();
            if (p1Turn){
                lblTurn.setText(player1.getName() + " wins!");
                player1.incrementWins();
                player2.incrementLosses();
            } else {
                lblTurn.setText(player2.getName() + " wins!");
                player2.incrementWins();
                player1.incrementLosses();
            }
            playerOne.updateStats(player1);
            playerTwo.updateStats(player2);
            //lblTurn.setText("Welcome to Tic Tac Toe!");
            p1Turn = false;
        }
        p1Turn = !p1Turn;
    }
    
    public boolean isGameWon(){
        Component[] comp = board.getComponents();
        JButton[] butts = new JButton[9];
        int ind = 0;
        for (int i= 0; i < comp.length; i++){
            if (comp[i] instanceof JButton){
                butts[ind] = (JButton)comp[i];
                ind++;
            }
        }
        if (butts[0].getText().equals(butts[1].getText()) && butts[0].getText().equals(butts[2].getText()) && !(butts[0].getText().equals(""))){
            return true;
        } else if (butts[3].getText().equals(butts[4].getText()) && butts[3].getText().equals(butts[5].getText()) && !(butts[3].getText().equals(""))){
            return true;
        }else if (butts[6].getText().equals(butts[7].getText()) && butts[6].getText().equals(butts[8].getText()) && !(butts[6].getText().equals(""))){
            return true;
        } else if (butts[0].getText().equals(butts[3].getText()) && butts[3].getText().equals(butts[6].getText()) && !(butts[0].getText().equals(""))){
            return true;
        } else if (butts[1].getText().equals(butts[4].getText()) && butts[1].getText().equals(butts[7].getText()) && !(butts[1].getText().equals(""))){
            return true;
        } else if (butts[2].getText().equals(butts[5].getText()) && butts[2].getText().equals(butts[8].getText()) && !(butts[2].getText().equals(""))){
            return true;
        } else if (butts[0].getText().equals(butts[4].getText()) && butts[0].getText().equals(butts[8].getText()) && !(butts[0].getText().equals(""))){
            return true;
        } else if (butts[2].getText().equals(butts[4].getText()) && butts[2].getText().equals(butts[6].getText()) && !(butts[2].getText().equals(""))){
            return true;
        } else {
            return false;
        }
    }
    
    public void freezeBoard(){
        Component[] comp = board.getComponents();
        for (int i= 0; i < comp.length; i++){
            if (comp[i] instanceof JButton){
                JButton b = (JButton)comp[i];
                b.setEnabled(false);
            }
        }
    }
    
    public static void main(String[] args) {
        new TicTacToe();       
    }
}