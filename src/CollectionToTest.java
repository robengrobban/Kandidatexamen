public interface CollectionToTest {
    int ACCESS_SIZE_OFFSET = 50;

    Object readOperation();
    Object updateOperation();
    Object iterateOperation();

    Object fillCollection(Integer[] start);
    Object resetCollection();
}