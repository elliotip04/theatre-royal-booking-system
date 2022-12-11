package Theatre;
import java.util.ArrayList;
import java.util.Random;

//import theatre.TicketClass;   

public class Booking {

	private ArrayList<Ticket> basket;
	private Ticket ticket;
	//private Performance performance;
	//private DBConnector connector;
	//private Manager manager;
	private int numOfTickets;
	private boolean moveToBasket;
	private boolean orderConfirmed;
	//private Random random;
	private Random bookingId;
	private int performanceId;
	private ArrayList<Random> soldTicketCollection;
	
	public Booking(Ticket ticket, int numOfTickets) {
		this.ticket = new Ticket();
		this.numOfTickets = numOfTickets;
		moveToBasket = false;
		orderConfirmed = false;
		bookingId = null;
		basket = new ArrayList<Ticket>();
		soldTicketCollection = new ArrayList<Random>();

	}

	public ArrayList<Ticket> getBasket() {
		return basket;
	}

	public void setBasket(ArrayList<Ticket> basket) {
		this.basket = basket;
	}

	public boolean isMoveToBasket() {
		return moveToBasket;
	}

	public boolean isOrderConfirmed() {
		return orderConfirmed;
	}

	public Random getBookingId() {
		return bookingId;
	}

	public void setBookingId(Random bookingId) {
		this.bookingId = bookingId;
	}
	
	public int getNumOfTickets() {
		return numOfTickets;
	}

	public void setNumOfTickets(int numOfTickets) {
		this.numOfTickets = numOfTickets;
	}
	
	public void toggleMoveToBasket() {
		moveToBasket = !moveToBasket;
	}

	public void toggleOrderConfirmed() {
		orderConfirmed = !orderConfirmed;
	}
	
	public void addOrderToBasket(Ticket order) {
		// Require a method in Ticket class to get the ticket before adding to basket
		if (moveToBasket == true) { 
			// only add ticket/order to basket when true
		Ticket ticket = order;
		basket.add(ticket); 
		System.out.println("Added to basket.");
		}
		else {
		System.out.println("Confirm first before adding to basket.");
		}
	}
	
	public ArrayList<Random> placeBooking() {
		Manager manager = new Manager();
		Performance performance = new Performance(null, null, null, 0.0);
		DBConnector connector = new DBConnector();
		Random random = new Random();

		connector.connect();
		connector.runQuery("SELECT peformance_ID from performance");

		if (manager.clearBooking()== true) {
		int bookingId = random.nextInt();

			for (int i = 0; i < numOfTickets; i++) {
				// call DBConnector class to run sql query
				connector.connect();

				// ticket_sold_id will increment in mysql as AUTO_INCREMENT is enabled when tickets_sold ticket was created
				query = "INSERT INTO ticket_sold (`tickets_sold_id`, `performance_id`, `booking_id`, `seat_type`, `number_of_tickets_sold`) VALUES ("
						+ 0 + "," + performanceId + "," + bookingId + "," + ticket.getSeatType() + "," + 1 + ")"; 
								
				rs = connector.runQuery(query);
				connector.printResult(rs);
				connector.close();

				soldTicketCollection.add(bookingId);
			}
		}
		else {
			System.output.println("Booking needs to be cleared first.");
		}

		System.output.println(soldTicketCollection.size() + " tickets booked."); // printing number of tickets sold
		System.output.println("Booking ID: " + bookingId); // printing booking ID

		return soldTicketCollection;
	}
	
	public void resetBooking() {
		moveToBasket = false;
		orderConfirmed = false;
		basket.clear();
		soldTicketCollection.clear();
	}
}
