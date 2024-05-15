package controller;
import java.sql.SQLException;

import com.mycompany.model.Database;
import com.mycompany.model.Post;
import com.mycompany.model.User;
import com.mycompany.view.Alert;

public class DislikePost {
	
	private User u;
	private Post p;
	private Database database;

	public DislikePost(User u, Post p, Database database) {
	this.u = u;
	this.p = p;
	this.database = database;
	}
	
	public boolean isDisLiked() {
		boolean disliked = false;	
		String delete = "DELETE FROM `likes` WHERE `User` = "+u.getID()   
		+" AND `Post` = "+p.getID()+" ;";                 // the last database statement until now 
    try { 
		database.getStatement().execute(delete);
		disliked = true;
		} catch (SQLException e) {
		new Alert(e.getMessage(), null);
		disliked = false;
		}
		return disliked ;
		}	
  }	
	
	

 
