package Theatre;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testAddOrderToBasket() {
//		ticket t = new Ticket(); 
//		Booking b = new Booking(ticket, 2); 
//		b.addOrderToBasket();
//		Assert.assertEquals("Confirm first before adding to basket.", b.addOrderToBasket());
//		b.toggleMoveToBasket(); 
//		Assert.assertEquals("Added to basket.", b.addOrderToBasket()); // test case for orderConfirmed == true
//		Assert.assertEquals(2, b.getBasket().size());
//	}
//
//	@Test
//	void testPlaceBooking() {
//		ticket t = new Ticket(); 
//		Booking b = new Booking(t, 3); 
//		b.toggleMoveToBasket(); 
//		b.addOrderToBasket(t);
//		assertEquals(0, b.placeBooking().size()); // test case for orderConfirmed == false
//		b.toggleOrderConfirmed();
//		assertEquals(3, b.placeBooking().size()); // test case for orderConfirmed == true
//	}
//
//	@Test
//	void testResetBooking() {
//		Performance p = new Performance(2022-12-13, 19-00-00-00);
//		ticket t = new Ticket(); 
//		Booking b = new Booking(ticket, 1); 
//		b.toggleMoveToBasket(); 
//		b.addOrderToBasket();
//		b.toggleOrderConfirmed();
//		b.placeBooking(null);
//		b.resetBooking();
//		assertEquals(0, b.getNumOfTickets());
//		assertEquals(0, b.getBasket());
//		assertEquals(false, b.isOrderConfirmed());
//
//	}
}
