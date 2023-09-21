import java.util.Scanner;

public class App {

    public static boolean run = true;
    public static Scanner scan = new Scanner(System.in);
    public double balance = 0;
    public static void main(String[] args) throws Exception {

        App account = new App();
        Scanner input = new Scanner(System.in);

        System.out.println("Välkommen till banken! Du har " + account.showBalance() + "kr på kontot.");

        while (run) {
            System.out.println("1. Se saldo \n2. Sätt in pengar \n3. Ta ut pengar \n4. Avsluta");
            String choice = input.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("Du har " + account.showBalance() + "kr på kontot.");
                    break;

                case "2":
                    System.out.println("Hur mycket pengar vill du sätta in?");

                    checkAmount();

                    double depositAmount = scan.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case "3":
                    System.out.println("Hur mycket pengar vill du ta ut?");

                    checkAmount();

                    double withdrawAmount = scan.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case "4":
                    exit();
                    break;

                default:
                    System.out.println("Du valde inte något av alternativen.");

            }

        }

        input.close();
        scan.close();

    }

    public void deposit(double depositAmount) {

        while (depositAmount > 0) {
            this.balance += depositAmount;
            System.out.println("Du satte in " + depositAmount + "kr på kontot.");
            break;
        }

        if (depositAmount <= 0) {
            System.out.println("Du kan varken sätta in 0 eller ett negativt antal pengar.");
        }

    }

    public void withdraw(double withdrawAmount) {

            if (this.balance >= withdrawAmount && withdrawAmount > 0) {
                this.balance -= withdrawAmount;
                System.out.println("Du tog ut " + withdrawAmount + "kr från kontot.");

            } else if (withdrawAmount > this.balance) {

            System.out.println("Du har inte tillräckligt med pengar för att ta ut " + withdrawAmount + "kr från kontot.");

        } else {
            System.out.println("Du kan varken ta ut 0 eller ett negativt antal pengar.");
        }

    }

    public static void checkAmount() {
                while (!scan.hasNextDouble()) {
                scan.next();

                System.out.println("Du gav inte en siffra.");
                return;
        }
    }

    public double showBalance() {
        return this.balance;
    }

    public static void exit() {
        System.out.println("Programmet avslutades.");
        run = false;
    }

}