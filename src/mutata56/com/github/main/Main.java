package mutata56.com.github.main;

import java.io.*;
import java.nio.file.Path;

public class Main {
    private static Path PATH = Path.of("IO\\Output.txt");
    public static void main(String[] args) {
        someMethod(args);
    }

    private static void someMethod(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH.toFile(),true))) {
            for(String str : args) {
                writer.write(str.split("\\s").length);
                writer.write("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
