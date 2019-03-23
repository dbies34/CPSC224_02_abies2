// MotionParallax4.java
// Drew Bies

package motionparallax4;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ddbie
 */
public class MotionParallax4 extends JFrame{
    
    
    public MotionParallax4(){
        initFrame();
    }
    
    private void initFrame(){
        add(new Board());
        pack();
        
        setTitle("Assignment 4 : Motion Parallax");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MotionParallax4 motion = new MotionParallax4();
            motion.setVisible(true);
        });
    }
}