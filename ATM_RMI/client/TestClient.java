package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import interact.Server_Client_Interface;

public class TestClient {
	public static void main(String args[]) {
	        if (System.getSecurityManager() == null) {
	            System.setSecurityManager(new SecurityManager());
	        }
	        try {
	            String name = "ATM_Object";
	            Registry registry = LocateRegistry.getRegistry(args[0]);
	            Server_Client_Interface atm = (Server_Client_Interface) registry.lookup(name);
	            atm.inquiry(1011);
	            atm.inquiry(1010);
	            atm.inquiry(1009);
	            atm.inquiry(1008);
	            atm.inquiry(1007);
	            atm.inquiry(1006);
	            atm.inquiry(1005);
	            atm.inquiry(1004);
	            atm.inquiry(1003);
	            atm.inquiry(1002);
	            atm.inquiry(1001);
	            atm.inquiry(1000);
	            atm.inquiry(999);
	            atm.deposit(1002, 500);
	            atm.inquiry(1002);
	            atm.withdraw(1005, 5);
	            atm.inquiry(1005);
	            atm.transfer(1009, 1010, 381);
	            atm.inquiry(1010);
	            atm.inquiry(1009);
	            
	        } catch (Exception e) {
	            System.err.println("Client exception:");
	            e.printStackTrace();
	        }
	    }    
}
