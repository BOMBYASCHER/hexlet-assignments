package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        var minThread = new MinThread(numbers);
        var maxThread = new MaxThread(numbers);
        minThread.start();
        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " started...");
        maxThread.start();
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " started...");
        try {
            minThread.join();
            LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " finished!");
            maxThread.join();
            LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " finished!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Map.of("min", minThread.getResult(), "max", maxThread.getResult());
    }
    // END
}
