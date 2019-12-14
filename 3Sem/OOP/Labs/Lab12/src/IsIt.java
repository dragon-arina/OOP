import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsIt {
    public static void isEqual() {
        Scanner in = new Scanner(System.in);
        Pattern p1 = Pattern.compile("abcdefghijklmnopqrstuv18340");
        Matcher m1 = p1.matcher( in.nextLine() );
        System.out.println("Input string is right? " + m1.matches());

    }
}
