/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program - 9 (CLIENT)
TCP program that swaps each character pair in a text file
*/
import java.io.*;
import java.net.Socket;

class TCPClient {
    public static void main(String[] args) {
        String serverHostname = "localhost";
        int serverPort = 1234;
        String filename = "input.txt";

        try (Socket socket = new Socket(serverHostname, serverPort);
             FileInputStream fileInputStream = new FileInputStream(filename);
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {

            // Read file content
            byte[] fileData = new byte[(int) new File(filename).length()];
            fileInputStream.read(fileData);

            // Send file data to the server
            dataOutputStream.writeInt(fileData.length);
            dataOutputStream.write(fileData);

            System.out.println("File sent successfully.");
        } catch (IOException e) {
            System.err.println("Error in TCP client: " + e.getMessage());
        }
    }
}

/*
OUTPUT
File sent successfully.
*/