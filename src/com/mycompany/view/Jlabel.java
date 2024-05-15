package com.mycompany.view;
import java.awt.Color;
import java.awt.Font;


public class Jlabel extends javax.swing.JLabel
{
public Jlabel(String text, int textSize, Color color, int style) 
{
setFont(new Font("Segoe UI", style, textSize));
setText(text);
setForeground(color);
}

    
}