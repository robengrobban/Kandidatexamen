import java.util.*;

public interface CollectionToTest {

    Object readOperation();
    Object updateOperation();
    Object iterateOperation();

    Object fillCollection(List<Integer> start);
    Object resetCollection();

}
