import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        HashMap<String, String> hm = (HashMap<String, String>) Hodor.Stark();
        System.out.println(Hodor.getSameFirstNameCount(hm, "Depp"));
        System.out.println(Hodor.getSameLastNameCount(hm, "Johnny"));

    }
}