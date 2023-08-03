package lesson5_level2;

import java.io.*;

public class Main {
    public static void main(String[] args) {


        File fileOne;
        File fileTwo;

        if (args.length == 2) {
            fileOne = new File(args[0]);
            fileTwo = new File(args[1]);
        } else {
            fileOne = new File("D:\\One\\naaa.txt");
            fileTwo = new File("D:\\Two\\naaa.txt");
        }


        try{
          if(FileIdentity.checkFile(fileOne, fileTwo)) {
              System.out.println("Accessibility Files!");
          }else{
              System.out.println("Files not available!");
          }
        } catch(IOException e){
            e.printStackTrace();
        }

        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }

    }
}
