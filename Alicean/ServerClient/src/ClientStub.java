import java.rmi.*;

public class ClientStub {
	String server;
	int port;
	
	ClientStub(String server, int port)
	{
		this.server = server;
		this.port = port;
	}
	
	
	// this operation increases the balance of user account acnt by amt, and returns nothing
	void deposit(int acnt, int amt)
	{
		
	}
	// this operation decreases the balance of user account acnt by amt, and returns nothing
	void withdraw(int acnt, int amt)
	{
		
	}
	// this operation transfers money with amount of amt from banking account acnt1 to account acnt2
	void transfer(int acnt1, int acnt2, int amt)
	{
		
	}
	// this operation returns the balance of user account acnt
	int inquiry(int acnt)
	{
		return 0;
	}
}
