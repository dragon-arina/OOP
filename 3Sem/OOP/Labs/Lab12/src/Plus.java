import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Plus {
    public static void isWithoutPlus (String str) {
        Pattern p1 = Pattern.compile("(\\d+\\p{Blank}[^\\+])");
        Matcher m1 = p1.matcher(str);
        String result;
        System.out.print("Найденные цифры без следующего знака + после них: ");
        while (m1.find()) {
            result = m1.group();
            System.out.print(result + " ");
        }
        System.out.print("\n");
    }
}
