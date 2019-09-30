/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Néstor Ojeda
 */
public class DrawablePanel extends JPanel {
    
    
    private final ArrayList<Point2D> trail;
    private Color backgroundColor;
    private Color pencilColor;
    
    private final int DEFAULT_THICKNESS = 24;
    private final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    private final Color DEFAULT_PENCIL_COLOR = Color.BLACK;

    
    
    public DrawablePanel(){
       trail = new ArrayList<>();
       

       backgroundColor = DEFAULT_BACKGROUND_COLOR;
       pencilColor = DEFAULT_PENCIL_COLOR;
    }
    
    
    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        this.setBackground(backgroundColor);
        g.setColor(pencilColor);
     
        trail.forEach((point2D) -> {
            g.fillOval((int) point2D.getX(), (int) point2D.getY(), DEFAULT_THICKNESS, DEFAULT_THICKNESS);
        });
    }
    
     void changeBackground(Color color) {
        backgroundColor =  color;
        System.out.println("Log : background color changed to: " + pencilColor.toString());

    }
    
    void changePencilColor(Color color){
       pencilColor = color;
       System.out.println("Log : pencil color changed to: " + pencilColor.toString());
    }

    void paint(int x, int y) {
        trail.add(new Point(x, y));
        if(trail.size() > 5){
            trail.remove(0);
        }
        System.out.println("Log : registered point at " + x + " , " + y);
    }
    
    
    
    
   
    
    
    
    
    
    

      

}
