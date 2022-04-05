public class Main {

    // Entry point to tests
    public static void main(String[] args) {
        int version = Runtime.version().version().get(0);
        switch (version) {
            case 17:
                testFor17();
                break;
            case 8:
                testFor8();
                break;
            default:
                System.out.println("Wrong version.... :(");
        }
    }

    private static void testFor17() {
        Observer observer = new Observer("Queue-17");
        new QueueTest(1, 32768, 34, 33, 33, observer);
        new QueueTest(3, 32768, 34, 33, 33, observer);
        new QueueTest(6, 32768, 34, 33, 33, observer);
        new QueueTest(12, 32768, 34, 33, 33, observer);
        observer.writeToFile();

        observer = new Observer("List-17");
        new ListTest(1, 32768, 34, 33, 33, observer);
        new ListTest(3, 32768, 34, 33, 33, observer);
        new ListTest(6, 32768, 34, 33, 33, observer);
        new ListTest(12, 32768, 34, 33, 33, observer);
        observer.writeToFile();

        observer = new Observer("HashMap-17");
        new HashMapTest(1, 32768, 34, 33, 33, observer);
        new HashMapTest(3, 32768, 34, 33, 33, observer);
        new HashMapTest(6, 32768, 34, 33, 33, observer);
        new HashMapTest(12, 32768, 34, 33, 33, observer);
        observer.writeToFile();

        observer = new Observer("TreeMap-17");
        new TreeMapTest(1, 32768, 34, 33, 33, observer);
        new TreeMapTest(3, 32768, 34, 33, 33, observer);
        new TreeMapTest(6, 32768, 34, 33, 33, observer);
        new TreeMapTest(12, 32768, 34, 33, 33, observer);
        observer.writeToFile();
    }

    private static void testFor8() {

    }

}
