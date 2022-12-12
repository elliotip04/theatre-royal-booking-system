package Theatre;

import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TheatreRoyal {

	private Performance performance;
	private InputReader reader;
	private Booking booking;
	private Ticket ticket;
	private int stall, circle, orderNo, select, orderTotal;
	private double postageFee;
	private DBConnector connector;
	private Customer customer; // null = logged out; !null = logged in;

	public TheatreRoyal() {
		customer = null;
		connector = new DBConnector();
		connector.connect();
		reader = new InputReader();
		stall = 120;
		circle = 80;
		orderNo = 0;
		select = 0;
		orderTotal = 0;
	}

	public int getSelect() {
		return select;
	}

	public void start() {
		System.out.println("Welcome to the Theatre Royal! We're glad to have you here.");
		printOptionMenu();
//			browse();
//			printOptionMenu();
	}

	public void printOptionMenu() {
		int choice = 0;
		// if conditions for customer log in
		System.out.println("\n\nWould you like to: ");
		System.out.println("1:	Browse through shows");
		System.out.println("2:	Search for a date to see the available performances");
		System.out.println("3:	Log in to complete a purchase");
		// login now turns into these new options
		while (choice < 1 || choice > 7) {
			choice = reader.getNumber("\nEnter the number of the function you wish to perform");
		}
		if (choice == 1) {
			browse();
			printOptionMenu();
		} else if (choice == 2) {
			search();
			printOptionMenu();
		} else if (choice == 3) {
			customerLogin();
			System.out.println("\n\nWhat would you like to do next?");
			System.out.println("4:	Add a ticket to basket");
			System.out.println("5:	Display basket");
			System.out.println("6:	Go to checkout");
			choice = 0;
			while (choice < 1 || choice > 7) {
				choice = reader.getNumber("\nEnter the number of the function you wish to perform");
				// bug here! prints a specific line from the search() method, very weird.
			}
			if (choice == 4) {
				sell();
				booking.addOrderToBasket(ticket);
				printOptionMenu();
			} else if (choice == 5 && booking.getBasket() != null) {
				int basket = booking.getBasket().size();
				System.out.println("Here's how many tickets you have in your basket " + basket);
				System.out.println("Total order value of GBP " + orderTotal);
				printOptionMenu();
			} else if (choice == 6) {
				if (booking.getBasket().size() > 0) {
//					sell();
					checkout();
					// next customer
					start();
				} else {
					System.out.println("\n\nYour basket is empty! Please select a ticket before checkout.");
					printOptionMenu();
				}
			}
		}

	}

	public void customerLogin() {
		customer = new Customer(null, null, null);
		System.out.println("Before selecting and purchasing a ticket, we'll need you to log in to your account.");
		String name = reader.getText("\nPlease enter your name");
		customer.setName(name);
		String email = reader.getText("\nPlease enter your email");
		customer.setEmail(email);
		String address = reader.getText("\nPlease enter your address");
		customer.setAddress(address);
		customer = new Customer(name, email, address);
	}

	public void browse() {
		int select = 0;
		ResultSet rs = connector.runQuery(
				"SELECT p.performance_id, p.performance_date, s.show_name, p.start_time FROM performance p left join theatre.show s on p.show_id = s.show_id");
		System.out.println("Here's a list of all our current shows:");
		connector.printResultStart(rs);
		while (select < 1 || select > 11) {
			select = reader.getNumber("\nPlease enter the performance ID of the show you'd like to view in details");
		}
		if (select == 1) {
			ResultSet one = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 1");
			connector.printResultBrowse(one);
		}
		if (select == 2) {
			ResultSet two = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 2");
			connector.printResultBrowse(two);
		}
		if (select == 3) {
			ResultSet three = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 3");
			connector.printResultBrowse(three);
		}
		if (select == 4) {
			ResultSet four = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 4");
			connector.printResultBrowse(four);
		}
		if (select == 5) {
			ResultSet five = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 5");
			connector.printResultBrowse(five);
		}
		if (select == 6) {
			ResultSet six = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 6");
			connector.printResultBrowse(six);
		}
		if (select == 7) {
			ResultSet seven = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 7");
			connector.printResultBrowse(seven);
		}
		if (select == 8) {
			ResultSet eight = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 8");
			connector.printResultBrowse(eight);
		}
		if (select == 9) {
			ResultSet nine = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 9");
			connector.printResultBrowse(nine);
		}
		if (select == 10) {
			ResultSet ten = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 10");
			connector.printResultBrowse(ten);
		}
		if (select == 11) {
			ResultSet eleven = connector.runQuery(
					"SELECT s.show_name, s.show_type, s.show_duration, s.show_description, s.show_language FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where p.performance_id = 11");
			connector.printResultBrowse(eleven);
		}
	}

	// reference = date YYYYMMDD
	// reference = time HHMM

	public void search() {
		int date = -999;
		while (date < 0) {
			date = reader.getNumber(
					"\nEnter the date as YYYYMMDD and we'll show you the performances available for that date.");
		}
		ResultSet s = connector.runQuery(
				"SELECT s.show_name, p.start_time FROM theatre.performance p left join theatre.show s on p.show_id = s.show_id where performance_date ="
						+ date);
		connector.printResultSearch(s);
	}

	public void sell() {
//		int date = reader.getNumber("Enter the performance date in the format YYYYMMDD");
//		while (date < 6 || date > 6) {
//			date = reader.getNumber("Enter the performance date in the format YYYYMMDD");
//		}
//		int time = reader.getNumber("Enter the performance stage time in the format HHMM");
//		while (time < 4 || time > 4) {
//			date = reader.getNumber("Enter the performance stage time in the format HHMM");
//		}
//		if (!performance.getDate().equals(date) && !performance.getTime().equals(time)) {
//			// doesn't contain key = back to the start
//			System.out.println("Performance not found at specified date and stage time, please try again.");
//			sell();
//		} else {
//			browse();
//			connector.connect();
		int quantity = 0;
		ResultSet rs = connector.runQuery(
				"SELECT p.performance_id, p.performance_date, s.show_name, p.start_time FROM performance p left join theatre.show s on p.show_id = s.show_id");
		System.out.println("Here's a list of all our current shows:");
		connector.printResultStart(rs);
		int performance = reader.getNumber("\nPlease enter the performance ID of the show you'd like to book.");
		ticket = new Ticket(performance);
		String seat = reader.getText("What type of seat do you want? ('S' for stall, 'C' for circle)");
		if (seat.equals("S")) {
			ticket.toggleStall();
			if (stall > 0) {
				System.out.println("There are " + stall + " stall seats available");
				quantity = reader.getNumber("\nHow many stall seats do you want to book?");
				if (quantity <= stall) {
					stall = stall - quantity;
					for (int i = 0; i < quantity; i++) {
						String ticketType = reader.getText(
								"\nWill this ticket be for standard or concession entry?('S' for standard, 'C' for concession)");
						ResultSet price = connector
								.runQuery("SELECT price from performance where performance_id =" + performance);
						connector.printResultStandardPrice(price);
						if (ticketType.equals("C")) {
							ticket.toggleConcession();
							System.out.println("Ticket type set to concession");
							ResultSet concession = connector.runQuery(
									"SELECT price_concession from performance where performance_id =" + performance);
							connector.printResultConcessionPrice(concession);
						} else {
							System.out.println("Ticket type set to standard");
							ticketType = "S";
						}
						booking.addOrderToBasket(ticket);
						System.out.println("\n Your ticket was successfully added to basket");
					}
				}
			}
		} else if (seat.equals("C")) {
			ticket.toggleCircle();
			if (circle > 0) {
				System.out.println("There are " + circle + " circle seats available");
				quantity = reader.getNumber("\nHow many circle seats do you want to book?");
				if (quantity <= circle) {
					circle = circle - quantity;
					for (int i = 0; i < quantity; i++) {
						String ticketType = reader.getText(
								"\nWill this ticket be for standard or concession entry?('S' for standard, 'C' for concession)");
						ResultSet price = connector
								.runQuery("SELECT price from performance where performance_id =" + performance);
						connector.printResultStandardPrice(price);
						if (ticketType.equals("C")) {
							ticket.toggleConcession();
							System.out.println("Ticket type set to concession");
							ResultSet concession = connector.runQuery(
									"SELECT price_concession from performance where performance_id =" + performance);
							connector.printResultConcessionPrice(concession);
						} else {
							System.out.println("Ticket type set to standard");
							ticketType = "S";
						}
						Booking booking = new Booking(customer, ticket, quantity);
						booking.addOrderToBasket(ticket);
						booking.addTicketToSoldCollection(quantity);
						int price1 = connector.printResultSetPriceAsInt(price);
						orderTotal = quantity * price1;
						setOrderTotal(orderTotal);
						System.out.println("\n Your ticket was successfully added to basket. Your total basket value is: " + orderTotal);
					}
				}
			}
		} else {
			System.out.println("\nSeat type entered incorrectly, please try again");
		}
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int newValue) {
		this.orderTotal += newValue;
	}

	public void checkout() {
		// ask for their details - name, address, card number
		System.out.println(
				"In order to complete your purchase, you'll need to enter your card details. Don't worry, this information will be encrypted.");
		String cardNo = reader.getText("Please enter your 16 digit card number");
		while (cardNo.length() < 16) {
			cardNo = reader.getText("Please enter your 16 digit card number");
		}
		cardNo = Encryption.encrypt("card", cardNo);

		System.out.println("Your basket total is " + getOrderTotal());
		String collect = reader.getText(
				"Would you like to collect your tickets or have them posted (Type 'C' to collect or 'P' to deliver)");
		if (collect.equals("P") || collect.equals("p")) {
			System.out.println("You have opted to have your tickets posted");
			// go through every ticket in basket
			postageFee = 0;
			int concessionCount = 0;
			for (Ticket ticket : booking.getBasket()) {
				// if ticket type is c, increment counter
				if (ticket.getPriceType() == false) {
					concessionCount++;
				}
			}
			if (concessionCount == booking.getBasket().size()) {
				// if c = basket size, posting is free
				postageFee = 0;
			} else if (concessionCount > 0) {
				// else if c is > 0, posting is only £1
				postageFee = 1;
			} else {
				// else posting = £1 x basket size
				postageFee = booking.getBasket().size();
			}
		}

		// ask to confirm purchase
		System.out.println("Your basket total is " + getOrderTotal());
		String confirm = reader.getText("Are you happy to confirm your order? ('y' for yes or 'n' for no)");
		// if happy to complete purchase
		if (confirm.equals("y")) {
			// complete - generate order file and clear basket.
			System.out.println("Order confirmed");
			orderNo++;
		}
	}
}
//				String filename = "order" + orderNo + ".txt";
//				try {
//					FileWriter myWriter = new FileWriter("C:\\Users\\Joe\\Downloads\\" + filename);
//					myWriter.write("Order" + orderNo);
//					myWriter.write("\n Name: " + customer.getName());
//					myWriter.write("\n Address: " + customer.getAddress());
//					int counter = 1;
//					for (Ticket ticket : booking.getBasket()) {
//						myWriter.write("\nTicket " + counter + ":");
//						String show = ticket.getPerformance().getShow().getTitle();
//						myWriter.write("\nTitle: " + show);
//						String ticketType = ticket.getTicketType();
//						myWriter.write("\nTicket type: " + ticketType);
//						String seatType = ticket.getSeatType();
//						myWriter.write("\nSeat type: " + seatType);
//						String price = "" + ticket.getPriceType();
//						myWriter.write("\nPrice: " + price);
//						myWriter.write("\n-------------------------------------");
//					}
//					myWriter.close();
//					System.out.println("Order file successfully generated. Check downloads folder");
//				} catch (IOException e) {
//					System.out.println("An error occurred.");
//					e.printStackTrace();
//				}
//				booking.resetBooking();
//				postageFee=0;
//			} else {
//				// else not happy to complete purchase take back to main menu
//				printOptionMenu();
//			}
//		}
//}

//			public void removeTicket(Ticket ticket) {
//			basket.remove(ticket);
//			String type = ticket.getTicketType();
//			if (type == "STA") {
//				ticket.getPerformance().getSeatList().unbookStallSeat();
//			} else {
//				ticket.getPerformance().getSeatList().unbookCircleSeat();
//			}
//		}

//		public void displayBasket() {
//			int counter = 1;
//			for (Ticket ticket : booking.getBasket()) {
//				System.out.println("Ticket: " + counter);
//				ticket.printTicketDetails();
//				System.out.println("-----------------------------------------------");
//				counter++;
//			}
//			System.out.println("Basket total: " + getBasketTotal());
//		}

//		public double getBasketTotal() {
//			double total = 0;
//			for (Ticket ticket : booking.getBasket()) {
//				total += ticket.getPriceType();
//			}
//			return total;
//		}
