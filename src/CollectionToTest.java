import java.util.Collection;

public interface CollectionToTest {

    Object readOperation();
    Object updateOperation();
    Object iterateOperation();

    Object fillCollection(Collection<Integer> start);
    Object resetCollection();

}
