import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

public class TreeMapToTest implements CollectionToTest {

    private ConcurrentSkipListMap<Integer, Integer> map = new ConcurrentSkipListMap<>();

    @Override
    public Object readOperation() {
        return map.get(Utilities.randomInt(map.size()-ACCESS_SIZE_OFFSET));
    }

    @Override
    public Object updateOperation() {
        int dummy = map.remove(Utilities.randomInt(map.size()-ACCESS_SIZE_OFFSET));
        map.put(dummy, dummy);
        return dummy;
    }

    @Override
    public Object iterateOperation() {
        AtomicReference<Integer> dummy = new AtomicReference<>(0);
        map.forEach((key, value) -> {
            dummy.set(key);
        });
        return dummy;
    }

    @Override
    public Object fillCollection(List<Integer> start) {
        map.clear();
        start.forEach((value)->{
            map.put(value, value);
        });
        return Collections.unmodifiableCollection(map.keySet());
    }

    @Override
    public Object resetCollection() {
        map = new ConcurrentSkipListMap<>();
        return Collections.unmodifiableCollection(map.keySet());
    }
}
