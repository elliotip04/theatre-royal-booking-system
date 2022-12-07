import java.util.ArrayList;
import java.util.Random;   

public class Booking {

	private ArrayList<Ticket> basket;
	private Ticket ticket;
	private Performance performance;
	private DBConnector connector;
	private Manager manager;
	private int numOfTickets;
	private boolean moveToBasket;
	private boolean orderConfirmed;
	private Random random;
	private int bookingID;
	private int performanceID;
	
	
	public Booking(Ticket ticket, int numOfTickets) {
		this.ticket = new Ticket();
		this.numOfTickets = 0;
		basket = new ArrayList<Ticket>();
		manager = new Manager();
		performance = new Performance();
		moveToBasket = false;
		orderConfirmed = false;
		Random random = new Random();
		bookingID = null;
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

	public void setMoveToBasket(boolean moveToBasket) {
		this.moveToBasket = moveToBasket;
	}

	public boolean isOrderConfirmed() {
		return orderConfirmed;
	}

	public void setOrderConfirmed(boolean orderConfirmed) {
		this.orderConfirmed = orderConfirmed;
	}

	public Random getBookingID() {
		return bookingID;
	}

	public void setBookingID(Random bookingID) {
		this.bookingID = bookingID;
	}
	
	public int getNumOfTickets() {
		return numOfTickets;
	}

	public void setNumOfTickets(int numOfTickets) {
		this.numOfTickets = numOfTickets;
	}

	public int getPerformanceID() {
		return performanceID;
	}

	public void setPerformanceID(int performanceID) {
		this.performanceID = performanceID;
	}
	
	public void toggleMoveToBasket() {
		moveToBasket = !moveToBasket;
	}

	public void toggleOrderConfirmed() {
		orderConfirmed = !orderConfirmed;
	}
	
	public void addOrderToBasket() {
		// Require a method in Ticket class to get the ticket before adding to basket
		// order = ticket.getTicket() 
		if (moveToBasket == true) { 
			// only add ticket/order to basket when true
			basket.add(order);
			
			message = "Added to basket.";
		}
		else {
			message = "Confirm first before adding to basket.";
		}
		return message;
	}
	
	public String placeBooking() {
		if (manager.clearBooking() == true) {
			// call DBConnector class to run sql query
			int bookingID = random.nextInt();
			int performanceID = performance.getPerformanceID();
			
			connector.connect();
			
			query = 
				"INSERT INTO ticket_sold (`Booking ID`, `Performance ID`, `Seat Type`, `Number of Tickets Sold`) VALUES ("
				+ bookingID + "," + performanceID + "," + ticket.getSeatType() + "," + numOfTickets + ")";
							
			rs = connector.runQuery(query);
			connector.printResult(rs);
			connector.close();
			
			message = "Booking placed.";
		}
			
		else {
			message = "Booking needs to be cleared first.";
		}
		return message;
	}
	
	public void resetBooking() {
		moveToBasket = false;
		orderConfirmed = false;
		basket.clear();
	}
}
