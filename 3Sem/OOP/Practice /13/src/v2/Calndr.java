package v2;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Calndr {
    private int year;
    private int month;
    private  int day;
    Date date = new Date();
    Scanner scanner = new Scanner(System.in);

    public void setData() {
        System.out.println("Enter year: ");
        year = scanner.nextInt();
        System.out.println("Enter mount: ");
        month = scanner.nextInt();
        System.out.println("Enter day: ");
        day = scanner.nextInt();
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }


    @Override
    public String toString() {
        return "Calndr{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
