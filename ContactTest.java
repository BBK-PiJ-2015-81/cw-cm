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

}