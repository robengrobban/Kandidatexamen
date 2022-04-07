import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.atomic.AtomicReference;

public class QueueToTest implements CollectionToTest {

    private LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();

    @Override
    public Object readOperation() {
        return queue.peek();
    }

    @Override
    public Object updateOperation() {
        int dummy = queue.poll();
        queue.put(dummy);
        return dummy;
    }

    @Override
    public Object iterateOperation() {
        AtomicReference<Integer> dummy = new AtomicReference<>(0);
        queue.forEach(dummy::set);
        return dummy;
    }

    @Override
    public Object fillCollection(List<Integer> start) {
        queue.clear();
        queue.addAll(start);
        return Collections.unmodifiableCollection(queue);
    }

    @Override
    public Object resetCollection() {
        queue = new LinkedTransferQueue<>();
        return Collections.unmodifiableCollection(queue);
    }

}
