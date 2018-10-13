package notepad;

import java.time.LocalDate;
import java.time.LocalTime;




public class Reminder extends Alarm {
    private LocalDate date;

//dalee nasledovanie
    @Override
    public void askQuestions() {
        super.askQuestions();
        System.out.println("Enter reminder date");
         date = Main.askDate();
    }
// nasledovanie
    @Override
    public boolean hasSubstring(String str) {
        return super.hasSubstring(str)
                || date.format(Main.DATE_FORMATTER).contains(str);


    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() + ", " +
                "text='" + getText() + '\'' +
                ", date='" + date + '\'' +

                '}';
    }
}
