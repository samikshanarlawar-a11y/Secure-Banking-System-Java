import java.util.Scanner;

class BankAccount {
    private String name;
    private int pin;
    private double balance;
    private int failedAttempts;
    private boolean isBlocked;

    public BankAccount(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.failedAttempts = 0;
        this.isBlocked = false;
    }

    public boolean authenticate(int enteredPin) {
        if (isBlocked) {
            System.out.println("❌ Account is BLOCKED due to suspicious activity.");
            return false;
        }

        if (this.pin == enteredPin) {
            failedAttempts = 0;
            return true;
        } else {
            failedAttempts++;
            System.out.println("❌ Wrong PIN");

            if (failedAttempts >= 3) {
                isBlocked = true;
                System.out.println("🚨 Account BLOCKED due to multiple wrong PIN attempts.");
            }
            return false;
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("✅ Amount deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount > 50000) {
            isBlocked = true;
            System.out.println("🚨 Fraud Detected! Large withdrawal attempt.");
            System.out.println("❌ Account BLOCKED.");
            return;
        }

        if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawal successful.");
        }
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}

public class SecureBankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount("Samiksha", 1234, 100000);

        System.out.println("🏦 Welcome to Secure Banking System");

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (!account.authenticate(pin)) {
            sc.close();
            return;
        }

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (account.isBlocked()) {
                System.out.println("❌ Account is blocked. Contact admin.");
                break;
            }

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double wit = sc.nextDouble();
                    account.withdraw(wit);
                    break;

                case 4:
                    System.out.println("👋 Thank you for using Secure Banking System");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
        sc.close();
    }
}
