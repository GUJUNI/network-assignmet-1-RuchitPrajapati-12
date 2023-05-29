/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program - 8 (SERVER)
UDP program that replaces a sequence of consecutive blank spaces with a single space through multithreading
*/
import java.io.IOException;
import java.net.*;

class UDPServer {
    public static void main(String[] args) {
        int serverPort = 1234;

        try {
            DatagramSocket serverSocket = new DatagramSocket(serverPort);

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                Thread processThread = new Thread(() -> {
                    String processedMessage = replaceConsecutiveSpaces(message);
                    System.out.println("Received message: " + message);
                    System.out.println("Processed message: " + processedMessage);
                });
                processThread.start();
            }
        } catch (IOException e) {
            System.err.println("Error in UDP server: " + e.getMessage());
        }
    }

    private static String replaceConsecutiveSpaces(String input) {
        return input.replaceAll("\\s+", " ");
    }
}

/*
OUTPUT
Received message: Hello       World!      How    are   you?  My Self     Ruchit     Prajapati
Processed message: Hello World! How are you? My Self Ruchit Prajapati
*/