/**
 * Created by andre on 09/01/2016.
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class ContactManagerTest {

    private ContactManager myManager;
    private ContactManager myEmptyManager;
    private Calendar futureDate;
    private Calendar pastDate;
    private FutureMeeting testFutureMeeting;
    private FutureMeeting testMeeting;
    private PastMeeting testPastMeeting;
    private Set<Contact> players;

    @Before
    public void setUp() {

        // Create some contact managers
        myManager = new ContactManagerImpl();
        myEmptyManager = new ContactManagerImpl();

        // Add some contacts

        myManager.addNewContact("Manuel Neuer", "Goalkeeper");
        myManager.addNewContact("Philipp Lahm", "Right back");
        myManager.addNewContact("David Luiz", "Right centre back");
        myManager.addNewContact("Sergio Ramos", "Left centre back");
        myManager.addNewContact("Thiago Silva", "Left back");
        myManager.addNewContact("Andres Iniesta", "Right midfield");
        myManager.addNewContact("Toni Kroos", "Centre midfield");
        myManager.addNewContact("Angel Di Maria", "Left midfield");
        myManager.addNewContact("Lionel Messi", "Right wing");
        myManager.addNewContact("Cristiano Ronaldo", "Centre forward");
        myManager.addNewContact("Arjen Robben", "Left wing");

        // Create a future date
        futureDate = new GregorianCalendar(2020, 2, 5);

        // Create a past date
        pastDate = new GregorianCalendar(2010, 2, 5);

        // Choose players attending the meeting
        players = myManager.getContacts(4, 6, 9, 10);

        // Build some test meetings

        testFutureMeeting = myManager.getFutureMeeting(myManager.addFutureMeeting(players, futureDate)); //Meeting id 1
        testMeeting = myManager.getFutureMeeting(myManager.addFutureMeeting(players, futureDate)); // Meeting id 2
        myManager.addNewPastMeeting(players, pastDate,"Great meeting guys!"); // Meeting id 3

    }

    @After
    public void reset()     {

        myManager = null;
        myEmptyManager = null;
        futureDate = null;
        testFutureMeeting = null;
        players = null;


        File myContacts = new File("." + File.separator + "contacts.txt");
        if(myContacts.exists()){
            myContacts.delete();
        }

    }


    // Test Constructor

    @Test
    public void testingConstructor() {
        assertNotNull(myEmptyManager);
        assertNotNull(myManager);
    }

    // Test Contact Methods

    @Test
    public void testingGetContacts() {
        assertEquals(myManager.getContacts("Messi"),myManager.getContacts(9));
    }

    // Test Flush

    @Test
    public void testingFlush() {
        myManager.flush();
        assertTrue( new File("." + File.separator + "contacts.txt").exists());
    }



    // Test Meeting Methods

    // Testing addFutureMeeting

    @Test
    public void testingAddFutureMeeting()   {
        assertEquals(4, myManager.addFutureMeeting(players, futureDate));
    }

    @Test (expected = NullPointerException.class)
    public void testingAddFutureMeetingNullContacts()   {
        myManager.addFutureMeeting(null, futureDate);
    }

    @Test (expected = NullPointerException.class)
    public void testingAddFutureMeetingNullDate()   {
        myManager.addFutureMeeting(players, null);
    }

    // Testing getFutureMeeting

    @Test
    public void testingGetFutureMeeting()   {

        assertEquals(1, testFutureMeeting.getId());
        assertEquals(futureDate, testFutureMeeting.getDate());
        assertEquals(players, testFutureMeeting.getContacts());
    }


    // Testing getFutureMeetingList

    @Test (expected = NullPointerException.class)
    public void testingGetFutureMeetingListNull() {
        List<Meeting> testList = myManager.getFutureMeetingList(null);

    }

    @Test
    public void testingGetFutureMeetingList() {
        Contact[] testContact = myManager.getContacts("Ramos").toArray(new Contact[0]);
        List<Meeting> testList = myManager.getFutureMeetingList(testContact[0]);
        assertEquals(2, testList.size());
        System.out.println(testList.size());
    }

    // Testing getMeeting

    @Test
    public void testingGetMeeting() {
       assertEquals(testFutureMeeting, myManager.getMeeting(1));
    }

    // Testing getMeetingListOn

    @Test
    public void testingGetMeetingListOnNotNull()   {
        assertNotNull(myManager.getMeetingListOn(futureDate));
    }

    @Test
    public void testingGetMeetingListOn()   {
        List<Meeting> testList = myManager.getMeetingListOn(futureDate);
        assertEquals(2, testList.size());
    }


    // Testing addNewPastMeeting

    @Test (expected = NullPointerException.class)
        public void testingAddNewPastMeetingNull()  {
        myManager.addNewPastMeeting(null, pastDate, "Bad meeting guys, what happened?!");
    }

    // Testing getPastMeeting

    @Test
    public void testingGetPastMeetingNull()  {
        assertNotNull(myManager.getPastMeeting(3));

    }

    // Testing getPastMeetingListFor

    @Test
    public void testingGetPastMeetingListFor()   {
        Contact[] testContact = myManager.getContacts("Ramos").toArray(new Contact[0]);
        assertNotNull(myManager.getPastMeetingListFor(testContact[0]));


    }

    // Testing addMeetingNotes

    public void testingAddMeetingNotes()   {
        myManager.addMeetingNotes(3, "Great work lads");
        assertEquals("Great work lads", myManager.getPastMeeting(4).getNotes());
    }


}

