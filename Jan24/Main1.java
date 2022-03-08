package Jan24;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Courses {

    public static Map<String, Map<Student, Integer>> enrollments = Map.of();

    public static void enroll(Student student, String course, int marks) {
        enrollments.putIfAbsent(course, Map.of());
        enrollments.get(course).put(student, marks);
        student.courses.add(course);
    }

    public static int marksOf(Student student, String course) {
        return enrollments.get(course).get(student);
    }

    public static Student highestOfCourse(String course) {
        Map.Entry<Student, Integer> highest = null;

        for (var entry : enrollments.get(course).entrySet()) {
            if (highest == null)
                highest = entry;
            else if (highest.getValue() < entry.getValue())
                highest = entry;
        }

        return highest.getKey();
    }

    public Map<String, Integer> numberOfStudentsBelow50ForCourses() {
        Map<String, Integer> result = Map.of();

        for (var course : enrollments.entrySet()) {
            int belowThresholdCount = 0;
            for (var studentMarkEntry : course.getValue().entrySet())
                if (studentMarkEntry.getValue() < 50)
                    belowThresholdCount++;
            result.put(course.getKey(), belowThresholdCount);
        }

        return result;
    }

}

class Student {
    private static int nextRegisterNumber = 1000;

    public int registerNumber;

    Set<String> courses = new HashSet<>();

    Student() {
        registerNumber = nextRegisterNumber++;
    }

    static Student input(Scanner in) {
        Student student = new Student();

        System.out.println();
        System.out.println("Enter details for student registration number: " + student.registerNumber);

        System.out.print("Number of courses enrolled: ");
        int numberOfCourses = in.nextInt();
        in.nextLine();

        for (int i = 0; i < numberOfCourses; ++i) {
            System.out.print("Course code: ");
            String courseCode = in.nextLine().strip();

            if (!courseCode.startsWith("CSE")) {
                System.out.println("Invalid course code.");
                --i;
                continue;
            }

            System.out.print("Marks obtained (max 100): ");
            int markObtained = in.nextInt();
            in.nextLine();

            if (100 < markObtained && markObtained < 0) {
                System.out.println("Marks out of range. Enter again.");
                --i;
                continue;
            }

            Courses.enroll(student, courseCode, markObtained);
        }

        return student;
    }

}

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Number of students: ");
        int numberOfStudents = in.nextInt();
        in.nextLine();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; ++i)
            students.add(Student.input(in));

        in.close();
    }
}
