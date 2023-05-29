/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program - 10 (CLIENT)
TCP program that returns the size in bytes of a file entered on the command line through multithreading
*/
import java.io.*;
import java.net.Socket;

class TCPClient {
    public static void main(String[] args) {
        String serverHostname = "localhost";
        int serverPort = 1234;
        String filename = args[0];

        try (Socket socket = new Socket(serverHostname, serverPort);
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())) {

            // Send filename to the server
            dataOutputStream.writeUTF(filename);

            // Receive file size from the server
            long fileSize = dataInputStream.readLong();

            System.out.println("File size: " + fileSize + " bytes");
        } catch (IOException e) {
            System.err.println("Error in TCP client: " + e.getMessage());
        }
    }
}

/*
OUTPUT
File size: 106 bytes
*/