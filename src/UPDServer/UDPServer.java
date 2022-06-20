package UPDServer;
import java.io.*;
import java.net.*;
import java.util.Date;

public class UDPServer {
    static final int PORT = 15250;
    static final int DATA_LENGTH = 1024;
    private boolean isRunning = true;

    public void run() {
        try (DatagramSocket datagramSocket = new DatagramSocket(PORT)){
            DatagramPacket datagramPacket = new DatagramPacket(new byte[DATA_LENGTH], DATA_LENGTH);
            while (isRunning) {
                datagramSocket.receive(datagramPacket);
                String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                if (message.equals("STOP")) {
                    isRunning = false;
                } else {
                    System.out.println("[" + new Date() + "] " + datagramPacket.getAddress().getHostAddress() + ": " + message);
                }
            }
        } catch (IOException e) {
            System.out.println("UDPServer Error: " + e.getMessage());
        }
    }
}
