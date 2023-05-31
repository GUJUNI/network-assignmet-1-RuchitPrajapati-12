/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program-3 (SERVER)
TCP program that create Enter a number and generate its square and cube
*/
import java.io.*;
import java.net.*;

class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the number from the client
            String numberStr = in.readLine();
            int number = Integer.parseInt(numberStr);

            // Calculate the square and cube
            int square = number * number;
            int cube = number * number * number;

            // Send the square and cube to the client
            out.println("Square: " + square);
            out.println("Cube: " + cube);

            // Close the streams and socket
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Server {
    public static void main(String[] args) {
        int port = 1234;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
OUTPUT
Server listening on port 1234
New client connected: 127.0.0.1
*/