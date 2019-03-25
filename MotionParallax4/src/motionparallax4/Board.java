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
    private final int GRASS_INITIAL_X = -25;
    private final int GRASS_INITIAL_Y = 450;//(int) (BOARD_HEIGHT / 15);
    
    private final int GRASS_NEG_SCALE_X = 0 - 5;
    private final int GRASS_POS_SCALE_X = 5;
    private final int BIRD_NEG_SCALE_X = 0 - 4;
    private final int BIRD_POS_SCALE_X = 4;
    private final int MTN_NEG_SCALE_X = 0 - 3;
    private final int MTN_POS_SCALE_X = 3;
    private final int SUN_NEG_SCALE_X = 0 - 2;
    private final int SUN_POS_SCALE_X = 2;
    
    private final int GRASS_NEG_SCALE_Y = 0 - 5;
    private final int GRASS_POS_SCALE_Y = 5;
    private final int BIRD_NEG_SCALE_Y = 0 - 4;
    private final int BIRD_POS_SCALE_Y = 4;
    private final int MTN_NEG_SCALE_Y = 0 - 3;
    private final int MTN_POS_SCALE_Y = 3;
    private final int SUN_NEG_SCALE_Y = 0 - 2;
    private final int SUN_POS_SCALE_Y = 2;
    
    
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
    private int birdsY;
    private int grassX;
    private int grassY;
    private int constraintX;
    private int constraintY;
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
        
        constraintX = 0;
        constraintY = 0;
        birdsX = BIRDS_INTIAL_X;
        birdsY = BIRDS_INTIAL_Y;
        grassX = GRASS_INITIAL_X;
        grassY = GRASS_INITIAL_Y;
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
        g.drawImage(birds, birdsX, birdsY, this);
    }
    
    private class MyMouseListener implements MouseMotionListener{
        @Override
        public void mouseDragged(MouseEvent e){
            
        }
        @Override
        public void mouseMoved(MouseEvent e){
            currentX = e.getX();
            currentY = e.getY();
            
            if (currentX < 250 && constraintX < 0){
                sunX = sunX + SUN_POS_SCALE_X;
                grassX = grassX + GRASS_POS_SCALE_X;
                birdsX = birdsX + BIRD_POS_SCALE_X;
                constraintX++;
            }
            if (currentX > 250 && constraintX > -40){
                sunX = sunX + SUN_NEG_SCALE_X;
                grassX = grassX + GRASS_NEG_SCALE_X;
                birdsX = birdsX + BIRD_NEG_SCALE_X;
                constraintX--;
            }
            
            if (currentY < 250 && constraintY < 10){
                sunY = sunY + SUN_POS_SCALE_Y;
                grassY = grassY + GRASS_POS_SCALE_Y;
                birdsY = birdsY + BIRD_POS_SCALE_Y;
                constraintY++;
            }
            if (currentY > 250 && constraintY > -5){
                sunY = sunY + SUN_NEG_SCALE_Y;
                grassY = grassY+ GRASS_NEG_SCALE_Y;
                birdsY = birdsY + BIRD_NEG_SCALE_Y;
                constraintY--;
            }
            
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
