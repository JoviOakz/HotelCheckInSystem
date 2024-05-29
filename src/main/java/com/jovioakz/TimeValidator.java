package com.jovioakz;

public class TimeValidator {
    public static boolean validateTime(String time) {
        String[] times = time.split(":");

        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);

        if (hour < 0 || hour > 23) return false;

        if (minute < 0 || minute > 59 ) return false;

        return true;
    }
}
