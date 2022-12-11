package theatre;

import java.util.ArrayList;

public class Ticket {

	private final ArrayList<Ticket> soldTickets;
	private boolean seatType;// (true = stall / false = circle);
	private boolean priceType;// (true = standard / false = concession);
	private Show show;
	private Manager manager;
	private Customer customer;
	// (method calling for name) - what is meant by this?

	public Ticket() {
		soldTickets = new ArrayList<>();
		seatType = true;
		priceType = true;
		show = new Show();
		manager = new Manager();
		customer = new Customer();
	}

	public <Ticket> getSoldTickets() {
		return soldTickets;
	}

	public boolean getSeatType() {
		return seatType;
	}

	public boolean getPriceType() {
		return priceType;
	}

	public Show getShow() {
		return show;
	}

	public Manager getManager() {
		return manager;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void toggleCircle() {
		seatType = !seatType;
	}

	public void toggleConsesion() {
		priceType = !priceType;
	}

	public void addSoldTickets(Ticket ticket) {
		soldTickets.add(ticket);
	}

	public void generateTicket(Booking booking) {
		// only if array not full...
		if (soldTickets.size() < 200 /*&& method to check  if manager has greenlit booking?*/) {
			System.out.println("Here's your ticket:");
			System.out.println(/*method to get number of seats?*/ booking.getNumOfTickets() + " tickets to see " /*+ method to get show name? + method to get show date and stage time?*/);
			System.out.println("Thank you for booking. We hope you enjoy the show!");
		}
	}
}
