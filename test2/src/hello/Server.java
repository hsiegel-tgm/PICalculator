package hello;
        
import java.io.IOException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class Server implements Hello {
        
    public Server() {}

    public String sayHello() {
        return "Hello, world!";
    }
        
    public static void main(String args[]) {
    	String policy = "grant{permission java.security.AllPermission;};";
		System.setProperty("java.security.policy", policy.toString());
	/*	try {
			Runtime.getRuntime().exec("rmiregistry"); //oder auch nich????
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
    	try {

    	System.out.println(LocateRegistry.createRegistry(0));
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}