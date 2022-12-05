package Theatre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class OperaShowTest {

	@Test
	void constructorOperaShowTest() {
	OperaShow op = new OperaShow("Carmen", 120, "English", "Sample description", true, "Mark Smith");
	assertEquals("Carmen", op.getTitle());
	assertEquals(120, op.getDuration());
	assertEquals("English", op.getLanguage());
	assertEquals("Mark Smith; Sample description", op.getDescription());;

}
	@Test
	public void getLanguageTest() {
		OperaShow op1 = new OperaShow("Carmen", 120, "English", "Sample description", true, "Mark Smith");
		op1.getLanguage();
		assertEquals("English", op1.getLanguage());
	
}
	
	@Test
	public void hasLiveMusicTest() {
	OperaShow op2 = new OperaShow("Carmen", 120, "English", "Sample description", true, "Mark Smith");
	assertTrue(op2.getHasLiveMusic());

}
}


