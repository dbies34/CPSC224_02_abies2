// ICA5_FilesAndGUIs.java
// Drew Bies
// this program runs a GUI of a bookstore shopping app

package ica5_filesandguis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author ddbie
 */
public class ICA5_FilesAndGUIs extends JFrame{

    private JList lstBooks;
    private JList lstCart;
    private JPanel bookPanel;
    private JPanel cartPanel;
    private JButton btnAdd;
    private JButton btnClearAll;
    private JButton btnRemove;
    private JButton btnCheckOut;
    private JButton btnExit;
    
    final private int ARRAY_LENGTH = 10;
    
    Book[] books = new Book[ARRAY_LENGTH];
    Book[] cartBooks = new Book[ARRAY_LENGTH];
    private int numOfBooks;
    
    public ICA5_FilesAndGUIs() throws FileNotFoundException{
        // set title of window
        setTitle("Book Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        
        setLayout(new BorderLayout());
        loadBookArray();
        buildCartPanel();
        buildBookPanel();
        intializeCartBooks();
        
        
        btnExit = new JButton("Exit");
        btnCheckOut = new JButton("Check Out");
        
        add(bookPanel, BorderLayout.WEST);
        add(cartPanel, BorderLayout.EAST);
        //add(btnExit);
        add(btnCheckOut, BorderLayout.SOUTH);
        // fit components to size and set visible
        pack();
        setVisible(true);
    }
    
    public void buildCartPanel(){
        lstCart = new JList(cartBooks);
        btnRemove = new JButton("Remove");
        btnClearAll = new JButton("Clear Cart");
        lstCart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        btnRemove.addActionListener(new btnRemoveListener());
        btnClearAll.addActionListener(new btnClearAllListener());
        
        cartPanel = new JPanel();
        cartPanel.setBorder(BorderFactory.createTitledBorder("Shopping Cart:"));
        //cartPanel.set
        cartPanel.add(lstCart);
        cartPanel.add(btnRemove);
        cartPanel.add(btnClearAll);
    }
    
    public void buildBookPanel(){
        lstBooks = new JList(books);
        bookPanel = new JPanel();
        btnAdd = new JButton("Add to cart");
        
        bookPanel.setLayout(new BorderLayout());
        
        bookPanel.setBorder(BorderFactory.createTitledBorder("Books:"));
        lstBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        btnAdd.addActionListener(new btnAddListener());
        
        bookPanel.add(lstBooks);
        bookPanel.add(btnAdd, BorderLayout.SOUTH);
    }
    
    public void addBookToCart(int index){
        int i = 0;
        while(i < ARRAY_LENGTH && !"".equals(cartBooks[i].getName())){
            i++;
        }
        cartBooks[i] = books[index];
    }
    
    public void intializeCartBooks(){
        for(int i = 0; i < ARRAY_LENGTH; i++){
            cartBooks[i] = new Book();
        }
    }
    
    private class btnAddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int selectedIndex = lstBooks.getSelectedIndex();
            if(selectedIndex > -1)
                addBookToCart(selectedIndex);
        }
    }
    
    private class btnClearAllListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            lstCart.removeAll();
        }
    }
    
    private class btnRemoveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int selectedIndex = lstCart.getSelectedIndex();
            if(selectedIndex > 0)
                lstCart.remove(selectedIndex);
        }
    }
    
    private class btnExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(1);
        }
    }
    
    private class btnCheckOutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
    public void loadBookArray() throws FileNotFoundException{
        String file = "src/ica5_filesandguis/BookPrices.txt";
        File bookFile = new File(file);
        if(!bookFile.exists()){
            JOptionPane.showMessageDialog(null, "Could not find the file " + file);
            System.exit(1);
        }
        Scanner scr = new Scanner(bookFile);
        int i = 0, indexOfComma;
        double price;
        while(scr.hasNextLine()){
            String input = scr.nextLine();
            indexOfComma = input.indexOf(',');
            books[i] = new Book();
            books[i].setName(input.substring(0, indexOfComma));
            price = Double.valueOf(input.substring(indexOfComma + 1, input.length()));
            books[i].setPrice(price);
            i++;
        }
        numOfBooks = i;
        scr.close();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        new ICA5_FilesAndGUIs();
    }
    
}
