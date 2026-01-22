public non-sealed class FamilyTicket extends TicketMovie {

    private final int amount;
    private final double totalPrice;

    public FamilyTicket(int amount, String dubbedOrSubtitled, String movieName) {
        super(movieName, dubbedOrSubtitled);
        this.amount = amount;
        this.totalPrice = (amount >= 3) ? (this.getPrice() * amount * 0.95) : (this.getPrice() * amount);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getAmount() {
        return amount;
    }
}