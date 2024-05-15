package controller;
import java.sql.SQLException;
import com.mycompany.model.Database;
import com.mycompany.view.Alert;

public class ChangePassword {

private String password;
private int ID;
private Database database;
	
public ChangePassword( String password, int ID, Database database){
this.password = password;
this.ID =  ID;
this.database = database;	
}

public boolean change()
{
	boolean changed = false;
	String update="UPDATE `users` SET `password`='"+password +"' WHERE `ID` = "+ID+";";
	
	try {
		database.getStatement().execute(update);
		changed = true;
        } 
	catch (SQLException e) {
		new Alert(e.getMessage(), null);
		changed = false;
		}

		return changed;
	
	
	
}

}
