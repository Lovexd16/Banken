import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        App account = new App();
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        boolean run = true;

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

                    while (!scan.hasNextDouble()) {
                        scan.next();

                        System.out.println("Du gav inte en siffra. \nHur mycket vill du sätta in?");
                    }

                    double depositAmount = scan.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case "3":
                    System.out.println("Hur mycket pengar vill du ta ut?");

                    while (!scan.hasNextDouble()) {
                        scan.next();

                        System.out.println("Du gav inte en siffra. \nHur mycket vill du ta ut?");
                    }

                    double withdrawAmount = scan.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case "4":
                    exit();
                    run = false;
                    break;

                default:
                    System.out.println("Du valde inte något av alternativen.");

            }

        }

        input.close();
        scan.close();

    }

    public double balance = 0;

    public void deposit(double depositAmount) {

        while (depositAmount > 0) {
            this.balance += depositAmount;
            System.out.println("Du satte in " + depositAmount + "kr på kontot.");
            break;
        }

        if (depositAmount <= 0) {
            System.out.println("Du kan inte sätta in negativt med pengar.");
        }

    }

    public void withdraw(double withdrawAmount) {

        while (withdrawAmount > 0 && withdrawAmount <= this.balance) {
            if (this.balance >= withdrawAmount) {
                this.balance -= withdrawAmount;
                System.out.println("Du tog ut " + withdrawAmount + "kr från kontot.");
                break;
            }

        }
        if (withdrawAmount > this.balance) {
            System.out
                    .println("Du har inte tillräckligt med pengar för att ta ut " + withdrawAmount + "kr från kontot.");
        }

        if (withdrawAmount <= 0) {
            System.out.println("Du kan inte ta ut negativt med pengar.");
        }
    }

    public double showBalance() {
        return this.balance;
    }

    public static void exit() {
        System.out.println("Programmet avslutades.");
    }

}