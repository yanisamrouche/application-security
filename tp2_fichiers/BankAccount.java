package tp2_fichiers;

import java.util.Scanner;

import javax.management.Query;

public class BankAccount {
    public static void main(String[] args) {
        BankAccount UserAccount1 = new BankAccount();
        System.out.println("To see your bank account, you need authentification");
        Scanner sc = new Scanner(System.in);
        System.out.print("Username : ");
        String username = sc.nextLine();
        System.out.print("Password : ");
        String password = sc.nextLine();
        UserAccount1.authenticateUser(username, password);
        BankAccount newUserAccount1 = UserAccount1.createNewBankAccount("1478258936982587", password, username, 10000);
        System.out.println("===================================================================");
        System.out.println("AccountName : " + newUserAccount1.getAccountName() + " AccountNum : "
                + newUserAccount1.getAccountNumber() + " Balance : " + newUserAccount1.balance);
        System.out.println("===================================================================");

    }

    String accountNumber;
    String accountName;
    String accountSSN;
    double balance;

    private boolean isUserAuth = false;

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountSSN() {
        return accountSSN;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountOwnerName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountSSN(String accountSSN) {
        this.accountSSN = accountSSN;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean authenticateUser(String username, String password) {

        String query = "SELECT * FROM ACCOUNTS WHERE username =" + username + " AND password =" + password;
        System.out.println(query);
        isUserAuth = true;
        return isUserAuth;
    }

    public BankAccount createNewBankAccount(String accountNumber, String accountSSN,
            String accountName, double balance) {
        BankAccount account = new BankAccount();
        if (isUserAuth) {
            account.setAccountNumber(accountNumber);
            account.setAccountOwnerName(accountName);
            account.setAccountSSN(accountSSN);
            account.setBalance(balance);
            return account;
        } else {
            System.out.println("to create a new account you need authentification...");
        }
        return null;
    }
}
