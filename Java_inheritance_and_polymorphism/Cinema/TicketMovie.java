public sealed abstract class TicketMovie permits FamilyTicket, HalfPriceTicket {
    private final double price;
    protected String movieName;
    protected String DubbedOrSubtitled;

    public TicketMovie(String movieName, String DubbedOrSubtitled){
        this.movieName = movieName;
        this.DubbedOrSubtitled = DubbedOrSubtitled;
        this.price = 50d;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDubbedOrSubtitled() {
        return DubbedOrSubtitled;
    }

    public double getPrice() {
        return price;
    }


}