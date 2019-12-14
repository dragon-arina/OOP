import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static void isEmail(String str) {
        Pattern p1 = Pattern.compile("(\\w+)@(\\w+)(\\.)*(\\w+)*");
        Matcher m1 = p1.matcher(str);
        String result = "";
        System.out.print("Почтовый адрес: ");
        while (m1.find()) {
            result = m1.group();
            if (result.charAt(m1.end() - 1) == '.')
                System.out.println("почта написана неверно");
            else
                System.out.print(result + " ");
        }
        if (result.isEmpty())
            System.out.println("почта написана неверно");
    }
}
