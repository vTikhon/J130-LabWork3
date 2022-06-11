package TCPServer;


public class MainForTCPServer {
    public static void main(String[] args) {
        TCPServer server = new TCPServer();
        System.out.println("TCPServer started");
        server.start();
        System.out.println("TCPServer finished");
    }
}
