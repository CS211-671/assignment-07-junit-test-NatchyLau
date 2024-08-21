package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*; //has assertion

class StudentTest {
    Student s1;

    @BeforeEach
    void init(){
         s1 = new Student("6610450137","Natcha",75);
    }

    @Test
    public void testConstructorWithoutScore() {
        assertEquals("6610450137", s1.getId());
        assertEquals("Natcha", s1.getName());
        assertEquals(0, s1.getScore());
    }

    @Test
    public void testConstructorWithScore() {
        assertEquals("6610450137", s1.getId());
        assertEquals("Natcha", s1.getName());
        assertEquals(75, s1.getScore());
    }

    @Test
    public void testChangeName() {
        s1.changeName("Natty");
        assertEquals("Natty", s1.getName());
    }

    @Test //declare test annotation to run the code
    void testAddScore(){
        //Student s1 = new Student("6610450137","Natcha");
        assertEquals(0, s1.getScore());
        s1.addScore(40.5);
        assertEquals(40.5, s1.getScore());
        s1.addScore(10);
        assertEquals(50.5, s1.getScore());
    }

    @Test
    @DisplayName("grade calculation test")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(60.8);
        assertEquals("C", s.grade());
    }

    @Test
    public void testIsId() {
        assertTrue(s1.isId("6610450137"));
    }

    @Test
    public void testToString() {
        String expected = "{id: '6610450137', name: 'Natcha', score: 75}";
        assertEquals(expected, s1.toString());
    }
}