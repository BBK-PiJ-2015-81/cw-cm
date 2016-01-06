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
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getNotes() {
        return this.notes;
    }

    public void addNotes(String note) {
        if (getNotes().equals(""))  {
            notes = note;
        } else {
            notes = notes + "\n" + note;
        }
    }
}
