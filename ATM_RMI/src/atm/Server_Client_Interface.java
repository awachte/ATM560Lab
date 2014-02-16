package atm;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server_Client_Interface extends Remote {
	
	void deposit(int acnt, int amt)throws RemoteException;
	
	void withdraw(int acnt, int amt)throws RemoteException;
	
	void transfer(int acnt1, int acnt2, int amt)throws RemoteException;
	
	int inquiry(int acnt)throws RemoteException;	

}
