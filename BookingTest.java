import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookingTest {

	@Test
	void testAddOrderToBasket() {
		ticket t = new Ticket(); 
		Booking b = new Booking(ticket, 2); 
		b.addOrderToBasket();
		Assert.assertEquals("Confirm first before adding to basket.", b.addOrderToBasket());
		b.toggleMoveToBasket(); 
		Assert.assertEquals("Added to basket.", b.addOrderToBasket()); // test case for orderConfirmed == true
		Assert.assertEquals(2, b.getBasket().size());
	}

	@Test
	void testPlaceBooking() {
		ticket t = new Ticket(); 
		Booking b = new Booking(ticket, 3); 
		b.toggleMoveToBasket(); 
		b.addOrderToBasket();
		Assert.assertEquals(0, b.placeBooking().size()); // test case for orderConfirmed == false
		b.toggleOrderConfirmed();
		Assert.assertEquals(3, b.placeBooking().size()); // test case for orderConfirmed == true
	}

	@Test
	void testResetBooking() {
		ticket t = new Ticket(); 
		Booking b = new Booking(ticket, 1); 
		b.toggleMoveToBasket(); 
		b.addOrderToBasket();
		b.toggleOrderConfirmed();
		b.placeBooking();
		b.resetBooking();
		Assert.assertEquals(0, b.getNumOfTickets());
		Assert.assertEquals(0, b.getBasket().size());
		Assert.assertEquals(false, b.isOrderConfirmed());

	}

}
