package lesson5_task2_level1;

import java.io.*;

public class GroupFileStorage {
    public static void saveGroupToCSV(Group gr){
        File file = new File("D:\\Java_Project\\lesson5\\СП-135.txt");
        CSVStringConverter csv = new CSVStringConverter();
        try(Writer wr = new FileWriter(file)) {
            int sizeStudent = gr.getStudents().length;
            for(int i = 0; i < sizeStudent; i++){
                if(gr.getStudents()[i] != null) {
                    String strCSV = csv.toStringRepresentation(gr.getStudents()[i]);
                    wr.write(strCSV+ '\n');

                }
            }
        }catch (IOException e){
            System.out.println("Произошла ошибка");;
        }

    }

    public static Group loadGroupFromCSV(File file){
        String[] nameFile = file.getName().split("[.]");

        CSVStringConverter csv = new CSVStringConverter();

        Group newGroup = new Group();
        newGroup.setGroupName(nameFile[0]);

        try(InputStream is = new FileInputStream(file)) {
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));
            while(true) {
                String str = bis.readLine();
                if (str == null) {
                    break;
                }
                Student student = csv.fromStringRepresentation(str);
                try {
                    newGroup.addStudent(student);
                } catch (GroupOverflowException e) {
                    throw new RuntimeException(e);
                }
            }

        }catch (IOException e){
            System.out.println("Не удалось считать студента");
        }
        return newGroup;
    }

   public static File findFileByGroupName(String groupName, File workFolder){
       File[] files = workFolder.listFiles();

       for(File file : files){
           if(file.isFile()){
               String[] nameFile = file.getName().split("[.]");
               if(nameFile[0].equals(groupName)){
                   return file;
               }
           }else{
               findFileByGroupName(groupName, file);
           }
       }
       return null;
   }






}
