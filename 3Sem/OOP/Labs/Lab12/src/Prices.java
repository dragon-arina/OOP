import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prices {
    public static void showPrices (String str) {
        Pattern p1 = Pattern.compile("(\\d+\\p{Punct}\\d{2}\\p{Blank}\\p{Upper}{2,3})");
        Matcher m1 = p1.matcher(str);
        String result;
        while (m1.find()) {
            result = m1.group();
            System.out.println(result);
        }
    }
}
