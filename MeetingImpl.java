

/**
 * Created by andre on 06/01/2016.
 */

import java.util.Calendar;
import java.util.Set;

public abstract class MeetingImpl implements Meeting, java.io.Serializable   {

    private int ID;
    private Calendar date;
    private Set<Contact> contacts;

    //The Constructor
    public MeetingImpl(int ID, Calendar date, Set<Contact> contacts)    {

        if (ID <= 0) {
            throw new IllegalArgumentException("Exception! ID was 0 or less.");
        } else if (date == null) {
            throw new NullPointerException("Exception! A name was not provided.");
        } else if (contacts == null) {
            throw new NullPointerException("Exception! A set of contacts was not provided.");
        } else if (contacts.isEmpty()) {
            throw new IllegalArgumentException("Exception! There are no contacts.");
        } else {
            this.ID = ID;
            this.date = date;
            this.contacts = contacts;
        }

    }



    public int getId()  {
        return ID;
    }

    public Calendar getDate()   {
        return date;
    }

    public Set<Contact> getContacts()   {
        return contacts;
    }


}
