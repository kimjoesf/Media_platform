package com.mycompany.view;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.TOP;


public class JtextField extends javax.swing.JTextField {

private Shape shape;
private String hint;

public JtextField(String hint) {
super();
this.hint = hint;
setFont(new Font("Segoe UI", Font.BOLD, 20));
setOpaque(false);
setText(hint);
setForeground(Gui.TFhint);
setBorder(BorderFactory.createEmptyBorder(TOP,20, BOTTOM,20));

addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
if (getText().equals("")) {
setText(hint);
setForeground(Gui.TFhint);
   }
}

@Override
public void focusGained(FocusEvent e) {
if (getText().equals(hint)) {
setText("");
setForeground(Gui.black);
  }
}
  });
}


// for rounded corners      
@Override
protected void paintComponent(Graphics g) {
g.setColor(Gui.white);                        // for the box itself
g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 45, 45);
super.paintComponent(g);

}

//for rounded border
@Override
 protected void paintBorder(Graphics g) 
 {
g.setColor(Gui.white);                             // for the edge
g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 45, 45);
}
 
@Override
 public boolean contains(int x, int y) {
if (shape == null || !shape.getBounds().equals(getBounds())) 
{
shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 45, 45);
}
return shape.contains(x, y);
}

public boolean isEmpty()
{
    System.out.println(getText().equals(hint) || getText().equals(""));
return (getText().equals(hint) || getText().equals(" "));
}
 
}
