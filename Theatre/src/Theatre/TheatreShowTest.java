package Theatre;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class TheatreShowTest {

	@Test
	void constructorTheatreShowTest() {
	TheatreShow ts = new TheatreShow("Henry V", 120, "English", "Sample description");
	assertEquals("Henry V", ts.getTitle());
	assertEquals(120, ts.getDuration());
	assertEquals("Sample description", ts.getDescription());
	
	}
	
	@Test
	void getDescriptionTest() {
	TheatreShow ts1 = new TheatreShow("Henry V", 120, "English", "Sample description");
	ts1.getDescription();
	assertEquals("Sample description",ts1.getDescription());

}
}

