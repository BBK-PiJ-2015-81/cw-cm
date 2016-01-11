/**
 * Created by andre on 09/01/2016.
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class ContactManagerTest {

    private ContactManager myManager;
    private ContactManager myEmptyManager;
    private Calendar futureDate;
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

        // Choose players attending the meeting
        players = myManager.getContacts(4, 6, 9, 10);

    }

    @After
    public void reset()     {

        myManager = null;
        myEmptyManager = null;
        futureDate = null;
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

    @Test
    public void testingAddFutureMeeting()   {
        assertEquals(1, myManager.addFutureMeeting(players, futureDate));
    }

    @Test (expected = NullPointerException.class)
    public void testingAddFutureMeetingNullContacts()   {
        myManager.addFutureMeeting(null, futureDate);
    }

    @Test (expected = NullPointerException.class)
    public void testingAddFutureMeetingNullDate()   {
        myManager.addFutureMeeting(players, null);
    }
}
