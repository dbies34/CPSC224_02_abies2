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
        setSize(500, 500);
        setBackground(Color.cyan);
        
        addMouseMotionListener(new MyMouseListener());
        
        setVisible(true);
    }
    
    public void paintComponent(Graphics g){
        super.paint(g);
        
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
    
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    
    public static void main(String[] args) {
        new MotionParallax4();
    }
}