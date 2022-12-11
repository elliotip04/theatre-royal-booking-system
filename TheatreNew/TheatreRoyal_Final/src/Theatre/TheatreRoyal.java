package Theatre;

	import java.io.FileWriter; // Import the FileWriter class
	import java.io.IOException; // Import the IOException class to handle errors
import java.sql.ResultSet;
import java.util.ArrayList;

	public class TheatreRoyal {

		private Manager manager;
		private Performance performance;
		private InputReader reader;
		private Booking booking;
		private int stall, circle, orderNo, select;
		private double postageFee;
		private DBConnector connector;

		public TheatreRoyal() {
			DBConnector connector = new DBConnector();
			manager = new Manager();
			reader = new InputReader();
			stall = 120;
			circle = 80;
			orderNo = 0;
			select = 0;
		}
		
		public int getSelect() {
			return select;
		}

		public void start() {
			System.out.println("\n\n\nWelcome to the Theatre Royal");
			System.out.println("Here's a list of all our current shows:");
			browse();
			printOptionMenu();
		}

		public void printOptionMenu() {
			int choice = 0;
			System.out.println("\n\nWould you like to: ");
			System.out.println("1:	Browse through performances");
			System.out.println("2:	Search for a specific show using date and time");
			System.out.println("3:	Add a ticket to basket");
			System.out.println("4:	Display basket");
			System.out.println("5:	Go to checkout and complete purchase");
			while (choice < 1 || choice > 5) {
				choice = reader.getNumber("\nEnter the number of the function you wish to perform");
			}
			if (choice == 1) {
				browse();
				printOptionMenu();
			} else if (choice == 2) {
				search();
				printOptionMenu();
			} else if (choice == 3) {
				manager.clearBooking();
				Ticket ticket = new Ticket();
				booking.addOrderToBasket(ticket);
				printOptionMenu();
			} else if (choice == 4) {
				booking.getBasket();
				printOptionMenu();
			} else if (choice == 5) {
				if (booking.getBasket() > 0) {
					sell();
//					checkout();
					// next customer
					start();
				} else {
					System.out.println("\n\nYour basket is empty! Please select a ticket before checkout.");
					printOptionMenu();
				}
			}

		}

		public void browse() {
			connector.connect();
			int select = 0;
			ResultSet rs = connector.runQuery("SELECT p.performance_id, p.performance_date, s.show_title, p.start_time FROM performance p left join show s on p.show_id = s.show_id");
			connector.printResult(rs);
		    while (select < 1 || select > 11); {
		    select = reader.getNumber("\nPlease select the performance ID of the show you'd like to view in details");
		    }
		    if (select == 1) {
		    	ResultSet one = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 1");
		    	connector.printResult(one);
		    }
		    if (select == 2) {
		    	ResultSet two = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 2");
		    	connector.printResult(two);
		    }
		    if (select == 3) {
		    	ResultSet three = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 3");
		    	connector.printResult(three);
		    }
		    if (select == 4) {
		    	ResultSet four = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 4");
		    	connector.printResult(four);
		    }
		    if (select == 5) {
		    	ResultSet five = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 5");
		    	connector.printResult(five);
		    }
		    if (select == 6) {
		    	ResultSet six = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 6");
		    	connector.printResult(six);
		    }
		    if (select == 7) {
		    	ResultSet seven = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 7");
		    	connector.printResult(seven);
		    }
		    if (select == 8) {
		    	ResultSet eight = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 8");
		    	connector.printResult(eight);
		    }
		    if (select == 9) {
		    	ResultSet nine = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 9");
		    	connector.printResult(nine);
		    }
		    if (select == 10) {
		    	ResultSet ten = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 10");
		    	connector.printResult(ten);
		    }
		    if (select == 11) {
		    	ResultSet eleven = connector.runQuery("SELECT show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id = 11");
		    	connector.printResult(eleven);
		    }
		    connector.close();
		}
		
		//reference = date YYYYMMDD
		//reference = time HHMM

		public void search() {
			connector.connect();
			int date = reader.getNumber("\nEnter the date as YYYYMMDD and we'll show you the performances available");
			ResultSet s = connector.runQuery("SELECT p.performance_date, p.start_time, s.show_title, s.show_duration, s.show_description, s.show_language FROM performance p left join show s on p.show_id = s.show_id where performance_date =" + date);
			connector.printResult(s);
			// query the database
		}

		public void sell() {
			int date = reader.getNumber("Enter the performance date in the format YYYYMMDD");
			while (date < 6 || date > 6) {
				date = reader.getNumber("Enter the performance date in the format YYYYMMDD");
			}
			int time = reader.getNumber("Enter the performance stage time in the format HHMM");
			while (time < 4 || time > 4) {
				date = reader.getNumber("Enter the performance stage time in the format HHMM");
			}
			if (!performance.getDate().equals(date) && !performance.getTime().equals(time)) {
				// doesn't contain key = back to the start
				System.out.println("Performance not found at specified date and stage time, please try again.");
				sell();
			} else {
				browse();
				connector.connect();
				String seat = reader.getText("What type of seat do you want? ('S' for stall, 'C' for circle");
				if (seat.equals("S")) {
					Ticket ticket = new Ticket();
					ticket.toggleStall();
					if (stall > 0) {
						System.out.println("There are " + stall + " stall seats available");
						int quantity = reader.getNumber("How many stall seats do you want to book?");
						if (quantity <= stall) {
							for (int i = 0; i < quantity; i++) {
								String ticketType = reader.getText(
										"\nWill this ticket be for standard or concession entry?('S' for standard, 'C' for concession)");
								ResultSet price = connector.runQuery("SELECT price from performance where performance_id =" + select);
								connector.printResult(price);
								if (ticketType.equals("C")) {
									ticket.toggleConcession();
									System.out.println("Ticket type set to concession");
									ResultSet concession = connector.runQuery("SELECT price_concession from performance where performance_id =" + select);
									connector.printResult(concession);
								} else {
									System.out.println("Ticket type set to standard");
									ticketType = "S";
								}
								manager.clearBooking();
								booking.addOrderToBasket(ticket);
								System.out.println("\n Your ticket was successfully added to basket");
							}
						}

					}
				} else if (seat.equals("C")) {
					Ticket ticket = new Ticket();
					ticket.toggleCircle();
					browse();
					if (circle > 0) {
						System.out.println("There are " + circle + " circle seats available");
						int quantity = reader.getNumber("How many circle seats do you want to book?");
						if (quantity <= circle) {
							for (int i = 0; i < quantity; i++) {
								String ticketType = reader.getText(
										"\nWill this ticket be for standard or concession entry?('S' for standard, 'C' for concession)");
								ResultSet price = connector.runQuery("SELECT price from performance where performance_id =" + select);
								connector.printResult(price);
								if (ticketType.equals("C")) {
									ticket.toggleConcession();
									System.out.println("Ticket type set to concession");
									ResultSet concession = connector.runQuery("SELECT price_concession from performance where performance_id =" + select);
									connector.printResult(concession);
								} else {
									System.out.println("Ticket type set to standard");
									ticketType = "S";
								}
								manager.clearBooking();
								booking.addOrderToBasket(ticket);
								System.out.println("\n Your ticket was successfully added to basket");
							}
						}
					}
				} else {
					System.out.println("\nSeat type entered incorrectly, please try again");
				}
			}
		}


//		public void removeTicket(Ticket ticket) {
//			basket.remove(ticket);
//			String type = ticket.getTicketType();
//			if (type == "STA") {
//				ticket.getPerformance().getSeatList().unbookStallSeat();
//			} else {
//				ticket.getPerformance().getSeatList().unbookCircleSeat();
//			}
//
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

//		public void checkout() {
//			// ask for their details - name, address, card number
//			String name = reader.getText("Please enter your first and last name");
//			String address = reader.getText("Please enter your full address");
//			String cardNo = reader.getText("Please enter your 16 digit card number");
//			while (cardNo.length() < 16) {
//				cardNo = reader.getText("Please enter your 16 digit card number");
//			}
//			cardNo = Encryption.encrypt("card", cardNo);
//			
//			System.out.println("Your basket total is " + getBasketTotal());
//			String collect = reader.getText(
//					"Would you like to collect your tickets or have them posted (Type 'C' to collect or 'P' to deliver)");
//			if (collect.equals("P") || collect.equals("p")) {
//				System.out.println("You have opted to have your tickets posted");
//				// go through every ticket in basket
//				postageFee = 0;
//				int concessionCount = 0;
//				for (Ticket ticket : booking.getBasket()) {
//					// if ticket type is c, increment counter
//					if (ticket.getPriceType().equals("C")) {
//						concessionCount++;
//					}
//				}
//				if (concessionCount == booking.getBasket()) {
//					// if c = basket size, posting is free
//					postageFee = 0;
//				} else if (concessionCount > 0) {
//					// else if c is > 0, posting is only £1
//					postageFee = 1;
//				} else {
//					// else posting = £1 x basket size
//					postageFee = booking.getBasket();
//				}
//			}
//		
//			// ask to confirm purchase
//			System.out.println("Your basket total is " + getBasketTotal());
//			String confirm = reader.getText("Are you happy to confirm your order? ('y' for yes or 'n' for no)");
//			// if happy to complete purchase
//			if (confirm.equals("y")) {
//				// complete - generate order file and clear basket.
//				System.out.println("Order confirmed");
//				orderNo++;
//				String filename = "order0000" + orderNo + ".txt";
//				try {
//					FileWriter myWriter = new FileWriter("C:\\Users\\Joe\\Downloads\\" + filename);
//					myWriter.write("Order0000" + orderNo);
//					myWriter.write("\n Name: " + name);
//					myWriter.write("\n Address: " + address);
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
//
//		}
//
//		public double getBasketTotal() {
//			double total = 0;
//			for (Ticket ticket : booking.getBasket()) {
//				total += ticket.getPriceType();
//			}
//			return total;
//		}
	}