/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahtzee;

import java.util.*;
import java.lang.String;
import javax.swing.JOptionPane;
/**
 *
 * @author ddbie
 */
public class Yahtzee {

    static final int DICE_IN_PLAY = 5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] hand = new int[DICE_IN_PLAY];
        Scanner scnr = new Scanner(System.in);
        char playAgain = 'y';
        
        while(playAgain == 'y'){
            String keep = "nnnnn"; //setup to roll all dice in the first roll
            int turn = 1;
            while(turn < 4 && keep != "yyyyy"){
                //roll dice not kept
                for(int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++){
                    if (keep.charAt(dieNumber) != 'y')
                        hand[dieNumber] = rollDie();
                }
                printHand(hand, "Your roll was ");
                
                if(turn < 3){
                    System.out.println("Enter dice to keep (y or n):");
                    keep = scnr.nextLine();
                }
                turn++;
            }
            
            sortArray(hand, DICE_IN_PLAY);
            printHand(hand, "Your sorted roll ");
            
            for (int dieValue = 1; dieValue <= 6; dieValue++) {
                int currentCount = 0;
                for (int diePosition = 0; diePosition < 5; diePosition++) {
                    if (hand[diePosition] == dieValue) {
                        currentCount++;
                    }
                }
                System.out.println("Score " + totalAllDice(hand) + " on the "
                    + "3 of a kind line");
            }
            if(maxOfAKindFound(hand) >= 3){
                
            }
        }
    }
    
    public static int rollDie(){
        Random rand = new Random();
        int roll = rand.nextInt(6) + 1;
        return roll;
    }
    
    public static void printHand(int[] hand, String message){
        System.out.println(message);
        for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
        {
            System.out.print(hand[dieNumber] + " ");
        }
        System.out.println();
    }
    
    //this function returns the count of the die value occurring most in the hand
    //but not the value itself
    public static int maxOfAKindFound(int[] hand){
        int maxCount = 0;
        int currentCount;
        for(int dieValue = 1; dieValue <= 6; dieValue++){
            currentCount = 0;
            for(int diePosition = 0; diePosition < 5; diePosition++){
                if(hand[diePosition] == dieValue)
                    currentCount++;
            }
            if(currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }
    
    //this function returns the total value of all dice in a hand
    public static int totalAllDice(int[] hand){
        int total = 0;
        for(int diePosition = 0; diePosition < 5; diePosition++){
            total += hand[diePosition];
        }
        return total;
    }
    
    //bubble sort from  Gaddis chapter 8
    public static void sortArray(int[] array, int size){
        boolean swap;
        int temp;
        
        do{
            swap = false;
            for(int count = 0; count < (size - 1); count++){
                if(array[count] > array[count + 1]){
                    temp = array[count];
                    array[count] = array[count + 1];
                    array[count + 1] = temp;
                    swap = true;
                }
            }
        } while(swap);
    }
    
    //this function returns the length of the longest
    //straight found in a hand
    public static int maxStraightFound(int[] hand){
        int maxLength = 1;
        int curLength = 1;
        for(int i = 0; i < 4; i++){
            if(hand[i] + 1 == hand[i + 1]) // jump of 1
                curLength++;
            else if(hand[i] + 1 < hand[i + 1]) // jump of >= 2
                curLength = 1;
            if(curLength > maxLength)
                maxLength = curLength;
        }
        return maxLength;
    }
    
    //this function returns true if the hand is a full house
    //or false if it does not
    public static boolean fullHouseFound(int[] hand){
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount;
        for (int dieValue = 1; dieValue <=6; dieValue++){
        currentCount = 0;
        for (int diePosition = 0; diePosition < 5; diePosition++){
            if (hand[diePosition] == dieValue)
                currentCount++;
        }
        if (currentCount == 2)
            found2K = true;
        if (currentCount == 3)
            found3K = true;
        }
        if (found2K && found3K)
            foundFH = true;
    return foundFH;    
    } 
}
