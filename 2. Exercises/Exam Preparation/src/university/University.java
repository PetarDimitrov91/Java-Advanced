package university;

import java.util.ArrayList;
import java.util.List;

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
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (studentExist(student)) {
            return "Student is already in the university";
        }
        if (this.students.size() < capacity) {
            this.students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (studentExist(student)) {
            students.remove(student);
            return String.format("Removed student %s%s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder b = new StringBuilder();
        for (Student student : students) {
            b.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n"
                    , student.getFirstName(), student.getLastName(), student.getBestSubject()));
        }
        return b.toString().trim();
    }

    private boolean studentExist(Student student) {
        for (Student currentStudent : students) {
            if (currentStudent.getFirstName().equals(student.getFirstName()) &&
                    currentStudent.getLastName().equals(student.getLastName())) {
                return true;
            }
        }
        return false;
    }
}
