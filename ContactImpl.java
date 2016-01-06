/**
 * Created by andre on 05/01/2016.
 */
public class ContactImpl implements Contact, java.io.Serializable {

    private int ID;
    private String name;
    private String notes;

    //Three parameter constructor
    public ContactImpl(int ID, String name, String notes)    {
        this.ID = ID;
        this.name = name;
        this.notes = notes;
    }

    public int getId() {
        return 0;
    }

    public String getName() {
        return null;
    }

    public String getNotes() {
        return null;
    }

    public void addNotes(String note) {

    }
}
