import java.util.HashMap;
import java.util.Hashtable;

public class SecondTask {
    private HashMap <String, String> numbers = new HashMap<String, String>();


    void Put(String key, String value){
        numbers.put(key, value);
    }

    private String LookUp(String key){
        return numbers.get(key);
    }
    void Delete(String value, String key){
        numbers.remove(key,value);
    }
    int Hash(String key){
        return this.LookUp(key).hashCode()*31;
    }
}
