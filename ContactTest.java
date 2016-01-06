/**
 * Created by andre on 05/01/2016.
 */

import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

    private String expectedName;
    private String expectedNotes;
    private int expectedID;
    private Contact testContact;

    @Before
    public void setUp() {
        expectedID = 1;
        expectedName = "Donald Trump";
        expectedNotes = "Running for president";
        testContact = new ContactImpl(expectedID, expectedName, expectedNotes);
    }

    @Test
    public void testingGetID() {
        assertEquals(expectedID, testContact.getId());
    }

    @Test
    public void testingGetName() {
        assertEquals(expectedName, testContact.getName());
    }

    @Test
    public void testingGetNotes() {
        assertEquals(expectedNotes, testContact.getNotes());
    }

    @Test
    public void testingAddNotes() {
        testContact.addNotes("Really?!");
        assertEquals(expectedNotes + "\n" + "Really?!", testContact.getNotes());
        //System.out.println(testContact.getNotes());
    }

    @Test
    public void testingAddNotesEmptyString() {
        testContact.addNotes("");
        assertEquals(expectedNotes, testContact.getNotes());
    }

    @Test
    public void testingAddNotesNull() {
        testContact.addNotes(null);
        assertEquals(expectedNotes, testContact.getNotes());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testingIdThrowsException() {
        testContact = new ContactImpl(-1, expectedName, expectedNotes);
    }

    @Test (expected = NullPointerException.class)
    public void testingNameThrowsException() {
        testContact = new ContactImpl(expectedID, null, expectedNotes);
    }

    @Test (expected = NullPointerException.class)
    public void testingNotesThrowsException() {
        testContact = new ContactImpl(expectedID, expectedName, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testingAllThrowException() {
        testContact = new ContactImpl(-1, null, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testingIdThrowsException2param() {
        testContact = new ContactImpl(-1, expectedName);
    }

    @Test (expected = NullPointerException.class)
    public void testingNameThrowsException2param() {
        testContact = new ContactImpl(expectedID, null);
    }

    @Test
    public void testingGetNotes2param() {
        testContact = new ContactImpl(expectedID, expectedName);
        assertEquals("", testContact.getNotes());
    }
}