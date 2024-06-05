import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class sampleTest {

    @Test
    public void test() {
        List<Expert> experts = new ArrayList<>(List.of(
                new Expert(5L),
                new Expert(5L),
                new Expert(5L),
                new Expert(5L),
                new Expert(5L),
                new Expert(5L)
        ));



        Long aa=experts.stream().mapToLong(Expert ::getPriority)
                .min()
                .orElse(0);

        List<Expert> aaa=experts.stream().filter(c -> c.getPriority()==aa)
                .collect(Collectors.toList());

        System.out.println(aaa);


        experts.sort((o1, o2) -> Math.toIntExact(o2.getPriority() - o1.getPriority()));

        List<Expert> list1 = experts.stream()
                .filter(expert -> expert.equals(experts.get(0)))
                .toList();

//        Optional<Expert> max = experts.stream()
//                .max((o1, o2) -> Math.toIntExact(o2.getPriority() - o1.getPriority()));

        if (list1.size() < experts.size()) {
            List<Expert> expert = experts.stream()
                    .filter(expert1 -> expert1.getPriority() < list1.get(0).getPriority())
                    .toList();
            System.out.println(expert);

        } else {
            System.out.println(list1);
        }

    }

    @Test
    public void test2() {
        LongStream longStream = LongStream.of(3L, 3L, 2L, 2L, 1L);

        longStream.reduce(Long::sum)
                .ifPresent(System.out::println);

        List<Expert> experts = new ArrayList<>(List.of(
                new Expert(3L),
                new Expert(3L),
                new Expert(3L),
                new Expert(2L),
                new Expert(1L),
                new Expert(1L)
        ));

        long longPriority = experts.stream()
                .mapToLong(expert -> expert.getPriority())
                .sum();
        System.out.println(longPriority);
    }

    @Test
    public void test3() {
        Date date1 = new Date(2024, 4, 2);
        LocalDate creationDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period between = Period.between(LocalDate.now(), creationDate);
        System.out.println(between.getDays());
        if (between.getDays() > 30) {
            throw new RuntimeException("ارور");
        } else {
            System.out.println("ok");
        }
    }


    @Test
    public void test4() {
        String a = "aa";
        String b = "bb";
        System.out.println(a + b);
    }


    @Test
    public void test5() {
        List<StudentSort> students = new ArrayList<>(List.of(
                new StudentSort(5, "za")
                , new StudentSort(1, "zb")
                , new StudentSort(1, "ab")
                , new StudentSort(1, "mb")
                , new StudentSort(1, "tb")
                , new StudentSort(1, "bb")
                , new StudentSort(3, "cc")
        ));

        Comparator<StudentSort> studentComparator = Comparator.comparing(StudentSort::getId)
                .thenComparing(StudentSort::getName);

        students.sort(studentComparator);
        System.out.println(students);
    }

    @Test
    public void test6() {
        String string = " HellO";
        String string1 =
                string.chars().mapToObj(str -> (char) str)
                        .map(str -> Character.isLowerCase(str) ? Character.toUpperCase(str) : Character.toLowerCase(str))
                        .map(Object::toString)
                        .collect(Collectors.joining());
        System.out.println(string1);
    }

    @Test
    public void setAlarm() {
        Boolean employed = Boolean.TRUE;
        Boolean vacation = Boolean.FALSE;
        if (Boolean.TRUE.equals(employed) && Boolean.FALSE.equals(vacation)) {
            System.out.println(Boolean.TRUE);
        }
        System.out.println(Boolean.FALSE);
    }

    @Test
    public void test7(){
        int number = -3;
        int length = String.valueOf(number < 0 ? number * -1 : number).length();
        int p = (int)Math.pow(5, length);
        System.out.println(number * p);

    }


    @Test
    public void test8(){
        int[] array = {-4 , 20 , 4};
        int[] array1 = IntStream.range(1, array.length)
                .filter(i -> array[i] % i == 0)
                .map(i -> array[i])
                .toArray();
        System.out.println(Arrays.toString(array1));
    }







}


