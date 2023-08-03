package lesson5_task2_level1;

import java.util.Comparator;

public class StudentLastNameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;

        String lastNameFirst = student1.getLastName();
        String lastNameTwo = student2.getLastName();


        return lastNameFirst.compareTo(lastNameTwo);
    }
}
