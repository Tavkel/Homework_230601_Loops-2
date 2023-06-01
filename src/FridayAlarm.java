import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class FridayAlarm {

    synchronized void fridayReportAlarm() {
        Thread fridayReportAlarm = new Thread(() -> {
            while (true) {
                var timeDate = LocalDate.now();
                var time = LocalTime.now();
                if (timeDate.getDayOfWeek() == DayOfWeek.FRIDAY
                        && time.isAfter(LocalTime.parse("12:00:00"))
                        && time.isBefore(LocalTime.parse("12:10:00"))) {
                    System.out.println("ОТЧЕЕЕЕТ!!!!");
                    try {
                        Thread.sleep(1000 * 60 * 60);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        Thread.sleep(1000 * 60 * 9);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        fridayReportAlarm.start();
    }
}
