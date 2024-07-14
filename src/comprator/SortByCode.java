package comprator;

import java.util.Comparator;

public class SortByCode implements Comparator<Student> {

    @Override
    public int compare(Student first, Student second) {
        return first.code - second.code;
    }
}
