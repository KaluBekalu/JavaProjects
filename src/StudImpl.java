
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.sql.*;

public class StudImpl extends UnicastRemoteObject implements StudInterface {

    
    public StudImpl() throws RemoteException {
        super();
    }
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/Student";

    String USER = "root";
    String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    public void connect() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Database Connecting...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to Database");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getStudent() throws RemoteException {
        ArrayList<Student> list = new ArrayList<Student>();
//DB Connection method
        connect();

        try {
            System.out.println("Creating Statement...");
            stmt = conn.createStatement();
//            String sql1 = "    INSERT INTO `student` (`ID`, `Name`, `Department`) VALUES ('12333', 'Stud2', 'Dept2');";
            String sql = "SELECT * FROM Student";
//            stmt.executeUpdate(sql1);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String dept = rs.getString("Department");

                Student student = new Student();
                student.setID(id);
                student.setName(name);
                student.setName(name);
                student.setDept(dept);
                
                list.add(student);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }
//    public ArrayList<Student> getStudent() throws RemoteException {
//        ArrayList<Student> list = new ArrayList<Student>();
////DB Connection method
//        connect();
//
//        try {
//            System.out.println("Creating Statement...");
//            stmt = conn.createStatement();
//            String sql = "SELECT * FROM Student";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                int id = rs.getInt("ID");
//                String name = rs.getString("Name");
//                String dept = rs.getString("Department");
//
//                Student student = new Student();
//                student.setID(id);
//                student.setDept(dept);
//                student.setName(name);
//                list.add(student);
//            }
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

// Setter Server method
    public void setStudent(int ID, String Name, String Dept) throws RemoteException {
//        ArrayList<Student> list = new ArrayList<Student>();
//        DB Connection method
        connect();

        int newId;
        String newName, newDept;

        newId = ID;
        newName = Name;
        newDept = Dept;

        try {
            System.out.println("Creating Statement...");
            stmt = conn.createStatement();
//            String sql = "INSERT INTO `student` (`ID`, `Name`, `Department`) VALUES ("+ ID + ", `" + Name + "`, `" + Dept + "`);";
            String sql = "INSERT INTO `student` (`ID`, `Name`, `Department`) VALUES ('"+ID+"', '"+Name+"', '"+Dept+"');";
            System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
            System.out.println("Successfull written to Database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
