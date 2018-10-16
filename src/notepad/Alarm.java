package notepad;

import java.time.LocalTime;
//implements poszvoljaet nasledovat` interface, neograni4ennoe koli4estvo, extends tolko odin
public class Alarm extends Note implements Expirable{
    private LocalTime time;
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
        time = Main.askTime();
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Time{" +
                "time = " + time +
                '}';
    }

    @Override
    public boolean isExpired() {
        LocalTime now = LocalTime.now();
        return time.isBefore(now);

    }
}

