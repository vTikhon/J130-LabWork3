package UDPClient;
import java.io.*;
import java.net.*;

public class UDPClient {
    static final int PORT = 15250;
    private boolean isRunning = true;

    public void run (String address) {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            System.out.println("(NOTE: message STOP will stop the client and the server)");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (isRunning) {
                System.out.println("Input your message:");
                String message = reader.readLine();
                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(address), PORT);
                datagramSocket.send(packet);
                if (message.equals("STOP")) {
                    isRunning = false;
                }
            }
        } catch (SocketException e) {
            System.out.println("Can't connect to that address.");
        } catch (IOException e) {
            System.out.println("UDPClient Error :" + e.getMessage());
        }
    }
}
