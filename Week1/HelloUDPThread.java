
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author rhys
 *
 */
public class HelloUDPThread extends Thread {

	
	private DatagramSocket socket = null;
	private boolean keepRunning = true;
	public HelloUDPThread() throws IOException
	{
		this("HelloThread");
	}
	
	public HelloUDPThread(String name) throws IOException
	{

		socket = new DatagramSocket(2929);

	}
	
	@Override
	public void run() {
		System.out.println("Server ready and waiting for client requests");
		while(keepRunning)
		{
			byte[] buf = new byte[256];

            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
				socket.receive(packet);

				String inputLang = new String(packet.getData()).trim();
				System.out.println("\n"+inputLang);

				InetAddress address = packet.getAddress();
                int port = packet.getPort();
                switch(inputLang)
                {
                case "Spanish":
                	buf = "Hola!".trim().getBytes();
                	break;
                case "Welsh":
                	buf = "Shwmae!".trim().getBytes();
                	break;
                case "Swedish":
                	buf = "Hej!".trim().getBytes();
                	break;
                default:
                	buf = "Hello!".trim().getBytes();
                	
                }
                System.out.println("sending back " +new String(buf));

                packet = new DatagramPacket(buf, buf.length, address, port);

                socket.send(packet);
                
				
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		socket.close();
	}
	
	
	

}