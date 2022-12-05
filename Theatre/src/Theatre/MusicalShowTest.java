package Theatre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class MusicalShowTest {

	@Test
	void constructorMusicalShowTest() {
	MusicalShow ms = new MusicalShow("Frozen the Musical", 135, "English", "Sample description", true, "Frozen Princess");
	assertEquals("Frozen the Musical", ms.getTitle());
	assertEquals(135, ms.getDuration());
	assertEquals("English", ms.getLanguage());
	assertEquals("Frozen Princess; Sample description", ms.getDescription());;

}
	@Test
	public void getLanguageTest() {
	MusicalShow ms2= new MusicalShow("Frozen the Musical", 135, "English", "Sample description", true, "Frozen Pricess");
	ms2.getLanguage();
	assertEquals("English", ms2.getLanguage());
	
}
	
	@Test
	public void hasLiveMusicTest() {
	MusicalShow ms3= new MusicalShow("Frozen the Musical", 135, "English", "Sample description", true, "Frozen Pricess");
	assertTrue(ms3.getHasLiveMusic());

}
}


