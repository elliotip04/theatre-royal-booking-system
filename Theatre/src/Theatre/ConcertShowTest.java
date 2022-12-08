package Theatre;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class ConcertShowTest {

	@Test
	void constructorConcertShowTest() {
	ConcertShow cs = new ConcertShow("Bright Eyes", 180, "Sample description", "Jane Doe");
	assertEquals("Bright Eyes", cs.getTitle());
	assertEquals(180, cs.getDuration());
	assertEquals("Jane Doe; Sample description", cs.getDescription());;
	
	}
	
	@Test
	void getDescriptionTest() {
	ConcertShow cs1 = new ConcertShow("Bright Eyes", 180, "Sample description", "Jane Doe");
	cs1.getDescription();
	assertEquals("Jane Doe; Sample description",cs1.getDescription());
}
}
