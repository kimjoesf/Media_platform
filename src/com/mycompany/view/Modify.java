package com.mycompany.view;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import com.mycompany.model.Database;
import com.mycompany.model.User;
import controller.CreateUser;
import controller.UpdateUser;


public class Modify {
	
	public Modify(User user, Database database) 
	{
		JFrame frame = new JFrame();

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(72, 84, 149, 84));
		panel.add(new Jlabel("Modify Your Profile", 40, Gui.black, Font.BOLD),
		BorderLayout.NORTH);

		JPanel center = new JPanel(new GridLayout(4, 1, 10, 10));
		center.setBackground(null);
		center. setBorder(BorderFactory.createEmptyBorder(50, 231, 17, 231));

		JtextField firstName = new JtextField("First Name");
		firstName.setText(user.getFirstName());
		firstName.setForeground(Gui.black);    // responsible for the color of the things you will write in this text field 
		center.add(firstName);
		
		JtextField lastName = new JtextField("Last Name");
		lastName.setText(user.getLastName());
		lastName.setForeground(Gui.black); 
		center.add(lastName);
		
		JtextField email = new JtextField("Email");
		email.setText(user.getEmail());
		email.setForeground(Gui.black); 
		center.add(email);
		
		Jbutton ok = new Jbutton("ok", 45, 20);
		
		ok.addMouseListener((MouseListener) new MouseListener() {  
				@Override
	 public void mouseClicked(MouseEvent e) {
		
		if (firstName.isEmpty()) {
		new Alert("First Name cannot be empty", frame);
		return;}
		if (lastName.isEmpty()) {
		new Alert("Last Name cannot be empty", frame);
		return;}

		if (email.isEmpty()) {
		new Alert("Email cannot be empty", frame);
		return;}
		User updatedUser= user;
		
		updatedUser.setFirstName(firstName.getText());
		updatedUser.setLastName(lastName.getText());
		updatedUser.setEmail(email.getText());
		UpdateUser update= new UpdateUser(user, database) ;
		
		if(!email.getText().equals(user.getEmail()) && update.isEmailUsed( )) {
			new Alert("this email already exists ", frame);
			return;}
		
			
     if(update.update()) {
    	 new Home(updatedUser,database) ;                    // use updated user
    	 new Alert(" profile updated ", frame);
    	 frame.dispose();
   } 
     else {
    	  new Home(user, database) ;                        // use old user
    	 
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
		
		center.add(ok);
		panel.add(center, BorderLayout.CENTER);
		
		Jlabel changePassword = new Jlabel("Change Password", 20,
				Gui.black, Font.BOLD);
		    
		changePassword.addMouseListener(new MouseListener() {
	@Override
	public void mouseClicked(MouseEvent e) {
		new ChangePassword(user, database) ;
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
		    
			changePassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
			changePassword.setHorizontalAlignment(Jlabel.CENTER);
			panel.add(changePassword, BorderLayout.SOUTH);
			frame.getContentPane().add(panel);
            frame.setVisible(true);
			frame.requestFocus();
		
		
	}

}
