import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader {

	private Scanner scanner;
	
	public InputReader() {
		scanner = new Scanner(System.in);
	}

	public Scanner getScanner() {
        return scanner;
	}
	/**
     * We will have this method read through a specific file only for
     * Testing purposes. The main scanner will read the keyboards input
     */
	public void inputReader (String file) {
		try {
            scanner = new Scanner (new File(file));
        } catch (FileNotFoundException e) {
            System.err.println("The file " + file + " was not found");
            System.exit(1);
        }
	}
	public String getText(String prompt) {
	        System.out.println(prompt);
	        String input = scanner.nextLine();
	        return input;
	    }
		
	public int getNumber (String prompt) {
	        System.out.println(prompt);
	        int number = scanner.nextInt();
	        scanner.nextLine();
	        return number;
	    }
	}


