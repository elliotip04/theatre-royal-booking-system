package Theatre;

public class TheatreShow extends Show {

	private String language, description;
	
	public TheatreShow(String title, int duration, String language, String description) {
		super(title, duration);
		// TODO Auto-generated constructor stub
		this.language = language;
		this.description = description;
		
	}

	public String getLanguage() {
		return language;
	}
	
	public String getDescription() {
		return description;
	}

}
