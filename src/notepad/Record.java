package notepad;

public abstract class Record {
    private static int count = 0;
    private int id;

    public Record() {
        count++;
        id = count;
    }

    public abstract boolean hasSubstring(String str);
    //abstraktnij metod dlja voprosov

    public abstract void askQuestions();

    public int getId() {
        return id;
    }
}
