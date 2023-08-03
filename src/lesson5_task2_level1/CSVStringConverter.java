package lesson5_task2_level1;

public class CSVStringConverter implements StringConverter  {
    public String toStringRepresentation (Student student){
        return student.getName() + ";" + student.getLastName() + ";" + student.getGender() + ";" + student.getId() + ";" +  student.getGroupName();
    }

    public Student fromStringRepresentation (String str){
        String[] massiveStr = str.split(";");
        String name = massiveStr[0];
        String lastName = massiveStr[1];
        Gender gender = null;
        if(massiveStr[2].equals("MAN")){
            gender = Gender.MAN;
        }else if(massiveStr[2].equals("WOMAN")){
            gender = Gender.WOMAN;
        }else{
            System.out.println("Вы не выбрали пол для студента!");
            System.exit(0);
        }
        int id = Integer.parseInt(massiveStr[3]);
        String group = massiveStr[4];

        return new Student(name, lastName, gender, id, group);
    }
}
