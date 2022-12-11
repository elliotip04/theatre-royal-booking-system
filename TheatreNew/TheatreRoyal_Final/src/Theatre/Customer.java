package Theatre;
//import java.sql.Date;
//import java.sql.Time;

public class Customer {
	private Boolean infiniteBudget;
//	private TheatreRoyal currentTheatre;
	private int ticketsBought;
	
	public Customer() {
		infiniteBudget = true;
//		currentTheatre = null;
		ticketsBought = 0;
	}

	
	public Boolean getBudget() {
		return infiniteBudget;
	}
	
	public int getTicketsBought() {
		return ticketsBought;
	}

//	public TheatreRoyal getCurrentTheatre() {
//		return currentTheatre;
//	}
	
	
//	 public void enter(TheatreRoyal newTheatre) {
//	        if (currentTheatre == null){
//	        	currentTheatre = newTheatre;
//	        }
	
//	public void exit() {
//        currentTheatre = null;
//    }
	
//	public void buy(int numOfTickets, Show show, Date date, Time time) {
//        // customer can only buy when in the theater and has unlimited budget
//        if (currentTheatre != null && infiniteBudget == true){
//            // change the amount the theater has sold using manager sell method
//            manager.sell();
//	          ticketsBought = ticketsBought + numOfTickets;
//    }
	    }

	
	
	
	
	

