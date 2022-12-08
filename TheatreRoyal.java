
	import java.io.FileWriter; // Import the FileWriter class
	import java.io.IOException; // Import the IOException class to handle errors
	import java.util.ArrayList;

	public class TheatreRoyal {

		private Manager manager;
		private Performance performance;
		private InputReader reader;
		private Booking booking;
		private int stall, circle, orderNo;
		private double postageFee;

		public TheatreRoyal(Performance performance) {
			this.performance = performance;
			booking = new Booking();
			manager = new Manager();
			reader = new InputReader();
			stall = 120;
			circle = 80;
			orderNo = 0;
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
			System.out.println("2:	Search for a specific show");
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
				booking.addOrderToBasket();
				printOptionMenu();
			} else if (choice == 4) {
				booking.getBasket();
				printOptionMenu();
			} else if (choice == 5) {
				if (booking.getBasketSize() > 0) {
					sell();
					checkout();
					// next customer
					start();
				} else {
					System.out.println("\n\nYour basket is empty! Please select a ticket before checkout.");
					printOptionMenu();
				}
			}

		}

		public void browse() {
			DBConnector connector = new DBConnector();
			connector.runQuery("Show");
//			connector.printResult(null);
		}

		public void search() {
			// query the database
		}

		public void sell() {
			int date = reader.getNumber("Enter the performance date in the format YYMMDD");
			while (date < 6 || date > 6) {
				date = reader.getNumber("Enter the performance date in the format YYMMDD");
			}
			int time = reader.getNumber("Enter the performance stage time in the format HHMM");
			while (time < 4 || time > 4) {
				date = reader.getNumber("Enter the performance stage time in the format HHMM");
			}
			if (!performance.getPerformance().containsKey(date + time)) {
				// doesnt contain key = back to the start
				System.out.println("Performance not found at specified date and stage time, please try again.");
				sell();
			} else {
				Performance performance = performance.getPerformance(date + time);
				String seat = reader.getText("What type of seat do you want? ('S' for stall, 'C' for circle");
				if (seat.equals("S")) {
					int availableStall = getAvailableStallSeats();
					if (availableStall > 0) {
						System.out.println("There are " + availableStall + " stall seats available");
						int quantity = reader.getNumber("How many stall seats do you want to book?");
						if (quantity <= availableStall) {
							for (int i = 0; i < quantity; i++) {
								String ticketType = reader.getText(
										"\nWill this ticket be for standard or concession entry?('S' for standard, 'C' for concession)");
								double price = performance.getStallPrice();
								if (ticketType.equals("C")) {
									System.out.println("Ticket type set to concession");
									price = (price / 4) * 3;
								} else {
									System.out.println("Ticket type set to standard");
									ticketType = "S";
								}
								Ticket ticket = new Ticket(performance, "STA", ticketType, price);
								manager.clearBooking();
								booking.addOrderToBasket();
								performance.reserveStallSeat();
								System.out.println("\n Your ticket was successfully added to basket");
							}
						}

					}
				} else if (seat.equals("C")) {
					int availableCircle = performance.getAvailableCircleSeats();
					if (availableCircle > 0) {
						System.out.println("There are " + availableCircle + " circle seats available");
						int quantity = reader.getNumber("How many circle seats do you want to book?");
						if (quantity <= availableCircle) {
							for (int i = 0; i < quantity; i++) {
								String ticketType = reader.getText(
										"\nWill this ticket be for standard or concession entry?('S' for standard, 'C' for concession)");
								double price = performance.getStallPrice();
								if (ticketType.equals("C")) {
									System.out.println("Ticket type set to concession");
									price = (price / 4) * 3;
								} else {
									System.out.println("Ticket type set to standard");
									ticketType = "S";
								}
								Ticket ticket = new Ticket(performance, "STA", ticketType, price);
								manager.clearBooking();
								booking.addOrderToBasket();
								performance.reserveStallSeat();
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

		public void displayBasket() {
			int counter = 1;
			for (Ticket ticket : booking.basket) {
				System.out.println("Ticket: " + counter);
				ticket.printTicketDetails();
				System.out.println("-----------------------------------------------");
				counter++;
			}
			System.out.println("Basket total: " + getBasketTotal());
		}

		public void checkout() {
			// ask for their details - name, address, card number
			String name = reader.getText("Please enter your first and last name");
			String address = reader.getText("Please enter your full address");
			String cardNo = reader.getText("Please enter your 16 digit card number");
			while (cardNo.length() < 16) {
				cardNo = reader.getText("Please enter your 16 digit card number");
			}
			cardNo = Encryption.encrypt("card", cardNo);
			
			System.out.println("Your basket total is " + getBasketTotal());
			String collect = reader.getText(
					"Would you like to collect your tickets or have them posted (Type 'C' to collect or 'P' to deliver)");
			if (collect.equals("P") || collect.equals("p")) {
				System.out.println("You have opted to have your tickets posted");
				// go through every ticket in basket
				postageFee = 0;
				int concessionCount = 0;
				for (Ticket ticket : booking.basket) {
					// if ticket type is c, increment counter
					if (ticket.getTicketType().equals("C")) {
						concessionCount++;
					}
				}
				if (concessionCount == booking.getBasketSize()) {
					// if c = basket size, posting is free
					postageFee = 0;
				} else if (concessionCount > 0) {
					// else if c is > 0, posting is only £1
					postageFee = 1;
				} else {
					// else posting = £1 x basket size
					postageFee = booking.getBasketSize();
				}
			}
		
			// ask to confirm purchase
			System.out.println("Your basket total is " + getBasketTotal());
			String confirm = reader.getText("Are you happy to confirm your order? ('y' for yes or 'n' for no)");
			// if happy to complete purchase
			if (confirm.equals("y")) {
				// complete - generate order file and clear basket.
				System.out.println("Order confirmed");
				orderNo++;
				String filename = "order0000" + orderNo + ".txt";
				try {
					FileWriter myWriter = new FileWriter("C:\\Users\\Joe\\Downloads\\" + filename);
					myWriter.write("Order0000" + orderNo);
					myWriter.write("\n Name: " + name);
					myWriter.write("\n Address: " + address);
					int counter = 1;
					for (Ticket ticket : booking.basket) {
						myWriter.write("\nTicket " + counter + ":");
						String show = ticket.getPerformance().getShow().getTitle();
						myWriter.write("\nTitle: " + show);
						String ticketType = ticket.getTicketType();
						myWriter.write("\nTicket type: " + ticketType);
						String seatType = ticket.getSeatType();
						myWriter.write("\nSeat type: " + seatType);
						String price = "" + ticket.getPrice();
						myWriter.write("\nPrice: " + price);
						myWriter.write("\n-------------------------------------");
					}
					myWriter.close();
					System.out.println("Order file successfully generated. Check downloads folder");
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
				booking.resetBooking();
				postageFee=0;
			} else {
				// else not happy to complete purchase take back to main menu
				printOptionMenu();
			}

		}

		public double getBasketTotal() {
			double total = 0;
			for (Ticket ticket : booking.basket) {
				total += ticket.getPrice();
			}
			return total;
		}
	}