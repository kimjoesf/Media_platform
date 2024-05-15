package com.mycompany.view;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;




public class Jbutton extends javax.swing.JLabel 
{
private Shape shape;
private int radius;

public Jbutton(String text,int raduis,int textsize)
{
super(text);
this.radius=raduis;
setFont(new Font("Segoe UI", Font.BOLD,textsize));
setOpaque(false);
setForeground(Gui.white);
setHorizontalAlignment(CENTER);
setCursor(new Cursor(Cursor.HAND_CURSOR));
}

// for rounded corners      
protected void paintComponent(Graphics g) {
g.setColor(Gui.blue);
g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
super.paintComponent(g);

}

//for rounded border
 protected void paintBorder(Graphics g) {
g.setColor(Gui.blue);
g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
}
 
 public boolean contains(int x, int y) {
if (shape == null || !shape.getBounds().equals(getBounds())) 
{
shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 45, 45);
}
return shape.contains(x, y);
}    
 }
