package controller;
import java.sql.SQLException;

import com.mycompany.model.Database;
import com.mycompany.model.User;
import com.mycompany.view.Alert;
import com.mycompany.view.Friend;

public class AddFriend {
	private User user,f;
	private Database database;
	
	
 public AddFriend(User user, Database database, User f) {
	 this.user = user;
	 this.database = database;
     this.f = f; 
 }
 
 public boolean isAdded() {
	 boolean added = false;
	 String insert = "INSERT INTO `Friends`(`User`, `Friend`)  VALUES ('"+
	 user.getID()+"', '"+f.getID()+"');";

try {
	 database.getStatement().execute(insert);
	 added = true;
	 } 
 catch (SQLException e) {
	 new Alert(e.getMessage(), null);
	 added = false;
	 }
	 return added; 
   }
}
