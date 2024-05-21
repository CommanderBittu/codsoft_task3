import java.util.Scanner;
interface BankACC
{
    public boolean withdraw(double amount);
    public double getBalance();
    public void deposit(double amount);
}
class BankAccount implements BankACC {
    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return true;
        }
    }
}
public class ATMInterface {
    private BankAccount account;
    Scanner sc = new Scanner(System.in);
    public ATMInterface(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("Welcome To Our ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Current Balance is: " + account.getBalance());
    }

    public void deposit() {
        System.out.print("Enter the amount to be deposited: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    public void withdraw() {
        System.out.print("Enter the amount to be withdrawn: ");
        double amount = sc.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Please take your cash from the counter.");
        }
    }
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount();
        ATMInterface atm = new ATMInterface(userAccount);
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            atm.displayOptions();
            System.out.print("Choose An Option : ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    atm.withdraw();
                    break;
                case 2:
                    atm.deposit();
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting. Thank you for using our ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 4);
        sc.close();
    }
}
