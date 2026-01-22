public non-sealed class HalfPriceTicket extends TicketMovie {
    private final int amount;
    private final double totalPrice;

    public HalfPriceTicket(int amount, String dubbedOrSubtitled, String movieName) {
        super(movieName, dubbedOrSubtitled);
        this.amount = amount;
        this.totalPrice = (this.getPrice() / 2) * this.amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getAmount() {
        return amount;
    }
}
