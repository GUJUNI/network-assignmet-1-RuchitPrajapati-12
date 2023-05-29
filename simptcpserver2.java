/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program - 9 (SERVER)
TCP program that swaps each character pair in a text file
*/
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServer {
    public static void main(String[] args) {
        int serverPort = 1234;
        String outputFilename = "output.txt";

        try (ServerSocket serverSocket = new ServerSocket(serverPort);
             Socket socket = serverSocket.accept();
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             FileOutputStream fileOutputStream = new FileOutputStream(outputFilename)) {

            // Read file data from the client
            int fileLength = dataInputStream.readInt();
            byte[] fileData = new byte[fileLength];
            dataInputStream.readFully(fileData);

            // Swap character pairs in the file data
            byte[] swappedData = swapCharacterPairs(fileData);

            // Write swapped data to the output file
            fileOutputStream.write(swappedData);

            System.out.println("File received and processed successfully.");
        } catch (IOException e) {
            System.err.println("Error in TCP server: " + e.getMessage());
        }
    }

    private static byte[] swapCharacterPairs(byte[] data) {
        byte[] swappedData = new byte[data.length];
        for (int i = 0; i < data.length; i += 2) {
            if (i + 1 < data.length) {
                swappedData[i] = data[i + 1];
                swappedData[i + 1] = data[i];
            } else {
                swappedData[i] = data[i];
            }
        }
        return swappedData;
    }
}

/*
OUTPUT
File received and processed successfully.
*/