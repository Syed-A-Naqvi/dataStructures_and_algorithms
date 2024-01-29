package Object_Arrays;

/**
 * Driver
 */
public class Driver {

    public static void searchStudents(Student[] students, String stu) {

        for (Student student : students) {
        
            //the student.equalsIgnoreCase() function returns true if the passed
            //string equals the calling string, case insensitive
            if(student.name.equalsIgnoreCase(stu)){
                System.out.printf("\"%s\" found.\n", stu);
                return;
            }

        }

        System.out.printf("\"%s\" not found.\n", stu);
        
    }

    public static void display(Student[] students) {

        for (Student student : students) {

            System.out.println(student.toString());
        }

    }

    public static void main(String[] args) {

        Student[] students = new Student[] {
            new Student("Steve Jobs", 55),
            new Student("Bill Gates", 65),
            new Student("Elon Musk", 45),
            new Student("Jeff Bezos", 55),
        };

        display(students);
        searchStudents(students, "Steve Jobs");

    }

}