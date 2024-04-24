package dk.kea.dat3js.hogwarts5.teachers;

import dk.kea.dat3js.hogwarts5.students.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void getFullNameWithMiddleName() {
        //ARRANGE
        Teacher teacher = new Teacher("Harry", "James", "Potter", null, "Potions", null);

        //ACT
        String fullName = teacher.getFullName();

        //ASSERT
        assertEquals("Harry James Potter", fullName);
    }

    @Test
    void getFullNameWithoutMiddleName() {
        //ARRANGE
        Teacher teacher = new Teacher("Harry", "Potter", null, "Potions", null);

        //ACT
        String fullName = teacher.getFullName();

        //ASSERT
        assertEquals("Harry Potter", fullName);
    }

    @Test
    void setFullNameWithMiddleName() {
        //ARRANGE
        Teacher teacher = new Teacher("Harry", "James", "Potter", null, "Potions", null);

        //ACT
        teacher.setFullName("Harry James Potter");

        //ASSERT
        assertEquals("Harry", teacher.getFirstName());
        assertEquals("James", teacher.getMiddleName());
        assertEquals("Potter", teacher.getLastName());
    }

    @Test
    void setFullNameWithoutMiddleName() {
        //ARRANGE
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions", null);

        //ACT
        teacher.setFullName("Minerva McGonagall");

        //ASSERT
        assertEquals("Minerva", teacher.getFirstName());
        assertNull(teacher.getMiddleName());
        assertEquals("McGonagall", teacher.getLastName());
    }

    @Test
    void setFullNameWithMultipleMiddleNames() {
        //ARRANGE
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions", null);

        //ACT
        teacher.setFullName("Harry James Sirius Potter");

        //ASSERT
        assertEquals("Harry", teacher.getFirstName());
        assertEquals("James Sirius", teacher.getMiddleName());
        assertEquals("Potter", teacher.getLastName());
    }

    @Test
    void setFullNameWithEmptyString() {
        //ARRANGE
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions", null);

        //ACT
        teacher.setFullName("");

        //ASSERT
        assertNull(teacher.getFirstName());
        assertNull(teacher.getMiddleName());
        assertNull(teacher.getLastName());
    }

    @Test
    void setFullNameWithNull() {
        //ARRANGE
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions", null);

        //ACT
        teacher.setFullName(null);

        //ASSERT
        assertNull(teacher.getFirstName());
        assertNull(teacher.getMiddleName());
        assertNull(teacher.getLastName());
    }

    @Test
    void setFullNameWithoutLastName() {
        //ARRANGE
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions", null);

        //ACT
        teacher.setFullName("Harry");

        //ASSERT
        assertEquals("Harry", teacher.getFirstName());
        assertNull(teacher.getMiddleName());
        assertNull(teacher.getLastName());
    }

    @Test
    void capitalizeIndividualNames() {
        //ARRANGE
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions", null);

        //ACT
        teacher.setFirstName("harry");
        teacher.setMiddleName("james");
        teacher.setLastName("potter");

        //ASSERT
        assertEquals("Harry", teacher.getFirstName());
        assertEquals("James", teacher.getMiddleName());
        assertEquals("Potter", teacher.getLastName());
    }

    @Test
    void capitalizeIndividualNamesWithCrazyCapitalization() {
        //ARRANGE
        Teacher teacher = new Teacher("first", "middle", "last", null, "Potions", null);

        //ACT
        teacher.setFirstName("hArRy");
        teacher.setMiddleName("jAmEs");
        teacher.setLastName("pOtTeR");

        //ASSERT
        assertEquals("Harry", teacher.getFirstName());
        assertEquals("James", teacher.getMiddleName());
        assertEquals("Potter", teacher.getLastName());
    }

}