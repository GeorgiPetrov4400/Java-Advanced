package ExamPreparation062022.university_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < capacity) {
            for (Student person : students) {
                if (person.getFirstName().equals(student.getFirstName()) && person.getLastName().equals(student.getLastName())) {
                    return "Student is already in the university";
                }
            }
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
        return "No seats in the university";

    }

    public String dismissStudent(Student student) {
        Student foundStudent = getStudent(student.getFirstName(), student.getLastName());

        if (foundStudent == null) {
            return "Student not found";
        }

        students.remove(student);

        return "Removed student " + foundStudent.getFirstName() + " " + foundStudent.getLastName();
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) ;
            return student;
        }
        return null;
    }

    public String getStatistics() {
        return students.stream().map(s -> String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                s.getFirstName(), s.getLastName(), s.getBestSubject())).collect(Collectors.joining(System.lineSeparator()));
    }
}
