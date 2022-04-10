import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class ListToTest implements CollectionToTest {

    private CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    @Override
    public Object readOperation() {
        return list.get(Utilities.randomInt(list.size()-ACCESS_SIZE_OFFSET));
    }

    @Override
    public Object updateOperation() {
        int dummy = list.remove(Utilities.randomInt(list.size()-ACCESS_SIZE_OFFSET));
        list.add(dummy);
        return dummy;
    }

    @Override
    public Object iterateOperation() {
        AtomicReference<Integer> dummy = new AtomicReference<>(0);
        list.forEach((value) -> {
            dummy.set(value);
        });
        return dummy;
    }

    @Override
    public Object fillCollection(Integer[] start) {
        list.clear();
        for (Integer value : start) {
            list.add(value);
        }
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
