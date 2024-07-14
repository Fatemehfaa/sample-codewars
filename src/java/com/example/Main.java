package java.com.example;

import comprator.SortByCode;
import comprator.Student;

import java.util.ArrayList;
    import java.util.Arrays;
import java.util.Collections;
import java.util.List;
    import java.util.stream.Collectors;
    import java.util.stream.IntStream;


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


    //Combine strings function
    //combineNames('James', 'Stevens')
    //returns:
    //'James Stevens'
    public String comineString(String a ,String b){
        return a + b;

    }


    //Create a function that takes an integer as an argument and returns "Even" for even numbers or "Odd" for odd numbers.
    public String evenOrOdd(int number){
        if (number % 2 == 0){
            return "even";
        }
        return "odd";
    }


    //Implement a function which convert the given boolean value into its string representation.
    public String convertToString(Boolean value){
       if (Boolean.TRUE.equals(value)){
           return "true";
       }
       return "false";
    }


    //Write a function named setAlarm/set_alarm/set-alarm/setalarm (depending on language) which receives two parameters. The first parameter, employed, is true whenever you are employed and the second parameter, vacation is true whenever you are on vacation.
    //The function should return true if you are employed and not on vacation (because these are the circumstances under which you need to set an alarm). It should return false otherwise. Examples:
    //true     | true     => false
    //true     | false    => true
    //false    | true     => false
    //false    | false    => false
    public static boolean setAlarm(Boolean employed , Boolean vacation){
        return employed && !vacation;
    }


    //When provided with a letter, return its position in the alphabet.
    //Input :: "a"
    //Ouput :: "Position of alphabet: 1"
    public static String positionAlphabet(Character letter){
        char lowerCase = Character.toLowerCase(letter);
        int position =  lowerCase  - 'a' + 1;
        return "Position of alphabet: 1" + position ;
    }


    //Jack really likes his number five: the trick here is that you have to multiply each number by 5 raised to the number of digits of each numbers, so, for example:
    //  3 -->    15  (  3 * 5¹)
    public static int multiply(Integer number){
        int length = String.valueOf(Math.abs(number)).length();
        int p = (int)Math.pow(5, length);
        return number * p;
    }


    //Return a new array consisting of elements which are multiple of their own index in input array (length > 1).
    public static int[] consisting(int[] array){
        List <Integer> result = new ArrayList<>();
        for (int i=1; i<array.length ; i++){
            if (array[i] % i ==0 ){
                result.add(array[i]);
            }
        }
        return result.stream().mapToInt(r -> r).toArray();
    }


    public static int[] consist(int[] array){
    return IntStream.range(1, array.length)
                .filter(i-> array[i] % i ==0 )
                .map(i -> array[i])
                .toArray();
        }



    //Write a function that merges two sorted arrays into a single one. The arrays only contain integers. Also, the final outcome must be sorted and not have any duplicate.
    public static int[] mergeArray(int[] first , int[] second){
       List<int[]> numbers = List.of(first , second);
        //Stream.of(first,second)
      return numbers.stream()
                .flatMapToInt(Arrays::stream)
                .distinct()
                .sorted()
                .toArray();
    }



    //Complete the function which returns the weekday according to the input number:
    //1 returns "Sunday"
    //2 returns "Monday"
    //3 returns "Tuesday"
    //4 returns "Wednesday"
    //5 returns "Thursday"
    //6 returns "Friday"
    //7 returns "Saturday"
    //Otherwise returns "Wrong, please enter a number between 1 and 7"
    public static String giveWeekday(int number){
        return switch (number) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "Wrong, please enter a number between 1 and 7";
        };

    }



    //Given an array of 4 integers
    //[a,b,c,d] representing two points (a, b) and (c, d), return a string representation of the slope of the line joining these two points.
    //For an undefined slope (division by 0), return undefined . Note that the "undefined" is case-sensitive.
    // a:x1
    //   b:y1
    //   c:x2
    //   d:y2
    public static String Slope(int[] numbers){
        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];
        int d = numbers[3];

        if (c - a ==0){
            return "undefined";
        }
        int numerator = d - b;
        int denominator = c - a;

        int slope = numerator / denominator;

        return String.valueOf(slope);

    }



    //Let's play! You have to return which player won! In case of a draw return Draw!.
    //"scissors", "paper" --> "Player 1 won!"
    //"scissors", "rock" --> "Player 2 won!"
    //"paper", "paper" --> "Draw!"
    public static String game(String p1 , String p2){

        if(p1.equals("scissors") && p2.equals("paper")){
            return "Player 1 won!";
        }
        if(p1.equals("rock") && p2.equals("scissors")){
            return "Player 1 won!";
        }
        if(p1.equals("paper") && p2.equals("rock")){
            return "Player 1 won!";
        }
        if(p1.equals("scissors") && p2.equals("rock")){
            return "Player 2 won!";
        }
        if(p1.equals("rock") && p2.equals("paper")){
            return "Player 2 won!";
        }
        if(p1.equals("paper") && p2.equals("scissors")){
            return "Player 2 won!";

        }
        if (p1.equals("paper") && p2.equals("paper")) {
            return "Draw!";
        }
        if (p1.equals("scissors") && p2.equals("scissors")) {
            return "Draw!";
        }
        if (p1.equals("rock") && p2.equals("rock")) {
            return "Draw!";
        }

        return null;
    }



    //Given a string str, reverse it and omit all non-alphabetic characters.
    //For str = "krishan", the output should be "nahsirk".
    //For str = "ultr53o?n", the output should be "nortlu".
    //Input/Output
    //[input] string str
    //A string consists of lowercase latin letters, digits and symbols.
    //[output] a string
    public static String reverse(String str){
        StringBuilder builder = new StringBuilder();
        char[] charArray = str.toCharArray();
        for(char c : charArray){
            if (Character.isLetter(c)) {
                builder.append(c);
            }
        }
        return builder.reverse().toString();
    }



    //In this kata you will create a function that takes a list of non-negative integers and strings and returns a new list with the strings filtered out.
    //Kata.filterList(List.of(1, 2, "a", "b")) => List.of(1,2)
    //Kata.filterList(List.of(1, "a", "b", 0, 15)) => List.of(1,0,15)
    //Kata.filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123)) => List.of(1, 2, 123)
    public static List<Object> filterList(List<Object> list){
       return list.stream()
                .filter(item -> item instanceof Integer )
                .map(item -> (Integer)item)
                .collect(Collectors.toList());
    }



    //Complete the function so that it finds the average of the three scores passed to it and returns the letter value associated with that grade.
    //|  Numerical Score   | Letter Grade |
    //| 90 <= score <= 100 |     'A'      |
    //|  80 <= score < 90  |     'B'      |
    //|  70 <= score < 80  |     'C'      |
    //|  60 <= score < 70  |     'D'      |
    //|  0 <= score < 60   |     'F'      |
    public static char getGrade(int s1 , int s2 , int s3){
       int average = ( s1 + s2 + s3)/3 ;
       if (average >= 90 && average <= 100){
           return 'A';
       } else if (average >= 80 && average < 90) {
           return 'B';
       } else if (average >= 70 && average < 80) {
           return 'C';
       } else if (average >= 60 && average < 70) {
           return 'D';
       } else {
           return 'F';
       }


    }



    //To find the mean (average) of a set of numbers add all of the numbers together and divide by the number of values in the list.
    //For an example list of 1, 3, 5, 7
    //1. Add all of the numbers
    //1+3+5+7 = 16
    //2. Divide by the number of values in the list. In this example there are 4 numbers in the list.
    //16/4 = 4
    public static int findAverage(int[] numbers){
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum/numbers.length;
    }
    //return (int)Arrays.stream(nums).average().orElse(0);



    //Your task is to write function factorial.
    public static long factorial(int num){
        if(num == 0){
            return 1;
        }
        long result = 1;
        for(int i = 1 ; i <= num ; i++){
            result *= i;
        }
        return result;
    }



    //Determine the total number of digits in the integer (n>=0) given as input to the function. For example, 9 is a single digit, 66 has 2 digits and 128685 has 6 digits. Be careful to avoid overflows/underflows.
    public static int digits(Long n){
       return Long.toString(n).length();
    }



    //Happy Holidays fellow Code Warriors!
    //Santa's senior gift organizer Elf developed a way to represent up to 26 gifts by assigning a unique alphabetical character to each gift. After each gift was assigned a character, the gift organizer Elf then joined the characters to form the gift ordering code.
    //Santa asked his organizer to order the characters in alphabetical order, but the Elf fell asleep from consuming too much hot chocolate and candy canes! Can you help him out?
    //Sort the Gift Code
    //Write a function called sortGiftCode/sort_gift_code/SortGiftCode that accepts a string containing up to 26 unique alphabetical characters, and returns a string containing the same characters in alphabetical order.
    //Examples (Input -- => Output):
    //"abcdef"                      -- => "abcdef"
    //"pqksuvy"                     -- => "kpqsuvy"
    //"zyxwvutsrqponmlkjihgfedcba"  -- => "abcdefghijklmnopqrstuvwxyz"
    public static String sortGift(String code){
        char[] charArray = code.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }


    /**
     * this function sum two number and divide 2 .
     *
     * @param a   a is number one .
     * @param b   b is number two .
     * @return    its return number of calculate of two number
     */
    public static int calculate(int a , int b){
        return (a + b)/2;

    }



    //Find the sum of all multiples of n below m
    //n and m are natural numbers (positive integers)
    //m is excluded from the multiples
    //Kata.sumMul(2, 9)   ==> 2 + 4 + 6 + 8 = 20
    //Kata.sumMul(4, 123) ==> 4 + 8 + 12 + ... = 1860
    //Kata.sumMul(4, -7)  // throws IllegalArgumentException
    public static long sumMul(int n , int m){
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException();
        }
        int k = (m - 1) / n;
        return n * k * (k + 1) / 2;
    }



    //Write a method that takes one argument as name and then greets that name, capitalized and ends with an exclamation point.
    //"riley" --> "Hello Riley!"
    public static String greets(String name) {
        char[] charArray = name.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            charArray[i] = Character.toLowerCase(charArray[i]);
        }
        return "Hello " + String.valueOf(charArray) + "!";
    }
    // return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();


    //Find the total sum of internal angles (in degrees) in an n-sided simple polygon. N will be greater than 2.
    public static int sumOfAngel(int n) {
        return (n - 2) * 180;
    }



    //Simple, given a string of words, return the length of the shortest word(s).
    //String will never be empty and you do not need to account for different data types.
    public static int findShort(String string){
        return Arrays.stream(string.split(" ")).mapToInt(String::length).min().orElse(0);
    }



    //Given a string made up of letters a, b, and/or c, switch the position of letters a and b (change a to b and vice versa). Leave any incidence of c untouched.
    public static String switchLetter(String letter){
        return letter.replace("a", "x").replace("b", "a").replace("x", "b");
    }












































}


































