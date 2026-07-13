package codeAlpha_StudentGradeTracker;

import java.util.ArrayList;

public class GradeTracker {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void displayStudents() {

        if(students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s\n","Name","Marks","Grade");
        System.out.println("------------------------------------------------");

        for(Student s:students) {
            System.out.printf("%-20s %-10d %-10s\n",
                    s.getName(),
                    s.getMarks(),
                    s.getGrade());
        }

        System.out.println("------------------------------------------------");
    }

    public double getAverage() {

        if(students.isEmpty())
            return 0;

        int total=0;

        for(Student s:students)
            total+=s.getMarks();

        return (double)total/students.size();
    }

    public Student getHighestStudent() {

        Student highest=students.get(0);

        for(Student s:students)
            if(s.getMarks()>highest.getMarks())
                highest=s;

        return highest;
    }

    public Student getLowestStudent() {

        Student lowest=students.get(0);

        for(Student s:students)
            if(s.getMarks()<lowest.getMarks())
                lowest=s;

        return lowest;
    }

    public void summaryReport() {

        if(students.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        System.out.println("\n========== SUMMARY REPORT ==========");

        System.out.println("Total Students : "+students.size());

        System.out.printf("Average Marks : %.2f\n",getAverage());

        Student high=getHighestStudent();
        Student low=getLowestStudent();

        System.out.println("Highest Score : "
                +high.getName()+" ("+high.getMarks()+")");

        System.out.println("Lowest Score : "
                +low.getName()+" ("+low.getMarks()+")");

        System.out.println("====================================");
    }
}