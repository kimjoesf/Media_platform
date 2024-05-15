package controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mycompany.model.Database;
import com.mycompany.model.Post;
import com.mycompany.view.Alert;


 


public class ReadPostLikes {
	private int likes;
	
	public  ReadPostLikes(Post p, Database database){	
	likes=0;
		String select =" SELECT * FROM `likes` WHERE  `post` = "+p.getID()+"; ";
	try {
		ResultSet rs = database.getStatement().executeQuery(select);
		while (rs.next()) {
		likes++;}		
			}
	catch(SQLException e) {	
		new Alert(e.getMessage(), null);
		}
	}
	public int getLikesCount() {	
		return likes;
	}
	
	
}
