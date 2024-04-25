package dk.kea.dat3js.hogwarts5.students;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getFullNameWithMiddleName() {
        //ARRANGE
        Student student = new Student("Harry", "James", "Potter", null, 1, false, "male");

        //ACT
        String fullName = student.getFullName();

        //ASSERT
        assertEquals("Harry James Potter", fullName);
    }

    @Test
    void getFullNameWithoutMiddleName() {
        //ARRANGE
        Student student = new Student("Harry", "Potter", null, 1);

        //ACT
        String fullName = student.getFullName();

        //ASSERT
        assertEquals("Harry Potter", fullName);
    }

    @Test
    void setFullNameWithMiddleName() {
        //ARRANGE
        Student student = new Student("first", "middle", "last", null, 1, false, "male");

        //ACT
        student.setFullName("Harry James Potter");

        //ASSERT
        assertEquals("Harry", student.getFirstName());
        assertEquals("James", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }

    @Test
    void setFullNameWithoutMiddleName() {
        //ARRANGE
        Student student = new Student("first", "middle", "last", null, 1, false, "male");

        //ACT
        student.setFullName("Harry Potter");

        //ASSERT
        assertEquals("Harry", student.getFirstName());
        assertNull(student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }

    @Test
    void setFullNameWithMultipleMiddleNames() {
        //ARRANGE
        Student student = new Student("first", "middle", "last", null, 1, false, "male");

        //ACT
        student.setFullName("Harry James Sirius Potter");

        //ASSERT
        assertEquals("Harry", student.getFirstName());
        assertEquals("James Sirius", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }

    @Test
    void setFullNameWithEmptyString() {
        //ARRANGE
        Student student = new Student("first", "middle", "last", null, 1, false, "male");

        //ACT
        student.setFullName("");

        //ASSERT
        assertNull(student.getFirstName());
        assertNull(student.getMiddleName());
        assertNull(student.getLastName());
    }

    @Test
    void setFullNameWithNull() {
        //ARRANGE
        Student student = new Student("first", "middle", "last", null, 1, false, "male");

        //ACT
        student.setFullName(null);

        //ASSERT
        assertNull(student.getFirstName());
        assertNull(student.getMiddleName());
        assertNull(student.getLastName());
    }

    @Test
    void setFullNameWithoutLastName() {
        //ARRANGE
        Student student = new Student("first", "middle", "last", null, 1, false,"male");

        //ACT
        student.setFullName("Harry");

        //ASSERT
        assertEquals("Harry", student.getFirstName());
        assertNull(student.getMiddleName());
        assertNull(student.getLastName());
    }

    @Test
    void capitalizeIndividualNames() {
        //ARRANGE
        Student student = new Student("first", "middle", "last", null, 1, false,"male");

        //ACT
        student.setFirstName("harry");
        student.setMiddleName("james");
        student.setLastName("potter");

        //ASSERT
        assertEquals("Harry", student.getFirstName());
        assertEquals("James", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }

    @Test
    void capitalizeIndividualNamesWithCrazyCapitalization() {
        //ARRANGE
        Student student = new Student("first", "middle", "last", null, 1, false,"male");

        //ACT
        student.setFirstName("hArRy");
        student.setMiddleName("jAmEs");
        student.setLastName("pOtTeR");

        //ASSERT
        assertEquals("Harry", student.getFirstName());
        assertEquals("James", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }
}