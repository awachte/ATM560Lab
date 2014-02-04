package atm;

import java.rmi.RemoteException;

public class Server_Object implements Server_Client_Interface {

	@Override
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

}
