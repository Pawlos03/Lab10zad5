import java.io.*;
import java.net.*;

public class BankIdentifier {

    public static void downloadFile(String fileUrl, String destinationPath) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(destinationPath)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("File downloaded successfully.");
        }
    }

    public static String findBankInfo(String accountPrefix, String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] columns = line.split("\t");
                if (columns.length > 0) {
                    String bankPrefix = columns[0].trim();
                    if (bankPrefix.equals(accountPrefix)) {
                        String bankName = columns[1].trim();
                        return "Bank Code: " + bankPrefix + ", Name: " + bankName;
                    }
                }
            }
        }
        return null;
    }
}

