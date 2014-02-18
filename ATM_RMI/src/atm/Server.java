package atm;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
		    System.setSecurityManager(new SecurityManager());
		}
		try {
	            String name = "ATM_Object";
	            Server_Client_Interface ATM = new Server_Object();
	            Server_Client_Interface stub =
	                (Server_Client_Interface) UnicastRemoteObject.exportObject(ATM, 0);
	            Registry registry = LocateRegistry.getRegistry();
	            registry.rebind(name, stub);
	            System.out.println("Server bound");
	     } catch (Exception e) {
	            System.err.println("Server exception:");
	            e.printStackTrace();
	     }
	}
}
