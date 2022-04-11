import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapToTest implements CollectionToTest {

    private ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    @Override
    public Object readOperation() {
        return map.get(Utilities.randomInt(map.size()- ACCESS_SIZE_INSET));
    }

    @Override
    public Object updateOperation() {
        try {
            int dummy = map.remove(Utilities.randomInt(map.size()- ACCESS_SIZE_INSET));
            map.put(dummy, dummy);
            return dummy;
        }
        catch (Exception ignored) {
            return updateOperation();
        }
    }

    @Override
    public Object iterateOperation() {
        int dummy = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            dummy = entry.getKey();
        }
        return dummy;
    }

    @Override
    public Object fillCollection(List<Integer> start) {
        map.clear();
        for (Integer value : start) {
            map.put(value, value);
        }
        return Collections.unmodifiableCollection(map.keySet());
    }

    @Override
    public Object resetCollection() {
        map = new ConcurrentHashMap<>();
        return Collections.unmodifiableCollection(map.keySet());
    }

    @Override
    public String toString() {
        return "HashMap";
    }

}
