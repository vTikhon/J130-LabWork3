package TCPServer;
import java.io.*;
import java.net.*;

public class TCPServer {
    public static final int PORT = 15260;

    public void start(){
        try(ServerSocket server = new ServerSocket(PORT)){
            Socket socket = server.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            StringBuilder messageBuilder = new StringBuilder();
            byte[] buffer = new byte[256];
            int var;
            while((var = inputStream.read(buffer)) > -1){
                messageBuilder.append(new String(buffer, 0, var));
            }
            String message = "Got message: " + messageBuilder;
            outputStream.write(message.getBytes());
            inputStream.close();
            outputStream.flush();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("TCPServer Error: " + e.getMessage());
        }
    }
}
