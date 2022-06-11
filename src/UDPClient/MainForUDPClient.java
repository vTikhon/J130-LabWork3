package UDPClient;
import java.util.Scanner;

public class MainForUDPClient {
    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        System.out.println("UDPClient is started!");

        Scanner inputAddress = new Scanner(System.in);
        System.out.println("Input an address of the server you want to connect:");
        String address = inputAddress.nextLine();
        System.out.println("(NOTE: message STOP will stop the client and the server)");
        client.run(address);

        System.out.println("UDPClient finished");
    }
}
