package v4;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClassDaterTest {
    public static void main(String[] args) {
        ClassDater classDater = new ClassDater();
        classDater.setData();
        Calendar calendar = Calendar.getInstance();
        calendar.set(classDater.getYear(), classDater.getMount(),classDater.getDays());
        System.out.println();
        SimpleDateFormat format1 = new SimpleDateFormat("<YYYY><MM><dd><HH><mm>");
        String formatted = format1.format(calendar.getTime());
        System.out.println(formatted);

    }
}
