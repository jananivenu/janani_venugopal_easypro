package utils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public String formatDate()
    {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String stringDate= DateFor.format(date);
        return stringDate;
    }
        }

