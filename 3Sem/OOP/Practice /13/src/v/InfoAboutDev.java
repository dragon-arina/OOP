package v;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InfoAboutDev {
    private String FIO;
    Date date = new Date();
    Calendar c = new GregorianCalendar();
    Date date2 = c.getTime();

public void setD() {
    c.set(Calendar.YEAR, 2017);
    c.set(Calendar.MONTH, 12);
    c.set(Calendar.DAY_OF_MONTH, 9);
    }

    public InfoAboutDev(String FIO) {
        this.FIO = FIO;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Override
    public String toString() {
        return "Задание выдано -> " + FIO + '\'' +
                "\n Дата и время получения: " + c.getTime() + "\n" +
                "--------------------------" + "\n" + "Задание сдал -> " + FIO +
                "\nДата и время сдачи: " + date;
    }

}
