package TCPServer;

public class MainForTCPServer {
    public static void main(String[] args) {
        TCPServer server = new TCPServer();
        System.out.println("TCPServer is ready to receive messages: ");
        server.start();
        System.out.println("TCPServer finished");
    }
}
