package mymedia;
import com.mycompany.model.Database;
import com.mycompany.view.Comments;
import com.mycompany.view.CustomeView;
import com.mycompany.view.Welcome;




public class Main 
{
    
 public static void main(String[]args)
 {
 
  new Welcome(new Database());
  
 }
 
}

