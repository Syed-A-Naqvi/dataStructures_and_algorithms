package q2;

import java.util.*;

/**
 * Driver
 */
public class Driver {

    public static Student getOldest(Student[] students) {
        Student oldest = students[0]; //O(1)

        for (Student student : students) { //O(n)
            if(student.getAge() > oldest.getAge()){ //O(1)
                oldest = student; //O(1)
            }
        }

        return oldest; //O(1)
        
    }

    public static void main(String[] args) {
        
        Student students[] = new Student[] 
        { 
            new Student("Steve", 55),
            new Student("Bill", 65),
            new Student("Warren", 75),
            new Student("Elon", 45),
            new Student("John", 35)
        };

        Student oldest = getOldest(students);

        System.out.println("Oldest student is: " + oldest.getName() + " with age: " + oldest.getAge());

    }

}