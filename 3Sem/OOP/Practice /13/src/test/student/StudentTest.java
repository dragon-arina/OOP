package test.student;

import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void getDateOfBirth() {
        Student student = new Student();
        student.setDateOfBirth(new Date(1421893256000L));
        assertEquals("Thursday, January 22, 2015", student.getDateOfBirth(DateFormat.FULL));
    }

    @Test
    public void testToString() {
        Student student = new Student();
        student.setDateOfBirth(new Date(1421893256000L));
        student.setGroup("Pust govoryat");
        student.setLastName("Galkin");
        student.setName("Maxim");
        assertEquals("Student{name='Maxim', lastName='Galkin', group='Pust govoryat', dateOfBirth=22.01.2015}", student.toString());
    }
}