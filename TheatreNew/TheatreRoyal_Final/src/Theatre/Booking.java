package Theatre;
import java.util.ArrayList;
import java.util.Random;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

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
	private ArrayList<Integer> soldTicketCollection;
	
	public Booking(Ticket ticket, int numOfTickets) {
		resetBooking();
		this.ticket = new Ticket();
		this.numOfTickets = numOfTickets;
		bookingId = null;
		setBasket(new ArrayList<Ticket>());
		soldTicketCollection = new ArrayList<Integer>();

	}

	public int getBasket() {
		return basket.size();
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
	
	public ArrayList<Integer> placeBooking(Performance performance) {
		Manager manager = new Manager();
		Show s = new Show(null, null, null, null, null, false, null);
		Performance p = performance;
		DBConnector connector = new DBConnector();
		Random random = new Random();

		if (manager.clearBooking() == true) {
		connector.connect();
		ResultSet showId = connector.runQuery("SELECT show_ID from show where show_name =" + s.getTitle());
		ResultSet time = connector.runQuery("SELECT start_time from performance where start_time =" + p.getTime());
		ResultSet date = connector.runQuery("SELECT performance_date from performance where performance_date =" + performance.getDate());
		ResultSet performanceId = connector.runQuery("SELECT performance_id from performance WHERE show_id =" + showId + "and start_time =" + time + "and performance_date =" + date);
        connector.close();
		int bookingId = random.nextInt();

			for (int i = 0; i < numOfTickets; i++) {
				// call DBConnector class to run sql query
				connector.connect();

				// ticket_sold_id will increment in mysql as AUTO_INCREMENT is enabled when tickets_sold ticket was created
				String query = "INSERT INTO ticket_sold (`tickets_sold_id`, `performance_id`, `booking_id`, `seat_type`, `number_of_tickets_sold`) VALUES ("
						+ 0 + "," + performanceId + "," + bookingId + "," + ticket.getSeatType() + "," + 1 + ")"; 
								
				ResultSet rs = connector.runQuery(query);
				connector.printResult(rs);
				connector.close();
				soldTicketCollection.add(bookingId);
			}
		}
		else {
			System.out.println("Booking needs to be cleared first.");
		}

		System.out.println(soldTicketCollection.size() + " tickets booked."); // printing number of tickets sold
		System.out.println("Booking ID: " + bookingId); // printing booking ID

		return soldTicketCollection;
	}
	
	public void resetBooking() {
		moveToBasket = false;
		orderConfirmed = false;
		basket.clear();
		soldTicketCollection.clear();
	}
}

