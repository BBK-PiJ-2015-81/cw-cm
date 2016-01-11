/**
 * Created by andre on 09/01/2016.
 */

import java.util.*;
import java.io.*;
import java.nio.file.*;


public class ContactManagerImpl implements ContactManager {

    private Set<Contact> contacts;
    private List<Meeting> meetings;
    private String MYFILE = "contacts.txt";
    private Calendar presentTime;

    // The Constructor

    public ContactManagerImpl() {

        //Set the current date/time for the other methods
        presentTime = new GregorianCalendar();

        //Make a file
        File myContacts = new File("." + File.separator + MYFILE);

        //Check if file exists
        if(myContacts.exists()) {

            //If the file does exist read it in
            try(ObjectInputStream myInput = new ObjectInputStream(new BufferedInputStream(new FileInputStream(myContacts)))){
                contacts = (Set<Contact>)myInput.readObject();
                meetings = (List<Meeting>)myInput.readObject();
            } catch (ClassNotFoundException exception)  {
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            // If the file doesn't exist make it
            if(contacts == null) contacts = new HashSet<Contact>();
            if(meetings == null) meetings = new ArrayList<Meeting>();
        }


    }

    public int addFutureMeeting(Set<Contact> contacts, Calendar date)   {

        if ((date == null) || (contacts == null)) {
            throw new NullPointerException("Exception! You must provide contacts and a date");
        } else if (contacts.size() == 0){
            throw new IllegalArgumentException("Exception! You must provide contacts");
        } else if (date.compareTo(presentTime) < 0) {
            throw new IllegalArgumentException("Exception! You cannot provide a past date.");
        } else {
            int createdID = meetings.size() + 1;
            FutureMeeting meetingAdded = new FutureMeetingImpl(createdID, date, contacts);
            meetings.add(meetingAdded);
            return meetingAdded.getId();
        }
    }


    /**
     * Returns the PAST meeting with the requested ID, or null if it there is none.
     *
     * The meeting must have happened at a past date.
     *
     * @param id the ID for the meeting
     * @return the meeting with the requested ID, or null if it there is none.
     * @throws IllegalStateException if there is a meeting with that ID happening
     *         in the future
     */
    public PastMeeting getPastMeeting(int id)   {

        return null;

    }


    /**
     * Returns the FUTURE meeting with the requested ID, or null if there is none.
     *
     * @param id the ID for the meeting
     * @return the meeting with the requested ID, or null if it there is none.
     *  @throws  IllegalArgumentException  if  there  is  a  meeting  with  that  ID  happening
     *                 in  the  past
     */
    public FutureMeeting  getFutureMeeting(int  id)     {
        for (Meeting i : meetings) {
            if (i.getId() == id)    {
                // Check if meeting is a past meeting
                if (i instanceof PastMeeting)   {
                    throw new IllegalArgumentException("Exception! A Past Meeting is invalid");
                } else {
                    return (FutureMeeting) i;
                }
            }
        }
        return null;
    }


    /**
     *  Returns  the  meeting  with  the  requested  ID,  or  null  if  it  there  is  none.
     *
     *  @param  id  the  ID  for  the  meeting
     *  @return  the  meeting  with  the  requested  ID,  or  null  if  it  there  is  none.
     */
    public Meeting  getMeeting(int  id)     {
        for (Meeting i : meetings) {
            if (i.getId() == id)    {
                return i;
            }
        }
        return null;
    }


    /**
     *  Returns  the  list  of  future  meetings  scheduled  with  this  contact.
     *
     *  If  there  are  none,  the  returned  list  will  be  empty.  Otherwise,
     *  the  list  will  be  chronologically  sorted  and  will  not  contain  any
     *  duplicates.
     *
     *  @param  contact  one  of  the  users  contacts
     *  @return  the  list  of  future  meeting(s)  scheduled  with  this  contact  (maybe  empty).
     *  @throws  IllegalArgumentException  if  the  contact  does  not  exist
     *  @throws  NullPointerException  if  the  contact  is  null
     */
    public List<Meeting>  getFutureMeetingList(Contact  contact)   {

        return null;

    }


    /**
     *  Returns  the  list  of  meetings  that  are  scheduled  for,  or  that  took
     *  place  on,  the  specified  date
     *
     *  If  there  are  none,  the  returned  list  will  be  empty.  Otherwise,
     *  the  list  will  be  chronologically  sorted  and  will  not  contain  any
     *  duplicates.
     *
     *  @param  date  the  date
     *  @return  the  list  of  meetings
     *  @throws  NullPointerException  if  the  date  are  null
     */
    public List<Meeting>  getMeetingListOn(Calendar  date)      {

        return null;

    }

    /**
     *  Returns  the  list  of  past  meetings  in  which  this  contact  has  participated.
     *
     *  If  there  are  none,  the  returned  list  will  be  empty.  Otherwise,
     *  the  list  will  be  chronologically  sorted  and  will  not  contain  any
     *  duplicates.
     *
     *  @param  contact  one  of  the  users  contacts
     *  @return  the  list  of  future  meeting(s)  scheduled  with  this  contact  (maybe  empty).
     *  @throws  IllegalArgumentException  if  the  contact  does  not  exist
     *  @throws  NullPointerException  if  the  contact  is  null
     */
    public List<PastMeeting>  getPastMeetingListFor(Contact  contact)      {

        return null;

    }


    /**
     *  Create  a  new  record  for  a  meeting  that  took  place  in  the  past.
     *
     *  @param  contacts  a  list  of  participants
     *  @param  date  the  date  on  which  the  meeting  took  place
     *  @param  text  messages  to  be  added  about  the  meeting.
     *  @throws  IllegalArgumentException  if  the  list  of  contacts  is
     *
    empty,  or  any  of  the  contacts  does  not  exist
     *  @throws  NullPointerException  if  any  of  the  arguments  is  null
     */
    public void  addNewPastMeeting(Set<Contact>  contacts,  Calendar  date,  String  text)     {



    }


    /**
     *  Add  notes  to  a  meeting.
     *
     *  This  method  is  used  when  a  future  meeting  takes  place,  and  is
     *  then  converted  to  a  past  meeting  (with  notes)  and  returned.
     *
     *  It  can  be  also  used  to  add  notes  to  a  past  meeting  at  a  later  date.
     *
     *  @param  id  the  ID  of  the  meeting
     *  @param  text  messages  to  be  added  about  the  meeting.
     *  @throws  IllegalArgumentException  if  the  meeting  does  not  exist
     *  @throws  IllegalStateException  if  the  meeting  is  set  for  a  date  in  the  future
     *  @throws  NullPointerException  if  the  notes  are  null
     */
    public PastMeeting  addMeetingNotes(int  id,  String  text)     {

        return null;

    }

    public int  addNewContact(String  name,  String  notes) {

        if ((name == null) || (notes == null)) {
            throw new NullPointerException("Exception! A valid name or note was not provided.");
        } else if (name.equals("") || notes.equals("")) {
            throw new IllegalArgumentException("Exception! A valid name or note was not provided.");
        } else {
            int createdID = contacts.size() + 1;
            Contact contactAdded = new ContactImpl(createdID, name, notes);
            contacts.add(contactAdded);
            return contactAdded.getId();
        }
    }


    public Set<Contact>  getContacts(String  name)      {

        if (name == null) {
            throw new NullPointerException("Exception! You must have a valid name.");
        } else if (name.equals("")) {
            return contacts;
        } else {
            Set<Contact> contactsReturned = new HashSet<Contact>();
            for(Contact i : contacts)   {
                if(i.getName().contains(name)){
                    contactsReturned.add(i);
                }
            }
            return contactsReturned;
        }
    }


    public Set<Contact> getContacts(int... ids)     {

        if(ids.length == 0) {
            throw new IllegalArgumentException("Exception! Please provide an id.");
        } else  {

            Set<Contact> contactsReturned = new HashSet<Contact>();

            // Check the provided ids exist
            int validIds = 0;

            for (Contact c : getContacts("")) {
                for (int i : ids) {
                    if (c.getId() == i) {
                        validIds++;
                    }
                }
            }
            if (validIds != ids.length) {
                throw new IllegalArgumentException("Exception! An invalid ID was entered");
            }

            //Build set to return

            for (Contact c : getContacts("")) {
                for (int i : ids) {
                    if (c.getId() == i) {
                        contactsReturned.add(c);
                    }
                }
            }
            return contactsReturned;
        }
    }

    public void flush()     {

        //Make a file
        File myContacts = new File("." + File.separator + MYFILE);

        //Check if file exists
        if(!myContacts.exists()) {

            //If the file does not exist write it
            try {
                myContacts.createNewFile();
            } catch(IOException exception)  {
                exception.printStackTrace();
            }
        } try(ObjectOutputStream myOutput = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(myContacts)))){
            myOutput.writeObject(contacts);
            myOutput.writeObject(meetings);
        }   catch(IOException exception) {
            exception.printStackTrace();
        }


    }


}
