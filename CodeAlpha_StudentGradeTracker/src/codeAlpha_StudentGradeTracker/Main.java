package codeAlpha_StudentGradeTracker;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        GradeTracker tracker=new GradeTracker();

        int choice;

        do {

            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Summary Report");
            System.out.println("4. Exit");
            System.out.print("Enter Choice : ");

            choice=sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Enter Student Name : ");
                    String name=sc.nextLine();

                    System.out.print("Enter Marks : ");
                    int marks=sc.nextInt();

                    while(marks<0 || marks>100) {

                        System.out.println("Marks should be between 0 and 100");
                        System.out.print("Enter Again : ");
                        marks=sc.nextInt();
                    }

                    tracker.addStudent(new Student(name,marks));

                    System.out.println("Student Added Successfully.");

                    break;

                case 2:

                    tracker.displayStudents();

                    break;

                case 3:

                    tracker.summaryReport();

                    break;

                case 4:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice");

            }

        }while(choice!=4);

        sc.close();

    }

}