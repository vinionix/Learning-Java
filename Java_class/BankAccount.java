import java.util.Scanner;

public class BankAccount {

    //Vars:

    private final String name;
    private final String lastName;
    private float balance;
    private final float overDraft;
    private float overDraftInUse;
    private static final Scanner Scanner = new Scanner(System.in);

    /**************************************************/

    //Constructor:
    BankAccount(){
        System.out.println("What is your name?");
        name = Scanner.nextLine();
        System.out.println("What is your Last Name?");
        lastName = Scanner.nextLine();
        System.out.println("How much will your first deposit be?");
        balance = Scanner.nextFloat();
        if (balance < 0f)
            balance = 0f;
        overDraft = (balance <= 500f) ? 50f : (balance / 2);
        overDraftInUse = 0f;
    }

    /**************************************************/


    //Get:

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public float getBalance() {
        return balance;
    }

    public float getOverDraftInUse() {
        return overDraftInUse;
    }

    public float getOverDraft() {
        return overDraft;
    }

    /**************************************************/

    //Body:

    public void checkBalance(){
        System.out.println("Your balance is " + getBalance());
    }

    public void checkOverDraft(){
        System.out.println("Your overdraft is " + getOverDraft());
    }

    public void dataAccount(){
        System.out.println("Name: " + getName());
        System.out.println("Last Name: " + getLastName());
    }

    public void depositFun(){
        System.out.println("How much do you want to deposit?");
        float deposit = Scanner.nextFloat();
        while (deposit < 0.01f)
        {
            System.out.println("Invalid Option, Try again.");
            deposit = Scanner.nextFloat();
        }
        if (this.overDraftInUse > 0.01f){
            float overDraftPaid;
            if (this.overDraftInUse >= deposit) {
                overDraftPaid = deposit;
                this.overDraftInUse -= deposit;
            }
            else{
                overDraftPaid = this.overDraftInUse;
                deposit -= this.overDraftInUse;
                this.overDraftInUse = 0;
            }
            System.out.printf("Congratulations, you paid %s of your overdraft.", overDraftPaid);
        }
        this.balance += deposit;
        System.out.println("Your new balance is " + getBalance());
    }

    public void withdrawFun(){
        System.out.println("How much do you want to withdraw?");
        float withdraw = Scanner.nextFloat();
        if (withdraw < 0f || this.balance < withdraw)
        {
            System.out.println("Invalid Option");
            return;
        }
        this.balance -= withdraw;
        System.out.println("Your new balance is " + getBalance());
    }

    public void payBills() {
        System.out.println("How much do you want to pay?");
        float value = Scanner.nextFloat();
        if ((this.balance + (this.overDraft - this.overDraftInUse)) < value)
            System.out.println("Insufficient balance");
        else if (value > this.balance) {
            value -= this.balance;
            this.balance = 0f;
            this.overDraftInUse = (this.overDraftInUse == 0f) ? value : (this.overDraftInUse + value);
        }
        else
            this.balance -= value;
    }

    public void overDaftStatus(){
        System.out.println("Total Overdraft: " + getOverDraft());
        System.out.println("Overdraft in use: " + getOverDraftInUse());
        System.out.println("Overdraft facility available: " + (getOverDraft() - getOverDraftInUse()));
    }

    public static void main(String[] args)
    {
        BankAccount bankAccount = new BankAccount();
        String controller;
        do {
            System.out.println("Choose an option between 1 and 5:\n" +
                    "1 - Consultar saldo\n" +
                    "2 - Consultar cheque especial.\n" +
                    "3 - Depositar dinheiro Sacar dinheiro\n" +
                    "4 - Pagar um boleto.\n" +
                    "5 - Verificar se a conta está usando cheque especial.\n" +
                    "6 - Sacar\n" +
                    "7 - Dados da conta.");
            controller = Scanner.nextLine();
            switch (controller) {
                case "1" -> bankAccount.checkBalance();
                case "2" -> bankAccount.checkOverDraft();
                case "3" -> bankAccount.depositFun();
                case "4" -> bankAccount.payBills();
                case "5" -> bankAccount.overDaftStatus();
                case "6" -> bankAccount.withdrawFun();
                case "7" -> bankAccount.dataAccount();
                case "exit" -> {}
                default -> System.out.println("Invalid Option!");
            }
        }
        while (!controller.equalsIgnoreCase("exit"));
    }
}
