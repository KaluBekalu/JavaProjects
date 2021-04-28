import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface StudInterface extends Remote{
    public ArrayList<Student> getStudent() throws RemoteException;
    public void setStudent(int ID, String Name, String Dept) throws RemoteException ;
            }
