import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author rhys
 *
 */
public interface HelloRMI extends Remote {
	
	public enum LANG  {WELSH, SPANISH, SWEDISH, UNSUPPORTED};

	/**
	 * @returns 
	 * @throws RemoteException
	 */
	 public String sayHello() throws RemoteException;
	 
	 /**
	 * @returns 
	 * @throws RemoteException
	 */
	 public String sayHello(LANG language) throws RemoteException;
}