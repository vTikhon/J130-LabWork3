package UDPClient;
import java.util.Scanner;

public class MainForUDPClient {
    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        Scanner inputAddress = new Scanner(System.in);
        System.out.println("Input an address of the server you want to connect:");
        String address = inputAddress.nextLine();
        client.run(address);
        System.out.println("UDPClient finished");
    }
}
