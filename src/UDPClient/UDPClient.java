package UDPClient;
import java.io.*;
import java.net.*;

public class UDPClient {
    static final int PORT = 15250;
    static final int DATA_LENGTH = 64;
    private boolean isRun = true;

    public void run (String address) {
        try (DatagramSocket datagramSocket = new DatagramSocket() ){
            DatagramPacket datagramPacket = new DatagramPacket(new byte[DATA_LENGTH], DATA_LENGTH, InetAddress.getByName(address), PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (isRun) {
                System.out.println("Input your message: \n");
                String message = reader.readLine();
                byte[] tempByteArray = message.getBytes();
                for (int i = 0 ; i < tempByteArray.length ; i += DATA_LENGTH-1) {
                    int length = (i + DATA_LENGTH-1)<tempByteArray.length ? DATA_LENGTH-1 : tempByteArray.length-i;
                    datagramPacket.setData(tempByteArray, i, length);
                    datagramSocket.send(datagramPacket);
                }
                if (message.equals("STOP")) {
                    isRun = false;
                }
            }
        } catch (IOException e) {
            System.out.println("UDPClient Error :" + e.getMessage());
        }
    }
}
