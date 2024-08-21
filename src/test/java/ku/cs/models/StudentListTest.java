package ku.cs.models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class StudentListTest {

    private StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    void testAddNewStudent_withoutScore() {
        studentList.addNewStudent("001", "Bella");
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size());
        assertEquals("Bella", students.get(0).getName());
        assertEquals("001", students.get(0).getId());
    }

    @Test
    void testAddNewStudent_withScore() {
        studentList.addNewStudent("002", "Becky", 85.5);
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size());
        assertEquals("Becky", students.get(0).getName());
        assertEquals("002", students.get(0).getId());
        assertEquals(85.5, students.get(0).getScore());
    }



    @Test
    void testFindStudentById_exist() {
        studentList.addNewStudent("001", "Bella");
        Student student = studentList.findStudentById("001");
        assertNotNull(student);
        assertEquals("Bella", student.getName());
    }

    @Test
    void testFindStudentById_notExist() {
        studentList.addNewStudent("001", "Bella");
        Student student = studentList.findStudentById("002");
        assertNull(student);
    }

    @Test
    void testGiveScoreToId_exist() {
        studentList.addNewStudent("001", "Bella");
        studentList.giveScoreToId("001", 75.0);
        Student student = studentList.findStudentById("001");
        assertEquals(75.0, student.getScore());
    }

    @Test
    void testGiveScoreToId_notExist() {
        studentList.addNewStudent("001", "Bella");
        studentList.giveScoreToId("002", 85.0);
        Student student = studentList.findStudentById("001");
        assertEquals(0.0, student.getScore());
    }

    @Test
    void testViewGradeOfId_exist() {
        studentList.addNewStudent("001", "Bella", 90.0);
        String grade = studentList.viewGradeOfId("001");
        assertEquals("A", grade);
    }

    @Test
    void testViewGradeOfId_notExist() {
        String grade = studentList.viewGradeOfId("002");
        assertNull(grade);
    }

    @Test
    void testGetStudents() {
        studentList.addNewStudent("001", "Bella");
        studentList.addNewStudent("002", "Becky", 85.5);
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(2, students.size());
    }
}