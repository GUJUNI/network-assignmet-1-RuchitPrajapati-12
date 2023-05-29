/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program - 10 (SERVER)
TCP program that returns the size in bytes of a file entered on the command line through multithreading
*/
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServer {
    public static void main(String[] args) {
        int serverPort = 1234;

        try (ServerSocket serverSocket = new ServerSocket(serverPort);
             Socket socket = serverSocket.accept();
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {

            // Receive filename from the client
            String filename = dataInputStream.readUTF();

            // Get file size
            File file = new File(filename);
            long fileSize = file.length();

            // Send file size to the client
            dataOutputStream.writeLong(fileSize);

            System.out.println("File size sent successfully.");
        } catch (IOException e) {
            System.err.println("Error in TCP server: " + e.getMessage());
        }
    }
}

/*
OUTPUT
File size sent successfully.
*/