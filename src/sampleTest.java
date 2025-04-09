import org.junit.Test;

import com.example.sample.Expert;
import com.example.sample.StudentSort;

import java.lang.reflect.Array;
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


        Long aa = experts.stream().mapToLong(Expert::getPriority)
                .min()
                .orElse(0);

        List<Expert> aaa = experts.stream().filter(c -> c.getPriority() == aa)
                .collect(Collectors.toList());

        System.out.println(aaa);


        experts.sort((o1, o2) -> Math.toIntExact(o2.getPriority() - o1.getPriority()));

        List<Expert> list1 = experts.stream()
                .filter(expert -> expert.equals(experts.get(0)))
                .toList();

//        Optional<java.com.example.Expert> max = experts.stream()
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
    public void test7() {
        int number = -3;
        int length = String.valueOf(number < 0 ? number * -1 : number).length();
        int p = (int) Math.pow(5, length);
        System.out.println(number * p);

    }


    @Test
    public void test8() {
        int[] array = {-4, 20, 4};
        int[] array1 = IntStream.range(1, array.length)
                .filter(i -> array[i] % i == 0)
                .map(i -> array[i])
                .toArray();
        System.out.println(Arrays.toString(array1));
    }


    @Test
    public void test9() {
        ArrayList<Object> list = new ArrayList<>(
                List.of(1, 2, "a", "b"));
        List<Integer> list1 = list.stream()
                .filter(item -> item instanceof Integer)
                .map(item -> (Integer) item)
                .toList();
        System.out.println(list1);
    }


    @Test
    public void test10() {
        int num = 4;
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        System.out.println(result);
    }


    @Test
    public void test11() {
        String code = "jhgaryua";
        char[] charArray = code.toCharArray();
        Arrays.sort(charArray);
        System.out.println(charArray);
    }


    @Test
    public void test12() {
        int n = 2;
        int m = 12;
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException();
        }
        int k = (m - 1) / n;
        System.out.println(n * k * (k + 1) / 2);
    }


    @Test
    public void test13() {
        String name = "rilley";
        char[] charArray = name.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            charArray[i] = Character.toLowerCase(charArray[i]);
        }
        System.out.println(String.valueOf(charArray));
    }


    @Test
    public void test14() {
        String a = "hello";
        int length = a.toCharArray().length;
        System.out.println(length);
    }


    @Test
    public void Test15() {
        String string = "jhfh huh ujjjjjjj";
        String[] split = string.split("\s");
        int min = Integer.MAX_VALUE;
        for (String s : split) {
            if (string.length() < min) {
                min = s.length();
            }
        }
        System.out.println(min);
    }

    @Test
    public void test16() {
        int a = 5;
        int b = 10;
        int[] result = new int[b - a + 1];
        for (int i = a; i < b; i++) {
            result[i - a] = i;
        }
        System.out.println(Arrays.toString(result));
    }


    @Test
    public void repeatedString() {
        String string = "sTring 12";
        StringBuilder result = new StringBuilder();

        for (char c : string.toCharArray()) {
            result.append(c).append(c);
        }
        System.out.println(result.toString());
    }


    @Test
    public void test17() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("hello");
        buffer.append("world");
        System.out.println(buffer.toString());
    }


    @Test
    public void test18() {
        StringBuilder builder = new StringBuilder();
        builder.append("hello");
        builder.append("world");
        System.out.println(builder.toString());
    }


    @Test
    public void test19() {
        String string = new String();
        string = "hello";
        string = "world";
        System.out.println(string);

    }


    @Test
    public void billboard() {
        String name = "ass";
        int price = 10;
        System.out.println(name.repeat(price).length());

    }


    @Test
    public void isIsogram() {
        String string = "sttring";
        string = string.toLowerCase();
        HashSet<Character> hashSet = new HashSet<>();
        for (Character c : string.toCharArray()) {
            if (hashSet.contains(c)) {
                System.out.println(false);
            }
            hashSet.add(c);
        }
        System.out.println(true);
    }


    @Test
    public void sumOfDifferences() {
        int[] arr = {10, 4, 1, 4};
        if (arr.length <= 1) {
            System.out.println(0);
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            sum += arr[i] - arr[i - 1];
        }
        System.out.println(sum);

    }


    @Test
    public void sayHello() {
        String[] arr = new String[]{"fa", "fn"};
        System.out.println(String.join(" ", arr));

    }

    @Test
    public void recursion() {
        int result = sum(10);
        System.out.println(result);
    }

    public static int sum(int k) {
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }


    @Test
    public void printf(){
        // Default
        System.out.printf("%f%n", 123456.78);

        // Two decimal digits
        System.out.printf("%.2f%n", 123456.78);

        // No decimal digits
        System.out.printf("%.0f%n", 123456.78);

        // No decimal digits but keep the decimal point
        System.out.printf("%#.0f%n", 123456.78);

        // Group digits
        System.out.printf("%,.2f%n", 123456.78);

        // Scientific notation with two digits of precision
        System.out.printf("%.2e", 123456.78);
    }


    @Test
    public void amalgar(){
        int a = -16, b = 1;
        System.out.println(a >> b);
        a = -17;
        b = 1;
        System.out.println(a >>> b);
    }






}


