package Theatre;

import java.util.ArrayList;

public class Manager {

	private int price;
	private boolean doubleBooked;
	private boolean isFull;
	private boolean showPlaying;
	private Booking booking;
	private ArrayList<Show> shows;
	// private Show currentShow;

	public Manager() {
		doubleBooked = false;
		isFull = false;
		showPlaying = false;
		price = 0;

		// currentShow = new Show();
	}

	public void toggleIsFull() {
		isFull = !isFull;
	}

	public void toggleDoubleBooked() {
		doubleBooked = !doubleBooked;
	}

	public void toggleShowPlaying() {
		showPlaying = !showPlaying;
	}

	public boolean clearBooking() {
		while (booking.isMoveToBasket() == true && booking.isOrderConfirmed() == false) {
			if (doubleBooked == false && isFull == false && showPlaying == true) {
				System.out.println("This booking can be completed.");
			} else {
				System.out.println("This booking cannot be processed.");
			}
		}
		return true;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public boolean isDoubleBooked() {
		return doubleBooked;
	}

	public void setDoubleBooked(boolean doubleBooked) {
		this.doubleBooked = doubleBooked;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public boolean isShowPlaying() {
		return showPlaying;
	}

	public void setShowPlaying(boolean showPlaying) {
		this.showPlaying = showPlaying;
	}
}
