package com.mycompany.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import com.mycompany.model.Database;
import com.mycompany.model.User;

import controller.CreateComment;
import controller.ReadPostsComments;



public class Comments {
	
	public Comments(User user,com.mycompany.model.Post post, Database database) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(null);

       panel.add(new Post(user, post, database, frame));
 	   panel.add(Box.createVerticalStrut(7));

		JPanel newComment = new JPanel(new BorderLayout());
		newComment.setBackground(Gui.white);
		Dimension dimension = new Dimension(500, 58);
		newComment.setPreferredSize(dimension);
		newComment.setMaximumSize(dimension);
		newComment.setMinimumSize(dimension);
		newComment.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 15));

		JTextArea commentIn = new JTextArea("Type a comment", 18, 5);
		newComment.add(new JScrollPane(commentIn), BorderLayout.CENTER);

		Jbutton commentBtn = new Jbutton("Post", 35, 16);
		commentBtn.setPreferredSize(new Dimension(81, 37));
		
		commentBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(commentIn.isEmpty()) {
					new Alert("can't publish an empty comment ", frame);
					return;
				}
				com.mycompany.model.Comment c = new com.mycompany.model.Comment(commentIn.getText(), user);
				if(new CreateComment(c, post, user, database ).commented()) {
					//new Alert("comment published ", frame);
					commentIn.setText("");
					panel.add(new Comment(c));
					panel.revalidate();	 
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
		
		newComment.add(commentBtn, BorderLayout.EAST);
		
		panel.add(newComment);
		panel.add(Box.createVerticalStrut(7));
		
 
		ArrayList<com.mycompany.model.Comment> comments = new ReadPostsComments(post, database).getComments();
		for (com.mycompany.model.Comment c: comments) {
		panel.add(new Comment(c));
		panel.add(Box.createVerticalStrut(7));	
		}

		frame.getContentPane().add(new JScrollPane(panel));
		
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {}

			@Override
			public void windowClosing(WindowEvent e) { }

			@Override
			public void windowClosed(WindowEvent e) {
				new Home(user, database);
			}

			@Override
			public void windowIconified(WindowEvent e) { }

			@Override
			public void windowDeiconified(WindowEvent e) { }

			@Override
			public void windowActivated(WindowEvent e) { }

			@Override
			public void windowDeactivated(WindowEvent e) { }
			
		} );
		
		frame.setVisible(true);
		frame.requestFocus();
		
		
	}
  
}
