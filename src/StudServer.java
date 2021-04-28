import java.rmi.registry.*;

//Server App
public class StudServer  {
    public static void main (String args[]){
        try{
            Registry reg = LocateRegistry.createRegistry(1099);
            StudImpl inst = new StudImpl();
            reg.rebind("StudService", inst);
            System.out.println("Server Running...");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
