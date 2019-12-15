import java.util.HashSet;
import java.util.TreeSet;

public class Tree<E> {
    HashSet<E> set = new HashSet<E>();
    TreeSet toTreeSet() {
        return new TreeSet(set);
    }




}