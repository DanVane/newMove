/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newMove;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Administrator
 */
public class Wall {
    private int xPos;
    private int yPos;
    private JButton wall;
    
    public Wall(int a,int b){
        xPos = a;
        yPos = b;
        wall = new JButton(new ImageIcon("F:\\pp\\Wall.jpg"));
        wall.setContentAreaFilled(false);
        wall.setBorder(null);
        wall.setBounds(xPos, yPos, 49, 49);
    }
    
    public JButton getWall(){
        return wall;
    }
    
    public int getxPos(){
        return xPos;
    }
    
    public int getyPos(){
        return yPos;
    }
}
