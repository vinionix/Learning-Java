import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    public int halfPriceTicket()
    {
        int  halfPriceTicket;
        do {
            System.out.println("How many half-price ticket");
            halfPriceTicket = scanner.nextInt();
            scanner.nextLine();
            if (halfPriceTicket < 0)
                System.out.println("Invalid quantity");
        } while (halfPriceTicket < 0);
        return (halfPriceTicket);
    }

    public int familyTicket()
    {
        int  familyTicket;
        do {
            System.out.println("How many family ticket? Note: Buy 3 or more family tickets and get a 5% discount.");
            familyTicket = scanner.nextInt();
            scanner.nextLine();
            if (familyTicket < 0)
                System.out.println("Invalid quantity");
        } while (familyTicket < 0);
        return (familyTicket);
    }

 static void main() {
        Main app = new Main();
        System.out.println("What movie do you want watch?");
        String movieName = scanner.nextLine();
        System.out.println("Dubbed or subtitled");
        String DubbedOrSubtitled = scanner.nextLine();
        int halfPriceTicketAmount = app.halfPriceTicket();
        int familyTicketAmount = app.familyTicket();
        HalfPriceTicket halfPriceTicketClass;
        FamilyTicket familyTicketClass;
        double marketValue = 0d;

        if (halfPriceTicketAmount > 0) {
            halfPriceTicketClass = new HalfPriceTicket(halfPriceTicketAmount, DubbedOrSubtitled, movieName);
            System.out.printf("You bought %d half-price ticket\n", halfPriceTicketClass.getAmount());
            marketValue = halfPriceTicketClass.getTotalPrice();
        }
        if (familyTicketAmount > 0) {
            familyTicketClass = new FamilyTicket(familyTicketAmount, DubbedOrSubtitled, movieName);
            System.out.printf("You bought %d family ticket ticket\n", familyTicketClass.getAmount());
            marketValue += familyTicketClass.getTotalPrice();
        }
        if (marketValue > 0d) {
            System.out.println("Total to pay: " + marketValue);
        }

    }
}
