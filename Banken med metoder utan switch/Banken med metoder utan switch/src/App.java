import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        App account = new App();
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner( System.in);
        boolean run = true;

        System.out.println("Välkommen till banken! Du har " + account.showBalance() + "kr på kontot.");

        while(run) {
            System.out.println("1. Se saldo \n2. Sätt in pengar \n3. Ta ut pengar \n4. Avsluta");
            String choice = input.nextLine();

            if (!choice.equals("1")&&!choice.equals("2")&&!choice.equals("3")&&!choice.equals("4")) {
                System.out.println("Du valde inte ett av alternativen.");
                continue;
            }

            if (choice.equals("1")) {
                System.out.println("Saldo: " + account.showBalance() + "kr.");
                continue;
                

            } else if (choice.equals("4")) {
                exit();
                break;
                }        
                
            System.out.println("Hur mycket pengar vill du sätta in / ta ut?");

                while (!scan.hasNextDouble()) {
                scan.next();

                System.out.println("Du gav inte en siffra. Försök igen.");
            }

            scan.hasNextDouble();

            if (choice.equals("2")) {
                double depositAmount = scan.nextDouble();
                account.deposit(depositAmount);

            } else if (choice.equals("3")) {
                double withdrawAmount = scan.nextDouble();
                account.withdraw(withdrawAmount);
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

        while (withdrawAmount > 0) {
              if (this.balance >= withdrawAmount) {
                this.balance -= withdrawAmount;
                System.out.println("Du tog ut " + withdrawAmount + "kr från kontot.");
                break;
        }

        } if (withdrawAmount > this.balance) {
            System.out.println("Du har inte tillräckligt med pengar för att ta ut " + withdrawAmount + "kr från kontot.");
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

