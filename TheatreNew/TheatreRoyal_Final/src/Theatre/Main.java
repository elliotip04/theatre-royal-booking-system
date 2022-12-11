package Theatre;

public class Main {

	public static void main(String[] args) {
		
		TheatreRoyal tr = new TheatreRoyal();
		tr.start();
		tr.printOptionMenu();
		tr.browse();
		tr.search();
		tr.sell();
		System.out.println("Hello");
	}
}
