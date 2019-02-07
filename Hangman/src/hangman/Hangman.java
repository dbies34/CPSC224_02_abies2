/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import javax.swing.JOptionPane;

/**
 *
 * @author ddbie
 */


public class Hangman {

    /**
     * @param args the command line arguments
     */
    final static String[] WORDS = {"Awkward", "Bagpipes", "Banjo", "Bungler", "Croquet",
        "Crypt", "Dwarves", "Fervid", "Fishhook", "Fjord", "Gazebo", "Gypsy", "Haiku",
        "Haphazard", "Hyphen", "Ivory", "Jazzy", "Jiffy", "Jinx", "Jukebox", "Kayak",
        "Kiosk", "Klutz", "Memento", "Mystify", "Numbskull", "Ostracize", "Oxygen",
        "Pajama", "Phlegm", "Pixel", "Polka", "Quad", "Quip", "Rhythmic", "Rogue",
        "Sphinx", "Squawk", "Swivel", "Toady", "Twelfth", "Unzip", "Waxy",
        "Wildebeest", "Yacht", "Zealous", "Zigzag", "Zippy", "Zombie"};
    
    public static void main(String[] args) {
        runMenu();
    }
    
    public static void runMenu(){
        String input = JOptionPane.showInputDialog("1. Play game from a randomly chosen word in a list" + 
                "\n2. Play game from a word entered by another user\n3. Exit Game");
        int in = Integer.parseInt(input);
        switch (in) {
            case 1: // play game from random word
                runGame(true);
                break; 
            case 2: // play game from specific word
                runGame(false);
                break;
            case 3: // exit the game 
                System.exit(1);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Enter a valid number.");
                runMenu();
                break;
        }
    }
    
    public static void runGame(boolean isRandom){
        String wordToGuess;
        if(isRandom){
            int rand = (int) (Math.random() * WORDS.length);
            wordToGuess = WORDS[rand];
        }else{
            wordToGuess = getWord();
        }
        JOptionPane.showMessageDialog(null, "your word: " + wordToGuess);
        int strikes = 0;
        while(strikes > 5){
        
        }
    }
    
    public static String getWord(){
        return JOptionPane.showInputDialog("Enter the word to be guessed: ").trim();
    }
}
