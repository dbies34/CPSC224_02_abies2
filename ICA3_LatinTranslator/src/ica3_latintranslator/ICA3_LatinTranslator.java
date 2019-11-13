/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ica3_latintranslator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ddbie
 */
public class ICA3_LatinTranslator extends JFrame {
    
    private JButton buttonSinister;
    private JButton buttonDexter;
    private JButton buttonMedium;
    private JLabel labelTranslated;
    private JLabel labelEnglish;
    
    private JPanel panel;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ICA3_LatinTranslator();
    }
    
    public ICA3_LatinTranslator(){
        setTitle("Latin Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);
    }
    
    private void buildPanel(){
        panel = new JPanel();
        
        buttonSinister = new JButton("Sinister");
        buttonDexter = new JButton("Dexter");
        buttonMedium = new JButton("Medium");
        labelTranslated = new JLabel("");
        
        buttonSinister.addActionListener(new SinisterButtonListener());
        buttonDexter.addActionListener(new DexterButtonListener());
        buttonMedium.addActionListener(new MediumButtonListener());
        
        panel.add(buttonSinister);
        panel.add(buttonDexter);
        panel.add(buttonMedium);
        panel.add(labelTranslated);
    }
    
    private class SinisterButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            labelTranslated.setText("Left");
        }
    }
    
    private class DexterButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            labelTranslated.setText("Right");
        }
    }
    
    private class MediumButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            labelTranslated.setText("Center");
        }
    }
}
