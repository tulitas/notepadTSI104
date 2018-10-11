package notepad;

import java.time.LocalTime;

public class Alarm extends Note{
    private LocalTime time;
    public boolean hasSubstring(String str) {
        return super.hasSubstring(str)

                || time.format(Main.TIME_FORMATTER).contains(str);

    }

    public LocalTime getTime() {
        return time;

    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "time=" + time +
                '}';
    }
}

