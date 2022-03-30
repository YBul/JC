package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
//        DataInputStream, DataOutputStream
//        localhost, 127.0.0.1
//        ServerSocket
        try (ServerSocket serverSocket = new ServerSocket(8082)) {
            System.out.println("Server started...");
            Socket client = serverSocket.accept();
            System.out.println("New connection!");

            InputStream clientInputStream = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(clientInputStream);

            OutputStream clientOutputStream = client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(clientOutputStream);

            while (true) {
                String echo = dataInputStream.readUTF();
                System.out.println(echo);

                if (echo.equals("/end")) {
                    dataOutputStream.writeUTF("Сервер закончил работу.");
                    break;
                }

                dataOutputStream.writeUTF(echo);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
