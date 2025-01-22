


package BankAppAndOthers;

import javax.swing.JOptionPane;

public class BankAppSure {

    public static void main(String[] args) {
        BankAppSure app = new BankAppSure();
        app.run();
    }

    public void run() {
        while (true) {
            String input = JOptionPane.showInputDialog("Select a bank:\n" +
                    "1. Access Bank\n" +
                    "2. Zenith Bank\n" +
                    "3. GT Bank\n" +
                    "4. First Bank\n" +
                    "5. UBA\n" +
                    "6. Union Bank");

            if (input == null) {
                break;
            }

            switch (input) {
                case "1":
                    AccessBank accessBank = new AccessBank();
                    accessBank.run();
                    break;
                case "2":
                    ZenithBank zenithBank = new ZenithBank();
                    zenithBank.run();
                    break;
                case "3":
                    GTBank gtBank = new GTBank();
                    gtBank.run();
                    break;
                case "4":
                    FirstBank firstBank = new FirstBank();
                    firstBank.run();
                    break;
                case "5":
                    UBA uba = new UBA();
                    uba.run();
                    break;
                case "6":
                    UnionBank unionBank = new UnionBank();
                    unionBank.run();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid bank.");
            }
        }
    }
}