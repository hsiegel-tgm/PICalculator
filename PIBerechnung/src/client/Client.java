package client;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import others.Methods;
import server.Calculator;


public class Client {
	public Client(String ip, int digits) {
		try {
			Methods.debug("welcome cilen");
			Registry registry = LocateRegistry.getRegistry(ip);
            
			Calculator piServer = (Calculator) registry.lookup("Calculator");

			BigDecimal pi = piServer.pi(digits);
			System.out.println("Client: " + pi.toString());

		}  catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
