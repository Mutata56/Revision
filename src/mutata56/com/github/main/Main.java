package mutata56.com.github.main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    private static final Path OUTPUT = Path.of("IO\\Output\\Output.txt");
    private static final Path INPUT = Path.of("IO\\Input\\Input.txt");
    public static void main(String[] args) {
        switch (args[0]) {
            case "-c" -> someMethod();
            case "-f" -> findWords(args[1]);
            default -> throw new IllegalArgumentException("Couldn't resolve mode.");
        }
    }

    private static void someMethod() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT.toFile(),false))) {
            int total = 0;
            for(String line : Files.readAllLines(INPUT)) {
                if(!line.isEmpty() && !line.isBlank()) {
                    int length = line.split("\\s").length;
                    total += length;
                    writer.write(length + "");
                    writer.write("\n");
                }
            }
            writer.write("Total words: " + total);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    private static void findWords(String word) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT.toFile(),true))) {
            int total = 0;
            for(String line : Files.readAllLines(INPUT)) {
                int index = -1;
                int count = 0;
                while((index = line.indexOf(word,index)) >= 0) {
                    count++;
                }
                total+= count;
                writer.write(count + "");
                writer.write("\n");
            }
            writer.write("Total words: " + total);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
