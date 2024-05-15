package com.mycompany.view;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import com.mycompany.model.Database;
import com.mycompany.model.Post;
import com.mycompany.model.Comment;
import com.mycompany.model.User;
import controller.ReadAllUsers;
import controller.ReadUserComments;
import controller.ReadUserLikes;
import controller.ReadUsersPosts;

import javax.swing.ImageIcon;



public class CustomeView {
	
	public CustomeView(String view, User user, Database database) {
		JFrame frame = new JFrame();

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(null);

		JPanel header = new JPanel(new BorderLayout());
		header. setBackground(Gui.white);
		Dimension dimension = new Dimension(500, 50);
		header.setPreferredSize(dimension);
		header. setMaximumSize(dimension);
		header.setMinimumSize(dimension);
		header. setBorder(BorderFactory.createEmptyBorder(10,15, 10, 15));

		JPanel north = new JPanel(new BorderLayout());
		north.setBackground(null);
		north.add(new Jlabel(view, 20, Gui.black, Font.BOLD),
		BorderLayout.WEST);
		javax.swing.JLabel home = new javax.swing.JLabel(new ImageIcon("pics/home.png"));  // the home sign 
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		home.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new Home(user, database);
				frame.dispose();
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
		
		north.add(home, BorderLayout.EAST);		
		header.add(north, BorderLayout.NORTH);
		panel.add(header);
		 
		switch (view) {
		case "Friends":
		ArrayList<User> users = new ReadAllUsers(database, user).getList();
		for (User u : users) {
		  panel.add(Box.createVerticalStrut(7));
 			panel.add(new Friend(user, database, u));	
		}
		break;
		case"Posts":
	ArrayList<Post> posts = new ReadUsersPosts(user,database).getPosts();
	for(Post p :posts) {
		panel.add(Box.createVerticalStrut(7));
		panel.add(new com.mycompany.view.Post(user, p, database, frame));
	}
		break;
		case"Comments":
       for(JPanel p : new ReadUserComments(user, database, frame).getPostsWithComments() )
       {
     panel.add(Box.createVerticalStrut(7));
   		panel.add(p);
       }
       break;
		case"Likes": 
			ArrayList<Post> likes = new ReadUserLikes(user,database).getPosts();
			for(Post p :likes) {
				panel.add(Box.createVerticalStrut(7));
				panel.add(new com.mycompany.view.Post(user, p, database, frame));
				}
	break;	
	}
			
		frame.getContentPane().add(new JScrollPane(panel));
		frame.setVisible(true);
		frame.requestFocus();
	}
      }
 
