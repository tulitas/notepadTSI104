package notepad;

import java.time.LocalTime;

public class Alarm extends Note{
    private LocalTime time;
    private String alarmt;
    public boolean hasSubstring(String str) {
        return super.hasSubstring(str)

                || time.format(Main.TIME_FORMATTER).contains(str);

    }

    public LocalTime getTime() {
        return time;

    }

    @Override
    public void askQuestions() {

        System.out.println("Enter alarm time:");
        alarmt = Main.askString();
    }

    public String getAlarmt() {
        return alarmt;
    }

    public void setAlarmt(String alarmt) {
        this.alarmt = alarmt;
    }


    @Override
    public String toString() {
        return "Alarm{" +
                "alarmt = " + alarmt +
                '}';
    }
}

