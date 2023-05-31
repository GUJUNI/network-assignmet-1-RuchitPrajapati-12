/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program-2 (CLIENT)
TCP program that create Copy 1st txt file content into 2nd txt file
*/
import java.io.*;
import java.net.Socket;

class TCPClient {
    public static void main(String[] args) {
        String serverIP = "SERVER_IP_ADDRESS"; // Change this to the IP address of the server
        int port = 1234; // Change this to the desired port number

        try {
            Socket socket = new Socket(serverIP, port);

            BufferedReader reader = new BufferedReader(new FileReader("input1.txt"));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }

            writer.close();
            reader.close();
            socket.close();

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}