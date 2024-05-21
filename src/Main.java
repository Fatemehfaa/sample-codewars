import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {


    }


    // Convert a Number to a String!
    //123  --> "123"
    public static String changeToString(int number) {
        return Integer.toString(number);
        // or return "" + number;
    }




//    write me a function stringy that takes a size and returns a string of alternating 1s and 0s.
//    the string should start with a 1.
//    a string with size 6 should return :'101010'.
//    with size 4 should return : '1010'.
//    with size 12 should return : '101010101010'.
//    The size will always be positive and will only use whole numbers.
    public static String stringy(int size){
        return IntStream.rangeClosed(1 , size)
                .map(i->i %2)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
    }



    //It's pretty straightforward. Your goal is to create a function that removes the first and last characters of a string. You're given one parameter, the original string. You don't have to worry about strings with less than two characters.
    //assertEquals("loquen", RemoveChars.remove("eloquent"));
    public static String remove(String string){
        String result = "";
        for (int i=1 ; i<string.length() - 1 ; i++){
            result +=string.charAt(i);
        }
        return result;
    }
//   or return string.substring(1 , string.length() - 1);




    //Given a string of digits, you should replace any digit below 5 with '0' and any digit 5 and above with '1'. Return the resulting string.
    public static String fakeBin(String numberToString){
                String res = "";
                for (int i = 0; i < numberToString.length(); i++) {
                    if (numberToString.charAt(i) < '5') {
                        res += '0';
                    } else {
                        res += '1';
                    }
                }
                return res;
            }
        //or return numberToString.replaceAll("[0-4]", "0").replaceAll("[5-9]", "1");




    //Create a function called shortcut to remove the lowercase vowels (a, e, i, o, u ) in a given string.
    //"hello"     -->  "hll"
    public static String removeVowels(String string){
        String[] vowels = {"a", "e", "i", "o", "u"};
        for(String s : vowels){
            if (string.contains(s)) {
               string = string.replace(s, "");
            }
        }
        return string;
    }
        // or return string.replaceAll("[aeiou]" ,"");



    //You get an array of numbers, return the sum of all of the positives ones.
    //
    //Example [1,-4,7,12] => 1 + 7 + 12 = 20
    public static int sum(int[] numbers) {
        int sum = 0;
        for (int i : numbers) {
            if (i > 0) {
                sum += i;
            }
        }
        return sum;
    }
    //or return Arrays.stream(numbers).filter(v -> v > 0).sum();


    //Return an array, where the first element is the count of positives numbers and the second element is sum of negative numbers. 0 is neither positive nor negative.
    //If the input is an empty array or is null, return an empty array.
    //For input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15], you should return [10, -65].
    public static int[] countPositivesSumNegatives(int[] input)
    {
        if (input == null || input.length == 0) return new int[] {};
        int count = 0,sum = 0;
        for (int i : input) {
            if (i > 0) count ++;
            if (i < 0) sum += i;
        }
        return new int[] {count,sum};
    }



    //Your function takes two arguments:
    //current father's age (years)
    //current age of his son (years)
    //Сalculate how many years ago the father was twice as old as his son (or in how many years he will be twice as old). The answer is always greater or equal to 0, no matter if it was in the past or it is in the future.
    public static int age(int fatherAge , int sonAge){
        return Math.abs((sonAge* 2)-fatherAge);
    }



    //Write a function which calculates the average of the numbers in a given list.
    //Note: Empty arrays should return 0.
    public static double average(int[] num){
        int sum = 0;
        for(int i:num){
            sum += i;
        }
        return sum/num.length;
    }
    //return Arrays.stream(num).average().orElse(0);




    //In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
    //highAndLow("1 2 3 4 5")  // return "5 1"
    //highAndLow("1 2 -3 4 5") // return "5 -3"
    public static String highAndLow(String number) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (String s : number.split(" ")) {
            int i = Integer.parseInt(s);
            if (min > i) {
                min = i;
            }
            if (max < i) {
                max = i;
            }
        }
        return max + " " + min;
    }
    //or  var stats = stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
    //    return stats.getMax() + " " + stats.getMin();
    //  }



    //Given an array of ones and zeroes, convert the equivalent binary value to an integer.
    //Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
    //Testing: [0, 0, 0, 1] ==> 1
    //Testing: [0, 0, 1, 0] ==> 2
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        return binary.stream().reduce((x, y) -> x * 2 + y).get();
    }


    //Write function RemoveExclamationMarks which removes all exclamation marks from a given string.
    public static String removeExclamation(String str){
        return str.replaceAll("!" , "");
    }




    //Write a method, that will get an integer array as parameter and will process every number from this array.
    //Return a new array with processing every number of the input-array like this:
    //If the number has an integer square root, take this, otherwise square the number.
    //Example
    //[4,3,9,7,2,1] -> [2,9,3,49,4,1]
    public static int[] squareOrSquareRoot(int[] array)
    {
        return Arrays.stream(array)
                .map(i -> Math.sqrt(i) % 1 == 0 ? ((int) Math.sqrt(i)) : (i * i))
                .toArray();
    }



    //Build a function that returns an array of integers from n to 1 where n>0.
    //Example : n=5 --> [5,4,3,2,1]
    public static int[] reverse(int num){
        int[] result = new int[num];
        for (int i=0 ; i<num ; i++){
             result[i] = num - 1;
        }
        return result;
    }
    //or return IntStream.range(-num, 0).map(Math::abs).toArray();




    //Create a function that accepts a string and a single character, and returns an integer of the count of occurrences the 2nd argument is found in the first one.
    //If no occurrences can be found, a count of 0 should be returned.
    //("Hello", "o")  ==>  1
    //("", "z")       ==>  0
    //str_count("Hello", 'o'); // returns 1
    //str_count("", 'z'); // returns 0
    public static int strCount(String string , char letter){
        int count = 0;
        for (char c : string.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return count;
    }
    //or return (int) string.chars().filter(s -> s==letter).count();



    //             1
    //          3     5
    //       7     9    11
    //   13    15    17    19
    //21    23    25    27    29
    //Calculate the sum of the numbers in the nth row of this triangle (starting at index 1) e.g.: (Input --> Output)
    //1 -->  1
    //2 --> 3 + 5 = 8
    private static int sumNum(int n){
        return n * n * n ;
    }



    //In this kata you need to check the provided array (x) for good ideas 'good' and bad ideas 'bad'. If there are one or two good ideas, return 'Publish!', if there are more than 2 return 'I smell a series!'.
    // If there are no good ideas, as is often the case, return 'Fail!'.
    public static String well(String[] x) {
        int count = 0;
        for (String s : x) {
            if (s.equals("good")) {
                count++;
            }
        }
        if (count == 0) {
            return "Fail!";
        }
        if (count == 2 || count == 1) {
            return "Publish!";
        } else {
            return "I smell a series!";

        }
    }



    //'world'  =>  'dlrow'
    //'word'   =>  'drow'
    public static String reversStr(String string){
        String result = "";
        for (int i= string.length()-1; i>=0 ; i--){
            result += string.charAt(i);
        }
        return result;
    }
    //or return new StringBuilder(string).reverse().toString();




    //dna
    //"ATTGC" --> "TAACG"
    //"GTAT" --> "CATA"
    public static String dna(String dna){
        return dna.replace("C", "D")
                .replace("T", "A")
                .replace("G", "C")
                .replace("B", "T")
                .replace("D", "G");
    }



    //Given an array of integers your solution should find the smallest integer.
    //Given [34, 15, 88, 2] your solution will return 2
    //Given [34, -345, -1, 100] your solution will return -345
    public static int smallest(int[] num){
        return Arrays.stream(num).min().getAsInt();
    }



    //Your classmates asked you to copy some paperwork for them. You know that there are 'n' classmates and the paperwork has 'm' pages.
    //Your task is to calculate how many blank pages do you need. If n < 0 or m < 0 return 0.
    //n= 5, m=5: 25
    //n=-5, m=5:  0
    public static int calculateBlankPages(int a , int b){
        if (a < 0 || b < 0) {
            return 0;
        }
     return a*b ;
    }



    //Create a function that gives a personalized greeting. This function takes two parameters: name and owner.
    //Use conditionals to return the proper message:
    public static String greet(String name, String owner){
        if (name.equals(owner))
            return "The text";
        return "guest";
    }


    //You will be given an array a and a value x. All you need to do is check whether the provided array contains the value.
    //Array can contain numbers or strings. X can be either.
    //Return true if the array contains the value, false if not.
    public static boolean check(Object[] a, Object b) {
        for (Object o : a)
            if (o.equals(b)) {
                return true;
            }
        return false;
    }
    //or return Arrays.asList(a).contains(b);


    //The first century spans from the year 1 up to and including the year 100, the second century - from the year 101 up to and including the year 200, etc.
    //Given a year, return the century it is in.
    //1705 --> 18
    //1900 --> 19
    //1601 --> 17
    public static int century(int year){
        return (year+ 99) / 100;
    }

    //Create a function that accepts a list/array and a number n, and returns a list/array of the first n elements from the list/array.
    public int[] getArray (int[] array , int a){
        return Arrays.stream(array)
                .limit(a).toArray();
    }



    //You are given the length and width of a 4-sided polygon. The polygon can either be a rectangle or a square.
    //If it is a square, return its area. If it is a rectangle, return its perimeter.
    //6, 10 --> 32
    //3, 3 --> 9
    public static int getArea(int length, int width){
        if (length == width){
            return length * width;
        }
        return (length + width ) *2;
    }
















}




































