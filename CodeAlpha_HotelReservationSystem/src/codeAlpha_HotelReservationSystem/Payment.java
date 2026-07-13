package codeAlpha_HotelReservationSystem;

import java.util.Scanner;

public class Payment {

    public static String processPayment() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nSelect Payment Method");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Cash");

        System.out.print("Choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("UPI Payment Successful.");
                break;

            case 2:
                System.out.println("Card Payment Successful.");
                break;

            case 3:
                System.out.println("Cash Payment Successful.");
                break;

            default:
                System.out.println("Invalid choice.");
                return "Pending";
        }

        return "Paid";
    }
}