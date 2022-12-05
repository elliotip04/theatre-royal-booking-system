package Theatre;
public abstract class Show {
	
	private String title;
	private int duration;
	
public Show (String title, int duration) {
	this.title = title;
	this.duration = duration;
}

public String getTitle() {
	return title;
}

public int getDuration() {
	return duration;
}
}
