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
        new QueueTest(24, 32768, 34, 33, 33, observer);
        new QueueTest(48, 32768, 34, 33, 33, observer);
        new QueueTest(1, 1048576, 34, 33, 33, observer);
        new QueueTest(3, 1048576, 34, 33, 33, observer);
        new QueueTest(6, 1048576, 34, 33, 33, observer);
        new QueueTest(12, 1048576, 34, 33, 33, observer);
        new QueueTest(24, 1048576, 34, 33, 33, observer);
        new QueueTest(48, 1048576, 34, 33, 33, observer);

        new QueueTest(1, 32768, 70, 15, 15, observer);
        new QueueTest(3, 32768, 70, 15, 15, observer);
        new QueueTest(6, 32768, 70, 15, 15, observer);
        new QueueTest(12, 32768, 70, 15, 15, observer);
        new QueueTest(24, 32768, 70, 15, 15, observer);
        new QueueTest(48, 32768, 70, 15, 15, observer);
        new QueueTest(1, 1048576, 70, 15, 15, observer);
        new QueueTest(3, 1048576, 70, 15, 15, observer);
        new QueueTest(6, 1048576, 70, 15, 15, observer);
        new QueueTest(12, 1048576, 70, 15, 15, observer);
        new QueueTest(24, 1048576, 70, 15, 15, observer);
        new QueueTest(48, 1048576, 70, 15, 15, observer);

        new QueueTest(1, 32768, 15, 70, 15, observer);
        new QueueTest(3, 32768, 15, 70, 15, observer);
        new QueueTest(6, 32768, 15, 70, 15, observer);
        new QueueTest(12, 32768, 15, 70, 15, observer);
        new QueueTest(24, 32768, 15, 70, 15, observer);
        new QueueTest(48, 32768, 15, 70, 15, observer);
        new QueueTest(1, 1048576, 15, 70, 15, observer);
        new QueueTest(3, 1048576, 15, 70, 15, observer);
        new QueueTest(6, 1048576, 15, 70, 15, observer);
        new QueueTest(12, 1048576, 15, 70, 15, observer);
        new QueueTest(24, 1048576, 15, 70, 15, observer);
        new QueueTest(48, 1048576, 15, 70, 15, observer);

        new QueueTest(1, 32768, 15, 15, 70, observer);
        new QueueTest(3, 32768, 15, 15, 70, observer);
        new QueueTest(6, 32768, 15, 15, 70, observer);
        new QueueTest(12, 32768, 15, 15, 70, observer);
        new QueueTest(24, 32768, 15, 15, 70, observer);
        new QueueTest(48, 32768, 15, 15, 70, observer);
        new QueueTest(1, 1048576, 15, 15, 70, observer);
        new QueueTest(3, 1048576, 15, 15, 70, observer);
        new QueueTest(6, 1048576, 15, 15, 70, observer);
        new QueueTest(12, 1048576, 15, 15, 70, observer);
        new QueueTest(24, 1048576, 15, 15, 70, observer);
        new QueueTest(48, 1048576, 15, 15, 70, observer);
        observer.writeToFile();
    }

    private static void testFor8() {

    }

}
