package lesson5_task2_level1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Group group = new Group();

        NewStudent student = new NewStudent();

        System.out.println("Введите имя группы");
        String inputGroupName = sc.nextLine();
        group.setGroupName(inputGroupName);

        System.out.println("Сколько студентов вы хотите добавить?");
        int studentWantToInput = sc.nextInt();

        for (int i = 1; i <= studentWantToInput; i++) {
            System.out.println("Студент #" + i);
            Student studentNew = student.createNewStudent();
            boolean studentAdd = student.addStudentForGroup(group, studentNew);
            if (studentAdd == false) {
                break;
            }
        }
        group.sortStudentsByLastName();
        for (Student student1 : group.getStudents()) {
            if (student1 != null) {
                System.out.println(student1);
            }
        }


        GroupFileStorage.saveGroupToCSV(group);                                             //запись группы в CSV файл
        File workFolder = new File("D:\\Java_Project\\lesson5");

        try {
            if(GroupFileStorage.findFileByGroupName("СП-135", workFolder) == null){
                throw new IllegalArgumentException("Такого файла не найдено!");
            }
            File file = GroupFileStorage.findFileByGroupName("СП-135", workFolder);    //поиск файла в рабочем каталоге
            Group group1 = GroupFileStorage.loadGroupFromCSV(file);                         //вычитка и возврат группы из файла

            int size = group1.getStudents().length;

            for(Student st : group1.getStudents()){
                if(st != null) {
                    System.out.println(st);
                }
            }

        } catch (IllegalArgumentException e) {
            System.exit(0);
        }






    }


}
