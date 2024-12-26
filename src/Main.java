import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileUrl = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";
        String filePath = "bank_data.txt";

        // Step 1: Download the file
        try {
            BankIdentifier.downloadFile(fileUrl, filePath);
        } catch (IOException e) {
            System.out.println("Failed to download the file: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first three digits of the account number: ");
        String accountPrefix = scanner.nextLine().trim();

        try {
            String bankInfo = BankIdentifier.findBankInfo(accountPrefix, filePath);
            if (bankInfo != null) {
                System.out.println("Bank Information: " + bankInfo);
            } else {
                System.out.println("No bank found with the given account prefix.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
