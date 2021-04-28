
import java.rmi.*;
import java.util.*;

public class StudClient {

    public static void newStud(int ID, String Name, String Dept) {
       try {
            StudInterface StudInter = (StudInterface) Naming.lookup("rmi://localhost:1099/StudService");
          StudInter.setStudent(ID, Name, Dept);
//            StudInter.setStudent(16, "kal", "adfkj");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static void getStud() {
        try {
            StudInterface studListRef = (StudInterface) Naming.lookup("rmi://localhost:1099/StudService");
            ArrayList<Student> studList = (ArrayList) studListRef.getStudent();

            for (Student s : studList) {
                System.out.println("ID: " + s.getID());
                System.out.println("Name: " + s.getName());
                System.out.println("Department: " + s.getDep());
                System.out.println("..............................");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            int id;
            String name, dept;
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter an ID: ");
            id = sc.nextInt();
            System.out.println("Enter an Name: ");
            name = sc.next();
            System.out.println("Enter an Department: ");
            dept = sc.next();
            
            newStud(id, name, dept);
            
            getStud();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
