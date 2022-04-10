import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

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
        int dummy = 0;
        for (Integer value : queue) {
            dummy = value;
        }
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

    @Override
    public String toString() {
        return "Queue";
    }

}
