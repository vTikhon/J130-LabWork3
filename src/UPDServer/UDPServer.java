package UPDServer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    static final int PORT = 15250;
    static final int DATA_LENGTH = 64;
    DatagramPacket packet;

    public void start(){
        try (DatagramSocket socket = new DatagramSocket(PORT)){
            packet = new DatagramPacket(new byte[DATA_LENGTH], DATA_LENGTH);
            while(true){
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Got message: " + msg + " >>> " + packet.getAddress().getHostAddress());
            }
        } catch (IOException e) {
            System.out.println("UDPServer Error: " + e.getMessage());
        }
    }
}
