/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program-4 (CLIENT)
UDP program that create Once the connection is established, the server and client communicate by sending and receiving data using 
the send() and recv() functions
*/
import java.io.*;
import java.net.*;

class UDPClient {
    public static void main(String args[]) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 12345;

        // Send data to the server
        String message = "Hello, server!";
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        clientSocket.send(sendPacket);

        // Receive data from the server
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String receivedMessage = new String(receivePacket.getData());
        System.out.println("Received from server: " + receivedMessage);

        clientSocket.close();
    }
}

/*
OUTPUT
Received from server: Hello, client!
*/