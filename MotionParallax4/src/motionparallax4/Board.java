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
    private Image grass;
    private Image mountainNear;
    private Image mountainFar;
    
    private int sunX;
    private int sunY;
    private int grassX;
    private int grassY;
    private int birdsX;
    private int mountainNearX;
    private int mountainNearY;
    private int mountainFarX;
    private int mountainFarY;
    
    public Board(){
        initBoard();
    }
    
    private void initBoard(){
        setBackground(Color.cyan);
        setPreferredSize(new Dimension(500, 500));
        
        birdsX = BIRDS_INTIAL_X;
        sunX = (int) (BOARD_WIDTH / 1.3);
        sunY = (int) (BOARD_HEIGHT / 50);
        
        grassX = -20;
        grassY = 50;
        
        mountainNearX = 0;
        mountainNearY = 50;
        
        mountainFarX = 0;
        mountainFarY = 50;
        
        loadImages();
        
        addMouseMotionListener(new MyMouseListener());
        
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    private void loadImages(){
        ImageIcon icon = new ImageIcon("src/motionparallax4/bird.png");
        birds = icon.getImage();
        
        ImageIcon iconGrass = new ImageIcon("src/motionparallax4/grass.png");
        grass = iconGrass.getImage();
        
        ImageIcon iconMN = new ImageIcon("src/motionparallax4/mountainNear.png");
        mountainNear = iconMN.getImage();
        
        ImageIcon iconMF = new ImageIcon("src/motionparallax4/mountainFar.png");
        mountainFar = iconMF.getImage();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawSun(g);
        drawBirds(g);
        drawMountainFar(g);
        drawMountainNear(g);
        drawGrass(g);
    }
    
    private void drawMountainFar(Graphics g){
        g.drawImage(mountainFar, mountainFarX, mountainFarY, this);
    }
    
    private void drawMountainNear(Graphics g){
        g.drawImage(mountainNear, mountainNearX, mountainNearY, this);
    }
    
    private void drawGrass(Graphics g){
        g.drawImage(grass, grassX, grassY, BOARD_WIDTH + 50, BOARD_HEIGHT, this);
    }
    
    private void drawSun(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(sunX, sunY, (int) (BOARD_WIDTH / 5), (int) (BOARD_HEIGHT / 5));
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
