package controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mycompany.model.Database;
import com.mycompany.model.Post;
import com.mycompany.model.User;
import com.mycompany.view.Alert;



public class ReadUserLikes {
	
	ArrayList<Post> posts;
	
	public ReadUserLikes(User u, Database database) {
		posts= new ArrayList<>();
		String select = "SELECT * FROM `likes` WHERE `User` = "+u.getID()+" ;";
		ArrayList<Integer> postsIDs = new ArrayList<>();
		try {
		ResultSet rs = database.getStatement().executeQuery(select);
		while (rs.next()) {
		postsIDs.add(rs.getInt("Post"));
		 }
		for(int i=0; i<postsIDs.size();i++)
		{
			posts.add(new ReadPostByID(postsIDs.get(i),database).getPost());
		}
		
	 }  
		catch (SQLException e) {
		new Alert(e.getMessage(), null);}
	}
	
    public ArrayList<Post> getPosts() {
		  return posts;}
	
	
}