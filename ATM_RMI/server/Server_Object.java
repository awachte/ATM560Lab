package server;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import interact.Server_Client_Interface;

public class Server_Object implements Server_Client_Interface {

	private List<String> accounts = new ArrayList<String>();
	private List<String> balances = new ArrayList<String>();
		
	public void deposit(int acnt, int amt) throws RemoteException{
		
		try {
			Path file = Paths.get("/home/andy/ATM_RMI/accounts.txt");
			Charset charset = Charset.forName("UTF-8");
			accounts = Files.readAllLines(file, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}
		
		try {
			Path file = Paths.get("/home/andy/ATM_RMI/balances.txt");
			Charset charset = Charset.forName("UTF-8");
			balances = Files.readAllLines(file, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}

		String a = String.valueOf(acnt);
		
		int index = accounts.indexOf(a);
		if (index == -1){
			System.out.println("Account" + acnt + "does not exist.");
			return;
		}
		
		int bal = (Integer.valueOf(balances.get(index))).intValue();
		
		String dpt = String.valueOf(amt + bal);
		
		balances.set(index, dpt);
		
		try {
			Path file = Paths.get("/home/andy/ATM_RMI/balances.txt");
			Charset charset = Charset.forName("UTF-8");
			Files.write(file, balances, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}
		
		System.out.println("$" + amt + " successfully deposited into account " + acnt + ".");
		
	}

	@Override
	public void withdraw(int acnt, int amt) throws RemoteException{
		
		try {
			Path file = Paths.get("/home/andy/ATM_RMI/accounts.txt");
			Charset charset = Charset.forName("UTF-8");
			accounts = Files.readAllLines(file, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}
		
		try {
			Path file = Paths.get("/home/andy/ATM_RMI/balances.txt");
			Charset charset = Charset.forName("UTF-8");
			balances = Files.readAllLines(file, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}

		String a = String.valueOf(acnt);
		
		int index = accounts.indexOf(a);
		if (index == -1){
			System.out.println("Account" + acnt + "does not exist.");
			return;
		}
		
		int bal = (Integer.valueOf(balances.get(index))).intValue();
		
		String wdl = String.valueOf(bal - amt);
		
		balances.set(index, wdl);
		
		try {
			Path file = Paths.get("/home/andy/ATM_RMI/balances.txt");
			Charset charset = Charset.forName("UTF-8");
			Files.write(file, balances, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}
		
		System.out.println("$" + amt + " successfully withdrawn from account " + acnt + ".");
	}

	@Override
	public void transfer(int acnt1, int acnt2, int amt) throws RemoteException{
		
		try {
			Path file = Paths.get("/home/andy/ATM_RMI/accounts.txt");
			Charset charset = Charset.forName("UTF-8");
			accounts = Files.readAllLines(file, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}
		
		try {
			Path file = Paths.get("/home/andy/ATM_RMI/balances.txt");
			Charset charset = Charset.forName("UTF-8");
			balances = Files.readAllLines(file, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}

		String a = String.valueOf(acnt1);
		String b = String.valueOf(acnt2);
		
		int index1 = accounts.indexOf(a);
		if (index1 == -1){
			System.out.println("Account" + acnt1 + "does not exist.");
			return;
		}
		
		int index2 = accounts.indexOf(b);
		if (index2 == -1){
			System.out.println("Account" + acnt2 + "does not exist.");
			return;
		}
		
		int bal1 = (Integer.valueOf(balances.get(index1))).intValue();
		
		int bal2 = (Integer.valueOf(balances.get(index2))).intValue();
		
		String wdl = String.valueOf(bal1 - amt);
		
		balances.set(index1, wdl);
		
		String dpt = String.valueOf(bal2 + amt);
		
		balances.set(index2, dpt);

		try {
			Path file = Paths.get("/home/andy/ATM_RMI/balances.txt");
			Charset charset = Charset.forName("UTF-8");
			Files.write(file, balances, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}
				
		System.out.println("$" + amt + " successfully transfered from account " + acnt1 + " to account " + acnt2 + ".");
	}

	@Override
	public int inquiry(int acnt) throws RemoteException{
		
		try {
			Path file = Paths.get("/home/andy/ATM_RMI/accounts.txt");
			Charset charset = Charset.forName("UTF-8");
			accounts = Files.readAllLines(file, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}
		
		try {
			Path file = Paths.get("/home/andy/ATM_RMI/balances.txt");
			Charset charset = Charset.forName("UTF-8");
			balances = Files.readAllLines(file, charset);
			
		} catch (IOException x) {
			System.err.println(x);
		}

		String a = String.valueOf(acnt);
		
		int index = accounts.indexOf(a);
		if (index == -1){
			System.out.println("Account" + acnt + "does not exist.");
			return -1;
		}
		
		int bal = (Integer.valueOf(balances.get(index))).intValue();
							
		System.out.println("The balance of account " + acnt + " is $" + bal + ".");
		
		return bal;
	}
}
