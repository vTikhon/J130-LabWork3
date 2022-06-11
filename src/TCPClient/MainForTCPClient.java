package TCPClient;

public class MainForTCPClient {
    public static void main(String[] args) {
        TCPClient client = new TCPClient();
        System.out.println("TCPClient started");
        client.start();
        System.out.println("TCPClient finished");
    }
}
