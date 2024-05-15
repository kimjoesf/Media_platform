package controller;
import java.sql.SQLException;

import com.mycompany.model.Database;
import com.mycompany.model.User;
import com.mycompany.view.Alert;


public class UpdateUser {
private Database database;
private User user;


public UpdateUser(User user, Database database){
  this.database = database;
  this.user = user;
}
	

public boolean isEmailUsed()  {
		return new CreateUser(user, database).isEmailUsed();
		}
	
 
public boolean update(){
	 boolean updated = false;
	 String update = "UPDATE `users` SET  `FirstName`='"+user.getFirstName()+
			 "', `LastName` ='"+user.getLastName()+"',`Email`='"+user.getEmail()+
			 "' WHERE `ID` = "+user.getID()+" ;";
	 
	 try {
		 database.getStatement().execute(update);
		 updated = true;
	 }
	 catch(SQLException e) {
		 new Alert(e.getMessage(),null);
		 updated = false;
	 }
	 
	 return updated;
	 
 }
}
