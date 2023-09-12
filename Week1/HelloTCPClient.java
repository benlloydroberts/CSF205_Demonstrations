import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * @author rhys
 *
 */
public class HelloTCPClient {

	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("127.0.0.1",3939);

			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pr = new PrintWriter(out);
			String inputLine = null;
			String outputLine = "Welsh";
			System.out.println("Sending "+outputLine+" to server");

			pr.println(outputLine);
			pr.flush();

			while((inputLine = br.readLine()) != null)
			{
				System.out.println("Response from server: "+inputLine);
			}

			clientSocket.close();
			
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}

}