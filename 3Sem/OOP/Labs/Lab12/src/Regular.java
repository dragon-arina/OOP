import java.util.ArrayList;
import java.util.regex.*;


public class Regular
{
    public static void ifMoney(String string)
    {
        Pattern pattern = Pattern.compile("[1-9]+[.][0-9]+ (USD|RUB|EU)");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            int start=matcher.start();
            int end=matcher.end();
            System.out.println(string.substring(start,end));
        }
    }

    public static void main(String[] args)
    {
        String money = new String("25.96 USD 44 ERR, 0.003 EU 25$ 69.99 RUB");
        ifMoney(money);
    }
}

