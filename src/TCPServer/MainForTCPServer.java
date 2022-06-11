package TCPServer;

public class MainForTCPServer {
    public static void main(String[] args) {
        TCPServer server = new TCPServer();
        System.out.println("TCPServer is ready to receive messages: ");
        System.out.println("(NOTE: message STOP will stop the client and the server)");
        server.run();
        System.out.println("TCPServer finished");
    }
}
