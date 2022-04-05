public class Main {

    // Entry point to tests
    public static void main(String[] args) {
        long start = System.nanoTime();
        Observer observer = new Observer();
        QueueTest queueTest = new QueueTest(1, 20, 20, 20);
        QueueTest queueTest2 = new QueueTest(1, 20, 20, 20);
        observer.writeToFile();
        long end = System.nanoTime();
        System.out.println((end-start)/1.0E6+"ms");
    }

}
