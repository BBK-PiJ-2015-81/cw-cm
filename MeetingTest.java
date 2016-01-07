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

    @Before
    public void setUp() {
        expectedID = 1;
        expectedDate = Calendar.getInstance();
        expectedContacts = new HashSet<Contact>();
        testMeeting =  new FutureMeetingImpl(expectedID, expectedDate, expectedContacts);
    }


    @Test (expected = IllegalArgumentException.class)
    public void testingIdThrowsException() {
        testMeeting =  new FutureMeetingImpl(-1, expectedDate, expectedContacts);
    }

    @Test (expected = NullPointerException.class)
    public void testingDateThrowsException() {
        testMeeting =  new FutureMeetingImpl(1, expectedDate, null);
    }

    @Test (expected = NullPointerException.class)
    public void testingContactThrowsException() {
        testMeeting =  new FutureMeetingImpl(1, null, expectedContacts);
    }






}
