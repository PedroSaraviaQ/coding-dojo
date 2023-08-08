public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.displayAccountBalance();

        account.depositMoney(200, "checking");
        account.depositMoney(700, "savings");

        account.displayAccountBalance();

        account.withdrawMoney(300, "checking");
        account.withdrawMoney(300, "savings");

        account.displayAccountBalance();
    }
}
