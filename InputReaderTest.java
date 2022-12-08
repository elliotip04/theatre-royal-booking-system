import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputReaderTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    public void constructorInputReaderTest() {
        InputReader scanner = new InputReader();
        assertNotNull(scanner.getScanner());
    }
    
    @Test
    public void getTextTest() {
        InputReader scanner = new InputReader();
        scanner.inputReader("TestText.txt");
        String text = scanner.getText("Enter some text");
        assertEquals("I am looking for Stormzy Concert", text);
        text = scanner.getText("Enter some text");
        assertEquals("What's the price for this show?", text);
    }
    
    @Test
    public void getNumberTest() {
        InputReader scanner = new InputReader();
        scanner.inputReader("TestNumbers.txt");
        int number = scanner.getNumber("Enter a number");
        assertEquals(4, number);
        number = scanner.getNumber("Enter a number");
        assertEquals(2, number);
    }
    
    @Test
    public void getMixedInput() {
        InputReader scanner = new InputReader();
        scanner.inputReader("TestMixedInput.txt");
        int number = scanner.getNumber("Enter a number");
        assertEquals(7, number);
        String text = scanner.getText("Enter some text");
        assertEquals("The Stormzy Concert is sold out", text);
        number = scanner.getNumber("Enter a number");
        assertEquals(-4, number);
        text = scanner.getText("Enter some text");
        assertEquals("What's your next available performance of Tosca?", text);
    }
}
