package UDPClient;
import java.io.*;
import java.net.*;

public class UDPClient {
    static final int PORT = 15250;
    static final int DATA_LENGTH = 64;
    private boolean isRunning = true;

    public void run (String address) {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[DATA_LENGTH], DATA_LENGTH, InetAddress.getByName(address), PORT);
            System.out.println("(NOTE: message STOP will stop the client and the server)");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (isRunning) {
                System.out.println("Input your message:");
                String message = reader.readLine();
                byte[] tempByteArray = message.getBytes();
                for (int i = 0 ; i < tempByteArray.length ; i += DATA_LENGTH-1) {
                    int length = (i + DATA_LENGTH-1)<tempByteArray.length ? DATA_LENGTH-1 : tempByteArray.length-i;
                    datagramPacket.setData(tempByteArray, i, length);
                    datagramSocket.send(datagramPacket);
                }
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
