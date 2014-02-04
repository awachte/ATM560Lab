public class Client {
	static ClientStub stub;
	
	static String server;
	static int port;
	String function;
	int account;
	int amount;
	
	public static void main(String[] args)
	{
		if (args.length == 1)
		{
			//load test file
			//for each line of text, call function
		}
		else if (args.length == 3 || args.length == 4)
		{
			//server = args[1].split(':')[0];
			//port = args[1].split(':')[1];
			stub= new ClientStub(server, port);
			//function = args[2];
			//account = args[3];
		}
		else
		{
			//error
		}
	}
	
	// this operation increases the balance of user account acnt by amt, and returns nothing
	void deposit(int acnt, int amt)
	{
		stub.alterAmount(acnt, amt);
	}
	// this operation decreases the balance of user account acnt by amt, and returns nothing
	void withdraw(int acnt, int amt)
	{
		int balance = stub.getAmount(acnt);
		if(balance < amt);
			//error
		else
		{
			stub.alterAmount(acnt, amt * -1);
		}
	}
	// this operation transfers money with amount of amt from banking account acnt1 to account acnt2
	void transfer(int acnt1, int acnt2, int amt)
	{
		int balance = stub.getAmount(acnt1);
		if(balance < amt);
			//error
		else
		{
			stub.alterAmount(acnt1, amt * -1);
			stub.alterAmount(acnt2, amt);
		}
	}
	// this operation returns the balance of user account acnt
	int inquiry(int acnt)
	{
		return stub.getAmount(acnt);
	}
	
}
//}
