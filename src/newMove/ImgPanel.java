/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newMove;

/**
 *
 * @author Administrator
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
public class ImgPanel extends JPanel {
    Image img;
public ImgPanel(Image img){	
    this.img = img;
	}		
@Override
public void paint(Graphics g) {	
    super.paint(g);
  g.drawImage(img, 0,0,128,128, this);//其中第二到第五个参数分别为x,y,width,height	
}
}