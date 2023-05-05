package application;

public class Room {
	private int roomNumber;
	private String roomType;
	private double price;
	private String availabilityStatus;

	public Room(int roomNumber, String roomType, double price, String availabilityStatus) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = price;
		this.availabilityStatus = availabilityStatus;
	}

	public boolean isAvailable() {
		return availabilityStatus.equals("available");
	}

	public String getDetails() {
		return "Room Number: " + roomNumber + "\nRoom Type: " + roomType + "\nPrice per Night: " + price
				+ "\nAvailability: " + availabilityStatus;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public String getAvailabilityStatus() {
		return this.availabilityStatus;
	}
}
