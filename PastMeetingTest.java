/**
 * Created by andre on 07/01/2016.
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


public class PastMeetingTest {

    private PastMeeting testMeeting;
    private int expectedID;
    private Calendar expectedDate;
    private Set<Contact> expectedContacts;
    private Set<Contact> emptyContacts;
    private String expectedNotes;

    @Before
    public void setUp() {
        expectedID = 1;
        expectedDate = Calendar.getInstance();
        expectedNotes = "Great meeting Mr. President!";

        expectedContacts = new HashSet<Contact>();
        expectedContacts.add(new ContactImpl(1, "Hillary Rodham Clinton", "Running for president"));

        emptyContacts = new HashSet<Contact>();

        testMeeting =  new PastMeetingImpl(expectedID, expectedDate, expectedContacts, expectedNotes);

    }


    @Test (expected = IllegalArgumentException.class)
    public void testingIdThrowsException() {
        testMeeting =  new PastMeetingImpl(-1, expectedDate, expectedContacts, expectedNotes);
    }

    @Test (expected = NullPointerException.class)
    public void testingNullContactThrowsException() {
        testMeeting =  new PastMeetingImpl(expectedID, expectedDate, null, expectedNotes);
    }

    @Test (expected = NullPointerException.class)
    public void testingNullDateThrowsException() {
        testMeeting =  new PastMeetingImpl(expectedID, null, expectedContacts, expectedNotes);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testingEmptyContactsSetThrowsException() {
        emptyContacts = new HashSet<Contact>();
        testMeeting =  new PastMeetingImpl(expectedID, expectedDate, emptyContacts, expectedNotes);
    }

    @Test
    public void testingGetNotes() {
        assertEquals(expectedNotes, testMeeting.getNotes());
    }

    @Test (expected = NullPointerException.class)
    public void testingNullNoteThrowsException() {
        testMeeting = new PastMeetingImpl(expectedID, expectedDate, expectedContacts, null);
    }

}
