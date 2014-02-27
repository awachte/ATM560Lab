package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;
import interact.Server_Client_Interface;

public class Client {
	static String server;
	static int port;
	static String function;
	static int val1;
	static int val2;
	static int val3;
	
	static Server_Client_Interface atm;
	
	static String help = "--usage:  <server address:port> <function> <int acnt> <int acnt> <int amnt>";
	
	public static void main(String[] args)
	{
		if (System.getSecurityManager() == null) {
	            System.setSecurityManager(new SecurityManager());
	        }
	        try {
	            String name = "ATM_Object";
	            Registry registry = LocateRegistry.getRegistry(args[0]);
	            atm = (Server_Client_Interface) registry.lookup(name);
	            System.out.println("Client bound");
		} catch (Exception e) {
	            System.err.println("Client exception:");
	            e.printStackTrace();
	        }
	        
		setParameters(args);
	/*	try { scinterface = (Server_Client_Interface)Naming.lookup(server); }
		catch(Exception e) { System.out.println("Client exception:  " + e); }
	*/	
		int i = callFunction(args);
		if (i == 0)
		{
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(function));
			} catch (FileNotFoundException e) {
				System.out.println("help");
				System.exit(1);
			}
			String line = null;
			try {
				while ((line = reader.readLine()) != null)
				{
					String[] fileArgs = line.split("");
					setParameters(fileArgs);
					i = callFunction(fileArgs);
					if (i == 0) System.err.println("File line error.");
				}
			} catch (IOException e) {
				System.err.println("File error.");
			}
		}
	}
	
	// this operation increases the balance of user account acnt by amt, and returns nothing
	static void deposit(int acnt, int amt)
	{
		int balance = inquiry(acnt);
		int newBalance = balance + amt;
		try { atm.deposit(acnt, amt); }
		catch(Exception e) {}
		balance = inquiry(acnt);
		if (balance == newBalance) System.out.println("Successfully deposited $" + amt + " into account " + acnt + ". Balance is $" + balance);
		else {
			System.out.println("Deposit error.  Exiting.");
			System.exit(1);
		}
	}
	// this operation decreases the balance of user account acnt by amt, and returns nothing
	static void withdraw(int acnt, int amt)
	{
		int balance = inquiry(acnt);
		int newBalance = balance - amt;
		if(newBalance < 0) {
			System.out.println("Not enough funds for withdrawl.");
			System.exit(1);
		}
		try { atm.withdraw(acnt, amt); }
		catch(Exception e) {}
		balance = inquiry(acnt);
		if (balance == newBalance) System.out.println("Successfully withdrew $" + amt + " from account " + acnt + ". Balance is $" + balance);
		else {
			System.out.println("Withdrawal error.  Exiting.");
			System.exit(1);
		}
	}
	// this operation transfers money with amount of amt from banking account acnt1 to account acnt2
	static void transfer(int acnt1, int acnt2, int amt)
	{
		int balance1 = inquiry(acnt1);
		int newBalance1 = balance1 - amt;
		int balance2 = inquiry(acnt1);
		int newBalance2 = balance2 + amt;
		if(newBalance1 < 0) {
			System.out.println("Not enough funds for transfer.");
			System.exit(1);
		}
		try { atm.transfer(acnt1, acnt2, amt); }
		catch(Exception e) {}
		balance1 = inquiry(acnt1);
		balance2 = inquiry(acnt2);
		if (balance1 == newBalance1 && balance2 == newBalance2) 
			System.out.println("Successfully transfered $" + amt + " from account " + acnt1 + " to account " + acnt2 + 
				". Balance for accont " + acnt1 + " is $" + balance1 + ". Balance for account " + acnt2 + " is $" + balance2 + ".");
		else {
			System.out.println("Transfer error.  Exiting.");
			System.exit(1);
		}
	}
	
	// this operation returns the balance of user account acnt
	private static int inquiry(int acnt)
	{
		return getAmount(acnt);
	}
	// reads in all parameters for the client and saves them
	private static void setParameters(String[]args)
	{
		if (args.length < 2 || args.length > 5)
		{
			System.out.println(help);
			System.exit(1);
		}
		val1 = -1;
		val2 = -1; 
		val3 = -1;
		server = args[0];
		function = args[1];
		if (args.length > 2) {
			try { val1 = Integer.parseInt(args[2]); }
			catch (NumberFormatException e) {
		        System.err.println("Argument 3 must be an integer");
		        System.exit(1);
		    }
		}
		if (args.length > 3) {
			try { val2 = Integer.parseInt(args[3]); }
			catch (NumberFormatException e) {
		        System.err.println("Argument 4 must be an integer");
		        System.exit(1);
		    }
		}
		if (args.length > 4) {
			try { val3 = Integer.parseInt(args[4]); }
			catch (NumberFormatException e) {
		        System.err.println("Argument 5 must be an integer");
		        System.exit(1);
		    }
		}
	}
	//calls proper function based on parameters
	private static int callFunction(String[] args)
	{
		if (function.equals("inquiry") && args.length == 2)  
		{
			Client.inquiry(val1);
			return 1;
		} 
		else if (function.equals("withdraw") && args.length == 3) 
		{
			Client.withdraw(val1, val2);
			return 1;
		} 
		else if (function.equals("deposit") && args.length == 3) 
		{
			Client.deposit(val1, val2);
			return 1;
		}
		else if (function.equals("transfer") && args.length == 4)
		{
			Client.transfer(val1, val2, val3);
			return 1;
		}
		else return 0;
	}
	// makes a balance inquiry from the server
	private static int getAmount(int acnt)
	{
		int amt = 0;
		try { amt = atm.inquiry(acnt); }
		catch(Exception e) {}
		return amt;
	}
}
