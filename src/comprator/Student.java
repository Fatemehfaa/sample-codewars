package comprator;

public class Student {
    int code;
    String name;
    String gender;

    public Student(int code, String gender, String name) {
        this.code = code;
        this.gender = gender;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
