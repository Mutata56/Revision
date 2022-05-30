package mutata56.com.github.main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    private static final Path OUTPUT = Path.of("IO\\Output.txt");
    private static final Path INPUT = Path.of("IO\\Input.txt");
    public static void main(String[] args) {
        switch (args[0]) {
            case "-c" -> someMethod();
            case "-f" -> findWords(args[1]);
            default -> throw new IllegalArgumentException("Couldn't resolve mode.");
        }
    }

    private static void someMethod() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT.toFile(),true))) {
            for(String line : Files.readAllLines(INPUT)) {
                writer.write(line.split("\\s").length);
                writer.write("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    private static void findWords(String word) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT.toFile(),true))) {
            for(String line : Files.readAllLines(INPUT)) {
                int index = -1;
                int count = 0;
                while((index = line.indexOf(word,index)) >= 0) {
                    count++;
                }
                writer.write(count);
                writer.write("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
