package Theatre;

public class ConcertShow extends Show {

	private String description;
	
	public ConcertShow(String title, int duration, String description, String performers) {
		super(title, duration);
		// TODO Auto-generated constructor stub
		//  Where live music is a part of a show, the name(s) of the principle performers or performing group should be displayed prominently within the details of the show.
		this.description = performers + "; " + description;
	}

	public String getDescription() {
		return description;
	}
}

