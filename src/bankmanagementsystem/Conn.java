    
package bankmanagementsystem;
import java.sql.*;
public class Conn {
  static Connection c;
   static    Statement s = null;
     public Conn(){
        try{
            
             Class.forName("com.mysql.cj.jdbc.Driver");
               c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Suyash@123");
              
               // Create a statement
            s = c.createStatement();
        }
        catch(Exception e){
         System.out.println(e);
         e.printStackTrace();
         
    }   
    
    
    }
}
