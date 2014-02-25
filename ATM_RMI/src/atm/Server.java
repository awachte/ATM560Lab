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
	            int port = Integer.valueOf(args[0]).intValue();
	            Server_Client_Interface ATM = new Server_Object();
	            Server_Client_Interface stub =
	                (Server_Client_Interface) UnicastRemoteObject.exportObject(ATM, port);
	            Registry registry = LocateRegistry.getRegistry();
	            registry.rebind(name, stub);
	            System.out.println("Server bound");
	     } catch (Exception e) {
	            System.err.println("Server exception:");
	            e.printStackTrace();
	     }
	}
}
