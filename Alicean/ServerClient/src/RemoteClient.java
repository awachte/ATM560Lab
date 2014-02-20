import java.rmi.*;
import java.rmi.server.*;

public class RemoteClient extends UnicastRemoteObject implements Server_Client_Interface{
	private String message;
	
	public RemoteClient(String msg) throws RemoteException
	{
		message = msg;
	}
	
	public String say(String m) throws RemoteException
	{
		return new StringBuffer(m).reverse().toString() + "\n" + message;
	}
	// this operation increases the balance of user account acnt by amt, and returns nothing
	public void deposit(int acnt, int amt) throws RemoteException
	{
		
	}
	// this operation decreases the balance of user account acnt by amt, and returns nothing
	public void withdraw(int acnt, int amt) throws RemoteException
	{
		
	}
	// this operation transfers money with amount of amt from banking account acnt1 to account acnt2
	public void transfer(int acnt1, int acnt2, int amt) throws RemoteException
	{
		
	}
	// this operation returns the balance of user account acnt
	public int inquiry(int acnt) throws RemoteException
	{
		return 0;
	}
}
