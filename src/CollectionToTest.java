import java.util.List;

public interface CollectionToTest {
    int ACCESS_SIZE_INSET = 100;

    Object readOperation();
    Object updateOperation();
    Object iterateOperation();

    Object fillCollection(List<Integer> start);
    Object resetCollection();
}