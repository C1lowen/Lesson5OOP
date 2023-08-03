package lesson5_task2_level1;

import java.util.Scanner;

public class NewStudent {

    public Student createNewStudent(){
        Scanner sc = new Scanner(System.in);

        Student student = new Student(null, null, null, 0, null);

        System.out.println("Введите имя студента: ");
        student.setName(sc.nextLine());

        System.out.println("Введите фамилию студента: ");
        student.setLastName(sc.nextLine());

        System.out.println("Введите пол студента(MAN/WOMAN): ");
        String gen = sc.nextLine();
        if(gen.equals("MAN")){
            student.setGender(Gender.MAN);
        }else if(gen.equals("WOMAN")){
            student.setGender(Gender.WOMAN);
        }else{
            System.out.println("Вы не выбрали пол для студента!");
            System.exit(0);
        }

        System.out.println("Введите id студента: ");
        student.setId(sc.nextInt());

        System.out.println("Введите группу студента: ");
        sc.nextLine();
        student.setGroupName(sc.nextLine());


        return student;
    }

    public boolean addStudentForGroup(Group group, Student student){
        try {
            group.addStudent(student);
            return true;
        }catch (GroupOverflowException e){
            e.printStackTrace();
            return false;
        }
    }


}
