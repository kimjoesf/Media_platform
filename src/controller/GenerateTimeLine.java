package controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mycompany.model.Database;
import com.mycompany.model.Post;
import com.mycompany.model.User;
import com.mycompany.view.Alert;



public class GenerateTimeLine {	
	private ArrayList<Post> posts;

	public GenerateTimeLine(User user, Database database) {
	posts = new ArrayList<>();
	StringBuilder sb = new StringBuilder();
	if (user.getFriendsIDs().size() != 0) {
		for (int i=0; i<user.getFriendsIDs().size();i++) {
	sb.append(" `User` ="+user.getFriendsIDs().get(i));
	if (i != user.getFriendsIDs().size()-1) {
	sb.append(" OR ");
	} 
	else {
	sb.append(";");
	}
		}
	String select = "SELECT * FROM `posts` WHERE "+sb.toString();
	 
   try {
	   ResultSet rs = database.getStatement().executeQuery(select);
	   ArrayList<Integer> usersIDs = new ArrayList<>();
	   while (rs.next()) {
	   Post p = new Post();
	   p.setID(rs.getInt("ID"));
	   p.setContent(rs.getString("Content"));
	   usersIDs.add(rs.getInt("User"));	     // from U to u
	   p.setDateTimeFromString(rs.getString("DateTime"));
	   posts.add(p);
	       }
	  for( int j=0; j<usersIDs.size();j++) {
		   posts.get(j).setUser(new ReadUserByID(usersIDs.get(j), database).getUser());
		   }
        }
           catch(SQLException e) {
        	  new Alert(e.getMessage(), null);
          }
       }
    }

	public ArrayList<Post> getPosts() {
	return posts;
  }
	
 }