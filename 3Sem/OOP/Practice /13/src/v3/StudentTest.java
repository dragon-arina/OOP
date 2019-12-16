package v3;

import java.text.DateFormat;
import java.util.Date;


public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setDateOfBirth(new Date(1521893256000L));
        student.setGroup("IKBO 16-18");
        student.setLastName("Irina");
        student.setName("Shayk");
        System.out.println(student.toString());

    }

}