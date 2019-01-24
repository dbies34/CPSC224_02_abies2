/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ica1_conversion_program;

import javax.swing.JOptionPane;

/**
 *
 * @author ddbie
 */
public class ICA1_Conversion_Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double meters = getInput();
        int menuInput = 0;
        while(menuInput != 4){
            menuInput = displayMenu();
            switch (menuInput) {
                case 1:
                    showKilometers(meters);
                    break;
                case 2:
                    showInches(meters);
                    break;
                case 3:
                    showFeet(meters);
                    break;
                default:
                    break;
            }
        }
        JOptionPane.showMessageDialog(null, "Bye!");
    }
    
    public static double getInput(){
        String meters = JOptionPane.showInputDialog("Enter a distance in meters: ");
        double num = Double.parseDouble(meters);
        if(num < 0){
            JOptionPane.showMessageDialog(null, "Number must be positive");
            num = getInput();
        }
        return num;
    }
    
    public static int displayMenu(){
        String inputString = JOptionPane.showInputDialog("1. Convert to kilometers\n" +
                "2. Convert to inches\n3. Convert to feet\n4. Quit the program");
        int input = Integer.valueOf(inputString);
        if(input < 0 || input > 4){
            JOptionPane.showMessageDialog(null, "Choose one of the options");
            input = displayMenu();
        }
        return input;
    }
    
    public static void showKilometers(double meters){
        JOptionPane.showMessageDialog(null, "Kilometers: " + (meters * 0.001));
    }
    
    public static void showInches(double meters){
        JOptionPane.showMessageDialog(null, "Inches: " + (meters * 39.37));
    }
    
    public static void showFeet(double meters){
        JOptionPane.showMessageDialog(null, "Feet: " + (meters * 3.281));
    }
}
