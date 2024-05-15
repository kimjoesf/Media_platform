package com.mycompany.view;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import com.mycompany.model.Database;
import com.mycompany.model.User;
import javax.swing.ImageIcon;


public class SideButton extends JPanel {

public SideButton(String text, String pic, User user, Database database, JFrame frame) {
	
	super(new FlowLayout(FlowLayout.LEFT, 10, 10));
	setMaximumSize(new Dimension(182, 50));
	setBackground(Gui.white);
	setCursor(new Cursor(Cursor.HAND_CURSOR));

	javax.swing.JLabel img = new javax.swing.JLabel(new ImageIcon("pics/"+pic+".png"));  // momken tshlha (heya for image user)
	add(img);

	add(new Jlabel(text, 17, Gui.textAreaHint, Font.BOLD));
	
	
	 addMouseListener(new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			new CustomeView(text, user, database);
			frame.dispose();
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			setBackground(Gui.hover);
		}

		@Override
		public void mouseExited(MouseEvent e) {setBackground(Gui.white);
		}
	
	});
	
	
   }	
	
}
