import java.rmi.Naming;

/**
 * @author rhys
 *
 */
public class HelloRMIClient {

	public static void main(String[] args)
	{
		int port = 1919;
		try
		{
			HelloRMI stub = (HelloRMI) Naming.lookup("rmi://127.0.0.1:"+port+"/Hello");
			System.out.println("Stub says: " +stub.sayHello());
			System.out.println("Stub says: " +stub.sayHello(HelloRMI.LANG.SPANISH));
			System.out.println("Stub says: " +stub.sayHello(HelloRMI.LANG.UNSUPPORTED));			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
}