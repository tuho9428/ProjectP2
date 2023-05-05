package application;

public class ExistingReservation extends Reservation {
	private String reservationNumber;
	private Room room;
	private double totalPrice;

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public String getReservationNumber() {
		return this.reservationNumber;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}
}
