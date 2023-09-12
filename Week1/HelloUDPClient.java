
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * @author rhys
 *
 */
public class HelloUDPClient {

	/**
	 * @param args
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) {

		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket();
			byte[] buf = new byte[256];

			InetAddress ipAddress = InetAddress.getByName("127.0.0.1");
			buf = "Spanish".getBytes();

			DatagramPacket packet = new DatagramPacket(buf,buf.length,ipAddress,2929);
			socket.send(packet);
			
			buf = new byte[256];
			packet = new DatagramPacket(buf,buf.length);
			socket.receive(packet);
			System.out.println(new String(packet.getData()).trim());

			buf = new byte[256];
			buf = "Welsh".getBytes();
			packet = new DatagramPacket(buf,buf.length,ipAddress,2929);
			socket.send(packet);

			buf = new byte[256];
			packet = new DatagramPacket(buf,buf.length);
			socket.receive(packet);
			System.out.println(new String(packet.getData()).trim());
			
			buf = new byte[256];
			buf = "Rubbish".getBytes();
			packet = new DatagramPacket(buf,buf.length,ipAddress,2929);
			socket.send(packet);

			buf = new byte[256];
			packet = new DatagramPacket(buf,buf.length);
			socket.receive(packet);
			System.out.println(new String(packet.getData()).trim());
			
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}finally {

			if(null!=socket)
			{
				socket.close();
			}
		}

	}

}