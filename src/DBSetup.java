import java.sql.*;

public class DBSetup {
  public void dbconn (){
          try{
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/Student";
            
            String USER = "root";
            String PASS = "";
            Connection conn = null;
            Statement stmt = null;
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            System.out.println("Database Connecting...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to Database");
            
          }catch(Exception e){
              e.printStackTrace();
          }
  }  
}
