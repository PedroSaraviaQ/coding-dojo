public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    private static double totalAmount = 0;

    public BankAccount() {
        accountNumber = randomAccountNumber();
        checkingBalance = 0;
        savingsBalance = 0;
        numberOfAccounts++;
    }

    private String randomAccountNumber() {
        String accountNumber = "";
        for (int i = 0; i < 10; i++) {
            accountNumber += (int) (Math.random() * 10);
        }
        return accountNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void depositMoney(double amount, String account) {
        if (account.equals("checking")) {
            checkingBalance += amount;
        } else if (account.equals("savings")) {
            savingsBalance += amount;
        }
        totalAmount += amount;
    }

    public void withdrawMoney(double amount, String account) {
        boolean success = false;
        if (account.equals("checking")) {
            if (checkingBalance - amount >= 0) {
                checkingBalance -= amount;
                success = true;
            }
        } else if (account.equals("savings")) {
            if (savingsBalance - amount >= 0) {
                savingsBalance -= amount;
                success = true;
            }
        }
        if (success) {
            totalAmount -= amount;
        }
    }

    public void displayAccountBalance() {
        System.out.printf("Checking: $%.2f, Savings: $%.2f%n", checkingBalance, savingsBalance);
    }
}
