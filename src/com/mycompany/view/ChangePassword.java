package com.mycompany.view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import com.mycompany.model.Database;
import com.mycompany.model.User;


public class ChangePassword {
	public ChangePassword(User user, Database database)
	{
		JFrame frame = new JFrame();

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(83, 99, 175, 99));
		panel.add(new Jlabel("Change Password", 40, Gui.blue, Font.BOLD),
		BorderLayout.NORTH);
		JPanel center = new JPanel(new GridLayout(4, 1, 10, 10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(58, 216, 0, 216));
		JtextField oldPassword = new JtextField("Old Password");
		center.add(oldPassword);
		JtextField newPassword = new JtextField("New Password");
		center.add(newPassword);
		JtextField confirmPassword = new JtextField("Confirm Password");
		center.add(confirmPassword);
		Jbutton ok = new Jbutton("OK", 45, 20);
		
		ok.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(oldPassword.isEmpty()){
				new Alert ("please enter your old password", frame)	;
				return;
				}
				
				if(!oldPassword.getText().equals(user.getPassword())) {
					
				new Alert("old password doesn't match", frame);
				}
				if(newPassword.isEmpty()){
				new Alert ("please enter the new password", frame)	;
				return;
				}
				if(newPassword.getText().length() <8 ){
				new Alert("password must contains at least 8 characters ", frame);	
					return;
				}
				if (confirmPassword.isEmpty()) {
					new Alert("Please confirm password", frame);
					return;
					}

					if (!newPassword.getText().equals(confirmPassword.getText())) {
					new Alert("Password doesn't match", frame);
					return;
					}
			 controller.ChangePassword change = new controller.ChangePassword(newPassword.getText(),user.getID(),database); 
			 if(change.change()) {
				new Home(user, database);     // returns the user again to the home page after changing password without it after changing password the program will close 
				 new Alert(" password changed", frame);
				 frame.dispose();
				 
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
		
		center.add(ok);
		
		panel.add(center,BorderLayout.CENTER );   // di bt2d el text fields fe el panel aw el page y3ni
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame. requestFocus () ;
		
	}
	
	
	
	
	
}
