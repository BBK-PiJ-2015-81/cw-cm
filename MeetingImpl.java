

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

        this.ID = ID;
        this.date = date;
        this.contacts = contacts;


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
