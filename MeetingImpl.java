

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




    }



    public int getID()  {
        return 0;
    }

    public Calendar getDate()   {
        return null;
    }

    public Set<Contact> getContacts()   {
        return null;
    }


}
