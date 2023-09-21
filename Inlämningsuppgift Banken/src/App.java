import java.util.Scanner;

public class App {

    public static boolean run = true;
    public static Scanner scan = new Scanner(System.in);
    public double balance = 0;
    public static App account = new App();
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        //Välkomst meddelande. Visar start summan (0kr).
        welcome();

        while (run) {

            //Visar menyn med de 4 olika valen.
            showMenu();
            String choice = input.nextLine();

            switch (choice) {

                case "1":

                    //Visar saldot.
                    showBalanceMessage();

                    break;

                case "2":

                    //Ställer frågan hur mycket man vill sätta in.
                    depositAmountQuestion();

                    //Kollar så att det man skriver in är ett tal. Om inte kommer felmeddelande.
                    checkAmount();

                    //Scannar siffran man skrev och uppdaterar saldot.
                    getDepositAmount();

                    break;

                case "3":

                    //Ställer frågan hur mycket man vill ta ut.
                    withdrawAmountQuestion();

                    //Kollar så att det man skriver in är ett tal. Om inte kommer felmeddelande.
                    checkAmount();

                    //Scannar siffran man skrev och uppdaterar saldot.
                    getWithdrawAmount();

                    break;

                case "4":

                    //Avslutar programmet och skriver en syso att programmet har avslutats.
                    exit();

                    break;

                default:

                    //Syso som berättar att man inte valt ett av alternativen.
                    messageIfInvalidChoice();

            }

        }

        //Stänger "input" och "scan" Scanners.
        input.close();
        scan.close();

    }

    //För välkommst meddelandet och för case 1. Skickar tillbaka hur mycket man har på kontot.
    public double showBalance() {
        return this.balance;
    }

    //Meddelande man får när man startar programmet. Visar start summan (0kr).
    public static void welcome() {
        System.out.println("Välkommen till banken! Du har " + account.showBalance() + "kr på kontot.");
    }

    //Visar menyn med de 4 alternativen.
    public static void showMenu() {
        System.out.println("1. Se saldo \n2. Sätt in pengar \n3. Ta ut pengar \n4. Avsluta");
    }

    //Felmeddelandet om man inte valt ett av de fyra alternativen.
    public static void messageIfInvalidChoice() {
        System.out.println("Du valde inte något av alternativen.");
    }

    //För case 1. Kallar på showBalance metoden, och visar hur mycket man har på kontot.
      public static void showBalanceMessage() {
        System.out.println("Du har " + account.showBalance() + "kr på kontot.");
    }

    //För case 2. Frågar summan.
    public static void depositAmountQuestion() {
        System.out.println("Hur mycket pengar vill du sätta in?");
    }

     //För case 2. Uppdaterar saldot och berättar hur mycket man satte in.
    public void deposit(double depositAmount) {

        while (depositAmount > 0) {
            this.balance += depositAmount;
            System.out.println("Du satte in " + depositAmount + "kr på kontot.");
            break;
        }

        //För case 2. Berättar att man inte kan sätta in 0 eller mindre antal kr om man försökte göra det.
        if (depositAmount <= 0) {
            System.out.println("Du kan varken sätta in 0 eller ett negativt antal pengar.");
        }

    }

    //För case 2. Fångar upp summan man skrev. Kallar på deposit metoden.
    public static void getDepositAmount() {
        double depositAmount = scan.nextDouble();
        account.deposit(depositAmount);
    }

    //För case 3. Frågar hur mycket man vill ta ut.
    public static void withdrawAmountQuestion() {
        System.out.println("Hur mycket pengar vill du ta ut?");
    }

        //För case 3. Uppdaterar saldot och berättar hur mycket man tagit ut. Kollar att man inte tar ut mer än vad saldot har, och att man tar ut mer än 0kr. Skriver även ut hur mycket man tog ut.
    public void withdraw(double withdrawAmount) {

            if (this.balance >= withdrawAmount && withdrawAmount > 0) {
                this.balance -= withdrawAmount;
                System.out.println("Du tog ut " + withdrawAmount + "kr från kontot.");

                //För case 3. Visar ett felmeddelande om man försökte ta ut mer än vad man har på saldot.
            } else if (withdrawAmount > this.balance) {

            System.out.println("Du har inte tillräckligt med pengar för att ta ut " + withdrawAmount + "kr från kontot.");

            //För case 3. Berättar att man inte kan ta ut 0 eller mindre antal kr om man försökte göra det.
        } else {
            System.out.println("Du kan varken ta ut 0 eller ett negativt antal pengar.");
        }

    }

        //För case 3. Fångar upp summan man skrev. Kallar på withdraw metoden.
        public static void getWithdrawAmount() {
        double withdrawAmount = scan.nextDouble();
        account.withdraw(withdrawAmount);
    }


    //För case 2 och 3. Kollar så man skrivit en siffra. Om man skrev något annat kommer ett felmeddelande.
    public static void checkAmount() {
                while (!scan.hasNextDouble()) {
                scan.next();

                System.out.println("Du gav inte en siffra.");
                return;
        }
    }

    //För case 4. Avslutar programmet och berättar att det avslutats.
    public static void exit() {
        System.out.println("Programmet avslutades.");
        run = false;
    }

}