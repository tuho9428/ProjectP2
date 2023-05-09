package application;

import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) {
    	// Create instances of the classes required for the booking system
        BookingSystem bookingSystem = new BookingSystem();
        Room room1 = new Room("101", "Single", 100.0, "available" );
        Room room2 = new Room("102", "Double", 150.0, "available");
        Room room3 = new Room("201", "Suite", 200.0, "available");
        Guest guest1 = new Guest("Mr.", "John", "D.", "Doe", "1234567890", "john.doe@example.com");
        Guest guest2 = new Guest("Ms.", "Jane", "E.", "Smith", "9876543210", "jane.smith@example.com");

        // Add available rooms to the booking system
        bookingSystem.getAvailableRooms().add(room1);
        bookingSystem.getAvailableRooms().add(room2);
        bookingSystem.getAvailableRooms().add(room3);

        // Test the booking system
        System.out.println("=== Hotel Reservation System ===");

        // Make a new booking
        System.out.println("\nMaking a new booking:");
        LocalDate checkInDate = new LocalDate(8, 5, 2023); // Replace with desired check-in date
        LocalDate checkOutDate = new LocalDate(10, 5, 2023); // Replace with desired check-out date
        bookingSystem.checkAvailability(checkInDate, checkOutDate);

        // Assume the user selects room2
        Room selectedRoom = room2;

        // Assume the user fills out personal details and address
        Address address = new Address("USA", "123 Main St", "", "New York", "12345", "Additional details");

        guest1.setAddress(address);
        guest1.setAdults(2);
        guest1.setChildren(0);

        // Book the room
        bookingSystem.bookRoom(selectedRoom, guest1, checkInDate, checkOutDate);

        // Check existing booking
        System.out.println("\nChecking an existing booking:");
        Reservation existingBooking = bookingSystem.retrieveBookingDetails("ABC123"); // Replace with actual booking number

        if (existingBooking != null) {
            System.out.println("Booking details: " + existingBooking.toString());

            // Retrieve guest details
            Guest guestDetails = bookingSystem.retrieveGuestDetails(existingBooking.getReservationNumber());
            if (guestDetails != null) {
                System.out.println("Guest details: " + guestDetails.toString());
            } else {
                System.out.println("Guest details not found.");
            }
        } else {
            System.out.println("Booking not found.");
        }
    }
    	
    	
        // Create a sample Room
        Room room1 = new Room("001", "Single", 90.0, "available");
        Room room2 = new Room("002", "Double", 200.0, "available");
        Room room3 = new Room("103", "Triple", 250.0, "available");
        Room room4 = new Room("104", "Quad", 300.0, "available");
        
        List<Room> rooms = new ArrayList<>();
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);

        // Create a sample Guest
        Guest guest1 = new Guest("Mr.", "John", "Doe", "1234567890", "john.doe@example.com");
        System.out.println(guest1);

        // Create a sample Address for the guest
        Address address1 = new Address("123 Main St", "Cityville", "WA", "12345" ,"USA" );
        System.out.println(address1);
        
        // Assign the address to the guest
        guest1.setAddress(address1);
        System.out.println(guest1);

        // Create a sample Reservation
        //Reservation reservation1 = new Reservation(LocalDate.of(2023, 5, 8), LocalDate.of(2023, 10, 8), guest1);
        //System.out.println(reservation1);

        //Create a sample RoomReservation
        RoomReservation roomReservation1 = new RoomReservation(room1, LocalDate.of(2023, 5, 8), LocalDate.of(2023, 10, 8), guest1);
        System.out.println(roomReservation1);
        
        
        // Implementation to generate a unique booking number
        // You can use your own logic here, such as generating a random string or using a counter
        // For simplicity, let's assume it generates a random 6-digit number
        String bookingNum = "JA" + BookingSystem.generateBookingNumber();
        System.out.println(bookingNum);

        

        // Create a sample ExistingReservation
        ExistingReservation existingReservation1 = new ExistingReservation(bookingNum , room1, 200.0, guest1);
        System.out.println(existingReservation1);
        
        // Create a sample EmailSender
        //EmailSender emailSender = new EmailSender("smtp.example.com", 587, "your-email@example.com", "your-password");

        // Test the EmailSender by sending an email to the guest
//        try {
//            String to = guest1.getEmailAddress();
//            String subject = "Reservation Confirmation";
//            String body = "Dear " + guest1.getFirstName() + ",\n\nThank you for your reservation!\n\nWe look forward to welcoming you on your stay.\n\nBest regards,\nThe Hotel Team";
//            emailSender.sendEmail(to, subject, body);
//            System.out.println("Email sent successfully to: " + to);
//        } catch (MessagingException e) {
//            System.out.println("Failed to send email: " + e.getMessage());
//        }
        
        
    }
}
