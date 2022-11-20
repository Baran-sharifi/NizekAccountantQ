package nizekAccountant.logic.Date;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeNizek {
    int minute;
    int hour;


    public TimeNizek() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        this.minute = zonedDateTime.getMinute();
        this.hour = zonedDateTime.getHour();
    }

 public TimeNizek(int hour, int minute) {
        this.minute = minute;
        this.hour = hour;
    }
    
    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }


    @Override
    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }
}
