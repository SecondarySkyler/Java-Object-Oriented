package Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Compress {

    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/skyle/IdeaProjects/POO/src/Exception/Compress.java");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data.replaceAll("\\s+", ""));
            }
            fileReader.close();
        } catch (FileNotFoundException ffe) {
            System.err.println("Error, can't find the file");
        }
    }
}
