package com.mycompany.view;
import com.mycompany.model.Database;
import com.mycompany.model.User;
import controller.CreateUser;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Welcome 
{
public Welcome(Database database) 
{
JFrame frame = new JFrame();
JPanel panel= new JPanel(new BorderLayout());
panel.setBackground(null);
panel.setBorder(BorderFactory.createEmptyBorder(53,84,76, 84));
panel.add(new Jlabel("Welcome",40,Gui.blue,Font.BOLD),BorderLayout.NORTH);
JPanel center = new JPanel(new GridLayout(6, 1, 10,10));
center.setBackground(null);
center.setBorder(BorderFactory.createEmptyBorder(22, 231, 17,231));
JtextField firstName = new JtextField("First Name"); 
center.add(firstName);
JtextField lastName = new JtextField("Last Name"); 
center.add(lastName);
JtextField email = new JtextField("Email"); 
center.add(email);
JtextField password = new JtextField("Password"); 
center.add(password);
JtextField confirmpassword = new JtextField("Confirm Password"); 
center.add(confirmpassword);
Jbutton createacc = new Jbutton("create account", 45, 20);
createacc.addMouseListener(new MouseListener()
{
@Override
public void mouseReleased(MouseEvent e) {}
 
@Override
public void mousePressed(MouseEvent e) {}
 
@Override
public void mouseExited(MouseEvent e) {}
 
@Override
public void mouseEntered(MouseEvent e) {}
 
@Override
public void mouseClicked(MouseEvent e) {
if (firstName.isEmpty()) {
new Alert("First Name cannot be empty", frame);
    
return;
    }
if(lastName.isEmpty())
    {
    new Alert("last Name can't be empty",frame);
    return;
    }

if(email.isEmpty())
    {
    new Alert("email can't be empty",frame);
    return;
    }

if(password.isEmpty())
    {
    new Alert("password can't be empty",frame);
    return;
    }

if(password.getText().length()<8)
    {
    new Alert("password must contain at least 8 characters",frame);
    return;
    }

if(confirmpassword.isEmpty())
    {
    new Alert("confirm password ",frame);
    return;
    }
 
if(!password.getText().equals(confirmpassword.getText()))
    {
    new Alert("doesn't match password",frame);
    return;
    }
User u = new User();
u.setFirstName(firstName.getText());
u.setLastName(lastName.getText());
u.setEmail(email.getText());
u.setPassword(password.getText());
CreateUser create = new CreateUser(u,database);
if(!create.isEmailUsed())
{
	create.create();
u = create.getUser();
//new Alert("account created succesfully, id: "+u.getID() ,frame);
 new Home(u, database);
 frame.dispose();
  } 
else{new Alert("this account already exists" ,frame);}
} 

});
 
center.add(createacc);
panel.add(center,BorderLayout.CENTER); 
Jlabel login = new Jlabel("Already have account? login",20,Gui.black,Font.BOLD);

login.addMouseListener(new MouseListener() {
	@Override
	public void mouseClicked(MouseEvent e) {
		new Login(database);
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


login.setCursor(new Cursor(Cursor.HAND_CURSOR));
login.setHorizontalAlignment(JLabel.CENTER);
panel.add(login, BorderLayout.SOUTH);
frame.getContentPane().add(panel);
frame.setVisible(true);
frame.requestFocus();

}

}
