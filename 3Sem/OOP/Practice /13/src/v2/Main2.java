package v2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main2 {
    public static void main(String[] args) {
        Calndr calndr = new Calndr();
        calndr.setData();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar.set(calndr.getYear(), calndr.getMonth(),calndr.getDay());
        System.out.println();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/YYYY");
        String formatted = format1.format(calendar.getTime());
        String formatted1 = format1.format(calendar1.getTime());
        System.out.println(formatted);
        System.out.println(formatted1);
        System.out.println("Дата введенная пользователем раньше той, которая сейчас? "+calendar.before(calendar1));
    }
}
