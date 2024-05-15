package com.mycompany.view;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import com.mycompany.model.Database;
import com.mycompany.model.User;

import controller.CreatePost;
import controller.GenerateTimeLine;
 


public class Home {
  
 public Home(User user, Database database) { 
	 JFrame frame = new JFrame();
	 frame.getContentPane().setLayout(new BorderLayout());
	 
	 new GenerateTimeLine(user, database);
	 
	 JPanel sideBar = new JPanel();
	 sideBar.setBackground(Gui.white);
	 Dimension sideBarDim = new Dimension(182, 1000);
	 sideBar.setPreferredSize(sideBarDim);
	 sideBar.setMaximumSize(sideBarDim);
	 sideBar.setMinimumSize(sideBarDim);
	 sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
	 sideBar.add(Box.createVerticalStrut(10));
	 
	 JPanel profile =new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	 profile.setMaximumSize(new Dimension(182, 50));
	 profile. setBackground(Gui.white);
	 profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
	 profile.add(new Jlabel(user.getname(), 19, Gui.black, Font.BOLD));   // profile user word color 
	
	profile.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Modify(user, database);
				frame.dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {	
			}
		});
	 
	 sideBar.add(profile);
	 sideBar.add(Box.createVerticalStrut(3));
	 sideBar.add(new SideButton("Posts", "myposts", user, database, frame));
	 sideBar.add(Box.createVerticalStrut(3));
	 sideBar.add(new SideButton("Comments", "mycomments", user, database, frame));
	 sideBar.add(Box.createVerticalStrut(3));
	 sideBar.add(new SideButton("Likes", "mylikes", user, database, frame));
	 sideBar.add(Box.createVerticalStrut(3));
	 sideBar.add(new SideButton("Friends", "friends", user, database, frame));
	 sideBar.add(Box.createVerticalStrut(3));
	 frame.getContentPane().add(sideBar,BorderLayout.WEST);
	 
	 JPanel panel = new JPanel();
	 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	 panel.setBackground(null);

	 JPanel header = new JPanel(new BorderLayout());
	 header. setBackground(Gui.white);
	 Dimension dimension = new Dimension(500, 159);
	 header.setPreferredSize(dimension);
	 header.setMinimumSize(dimension);
	 header.setMaximumSize(dimension);
	 header. setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

	 JPanel north = new JPanel(new BorderLayout());
	 north.setBackground(null);
	 north.add(new Jlabel("Home", 20, Gui.black, Font.BOLD),
	 BorderLayout.WEST);
	 header.add(north, BorderLayout.NORTH);
	 
	 JTextArea postIn = new JTextArea("Share your thoughts ... ", 18, 20);
	 header.add(new JScrollPane(postIn), BorderLayout.CENTER);

	 JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	 south.setBackground(null);

	 Jbutton postBtn = new Jbutton("Post", 35, 16);
	 
	 postBtn.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(postIn.isEmpty()) {
				new Alert("can't publish an empty post", frame);
				return;
			}
	com.mycompany.model.Post post = new com.mycompany.model.Post(postIn.getText(), user);
	if(new CreatePost(post, database).posted()) {
	 new Alert("Posted", frame);
	  postIn.setText("");
		
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
		 
	 });
	 
	 postBtn.setPreferredSize(new Dimension(81, 37));
	 south.add(postBtn);
	 header. add(south, BorderLayout.SOUTH);

	 panel.add(header);
	  
	 ArrayList<com.mycompany.model.Post> posts = new GenerateTimeLine(user, database).getPosts();
	 
	 for(int i=0; i<posts.size(); i++)
	 {
		 panel.add(Box.createVerticalStrut(7));
		 panel.add(new Post(user, posts.get(i), database, frame));
		 
	 }
	 

	 frame.getContentPane().add(new JScrollPane(panel), BorderLayout.CENTER);
	 frame.getContentPane().add(Box.createHorizontalStrut(182), BorderLayout.EAST);
	 
	 frame.setVisible(true);
	 frame.requestFocus();
	 
 }
}
