/**
 * Created by andre on 06/01/2016.
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class MeetingTest {

    private Meeting testMeeting;
    private int expectedID;
    private Calendar expectedDate;
    private Set<Contact> expectedContacts;
    private Set<Contact> emptyContacts;

    @Before
    public void setUp() {
        expectedID = 1;
        expectedDate = Calendar.getInstance();

        expectedContacts = new HashSet<Contact>();
        expectedContacts.add(new ContactImpl(1, "Donald Trump", "Running for president"));

        emptyContacts = new HashSet<Contact>();

        testMeeting =  new FutureMeetingImpl(expectedID, expectedDate, expectedContacts);

    }


    @Test (expected = IllegalArgumentException.class)
    public void testingIdThrowsException() {
        testMeeting =  new FutureMeetingImpl(-1, expectedDate, expectedContacts);
    }

    @Test (expected = NullPointerException.class)
    public void testingNullDateThrowsException() {
        testMeeting =  new FutureMeetingImpl(expectedID, expectedDate, null);
    }

    @Test (expected = NullPointerException.class)
    public void testingNullContactThrowsException() {
        testMeeting =  new FutureMeetingImpl(expectedID, null, expectedContacts);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testingEmptyContactsSetThrowsException() {
        emptyContacts = new HashSet<Contact>();
        testMeeting =  new FutureMeetingImpl(expectedID, expectedDate, emptyContacts);
    }

    @Test
    public void testingGetID() {
        assertEquals(expectedID, testMeeting.getId());
    }

    @Test
    public void testingGetDate() {
        assertEquals(expectedDate, testMeeting.getDate());
    }

    @Test
    public void testingGetContacts() {
        assertEquals(expectedContacts, testMeeting.getContacts());
    }


}
