import java.rmi.*;

public interface ClientInterface extends Remote{
	public String say(String msg) throws RemoteException;
	// this operation increases the balance of user account acnt by amt, and returns nothing
	void deposit(int acnt, int amt) throws RemoteException;
	// this operation decreases the balance of user account acnt by amt, and returns nothing
	void withdraw(int acnt, int amt) throws RemoteException;
	// this operation transfers money with amount of amt from banking account acnt1 to account acnt2
	void transfer(int acnt1, int acnt2, int amt) throws RemoteException;
	// this operation returns the balance of user account acnt
	int inquiry(int acnt) throws RemoteException;
}
