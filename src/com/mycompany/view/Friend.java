package com.mycompany.view;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.mycompany.model.Database;
import com.mycompany.model.User;

import controller.AddFriend;
import controller.CreatePost;
import controller.RemoveFriend;



@SuppressWarnings("serial")
public class Friend extends JPanel {
 
 public Friend(User mainUser,Database database ,User u) {
	
	 setLayout(new BorderLayout());
   
	 setBackground(Gui.white);
	 setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 15));

	 Jlabel author = new Jlabel(u.getname(), 20, Gui.post, Font.BOLD);
	  add(author, BorderLayout.WEST);
	  
	 JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	 right.setBackground(null);
     
	 Jbutton addFriend = new Jbutton("Follow", 35, 16);
     addFriend.setPreferredSize(new Dimension(81, 37)); 
     addFriend.setVisible(false);
     
     
     right.add(addFriend);
 	 
     Jlabel remove = new Jlabel("Unfollow", 16, Gui.blue, Font.BOLD);
     remove.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
     remove.setVisible(false);
     remove.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
     
     remove.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (new RemoveFriend(mainUser, database, u).isRemoved()) {
				mainUser.removeFriend(u);
				remove. setVisible(false);
				addFriend.setVisible(true);
				}
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
    	 
    	 
     } );
     
     right.add(remove);
     
     if (mainUser.isFriend(u)) {
    	addFriend.setVisible(false); 
    	 remove. setVisible(true);
    	 } 
     else {
    	 addFriend.setVisible(true);
    	 remove.setVisible(false);
    	 }
     
     addFriend.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (new AddFriend(mainUser, database, u).isAdded()) {
				mainUser.addFriend(u);
				addFriend.setVisible(false);
				remove. setVisible(true);}
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
    	 
    	 
     } );
     
     
     add(right);

	 Dimension dimension = new Dimension(500, 67);  // bta3t dimention el rectangle ely gowa el kalam(add)
	 setPreferredSize(dimension);
	 setMaximumSize(dimension);
	 setMinimumSize(dimension);
	 	 
   }
	
	

}
