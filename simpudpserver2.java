/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program - 7 (SERVER)
UDP program that converts string into binary
*/
import java.io.IOException;
import java.net.*;

class UDPServer {
    public static void main(String[] args) {
        int serverPort = 1234;
        byte[] receiveData = new byte[1024];

        try {
            DatagramSocket serverSocket = new DatagramSocket(serverPort);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                String binaryString = convertToBinary(message);

                System.out.println("Received message: " + message);
                System.out.println("Binary representation: " + binaryString);
            }
        } catch (IOException e) {
            System.err.println("Error in UDP server: " + e.getMessage());
        }
    }

    private static String convertToBinary(String input) {
        StringBuilder binaryString = new StringBuilder();
        for (char c : input.toCharArray()) {
            String binary = Integer.toBinaryString(c);
            binaryString.append(binary).append(" ");
        }
        return binaryString.toString();
    }
}

/*
OUTPUT
Received message: Hello, World!
Binary representation: 1001000 1100101 1101100 1101100 1101111 101100 100000 1010111 1101111 1110010 1101100 1100100 100001
*/