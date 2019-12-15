import java.util.Hashtable;

public class FirstTask {
    private Hashtable<String, String> numbers ;

    void Init(){
        numbers = new Hashtable<String, String>();
    }

    void Add(String key, String value){
        numbers.put(key, value);
    }

    String LookUp(String key){
        return numbers.get(key);
    }
    void Delete(String value, String key){
        numbers.remove(key,value);
    }
    int Hash(String key){
        return this.LookUp(key).hashCode()*31;
    }
}
