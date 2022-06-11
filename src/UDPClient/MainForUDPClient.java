package UDPClient;

public class MainForUDPClient {
    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        System.out.println("UDPClient started");
        client.start();
        System.out.println("UDPMessage finished");
    }
}
