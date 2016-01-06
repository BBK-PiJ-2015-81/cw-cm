/**
 * Created by andre on 06/01/2016.
 */

import java.util.Calendar;
import java.util.Set;

public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting {

    //Call MeetingImpl's constructor with arguments the FutureMeetingImpl constructor takes.
    public FutureMeetingImpl(int ID, Calendar date, Set<Contact> contacts){
        super(ID, date, contacts);
    }



}
