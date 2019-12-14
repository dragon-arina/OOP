import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void isReliable (String str) {
        Pattern p1 = Pattern.compile("[a-zA-Z0-9_]{8,}");
        Matcher m1 = p1.matcher(str);
        String result = "";
        System.out.print("\nПароль: ");
        if (m1.find()) {
            result = m1.group();
            if (m1.matches() && checkSymbols(result))
                System.out.print(result);
            else
                System.out.println("ненадежен");
        }
    }
    public static boolean checkSymbols(String str) {
        boolean isLower = false, isUpper = false, isDigit = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                isLower = true;
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                isUpper = true;
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                isDigit = true;
        }
        return isLower && isUpper && isDigit;
    }
}
