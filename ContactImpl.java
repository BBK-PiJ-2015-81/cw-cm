/**
 * Created by andre on 05/01/2016.
 */
public class ContactImpl implements Contact, java.io.Serializable {

    private int ID;
    private String name;
    private String notes;

    //Three parameter constructor
    public ContactImpl(int ID, String name, String notes) {

        if (ID <= 0) {
            throw new IllegalArgumentException("Exception! ID was 0 or less.");
        } else if (name == null) {
            throw new NullPointerException("Exception! A name was not provided.");
        } else if (notes == null) {
            throw new NullPointerException("Exception! A note was not provided.");
        } else {
            this.ID = ID;
            this.name = name;
            this.notes = notes;
        }
    }

    //Two parameter constructor
    public ContactImpl(int ID, String name) {

        if (ID <= 0) {
            throw new IllegalArgumentException("Exception! ID was 0 or less.");
        } else if (name == null) {
            throw new NullPointerException("Exception! A name was not provided.");
        } else {
            this.ID = ID;
            this.name = name;
            this.notes = "";
        }
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

        // Don't allow adding null or an empty string to the notes
        if ((note != null) && !(note.equals(""))) {

            if (getNotes().equals("")) {
                notes = note;
            } else {
                notes = notes + "\n" + note;
            }
        }
    }
}