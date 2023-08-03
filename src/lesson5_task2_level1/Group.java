package lesson5_task2_level1;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    private Student[] students;



    public Group() {
        students = new Student[10];
        this.groupName = null;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if(!(student.getGroupName().equals(this.groupName))){
            System.out.println("Студент "+ student.getName() +" не может быть в этой группе!");
            return;
        }
       for(int i = 0; i < students.length; i++){
           if(students[i] == null){
               students[i] = student;
               return;
           }
       }
       throw new GroupOverflowException("В группу нельзя добавить больше 10 студентов");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && students[i].getLastName().equals(lastName)){
                return students[i];
            }
        }
        throw new StudentNotFoundException("Такого студента не найдено!");
    }

    public boolean removeStudentByID(int id) {
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && students[i].getId() == id){
                students[i] = null;
                return true;
            }
        }
        return false;
    }
    public Student[] sortStudentsByLastName(){
       Arrays.sort(students, Comparator.nullsLast(new StudentLastNameComparator()));

       return students;
    }

    @Override
    public String toString() {
         String result = "Group" + System.lineSeparator();
         Student[] sortedStudentsForLastName = sortStudentsByLastName();

         for(int i = 0; i < sortedStudentsForLastName.length; i++){
             if(sortedStudentsForLastName[i] != null){
                 result +=  sortedStudentsForLastName[i].toString() + System.lineSeparator();
             }
         }
        return result;
    }
}
