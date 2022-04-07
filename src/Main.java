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
                System.out.println("Wrong version.... :O");
        }
    }

    private static void testFor17() {
        Observer observer = new Observer("Queue-17");
        WarmUpSequence.queue();
        TestSequence.queue(1, 32768, 34, 33, 33, observer);
        TestSequence.queue(3, 32768, 34, 33, 33, observer);
        TestSequence.queue(6, 32768, 34, 33, 33, observer);
        TestSequence.queue(12, 32768, 34, 33, 33, observer);
        TestSequence.queue(24, 32768, 34, 33, 33, observer);
        TestSequence.queue(48, 32768, 34, 33, 33, observer);
        observer.writeToFile();

        observer = new Observer("List-17");
        WarmUpSequence.list();
        TestSequence.list(1, 32768, 34, 33, 33, observer);
        TestSequence.list(3, 32768, 34, 33, 33, observer);
        TestSequence.list(6, 32768, 34, 33, 33, observer);
        TestSequence.list(12, 32768, 34, 33, 33, observer);
        TestSequence.list(24, 32768, 34, 33, 33, observer);
        TestSequence.list(48, 32768, 34, 33, 33, observer);
        observer.writeToFile();

        observer = new Observer("HashMap-17");
        WarmUpSequence.hashMap();
        TestSequence.hashMap(1, 32768, 34, 33, 33, observer);
        TestSequence.hashMap(3, 32768, 34, 33, 33, observer);
        TestSequence.hashMap(6, 32768, 34, 33, 33, observer);
        TestSequence.hashMap(12, 32768, 34, 33, 33, observer);
        TestSequence.hashMap(24, 32768, 34, 33, 33, observer);
        TestSequence.hashMap(48, 32768, 34, 33, 33, observer);
        observer.writeToFile();

        observer = new Observer("TreeMap-17");
        WarmUpSequence.treeMap();
        TestSequence.treeMap(1, 32768, 34, 33, 33, observer);
        TestSequence.treeMap(3, 32768, 34, 33, 33, observer);
        TestSequence.treeMap(6, 32768, 34, 33, 33, observer);
        TestSequence.treeMap(12, 32768, 34, 33, 33, observer);
        TestSequence.treeMap(24, 32768, 34, 33, 33, observer);
        TestSequence.treeMap(48, 32768, 34, 33, 33, observer);
        observer.writeToFile();
    }

    private static void testFor8() {

    }

}
