package com.mycompany.view;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.model.Database;
import com.mycompany.model.User;

import controller.ReadUser;


public class Login {
	
	public Login(Database database) {
		
		JFrame frame = new JFrame();

		JPanel panel = new JPanel(new BorderLayout()); 
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(115,0, 182, 0));

		Jlabel title = new Jlabel("Login", 40, Gui.blue, Font.BOLD);
		title. setHorizontalAlignment(Jlabel.CENTER);
		panel.add(title, BorderLayout.NORTH);

		JPanel center = new JPanel(new GridLayout(3, 1, 10, 10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(34, 315, 17, 315));
		JtextField email = new JtextField("Email");
		center.add(email);
		JtextField password = new JtextField("Password");
		center.add(password);
		Jbutton login = new Jbutton("Login", 45, 20);
		
		login.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (email.isEmpty()) {
					new Alert("Email cannot be empty", frame);
					return;
				       }
					if (password.isEmpty()) {
					new Alert("Password cannot be empty", frame);
					return;
					}
					ReadUser read= new ReadUser(email.getText(),password.getText(),database) ;
					if(read.loggedIn()){
					User user= read.getUser();
					//new Alert("logged in successfully, ID:"+user.getID(),frame);
					//new Modify(user, database);
					new Home(user, database);
					frame.dispose();
					}
					else
					{
						new Alert("incorrect email or password  ",frame);
					}
				}
		 
			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {	}
		  	
		});
		
		center.add(login);
		panel.add(center, BorderLayout.CENTER);
		Jlabel createAcc = new Jlabel("Don't have an account? signup", 20, Gui.black,Font.BOLD);	
		
		createAcc.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			   new Welcome(database);
			}
		 

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {	}
		  	
		});
	
		createAcc. setCursor(new Cursor(Cursor.HAND_CURSOR));
		createAcc.setHorizontalAlignment(Jlabel.CENTER);
		panel.add(createAcc, BorderLayout.SOUTH);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.requestFocus();
		
		
		
		
		
	}
	

}
