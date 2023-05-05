package application;

import java.util.Date;

public class RoomReservation extends Reservation {
	private Room room;
	private int adults;
	private int children;
	private double totalPrice;

	public void setRoom(Room room) {
		this.room = room;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getAdults() {
		return this.adults;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getChildren() {
		return this.children;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}
}
