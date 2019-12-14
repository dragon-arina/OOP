import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {
    public static void isDate (String str) {
        Pattern p1 = Pattern.compile("(([0][1-9]|[1-3][0-9])/([0][1-9]|[1][0-2])/([1][9]|[2-9][0-9])[0-9][0-9])");
        Matcher m1 = p1.matcher(str);
        String result = "";
        if (m1.find()) {
            result = m1.group();
            System.out.println(result);
        }
        if (result.isEmpty())
            System.out.println("Дата написана неверно");
    }
}
