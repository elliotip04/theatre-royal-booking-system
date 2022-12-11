package Theatre;
import java.sql.Date;
import java.sql.Time;

public class Performance {

	private Show show;
	private Date date;
	private Time time;
	private double price;
	//private int performanceID;

	public Performance(Date date, Time time) {
		this.date = date;
		this.time = time;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
