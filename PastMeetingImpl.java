/**
 * Created by andre on 06/01/2016.
 */

import java.util.Calendar;
import java.util.Set;

public class PastMeetingImpl extends MeetingImpl implements PastMeeting {

    private String notes;

    //Call MeetingImpl's constructor with arguments the PastMeetingImpl constructor takes.
    public PastMeetingImpl(int ID, Calendar date, Set<Contact> contacts, String notes){

        super(ID, date, contacts);

        if (notes == null)  {
            throw new NullPointerException("Exception! A note was not provided.");
        }   else{
            this.notes = notes;
        }
    }



    public String getNotes()    {
        return notes;
    }

}
