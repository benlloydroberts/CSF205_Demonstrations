
import java.io.IOException;

/**
 * @author rhys
 *
 */
public class HelloUDPServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new HelloUDPThread().start();

	}

}