import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

public class TreeMapTest extends TestSequence {

    // Constructors
    public TreeMapTest(int numberOfThreads, int elements, int readPercent, int updatePercent, int iteratePercent, Observer observer) {
        super("TreeMap", ""+Runtime.version().version().get(0), numberOfThreads, elements, readPercent, updatePercent, iteratePercent, observer);
    }

    // Methods
    @Override
    protected CollectionToTest createCollectionToTest() {
        return new CollectionToTest() {
            private ConcurrentSkipListMap<Integer, Integer> map = new ConcurrentSkipListMap<>();

            @Override
            public Object readOperation() {
                return map.get(Utilities.randomInt(map.size()-SIZE_OFFSET));
            }

            @Override
            public Object updateOperation() {
                int dummy = map.remove(Utilities.randomInt(map.size()-SIZE_OFFSET));
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
        };
    }

}
