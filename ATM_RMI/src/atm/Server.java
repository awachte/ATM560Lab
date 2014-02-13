package atm;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Server_Client_Interface {

	public void deposit(int acnt, int amt) throws RemoteException{
		// TODO Auto-generated method stub

	}

	@Override
	public void withdraw(int acnt, int amt) throws RemoteException{
		// TODO Auto-generated method stub

	}

	@Override
	public void transfer(int acnt1, int acnt2, int amt) throws RemoteException{
		// TODO Auto-generated method stub

	}

	@Override
	public int inquiry(int acnt) throws RemoteException{
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
		    System.setSecurityManager(new SecurityManager());
		}
		try {
	            String name = "ATM_Server";
	            Server_Client_Interface ATM = new Server();
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
