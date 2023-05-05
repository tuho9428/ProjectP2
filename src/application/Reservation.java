package application;

import java.util.Date;

public class Reservation {
	private Date checkInDate;
	private Date checkOutDate;
	private Guest guest;

	public void setCheckInDate(Date date) {
		this.checkInDate = date;
	}

	public void setCheckOutDate(Date date) {
		this.checkOutDate = date;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Date getCheckInDate() {
		return this.checkInDate;
	}

	public Date getCheckOutDate() {
		return this.checkOutDate;
	}

	public Guest getGuest() {
		return this.guest;
	}
}
