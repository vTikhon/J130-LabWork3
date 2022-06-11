package TCPClient;
import java.io.*;
import java.net.*;

public class TCPClient {
    public static final int PORT = 15260;
    public static final String HOST = "127.0.0.1";

    public void start(){
        try(Socket socket = new Socket(HOST, PORT)){
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            String message = "Hello world";
            outputStream.write(message.getBytes());
            socket.shutdownOutput();
            StringBuilder messageBuilder = new StringBuilder();
            byte[] buf = new byte[256];
            int var;
            while((var = inputStream.read(buf)) > -1){
                messageBuilder.append(new String(buf, 0, var));
            }
            System.out.println(messageBuilder);
            outputStream.close();
            inputStream.close();
        } catch (IOException e){
            System.out.println("TCPClient Error: " + e.getMessage());
        }
    }
}
