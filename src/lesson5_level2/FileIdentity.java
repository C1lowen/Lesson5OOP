package lesson5_level2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FileIdentity {

    public static boolean checkFile(File fileOne, File fileTwo) throws IOException {
        if(fileOne.length() != fileTwo.length()) return false;

        try(InputStream isOne = new FileInputStream(fileOne);
            InputStream isTwo = new FileInputStream(fileTwo)){

            while(isOne.available() != 0 && isTwo.available() != 0) {
                byte[] byteOne = new byte[100];
                byte[] byteTwo = new byte[100];

                isOne.read(byteOne);
                isTwo.read(byteTwo);

                if (!(Arrays.equals(byteOne, byteTwo))) return false;

            }
        }

        return true;
    }
}
