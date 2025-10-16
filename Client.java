import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8008;

        try {
            Socket socket = new Socket(host, port);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);

            // Thread to read messages from server
            Thread receiveThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println("Friend: " + serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            });
            receiveThread.start();

            // Main thread to send messages
            while (true) {
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    break;
                }
                pw.println(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
