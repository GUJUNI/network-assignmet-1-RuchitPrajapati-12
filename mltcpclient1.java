/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program-3 (CLIENT)
TCP program that create Enter a number and generate its square and cube
*/
import java.io.*;
import java.net.*;

class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 1234;

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            // Read the number from the user
            System.out.print("Enter a number: ");
            String numberStr = stdIn.readLine();
            int number = Integer.parseInt(numberStr);

            // Send the number to the server
            out.println(number);

            // Receive the square and cube from the server
            String square = in.readLine();
            String cube = in.readLine();

            // Print the result
            System.out.println("Square: " + square);
            System.out.println("Cube: " + cube);

            // Close the streams and socket
            in.close();
            out.close();
            stdIn.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
OUTPUT
Enter a number: 12
Square: Square: 144
Cube: Cube: 1728
*/