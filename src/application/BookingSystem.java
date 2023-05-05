package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingSystem {
	private List<Room> availableRooms;
	private List<Room> bookedRooms;
	private List<Reservation> bookings;
	private List<Guest> guests;

	public BookingSystem(List<Room> availableRooms) {
		this.availableRooms = availableRooms;
		this.bookedRooms = new ArrayList<>();
		this.bookings = new ArrayList<>();
		this.guests = new ArrayList<>();
	}

	public List<Room> checkAvailability(Date checkInDate, Date checkOutDate) {
		List<Room> availableRooms = new ArrayList<>();
		for (Room room : this.availableRooms) {
			boolean isAvailable = true;
			for (Reservation reservation : this.bookings) {
				if (room.equals(((RoomReservation) reservation).getRoom())
						&& !(checkOutDate.before(reservation.getCheckInDate())
								|| checkInDate.after(reservation.getCheckOutDate()))) {
					isAvailable = false;
					break;
				}
			}
			if (isAvailable) {
				availableRooms.add(room);
			}
		}
		return availableRooms;
	}

	public Reservation bookRoom(Room room, Guest guest, Date checkInDate, Date checkOutDate) {
		if (!availableRooms.contains(room)) {
			throw new IllegalArgumentException("Room is not available for booking.");
		}
		Reservation reservation = new RoomReservation(room, guest, checkInDate, checkOutDate);
		availableRooms.remove(room);
		bookedRooms.add(room);
		bookings.add(reservation);
		guests.add(guest);
		return reservation;
	}

	private String generateBookingNumber() {
		// generate a unique booking number, e.g. using UUID.randomUUID()
		return "BOOKING-12345";
	}

	public Reservation retrieveBookingDetails(String bookingNumber) {
		for (Reservation reservation : bookings) {
			if (reservation.getReservationNumber().equals(bookingNumber)) {
				return reservation;
			}
		}
		return null;
	}

	public Guest retrieveGuestDetails(String bookingNumber) {
		for (Reservation reservation : bookings) {
			if (reservation.getReservationNumber().equals(bookingNumber)) {
				return reservation.getGuest();
			}
		}
		return null;
	}

	public List<Room> getAvailableRooms() {
		return availableRooms;
	}

	public List<Room> getBookedRooms() {
		return bookedRooms;
	}

	public List<Reservation> getBookings() {
		return bookings;
	}

	public List<Guest> getGuests() {
		return guests;
	}
}
