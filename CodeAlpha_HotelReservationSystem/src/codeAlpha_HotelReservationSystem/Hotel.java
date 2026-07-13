package codeAlpha_HotelReservationSystem;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private int bookingCounter = 1;

    // Load room details from rooms.txt
    public void loadRooms() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("data/rooms.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int roomNo = Integer.parseInt(data[0]);
                String category = data[1];
                double price = Double.parseDouble(data[2]);
                boolean available = Boolean.parseBoolean(data[3]);

                rooms.add(new Room(roomNo, category, price, available));
            }

            br.close();

        } catch (Exception e) {

            System.out.println("Error loading rooms.");
            e.printStackTrace();

        }

    }

    // Display all rooms
    public void displayRooms() {

        System.out.println("\n=========== ALL ROOMS ===========");

        for (Room room : rooms) {
            System.out.println(room);
        }

    }

    // Search rooms by category
    public void searchRooms(String category) {

        System.out.println("\nAvailable " + category + " Rooms");

        boolean found = false;

        for (Room room : rooms) {

            if (room.getCategory().equalsIgnoreCase(category)
                    && room.isAvailable()) {

                System.out.println(room);
                found = true;

            }

        }

        if (!found) {
            System.out.println("No rooms available.");
        }

    }

    // Book a room
    public void bookRoom(Scanner sc) {

        System.out.print("\nEnter Customer Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        Room selectedRoom = null;

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNo && room.isAvailable()) {
                selectedRoom = room;
                break;
            }

        }

        if (selectedRoom == null) {

            System.out.println("Room is not available.");
            return;

        }

        sc.nextLine();

        System.out.print("Enter Check-in Date (dd-mm-yyyy): ");
        String checkIn = sc.nextLine();

        System.out.print("Enter Check-out Date (dd-mm-yyyy): ");
        String checkOut = sc.nextLine();

        String paymentStatus = Payment.processPayment();

        Customer customer = new Customer(name, phone);

        String bookingId = String.format("B%03d", bookingCounter++);

        Booking booking = new Booking(
                bookingId,
                customer,
                selectedRoom,
                checkIn,
                checkOut,
                paymentStatus);

        bookings.add(booking);

        selectedRoom.setAvailable(false);

        // Save room availability and bookings
        saveRooms();
        saveBookings();

        System.out.println("\nBooking Successful!");
        System.out.println("Booking ID : " + bookingId);

    }

    // Display all bookings
    public void viewBookings() {

        if (bookings.isEmpty()) {

            System.out.println("\nNo bookings found.");
            return;

        }

        System.out.println("\n========== BOOKINGS ==========");

        for (Booking booking : bookings) {
            System.out.println(booking);
        }

    }

    // Save bookings to bookings.txt
    public void saveBookings() {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("data/bookings.txt"));

            for (Booking booking : bookings) {

                bw.write(booking.toFileString());
                bw.newLine();

            }

            bw.close();

        } catch (IOException e) {

            System.out.println("Error saving bookings.");

        }

    }

    // Save room availability to rooms.txt
    public void saveRooms() {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("data/rooms.txt"));

            for (Room room : rooms) {

                bw.write(
                        room.getRoomNumber() + "," +
                        room.getCategory() + "," +
                        room.getPrice() + "," +
                        room.isAvailable());

                bw.newLine();

            }

            bw.close();

        } catch (IOException e) {

            System.out.println("Error saving rooms.");

        }

    }

    // Cancel booking
    public void cancelBooking(Scanner sc) {

        if (bookings.isEmpty()) {

            System.out.println("\nNo bookings found.");
            return;

        }

        System.out.print("\nEnter Booking ID: ");
        sc.nextLine();
        String bookingId = sc.nextLine();

        Booking bookingToRemove = null;

        for (Booking booking : bookings) {

            if (booking.getBookingId().equalsIgnoreCase(bookingId)) {

                bookingToRemove = booking;
                break;

            }

        }

        if (bookingToRemove == null) {

            System.out.println("Booking not found.");
            return;

        }

        bookingToRemove.getRoom().setAvailable(true);

        bookings.remove(bookingToRemove);

        // Save updated room availability and bookings
        saveRooms();
        saveBookings();

        System.out.println("Booking cancelled successfully.");

    }

}