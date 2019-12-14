package v4;

import java.util.Date;
import java.util.Scanner;

public class ClassDater {
    private int year;
    private int month;
    private int days;
    Date date = new Date();
    Scanner scanner = new Scanner(System.in);

    public void setData() {
        System.out.println("Enter year: ");
        year = scanner.nextInt();
        System.out.println("Enter mount: ");
        month = scanner.nextInt();
        System.out.println("Enter day: ");
        days = scanner.nextInt();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMount() {
        return month;
    }

    public void setMount(int month) {
        this.month = month;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

}
