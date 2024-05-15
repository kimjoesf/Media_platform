package controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.mycompany.model.Database;
import com.mycompany.model.Post;
import com.mycompany.model.Comment;
import com.mycompany.model.User;
import com.mycompany.view.Alert;
import com.mycompany.view.JFrame;



public class ReadUserComments {
 private ArrayList<JPanel> panels;
	
	
  public ReadUserComments(User u, Database database, JFrame frame) {
	  panels= new ArrayList<>();
	  String select = "SELECT * FROM `comments` WHERE `User` = "+u.getID()+" ;";
	  try {
	  ResultSet rs = database.getStatement().executeQuery(select);
	  ArrayList<Comment>comments = new ArrayList<>();
	  ArrayList<Integer>postIDs = new ArrayList<>();
	  while (rs.next()) {
	  Comment p = new Comment();
	  p.setID(rs.getInt("ID"));
	  p.setContent(rs.getString("Content"));
	  p.setUser(u);
	  p.setDateTimeFromString(rs.getString("DateTime"));
	  comments.add(p);
	  postIDs.add(rs.getInt("Post"));
	  }
	  for(int i=0;i<comments.size();i++) { 
		  Post post = new ReadPostByID(postIDs.get(i), database).getPost();
		  panels.add(new com.mycompany.view.Post(u, post, database, null));
		  panels.add(new com.mycompany.view.Comment(comments.get(i)));  
	  }
    } 
	  catch(SQLException e) {
		new Alert(e.getMessage(), null);
		} 
  }
  
  public ArrayList<JPanel>getPostsWithComments(){
	  return panels;
  }
  
}
