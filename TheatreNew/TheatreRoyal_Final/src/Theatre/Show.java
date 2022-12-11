package Theatre;

import java.sql.ResultSet;

public class Show {

	private String title, showType, duration, language, description, performers;
	private boolean hasLiveMusic;
	private DBConnector db;
	private TheatreRoyal tr;

	public Show(String title, String showType, String duration, String language, String description,
			boolean hasLiveMusic, String performers) {
		this.title = title;
		this.duration = duration;
		this.language = language;
		this.description = description;
		this.hasLiveMusic = hasLiveMusic;
		this.performers = performers;
		this.showType = showType;
		DBConnector db = new DBConnector();
		TheatreRoyal tr = new TheatreRoyal();
		}
	
	public void getShowIdOfCurrentShow(Show show) {
		Show currentShow = show; 
		
	}

	public String getTitle() {
		return title;
	}

	public ResultSet setTitle() {
		db.connect();
	    ResultSet title = db.runQuery("SELECT show_title FROM performance p left join show s on p.show_id = s.show_id where performance_id =" + tr.getSelect());
		db.close();
		return title;
	}

	public String getDuration() {
		return duration;
	}

	public ResultSet setDuration() {
		db.connect();
	    ResultSet duration = db.runQuery("SELECT s.show_duration FROM performance p left join show s on p.show_id = s.show_id where performance_id =" + tr.getSelect());
		db.close();
	    return duration;
	}

	public String getLanguage() {
		return language;
	}

	public ResultSet setLanguage() {
		db.connect();
	    ResultSet language = db.runQuery("SELECT show_language FROM performance p left join show s on p.show_id = s.show_id where performance_id =" + tr.getSelect());
		db.close();
		return language;
	}

	public String getDescription() {
		return description;
	}

	public ResultSet setDescription() {
		db.connect();
	    ResultSet description = db.runQuery("SELECT show_description FROM performance p left join show s on p.show_id = s.show_id where performance_id =" + tr.getSelect());
		db.close();
		return description;
	}

	public boolean isHasLiveMusic() {
		return hasLiveMusic;
	}

	public void setHasLiveMusic(boolean hasLiveMusic) {
		this.hasLiveMusic = hasLiveMusic;
	}

	public String getPerformers() {
		return performers;
	}

	public void setPerformers(String performers) {
		this.performers = performers;
	}

	public DBConnector getDb() {
		return db;
	}

	public void setDb(DBConnector db) {
		this.db = db;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}
}