/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program - 8 (CLIENT)
UDP program that replaces a sequence of consecutive blank spaces with a single space through multithreading
*/
import java.io.IOException;
import java.net.*;

class UDPClient {
    public static void main(String[] args) {
        String serverHostname = "localhost";
        int serverPort = 1234;
        String message = "Hello       World!      How    are   you?  My Self     Ruchit     Prajapati";

        try {
            InetAddress serverAddress = InetAddress.getByName(serverHostname);
            byte[] sendData = message.getBytes();

            DatagramSocket clientSocket = new DatagramSocket();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            clientSocket.send(sendPacket);
            clientSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverHostname);
        } catch (IOException e) {
            System.err.println("Error in UDP client: " + e.getMessage());
        }
    }
}
