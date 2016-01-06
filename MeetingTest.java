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
        testMeeting =  new MeetingImpl(expectedID, expectedDate, expectedContacts);
    }






}
