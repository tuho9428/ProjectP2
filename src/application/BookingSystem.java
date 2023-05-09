package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingSystem {
    private List<Room> availableRooms;
    private List<Room> bookedRooms;
    private List<Reservation> reservations;
    private List<Guest> guests;

    public BookingSystem() {
        availableRooms = new ArrayList<>();
        bookedRooms = new ArrayList<>();
        reservations = new ArrayList<>();
        guests = new ArrayList<>();
    }

    public void checkAvailability(LocalDate checkInDate, LocalDate checkOutDate) {
        List<Room> availableOptions = new ArrayList<>();

        for (Room room : availableRooms) {
            if (room.isAvailable(checkInDate, checkOutDate)) {
                availableOptions.add(room);
            }
        }

        if (availableOptions.isEmpty()) {
            System.out.println("No rooms available for the selected dates.");
        } else {
            System.out.println("Available room options:");
            for (Room room : availableOptions) {
                System.out.println(room.getDetails());
            }
        }
    }

    public void bookRoom(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) throws Exception {
        RoomReservation roomReservation = new RoomReservation(room, room.getPrice(), 
        		checkInDate, checkOutDate, guest, getAdults(), getChildren());

        availableRooms.remove(room);
        bookedRooms.add(room);
        reservations.add(roomReservation);
        guests.add(guest);

        String bookingNumber = generateBookingNumber();
        roomReservation.setReservationNumber(bookingNumber);

        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(guest.getEmailAddress(), bookingNumber);
    }

    private int getChildren() {
		// TODO Auto-generated method stub
    	return RoomReservation.getChildren();
	}

	private int getAdults() {
		// TODO Auto-generated method stub
		return RoomReservation.getAdults();
	}

	public static String generateBookingNumber() {
        // Implementation to generate a unique booking number
        // You can use your own logic here, such as generating a random string or using a counter
        // For simplicity, let's assume it generates a random 6-digit number
        return String.format("%06d", (int) (Math.random() * 1000000));
    }

    public Reservation retrieveBookingDetails(String bookingNumber) {
        for (Reservation reservation : reservations) {
            if (reservation instanceof ExistingReservation) {
                ExistingReservation existingReservation = (ExistingReservation) reservation;
                if (existingReservation.getReservationNumber().equals(bookingNumber)) {
                    return existingReservation;
                }
            }
        }
        return null;
    }

    public Guest retrieveGuestDetails(String bookingNumber) {
        for (Guest guest : guests) {
            for (Reservation reservation : guest.getReservations()) {
                if (reservation instanceof ExistingReservation) {
                    ExistingReservation existingReservation = (ExistingReservation) reservation;
                    if (existingReservation.getReservationNumber().equals(bookingNumber)) {
                        return guest;
                    }
                }
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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Guest> getGuests() {
        return guests;
    }
}

