package TCPClient;
import java.util.Scanner;

public class MainForTCPClient {
    public static void main(String[] args) {
        TCPClient client = new TCPClient();
        Scanner inputAddress = new Scanner(System.in);
        System.out.println("Input an address of the server you want to connect:");
        String address = inputAddress.nextLine();
        client.run(address);
        System.out.println("TCPClient finished");
    }
}
