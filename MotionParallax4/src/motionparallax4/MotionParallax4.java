// MotionParallax4.java
// Drew Bies

package motionparallax4;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ddbie
 */
public class MotionParallax4 extends JFrame{
    private int currentX;
    private int currentY;
    
    public MotionParallax4(){
        setTitle("Assignment 4: Motion Parallax");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addMouseMotionListener(new MyMouseListener());
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        // background sky
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 500, 500);
    }
    
    private class MyMouseListener implements MouseMotionListener{
        public void mouseDragged(MouseEvent e){
            
        }
        public void mouseMoved(MouseEvent e){
            currentX = e.getX();
            currentY = e.getY();
            repaint();
        }
    }
    
    public static void main(String[] args) {
        new MotionParallax4();
    }
}
