package ir.ninjacoder.ghostide.core.git;

import java.time.LocalTime;

public class GhostDate {

 public static String getGreeting() {
    LocalTime now = LocalTime.now();
    int hour = now.getHour();

    if (hour >= 5 && hour < 12) {
      return "Good Morning";
    } else if (hour >= 12 && hour < 17) {
      return "Good Afternoon";
    } else if (hour >= 17 && hour < 23) {
      return "Good Evening";
    } else {
      return "Good Night";
    }
  }
}
