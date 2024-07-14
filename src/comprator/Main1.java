package comprator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>(List.of(
                new Student(51 ,"sara","zahra") ,
                new Student(13 ,"mina","leyla")
        ));
        for (int i = 0; i < students.size(); i++)
            System.out.println(students.get(i));

        Collections.sort(students,new SortByCode());
        System.out.println("After sort");

        for (int i = 0; i < students.size(); i++)
            System.out.println(students.get(i));




    }
}
