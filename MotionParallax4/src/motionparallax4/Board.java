/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motionparallax4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author ddbie
 */
public class Board extends JPanel implements ActionListener{
    
    private int currentX;
    private int currentY;
     
    
    private final int BOARD_WIDTH = 500;
    private final int BOARD_HEIGHT = 500;
    private final int DELAY = 25;
    private final int BIRDS_INTIAL_X = BOARD_WIDTH;
    private final int BIRDS_INTIAL_Y = (int) (BOARD_HEIGHT / 10);
    
    private Timer timer;
    private Image birds;
    
    private int sunX;
    private int sunY;
    private int birdsX;
    
    public Board(){
        initBoard();
    }
    
    private void initBoard(){
        setBackground(Color.cyan);
        setPreferredSize(new Dimension(500, 500));
        
        birdsX = BIRDS_INTIAL_X;
        sunX = (int) (BOARD_WIDTH / 1.3);
        sunY = (int) (BOARD_HEIGHT / 50);
        
        loadImage();
        
        addMouseMotionListener(new MyMouseListener());
        
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    private void loadImage(){
        ImageIcon icon = new ImageIcon("src/motionparallax4/bird.png");
        birds = icon.getImage();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawSun(g);
        drawBirds(g);
    }
    
    private void drawSun(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(sunX, sunY, 100, 100);
    }
    
    private void drawBirds(Graphics g){
        g.drawImage(birds, birdsX, BIRDS_INTIAL_Y, this);
    }
    
    private class MyMouseListener implements MouseMotionListener{
        @Override
        public void mouseDragged(MouseEvent e){
            
        }
        @Override
        public void mouseMoved(MouseEvent e){
            currentX = e.getX();
            currentY = e.getY();
            //repaint();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        birdsX -= 1;
        
        if((birdsX + birds.getWidth(this)) <= 0){
            birdsX = BIRDS_INTIAL_X;
        }
        
        repaint();
    }
}
