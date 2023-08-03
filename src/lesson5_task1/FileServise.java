package lesson5_task1;

import java.io.*;

public class FileServise {

    public static long copyFile(File fileIn, File fileOut) throws IOException {
        try(InputStream is = new FileInputStream(fileIn);
            OutputStream os = new FileOutputStream(fileOut)){

            return is.transferTo(os);

        }
    }

    public static void copyFileInFolder(File folderIn, File folderOut, String extensions) throws IOException{
        File[] files = folderIn.listFiles();

        for(File file : files){
            try {
                String[] strNameFile = file.getName().split("[.]");
                if (file.isFile() && strNameFile[1].equals(extensions)) {
                    File fileOut = new File(folderOut, file.getName());
                    copyFile(file, fileOut);
                    System.out.println(file + " ==> " + strNameFile[1]);
                }else if(file.isDirectory()){
                     copyFileInFolder(file, folderOut, extensions);
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }
}
