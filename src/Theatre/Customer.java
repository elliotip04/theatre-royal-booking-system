package Theatre;
//import java.sql.Date;

//import java.sql.Time;

public class Customer {
	private Boolean infiniteBudget;
//	private TheatreRoyal currentTheatre;
	private int ticketsBought;
	private String name, email, address;
	private Encryption encryption;

	public Customer(String name, String email, String address) {
		infiniteBudget = true;
//		currentTheatre = null;
		ticketsBought = 0;
//		this.name = name;
//		this.email = email;
//		this.address = address;
		encryption = new Encryption();
	}

	public int getTicketsBought() {
		return ticketsBought;
	}

	public void setTicketsBought(int ticketsBought) {
		this.ticketsBought = ticketsBought;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Encryption getEncryption() {
		return encryption;
	}

	public void setEncryption(Encryption encryption) {
		this.encryption = encryption;
	}

	public Boolean getInfiniteBudget() {
		return infiniteBudget;
	}

}
