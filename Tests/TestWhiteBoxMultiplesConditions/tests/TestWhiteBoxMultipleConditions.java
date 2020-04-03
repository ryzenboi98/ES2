import com.es2.multipleconditions.*;
import com.es2.multipleconditions.PersonCannotDriveException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestWhiteBoxMultipleConditions {


    @AfterAll
    static void TearDown() {
        End e = new End();
    }
    // AQUI ESTÀ COURSE TEST
    @Test
    public void approved() {
        Marks m = new Marks(10, 1, 10);

        assertTrue(CourseUtils.approved(m));
    }

    @Test
    public void approvedNotWTest() {
        Marks m = new Marks(9, 1, 10);

        assertFalse(CourseUtils.approved(m));
    }

    @Test
    public void approvedNotAttend() {
        Marks m = new Marks(10, 0, 10);

        assertFalse(CourseUtils.approved(m));
    }

    @Test
    public void approvedNotWork() {
        Marks m = new Marks(10, 1, 9);

        assertFalse(CourseUtils.approved(m));
    }

    @Test
    public void approvedNotWTestAttend() {
        Marks m = new Marks(9, 0, 10);

        assertFalse(CourseUtils.approved(m));
    }

    @Test
    public void approvedNotWTestWork() {
        Marks m = new Marks(9, 1, 9);

        assertFalse(CourseUtils.approved(m));
    }

    @Test
    public void approvedNotAttendWork() {
        Marks m = new Marks(10, 0, 9);

        assertFalse(CourseUtils.approved(m));
    }

    @Test
    public void approvedNotAll() {
        Marks m = new Marks(9, 0, 9);

        assertFalse(CourseUtils.approved(m));
    }

    // AQUI ACABA TEST COURSE

    // AQUI COMEÇA TEST DRIVE

    @Test
    public void testDriveWrongAge() {
        Person p = new Person("Joe", 17);

        assertThrows(PersonCannotDriveException.class, () -> {
            DriveUtils.assertConditionsToDrive(p);
        });
    }

    @Test
    public void testDriveNullPointer() {
        assertThrows(PersonCannotDriveException.class, () -> {
            DriveUtils.assertConditionsToDrive(null);
        });
    }

    @Test
    public void testDriveRight() {
        Person p = new Person("Jones", 22);

        assertDoesNotThrow(() -> DriveUtils.assertConditionsToDrive(p));
    }

    // AQUI ACABA TEST DRIVE

    // AQUI COMEÇA O TEST LIST UTIL

    @Test
    public void testFindNameEmptyList() {
        assertEquals(-1,ListUtils.findName(new ArrayList<String>(),"ola"));
    }

    @Test
    public void testFindName() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Jeff");
        list.add("Jones");
        list.add("Jimmy");
        list.add("Jen");
        list.add("Joe");

        assertEquals(4, ListUtils.findName(list,"Joe"));
    }

    @Test
    public void testNotFindName() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Jeff");
        list.add("Jones");
        list.add("Jimmy");
        list.add("Jen");
        list.add("Joe");

        assertEquals(-1,ListUtils.findName(list,"ola"));
    }

    // AQUI AVABA O TEST LIST UTIL

}

