import java.util.StringTokenizer;

public class Manipulate {
    public static void showAllParts (String str) {
        StringTokenizer st = new StringTokenizer(str, "-");
        while (st.hasMoreTokens())
            System.out.print(st.nextToken() + " ");
        System.out.print("\n");
    }
}
