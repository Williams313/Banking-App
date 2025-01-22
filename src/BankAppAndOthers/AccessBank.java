
package BankAppAndOthers;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class AccessBank extends Bank {
    private final Map<String, Account> accounts;

    public AccessBank() {
        this.accounts = new HashMap<>();
    }

    @Override
    public void run() {
        while (true) {
            String choice = JOptionPane.showInputDialog("""
                    Enter Any Of Your Preferred choice:
                    Access Bank
                    1. Create account
                    2. Transfer funds
                    3. Check balance
                    4. Exit
                    """);

            switch (choice) {
                case "1" -> createAccount();
                case "2" -> transferFunds();
                case "3" -> checkBalance();
                case "4" -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid option.");
            }
        }
    }

    private void createAccount() {
        String accountNumber = JOptionPane.showInputDialog("Enter account number:");

        if (accounts.containsKey(accountNumber)) {
            showMessage("Account number already exists.");
            return;
        }

        String password = JOptionPane.showInputDialog("Enter password:");

        double balance = getDoubleInput("Fund your account:");
        if (balance < 0) {
            showMessage("Initial balance cannot be negative.");
            return;
        }

        accounts.put(accountNumber, new Account(accountNumber, password, balance));
        showMessage("Account created successfully.");
    }

    private void transferFunds() {
        String senderAccountNumber = JOptionPane.showInputDialog("Enter sender's account number:");

        if (!accounts.containsKey(senderAccountNumber)) {
            showMessage("Sender's account not found.");
            return;
        }

        Account senderAccount = accounts.get(senderAccountNumber);
        String senderPassword = JOptionPane.showInputDialog("Enter sender's password:");

        if (!senderAccount.getPassword().equals(senderPassword)) {
            showMessage("Incorrect sender password.");
            return;
        }

        String recipientAccountNumber = JOptionPane.showInputDialog("Enter recipient's account number:");
        if (!accounts.containsKey(recipientAccountNumber)) {
            showMessage("Recipient's account not found.");
            return;
        }

        double transferAmount = getDoubleInput("Enter transfer amount:");
        if (transferAmount < 0) {
            showMessage("Transfer amount cannot be negative.");
            return;
        }

        if (transferAmount > senderAccount.getBalance()) {
            showMessage("Insufficient funds.");
            return;
        }

        Account recipientAccount = accounts.get(recipientAccountNumber);
        senderAccount.setBalance(senderAccount.getBalance() - transferAmount);
        recipientAccount.setBalance(recipientAccount.getBalance() + transferAmount);

        showMessage("Transfer successful.");
    }

    private void checkBalance() {
        String accountNumber = JOptionPane.showInputDialog("Enter account number:");

        if (!accounts.containsKey(accountNumber)) {
            showMessage("Account not found.");
            return;
        }

        Account account = accounts.get(accountNumber);
        String password = JOptionPane.showInputDialog("Enter password:");

        if (!account.getPassword().equals(password)) {
            showMessage("Incorrect password.");
            return;
        }

        showMessage("Account balance: " + account.getBalance());
    }

    // Utility method to show a dialog message
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    // Utility method to get a double input with validation
    private double getDoubleInput(String message) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(message);
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid number.");
            }
        }
    }
}
