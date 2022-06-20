package UPDServer;

public class MainForUDPServer {
    public static void main(String[] args) {
        UDPServer server = new UDPServer();
        System.out.println("UDPServer is ready to receive messages: ");
        System.out.println("(NOTE: message STOP will stop the server)");
        server.run();
        System.out.println("UDPServer finished");
    }
}
