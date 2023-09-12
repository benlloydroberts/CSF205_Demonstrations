import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author rhys
 *
 */
public class HelloTCPServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {

			ServerSocket serverSocket = new ServerSocket(3939);
			System.out.println("Waiting for a client request...");

			Socket clientSocket = serverSocket.accept();

			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pr = new PrintWriter(out);
			String inputLine = null;
			String outputLine = null;

			inputLine = br.readLine();
			if(inputLine!=null){
				System.out.println("Received :"+inputLine);
				 switch(inputLine.trim())
	                {
	                case "Spanish":
	                	outputLine = "Hola!";
	                	break;
	                case "Welsh":
	                	outputLine = "Shwmae!";
	                	break;
	                case "Swedish":
	                	outputLine = "Hej!";
	                	break;
	                default:
	                	outputLine = "Hello!";
	                	
	                }
			}
			System.out.println("Sending back :"+outputLine);

			pr.println(outputLine);
			pr.flush();

			clientSocket.close();
			serverSocket.close();
			
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}

}