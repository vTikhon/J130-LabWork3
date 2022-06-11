package UPDServer;

public class MainForUDPServer {
    public static void main(String[] args) {
        UDPServer server = new UDPServer();
        System.out.println("UDPServer started");
        server.start();
        System.out.println("UDPServer finished");
    }
}
