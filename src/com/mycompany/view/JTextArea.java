package com.mycompany.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;

public class JTextArea extends javax.swing.JTextArea {

	private String hint;
	
public JTextArea(String hint, int textSize, int padding) {
  super();
  this.hint=hint;
  setFont(new Font("Segoe UI", Font.BOLD, textSize));
  setBackground(null);
  setText(hint);
  setForeground(Gui.textAreaHint);
  setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
	
  
  addFocusListener(new FocusListener() {

	@Override
	public void focusGained(FocusEvent e) {if (getText().equals(hint)) {
		setText("");
		setForeground(Gui.black);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (getText().equals("")) {
		setText(hint);
		setForeground(Gui.textAreaHint);
		}
	}
	  
   } );
 }

 public JTextArea(String text, int textSize, Color color, int style)
 {
	 super();
	 setFont(new Font("Segoe UI", style, textSize));
	 setText(text);
	 setForeground(color);
	 setEditable(false);
	 setPreferredSize(new Dimension(1000, (int) getPreferredSize().getHeight())); 
	 
  }

 public boolean isEmpty()
 {
     System.out.println(getText().equals(hint) || getText().equals(""));
 return (getText().equals(hint) || getText().equals(" "));
  }
	
		
}
