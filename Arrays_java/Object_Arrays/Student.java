package Object_Arrays;

public class Student {
    
    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age;
    }

    
}
