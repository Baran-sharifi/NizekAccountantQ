package nizekAccountant.logic.ConverterHelper;

import com.github.eloyzone.jalalicalendar.DateConverter;
import com.github.eloyzone.jalalicalendar.JalaliDate;
import nizekAccountant.logic.Date.DateNizek;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;
import nizekAccountant.logic.Date.TimeNizek;

public class ConverterTime {
   public static String convertToGregorian(DateNizek dateNizek) {
        DateConverter dateConverter = new DateConverter();
        LocalDate localDate = dateConverter.jalaliToGregorian(dateNizek.getYear(), dateNizek.getMonth(), dateNizek.getDay());
        StringBuilder sb = new StringBuilder();
        sb.append(localDate.getYear());
        sb.append("/");
        sb.append(localDate.getMonthValue());
        sb.append("/");
        sb.append(localDate.getDayOfMonth());
        return sb.toString();
    }
    public static String convertToPersian(String date) {
        DateConverter dateConverter = new DateConverter();
        String[] dateArray = date.split("/");
        String year = dateArray[0];
        String month = dateArray[1];
        String day = dateArray[2];
        JalaliDate jalaliDate2 = dateConverter.gregorianToJalali(
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(day));
        return jalaliDate2.toString();
    }
    public static DateNizek convertDate(String date) {
        String[] dateArray = date.split("-");
        int intDay = Integer.parseInt(dateArray[2]);
        int intMonth = Integer.parseInt(dateArray[1]);
        int intyear = Integer.parseInt(dateArray[0]);
        return new DateNizek(intDay,intMonth,intyear);
    }

    public static double findDifferencesInDays(String inputDueDate) {
        double differenceInTime = 0;
        double differenceInDays = 0;
        try {
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date(System.currentTimeMillis());
            String formatedLocalDate = formatter.format(date);
            Date dueDate = formatter.parse(inputDueDate);
            Date localDate = formatter.parse(formatedLocalDate);
            differenceInTime = dueDate.getTime() - localDate.getTime();
            differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;
        } catch (ParseException e) {
            System.out.println("Cannot parse date");
        }
        return differenceInDays;
    }
    public static TimeNizek convertToIran(String time) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date timeFresh = simpleDateFormat.parse(time);
        SimpleDateFormat sdfgmt = new SimpleDateFormat("hh:mm");
        sdfgmt.setTimeZone(TimeZone.getTimeZone("Asia/Tehran"));
        String[] array =  sdfgmt.format(timeFresh).split(":");

        return new TimeNizek(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
    }

}
