package Theatre;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void ConstructorCustomer() {
		Customer customer1 = new Customer();
		// assertNull(customer1.getCurrentTheatre(), "A new customer's shop should be
		// null\n");
		assertTrue(customer1.getBudget(), "A new customer should have unlimited budget\n");
	}
//
//	@Test
//	    public void testCustomerEnterExitTheatre() {
//	        Customer customer = new Customer();
//	        TheatreRoyal theatre1 = new TheatreRoyal();
//	        TheatreRoyal theatre2 = new TheatreRoyal();
//
//	        customer.enter(theatre1);
//	        assertEquals(theatre1, customer.getCurrentTheatre();
//	        
//	        customer.exit();
//	        assertNull(customer.getCurrentTheatre();
//
//	        customer.enter(theatre2);
//	        assertEquals(theatre2, customer.getCurrentTheatre();
//    }
	
//	 @Test
//	    public void testCustomerBuys(){
//		 Customer customer = new Customer();
//	     TheatreRoyal theater = new TheatreRoyal();
//	     Ticket ticket = new Ticket();
//	     
//	     customer.enter(theater);
//         assertEquals(theater, customer.getCurrentTheatre());
//
//	     customer.buy(5, Stormzy Concert, 2022-10-12, 19:00);
//	     assertEquals(5, ticket.getSoldTickets());
//	     assertEquals("You just bought 5 tickets for Stormzy Concert! Thank you.", theater.getPurchaseMessage());
//	     
//	 }
}
