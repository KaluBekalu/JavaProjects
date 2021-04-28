import java.io.Serializable;

public class Student implements Serializable {
    private int ID;
    private String Name, Department;
    
    public void setID(int new_ID){
        this.ID = new_ID;
    }
    public void setName(String new_name){
        this.Name = new_name;
    }
    
    public void setDept(String new_Dept){
        this.Department = new_Dept;
    }
    
    public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.Name;
    }
    public String getDep(){
      return this.Department;  
    }
    
}
