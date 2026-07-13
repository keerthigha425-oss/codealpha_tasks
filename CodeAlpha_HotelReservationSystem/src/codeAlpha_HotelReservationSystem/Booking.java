package codeAlpha_HotelReservationSystem;

import codeAlpha_HotelReservationSystem.Customer;
import codeAlpha_HotelReservationSystem.Room;

public class Booking {

    private String bookingId;
    private Customer customer;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private String paymentStatus;

    public Booking(String bookingId, Customer customer, Room room,
                   String checkInDate, String checkOutDate,
                   String paymentStatus) {

        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.paymentStatus = paymentStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Converts booking details into a format suitable for saving in bookings.txt
    public String toFileString() {

        return bookingId + "," +
               customer.getName() + "," +
               customer.getPhone() + "," +
               room.getRoomNumber() + "," +
               room.getCategory() + "," +
               checkInDate + "," +
               checkOutDate + "," +
               paymentStatus;
    }

    @Override
    public String toString() {

        return bookingId + " | "
                + customer.getName() + " | "
                + room.getRoomNumber() + " | "
                + room.getCategory() + " | "
                + checkInDate + " | "
                + checkOutDate + " | "
                + paymentStatus;
    }
}