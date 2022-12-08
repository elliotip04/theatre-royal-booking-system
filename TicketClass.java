package theatre;

public class TicketClass {

	private Performance performance;
	private String seatType, ticketType;
	private double price;

	public Ticket(Performance performance, String seatType, String ticketType, double price) {
			this.performance = performance;
			this.seatType = seatType;
			this.ticketType = ticketType;
			this.price = price;
		}

	public void printTicketDetails() {

		System.out.println("1 Ticket:");
		System.out.println("Ticket Type: " + ticketType);
		System.out.println("Seat Type: " + seatType);
		System.out.println("Price: " + price);
		System.out.println("Show details: ");
		performance.getShow().printShowDetails();

	}

	public String getTicketType() {
		return ticketType;
	}

	public String getSeatType() {
		return seatType;
	}

	public Performance getPerformance() {
		return performance;
	}

	public double getPrice() {
		return price;
	}

}
