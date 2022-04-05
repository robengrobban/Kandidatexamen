import java.util.concurrent.ThreadLocalRandom;

public class Utilities {

    // Methods
    public static int randomInt(int max) {
        return ThreadLocalRandom.current().nextInt(Math.max(max, 1));
    }

    public static void shuffleArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            int randomIndex = Utilities.randomInt(array.length);

            Object temp = array[randomIndex];
            array[randomIndex] = array[i];
            array[i] = temp;
        }
    }

}
