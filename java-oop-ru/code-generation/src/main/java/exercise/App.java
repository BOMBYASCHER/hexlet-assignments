package exercise;

import lombok.SneakyThrows;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    @SneakyThrows
    public static void save(Path filePath, Car object) {
        Files.writeString(filePath, object.serialize(), StandardOpenOption.WRITE);
    }
    @SneakyThrows
    public static Car extract(Path filePath) {
        return Car.unserialize(Files.readString(filePath));
    }
}
// END
