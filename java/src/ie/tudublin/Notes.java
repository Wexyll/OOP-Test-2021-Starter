package ie.tudublin;

public class Notes
{
    private char note;
    private int dur;

    //begin constructor for the Notes
    public Notes(char note, int dur){ 
        this.note = note;
        this.dur = dur;
    }

    //begin getter and setters for notes
    public char getNote() {
        return note;
    }

    public void setNote(char note) {
        this.note = note;
    }

    
    //begin getter/setter for duration
    public int getDuration() {
        return dur;
    }

    public void setDuration(char duration) {
        this.dur = duration;
    }

    //toString beginning
    @Override
    public String toString(){
        return "Notes [note =" + note + ", dur =" + dur + "]";
    }
}