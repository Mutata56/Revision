package mutata56.com.github.main;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    private static Path PATH = Path.of("IO\\Output.txt");
    public static void main(String[] args) {
        switch (args[0]) {
            case "-c" -> someMethod(Arrays.copyOfRange(args, 1, args.length));
            case "-f" -> findWords(Arrays.copyOfRange(args, 2, args.length), args[1]);
            default -> throw new IllegalArgumentException("Couldn't resolve mode.");
        }
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
    private static void findWords(String[] args,String word) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH.toFile(),true))) {
            for(String str : args) {
                int index = -1;
                int count = 0;
                while((index = word.indexOf(word,index)) >= 0) {
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
