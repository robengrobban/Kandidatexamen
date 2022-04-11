import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListToTest implements CollectionToTest {

    private CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    @Override
    public Object readOperation() {
        return list.get(Utilities.randomInt(list.size()- ACCESS_SIZE_INSET));
    }

    @Override
    public Object updateOperation() {
        int dummy = list.remove(Utilities.randomInt(list.size()- ACCESS_SIZE_INSET));
        list.add(dummy);
        return dummy;
    }

    @Override
    public Object iterateOperation() {
        int dummy = 0;
        for (Integer value : list) {
            dummy = value;
        }
        return dummy;
    }

    @Override
    public Object fillCollection(List<Integer> start) {
        list.clear();
        list.addAll(start);
        return Collections.unmodifiableCollection(list);
    }

    @Override
    public Object resetCollection() {
        list = new CopyOnWriteArrayList<>();
        return Collections.unmodifiableCollection(list);
    }

    @Override
    public String toString() {
        return "List";
    }

}
