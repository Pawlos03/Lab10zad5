### Bank Identifier

This Java program identifies the bank associated with a given account prefix by parsing data from the National Bank of Poland's publicly available file.

---

#### Features:
- Downloads the bank data file from the official NBP website.
- Prompts the user to input the first three digits of an account number.
- Searches for the corresponding bank code and name in the downloaded file.
- Dynamically handles file parsing to accommodate variations in format.

---

#### Prerequisites:
- Java 8 or higher.
- Internet access to download the bank data file.

---

#### How to Run:
1. Compile the program:
   ```javac Main.java BankIdentifier.java```
2. Run the program:
   ```java Main```
3. Follow the prompts:
   - Enter the first three digits of the account number when asked.
   - The program will display the bank name and code if found.

---

#### Project Structure:
- **BankIdentifier.java**: Contains methods for downloading and parsing the bank data file.
- **Main.java**: Handles user input and invokes the `BankIdentifier` methods.

---

#### Example Input and Output:
**Input**: `102`  
**Output**:  
```
File downloaded successfully.
Enter the first three digits of the account number: 102
Bank Information: Bank Code: 102, Name: Bank XYZ
```

---

#### Error Handling:
- If the file download fails, the program notifies the user.
- If the account prefix is not found, the program outputs:  
  ```No bank found with the given account prefix.```

---

#### Notes:
- Ensure the file format on the NBP website remains consistent for accurate results.
- File parsing logic can be adjusted to handle format changes. 

---
