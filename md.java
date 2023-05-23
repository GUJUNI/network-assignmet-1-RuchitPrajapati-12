/*
Name - Ruchit Prajapati
R.No - 28
Course - MCA-2
Subject - NETWORKING PRACTICAL
Assignment - Practical Assignment
****************************************************************************************************************************************
Program - 6
Write a program to compute a message digest for a file of any type and any size.
*/
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;

class MessageDigestExample {
    public static void main(String[] args) {
        String filePath = "E:/MCA/Sem-2/CLG/Java Prac/test.txt"; 

        try {
            File file = new File(filePath);

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                return;
            }

            // Compute the message digest
            String messageDigest = computeMessageDigest(file);
            System.out.println("Message Digest (SHA-256): " + messageDigest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String computeMessageDigest(File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("SHA-256"))) {

            byte[] buffer = new byte[8192];
            while (digestInputStream.read(buffer) != -1) {
                // Reading the file automatically updates the message digest
            }

            // Get the computed message digest
            MessageDigest messageDigest = digestInputStream.getMessageDigest();
            byte[] digestBytes = messageDigest.digest();

            // Convert the byte array to a hexadecimal string
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digestBytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

/*
OUTPUT
Message Digest (SHA-256): 0247a581a016fc45660f6a7f7894413c6b22faa575e0d69fecbea1f6967b6c04
*/