package controller;
import java.sql.SQLException;
import com.mycompany.model.Database;
import com.mycompany.model.Post;
import com.mycompany.model.User;
import com.mycompany.view.Alert;


public class LikePost {
	
	private User u;
	private Post p;
	private Database database;

	public LikePost(User u, Post p, Database database) {
	this.u = u;
	this.p = p;
	this.database = database;

	}

	public boolean isLiked() {
	boolean liked = false;
	String insert = "INSERT INTO `likes` (`User`,`Post`) VALUES ('"
	+u.getID()+"','"+p.getID()+"');";
 try {
	database.getStatement().execute(insert);
	liked = true;
	} 
 catch (SQLException e) {
	new Alert(e.getMessage(), null);
	liked = false;
	}

	return liked;
	 }
}
