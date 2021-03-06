package notepad;

import java.time.LocalTime;
//Note nasleduetsja ot Record

public class Note extends Record {
    private String text;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + getId() + "," +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return text.contains(str);
    }



//nasledovanie
    @Override
    public void askQuestions() {
        //vopros otpravljaetsja v MAIN
        System.out.println("Enter text:");
        text = Main.askString();


    }
}
