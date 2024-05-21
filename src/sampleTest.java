import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
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
    public void test2(){
        LongStream longStream = LongStream.of(3L , 3L , 2L ,2L ,1L);

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
    public void test3(){
        Date date1 = new Date(2024,4,2);
        LocalDate creationDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period between = Period.between( LocalDate.now() , creationDate);
        System.out.println(between.getDays());
        if (between.getDays() > 30){
            throw new RuntimeException("ارور");
        }else {
            System.out.println("ok");
        }
    }

}


