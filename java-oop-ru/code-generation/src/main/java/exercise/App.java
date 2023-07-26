package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path filePath, Car object) throws IOException {
        Files.writeString(filePath, object.serialize(), StandardOpenOption.WRITE);
    }
    public static Car extract(Path filePath) throws IOException {
        return Car.unserialize(Files.readString(filePath));
    }
}
// END
