package TCPClient;
import java.io.*;
import java.net.*;
import java.util.Date;

public class TCPClient {
    public static final int PORT = 15260;
    private boolean isRunning = true;

    public void run (String address) {
        System.out.println("(NOTE: message STOP will stop the client and the server)");
        while (isRunning) {
            try (Socket socket = new Socket(address, PORT)) {
                OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Input your message:");
                String message = reader.readLine();
                outputStream.write(message.getBytes());
                if (message.equals("STOP")) {
                    isRunning = false;
                }
                socket.shutdownOutput();

                //формируем ответ от сервера (в виде времени согласно заданию)
                StringBuilder messageBuilder = new StringBuilder();
                byte[] buffer = new byte[256];
                int length;
                while ((length = inputStream.read(buffer)) > -1) {
                    messageBuilder.append(new String(buffer, 0, length));
                }
                System.out.println("Server received your message at: " + messageBuilder);

                outputStream.flush();
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                System.out.println("TCPClient Error: " + e.getMessage());
                isRunning = false;
            }
        }
    }
}
