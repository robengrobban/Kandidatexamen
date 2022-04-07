import java.util.*;

public interface CollectionToTest {

    int ACCESS_SIZE_OFFSET = 10;

    Object readOperation();
    Object updateOperation();
    Object iterateOperation();

    Object fillCollection(List<Integer> start);
    Object resetCollection();

}
