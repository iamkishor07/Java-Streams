# Java - Streams

Stream API – one of the new feature introduced in Java 1.8 version along with Functional Interface and Lambda expression


we have to look at shortcomings of earlier versions till Java 1.7

# **Collection framework** :-

    #To represent/store group of objects/elements into single entity into some underlying data structure 
    then we should obviously go for Collection framework like List or Set

    #To process these group of objects/elements like sorting, filtering based on some condition, 
    mapping based on some operation then we have to explicitly write number of lines of code

# **Arrays** :-
    Arrays helps to represent/store fixed size of objects/elements of same data-type which doesn’t 
    either grow nor shrinks unlike Collection
    Again, to process Arrays for filtering, sorting, counting, iterating, finding, etc.
    we have to explicitly write number of lines of code

**Collection and Arrays stores objects/elements but their processing like sorting, filtering, counting, iterating, etc. 
isn’t feasible directly and we have to write many lines of code to achieve this manually.**

## But Stream API introduced in Java 1.8 version comes to rescue to process objects/elements stored in Collection/Arrays in a elegant way.

#Stream can be defined as sequence of elements supporting aggregate operations

    In other words, Stream are sequence of elements from source like Collection/Arrays for data processing like filtering, sorting, counting, finding, iterating, etc.
    These data processing can be operated/executed in sequential or parallel mode
    Stream support ordering in compliant with source provided like for example if the source is ArrayList which maintains insertion order
    so Stream preserves this order even after processing
# Note: Stream aren’t Collection, Stream only does processing on Collection

 # (Features or characteristics of Stream API :)
    Data-Structure :- Stream neither is a data-structure nor it stores data, only thing it does is data processing based on the operation specified
    Consumes source :- For Stream to process data, it needs source and it could be either Collection or Arrays or 
                    any I/O resources or Stream generator function
    Processing :- In short, Stream consume data-sources and performs some operations on it and finally produces 
                desired results but never modifies original data-sources i.e.; it is untouched
    Operations :- Stream operation divided into intermediate and terminal operations
    Intermediate operation :- It returns Stream itself, so we can chain multiple operations and final output of these 
                        operations are Stream only for example filter(Predicate), map(Function), sorted(Comparator), etc.
    Laziness :- Stream intermediate operations are lazy and computation on the source-data is only performed 
                when the terminal operation is initiated,and source elements are consumed only as needed
    Terminal operation :- It returns final output other than Stream for example count(), forEach(), collect(), min(), max(), etc. 
                        After initiating terminal operation,Stream are no longer available and it is said to be consumed
    Stream pipeline :- A pipeline in Stream API composed of 3 things namely source, zero or more intermediate operations and terminal operation
    Stream Parallelism :- Operation can be executed sequentially in single thread or parallel in multiple threads taking leverage of multi-core processor

# Stream API examples :
**Stream example to get EVEN number from List of Integer**
            
            package net.bench.resources.stream.example;
            import java.util.Arrays;
            import java.util.List;
            import java.util.stream.Collectors;

            public class StreamFilterEvenNumbers {
            
                public static void main(String[] args) {
             
                    System.out.println("Java 8 Stream example to filter only even number : \n");
             
                    // List of Integer - source
                    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
             
                    // Stream filter to get only EVEN numbers
                    List<Integer> filterEvenNumbers = numbers // original source
                            .stream() // 1. get stream from source
                            .filter(i -> i%2 == 0) // 2. intermediate operation to get even numbers
                            .collect(Collectors.toList()); // 3. terminal operation to produce result
             
                    // print to console using Java 8 forEach
                    filterEvenNumbers.forEach(i -> System.out.println(i));
                }
            }
    Output:
            Java 8 Stream example to filter only even number :
            2
            4
            6
            8

# Stream example to get String with length greater than 5 from List of Strings

        package net.bench.resources.stream.example;
        import java.util.ArrayList;
        import java.util.List;
        
        public class StreamFilterNames {
        
            public static void main(String[] args) {
         
                System.out.println("Java 8 Stream example to filter"
                        + " names having more than 5 characters : \n");
         
                // List of String - source
                List<String> names = new ArrayList<>();
         
                // add few names to String list using add() method
                names.add("Sachin");
                names.add("Warne");
                names.add("Pietersen");
                names.add("McCullum");
                names.add("Jonty");
                names.add("Richards");
                names.add("Ranatunga");
         
                // Stream filter to get names whose length is greater than 5 and also print to console
         
                names // original source
                .stream() // 1. get stream from source
                .filter(s -> s.length() > 5) // 2. intermediate operation to get names with length>5
                .forEach(name -> System.out.println(name)); // 3. terminal operation to print
            }
        }
        Output:
            Java 8 Stream example to filter names having more than 5 characters :
            Sachin
            Pietersen
            McCullum
            Richards
            Ranatunga
# Stream example to map each number to its square value from List of Integer

        package net.bench.resources.stream.example;
        import java.util.Arrays;
        import java.util.List;
        import java.util.stream.Collectors;
        
        public class StreamMapSquareExample {
        
            public static void main(String[] args) {
         
                System.out.println("Java 8 Stream example to Square each numbers : \n");
         
                // List of Integer - source
                List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
         
                // Stream map example to Square each number
                List<Integer> square = numbers // original source
                        .stream() // 1. get stream from source
                        .map(i -> i*i) // 2. intermediate operation to Square each numbers
                        .collect(Collectors.toList()); // 3. terminal operation to collect result
         
                // print to console using Java 8 forEach
                square.forEach(i -> System.out.println(i));
            }
        }
        Output:
            Java 8 Stream example to Square each numbers :
            1
            4
            9
            16
            25
            36
            49
            64
            81
# Stream example – combination of filter() and map() methods

        package net.bench.resources.stream.example;
        import java.util.ArrayList;
        import java.util.List;
        
        public class StreamFilterMapExample {
        
            public static void main(String[] args) {
         
                System.out.println("To Upper Case names having length more than 5 : \n");
         
                // List of String - source
                List<String> names = new ArrayList<>();
         
                // add few names to String list using add() method
                names.add("Sachin");
                names.add("Warne");
                names.add("Pietersen");
                names.add("McCullum");
                names.add("Jonty");
                names.add("Richards");
                names.add("Ranatunga");
         
                // Stream filter to get names whose length is greater than 5 and 
                // and map to upper case for each of the filtered names and 
                // also print to console
         
                names // original source
                .stream() // 1. get stream from source
                .filter(s -> s.length() > 5) // 2.1 intermediate operation to get names with length>5
                .map(s -> s.toUpperCase()) //    2.2 intermediate operation to convert to UpperCase
                .forEach(name -> System.out.println(name)); // 3. terminal operation to print
            }
        }
        Output:
            ToUpperCase names having length more than 5 :
            
            SACHIN
            PIETERSEN
            MCCULLUM
            RICHARDS
            RANATUNGA

As we have seen in earlier section that, operation are divided into Intermediate and Terminal operation. 
There are wide range of useful Stream API (function/method) available. We will categorize them below,

    Intermediate operation :
            distinct()
            filter()
            map()
            flatMap()
            limit()
            skip()
            peek()
            sorted()
            concat()
            empty()
            generate()
            iterate()
            of()
    
    Terminal operation :
            allMatch()
            anyMatch()
            noneMatch()
            collect()
            count()
            findAny()
            findFirst()
            forEach()
            forEachOrdered()
            min()
            max()
            reduce()

