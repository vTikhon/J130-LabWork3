package TCPServer;
import java.io.*;
import java.net.*;
import java.util.Date;

public class TCPServer {
    public static final int PORT = 15260;
    private boolean isRunning = true;

    public void run () {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (isRunning) {
                Socket socket = server.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                StringBuilder messageBuilder = new StringBuilder();
                byte[] buffer = new byte[256];
                int length;
                while ((length = inputStream.read(buffer)) > -1) {
                    messageBuilder.append(new String(buffer, 0, length));
                }
                if (String.valueOf(messageBuilder).equals("STOP")) {
                    isRunning = false;
                } else {
                    String message = "[" + new Date() + "] " + socket.getInetAddress().getHostAddress() + ": " + messageBuilder;
                    System.out.println(message);
                    outputStream.write(new Date().toString().getBytes()); //Отправляем дату получения сообщения обратно клиенту
                }
                outputStream.flush();
                inputStream.close();
                outputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("TCPServer Error: " + e.getMessage());
        }
    }
}
