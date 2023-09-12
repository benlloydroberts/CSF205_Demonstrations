import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


/**
 * @author rhys
 */
public class HelloRMIServer implements HelloRMI {

	/**
	 *
	 * @return String saying hello in English
	 */
	@Override
	public String sayHello() throws RemoteException {
		return "Hello!";
	}
	/**
	 *
	 * @return String saying hello in different languages
	 */
	@Override
	public String sayHello(LANG language) throws RemoteException {
		switch(language)
		{
		case WELSH:
			return "Shwmae!";
		case SPANISH:
			return "Hola!";
		case SWEDISH:
			return "Hej!";
		default:
			throw new RemoteException("Invalid Argument");
		}
	}

	public static void main(String[] args)
	{
		try
		{

			HelloRMIServer hs = new HelloRMIServer();

			HelloRMI stub = (HelloRMI)UnicastRemoteObject.exportObject(hs, 0);

			Registry registry = LocateRegistry.createRegistry(1919);

			registry.bind("Hello", stub);

			System.out.println("Ready to accept service requests");
			
		}catch(Exception e)
		{
			e.printStackTrace(System.out);
			
		}
	}

}