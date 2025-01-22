package BankAppAndOthers;

import java.util.Scanner;

public abstract class Bank {
    protected Scanner scanner;

    public Bank() {
        this.scanner = new Scanner(System.in);
    }

    public abstract void run();
}
