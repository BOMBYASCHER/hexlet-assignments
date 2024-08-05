package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String filePathA, String filePathB, String resultFilePath) {
        Path pathA = Paths.get(filePathA).toAbsolutePath().normalize();
        Path pathB = Paths.get(filePathB).toAbsolutePath().normalize();
        Path resultPath = Paths.get(resultFilePath).toAbsolutePath().normalize();
        CompletableFuture<String> readerA = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(pathA);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(e -> {
            System.out.println("The file '" + pathA.getFileName() + "' does not exist! Exception: " + e.getMessage());
            return null;
        });
        CompletableFuture<String> readerB = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(pathB);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(e -> {
            System.out.println("The file '" + pathB.getFileName() + "' does not exist! Exception: " + e.getMessage());
            return null;
        });
        return readerA.thenCombine(readerB, (fileA, fileB) -> {
            try (var bw = Files.newBufferedWriter(resultPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                String data = fileA + fileB;
                bw.append(data);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return "Done";
        });
    }

    public static CompletableFuture<Long> getDirectorySize(String directoryPath) {
        File directory = Paths.get(directoryPath).toFile();
        var asyncComputeFileSizes = Arrays.stream(directory.listFiles())
                .filter(File::isFile)
                .map(file -> CompletableFuture.supplyAsync(file::length))
                .toList()
                .toArray(new CompletableFuture[0]);
        var waitingFileSizes = CompletableFuture.allOf(asyncComputeFileSizes);
        var sizes = waitingFileSizes.thenApply(v ->
                Arrays.stream(asyncComputeFileSizes)
                        .map(CompletableFuture::join)
                        .toList()
        );
        return sizes.thenApply(size -> size.stream().mapToLong(c -> (Long) c).sum());
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/result.txt"
        ).get();
        // END
    }
}

