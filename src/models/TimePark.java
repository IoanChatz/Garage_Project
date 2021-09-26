package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TimePark {


    public String startPark(){
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
    Date date = new Date();  
    String start = formatter.format(date);
    return start;
    }
    
    public String endPark(){
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
    Date date = new Date();  
    String end = formatter.format(date);
    return end;  
    }

    public long findDifference(String start_date, String end_date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        long difference_In_Seconds = 0;
        long difference_In_Minutes = 0;
        long difference_In_Hours = 0;
        long difference_In_Days = 0;
        long totalMinutes = 0;
        try {
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);
            long difference_In_Time = d2.getTime() - d1.getTime();
            

            difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time)% 60;
            difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time)% 60;
            difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time)% 60;
            difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time)% 24;
            difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time)% 365;
            totalMinutes = ((difference_In_Days*24)*60) + (difference_In_Hours*60) + difference_In_Minutes ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return totalMinutes;
    }

    public double carRate(long minutes) {
        if (minutes <= 30) {
            return 0;
        } else {
            return 5 * (minutes / 60);
        }
    }
    
    public double motorcycleRate(long minutes) {
        if (minutes <= 30) {
            return 0;
        } else {
            return 3 * (minutes / 60);
        }
    }

}
