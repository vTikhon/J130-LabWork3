package UDPClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPClient {
    static final int PORT = 15250;
    static final int DATA_LENGTH = 64;
    public void start(){
//        String msg = "Hello world";
        try (DatagramSocket socket = new DatagramSocket() ){
            DatagramPacket packet = new DatagramPacket(new byte[DATA_LENGTH], DATA_LENGTH, InetAddress.getByName("127.0.0.1"), PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                System.out.println("Input your message: \n");
                String msg = reader.readLine();
                byte[]temp = msg.getBytes();
                for(int i=0 ; i<temp.length ; i+=DATA_LENGTH-1){
                    int length = DATA_LENGTH-1;
                    int len = (i + length)<temp.length ? length : temp.length-i;
                    packet.setData(temp, i, len);
                    socket.send(packet);
                }
            }
        } catch (IOException e) {
            System.out.println("UDPClient Error :" + e.getMessage());
        }
    }
}
