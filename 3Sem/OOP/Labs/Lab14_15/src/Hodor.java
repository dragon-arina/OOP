import java.util.HashMap;
import java.util.Map;

class Hodor {
    private static Map<String, String> map = new HashMap<String, String>();

       public static  Map<String, String> Stark() {
           map.put("Winona", "Ryder");
           map.put("Keanu", "Reeves");
           map.put("Sandra", "Bullock");
           map.put("Joaquin", "Phoenix");
           map.put("Leonardo", "DiCaprio");
           map.put("Johnny", "Depp");
           map.put("Margot", "Robbie");
           map.put("Bradley", "Cooper");
           map.put("Lady", "Gaga");
           map.put("Jennifer", "Lawrence");
           return map;
       }


    public static int getSameFirstNameCount(HashMap<String, String> map, String name)
    {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String value = pair.getValue();
            if (value.equals(name))
                count++;
        }
        return count;
    }

    public static int getSameLastNameCount(HashMap<String, String> map, String surname)
    {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (pair.getKey().equals(surname))
                count++;
        }
        return count;
    }
}