/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ica5_filesandguis;

/**
 *
 * @author ddbie
 */
public class Book {
    private String name;
    private double price;
    
    public Book(){
        name = "";
        price = 0.0;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String toString(){
        return name + ", $" + String.valueOf(price);
    }
}
