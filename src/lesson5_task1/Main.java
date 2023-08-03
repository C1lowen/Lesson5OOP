package lesson5_task1;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File fileIn = new File("D:\\One");
        File fileOut = new File("D:\\Two");

        try {
          FileServise.copyFileInFolder(fileIn, fileOut, "txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
