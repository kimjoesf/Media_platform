package controller;
import java.sql.SQLException;

import com.mycompany.model.Comment;
import com.mycompany.model.Database;
import com.mycompany.model.Post;
import com.mycompany.model.User;
import com.mycompany.view.Alert;






public class CreateComment {
	private Comment c;
	private Post p;
	private User u;
	private Database database;
	
		
	public CreateComment(Comment comment,Post p, User u ,Database database )
	{
		this.c = comment;
		this.database = database;
		this.p = p;
		this.u = u;
	}
	
	public boolean commented() {
		boolean commented=false;
		String insert = "INSERT INTO `comments` (`Content`, `Post`, `User`, `DateTime`)"
				+ " VALUES ('"+c.getContent()+"','"+p.getID()+"','"+u.getID()+"','"
				+c.getDateTimeToString()+"');";
		try {
			database.getStatement().execute(insert);
			commented = true;
		}
		catch(SQLException e) {
			new Alert(e.getMessage(), null);
			commented = false;
		}
		
		return commented ;
	
	}
	

}
