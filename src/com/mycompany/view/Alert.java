package com.mycompany.view;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Alert 
{
public Alert(String content , JFrame parent) {
JFrame frame = new JFrame();
frame.setSize(430, 170);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setResizable(false);

JPanel panel = new JPanel(new BorderLayout(5, 5));
panel.setBorder(BorderFactory.createEmptyBorder(15,15,15, 15));
panel.setBackground(Gui.white);

Jlabel title = new Jlabel("Alert", 24, Gui.blue, Font.BOLD);
title.setHorizontalAlignment(Jlabel.CENTER);
panel.add(title, BorderLayout.NORTH);
Jlabel msg = new Jlabel(content, 18, Gui.black, Font.BOLD);
msg.setHorizontalAlignment(Jlabel.CENTER);
panel.add(msg,BorderLayout.CENTER);
frame.getContentPane().add(panel);
frame.setLocationRelativeTo(parent);
frame.setVisible(true);

  }
    
}