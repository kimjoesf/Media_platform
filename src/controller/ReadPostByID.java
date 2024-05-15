package controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mycompany.model.Database;
import com.mycompany.model.Post;
import com.mycompany.view.Alert;

public class ReadPostByID {
	
	private Post post;

	public ReadPostByID(int ID, Database database) {
	String select = "SELECT * FROM `posts` WHERE `ID` = "+ID+" ;";
	try {
	ResultSet rs = database.getStatement().executeQuery(select);
	rs.next();
	post = new Post();
	post.setID(ID);
	post.setContent(rs.getString("Content"));
	post.setDateTimeFromString(rs.getString("DateTime"));
	post.setUser(new ReadUserByID(rs.getInt("User"), database).getUser());}
	catch(SQLException e) {
		new Alert(e.getMessage(), null);	
	 }
  }
	
	public Post getPost() {
		
		return post;
	}

}
