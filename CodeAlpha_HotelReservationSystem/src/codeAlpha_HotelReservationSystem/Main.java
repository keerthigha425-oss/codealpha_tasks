package codeAlpha_HotelReservationSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();

        hotel.loadRooms();

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("   HOTEL RESERVATION SYSTEM");
            System.out.println("==================================");
            System.out.println("1. View All Rooms");
            System.out.println("2. Search Standard Rooms");
            System.out.println("3. Search Deluxe Rooms");
            System.out.println("4. Search Suite Rooms");
            System.out.println("5. Book Room");
            System.out.println("6. View Bookings");
            System.out.println("7. Cancel Booking");
            System.out.println("8. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    hotel.displayRooms();
                    break;

                case 2:
                    hotel.searchRooms("Standard");
                    break;

                case 3:
                    hotel.searchRooms("Deluxe");
                    break;

                case 4:
                    hotel.searchRooms("Suite");
                    break;

                case 5:
                    hotel.bookRoom(sc);
                    break;

                case 6:
                    hotel.viewBookings();
                    break;

                case 7:
                    hotel.cancelBooking(sc);
                    break;

                case 8:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");

            }

        } while (choice != 8);

        sc.close();
    }
}