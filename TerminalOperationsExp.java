import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationsExp {
    public static void main(String[] args) {

        //forEach Consumer Functional Interface
        List<Integer> numbers = Arrays.asList(5,3,1,23,432);
        numbers.stream()
                .filter(((Integer val) -> val >= 3))
                .forEach((Integer val)-> System.out.print(val +", ") ); //8, 3, 23, 432

        //toArray()
        Integer[] arr = numbers.stream()
                .filter((Integer val) -> val >=3)
                .toArray((int size)-> new Integer[size]);

        System.out.println(Arrays.toString(arr)); // [8, 3, 23, 432]

        //reduce -> perform associative aggregation function of stream of elements in it
        Optional<Integer> reducedVal = numbers.stream()
                .reduce((Integer a,Integer b) -> a + b);

        System.out.println(reducedVal.get()); //467

        //Collect -> used to collect element of stream
        List<Integer> filterNumbers = numbers.stream()
                .collect(Collectors.toList());

        filterNumbers.forEach((Integer val) -> System.out.print(val+", ")); //8, 3, 1, 23, 432

        System.out.println();

        //min & Max -> returns the minimum or maximum element from the stream based on comparator provided

        Optional<Integer> minValue = numbers.stream()
                .filter((Integer val) -> val > 1)
                .min((Integer a, Integer b) -> a-b);
        System.out.println(minValue.get());//3

        Optional<Integer> minValue2  = numbers.stream()
                .filter((Integer val) -> val > 1)
                .min((Integer a, Integer b) -> b-a);
        System.out.println(minValue2.get());//432

        Optional<Integer> maxValue1 = numbers.stream()
                .filter((Integer val) -> val > 1)
                .min((Integer a, Integer b) -> b-a);
        System.out.println(maxValue1.get()); //432

        Optional<Integer> maxValue2 = numbers.stream()
                .filter((Integer val) -> val > 1)
                .min((Integer a, Integer b) -> a-b);
        System.out.println(maxValue2.get()); //3

        //Count     -> returns no of elements present in stream

        long noOfEle = numbers.stream()
                .filter((Integer val) ->val > 1)
                .count();
        System.out.println(noOfEle);


        //AnyMatch -> return boolean value if any value in stream matches the given predicate value
        boolean hasAnyMatch = numbers.stream()
                .anyMatch((Integer val) -> val % 2 == 0);
        System.out.println(hasAnyMatch);// true

        //AllMatch -> returns boolean value true,if all values present in stream match with the given predicate value
        boolean allMatch = numbers.stream()
                .allMatch((Integer val) -> val % 2 == 0);
        System.out.println(allMatch);// false

        //None Match -> return boolean value true, if all the values present in streams doesn't match with predicate value
        boolean noneMatch = numbers.stream()
                .noneMatch((Integer val) -> val % 2 == 0);
        System.out.println(noneMatch); // false

        //findFirst
        Optional<Integer> firstVal = numbers.stream()
                .filter((Integer val) -> val % 2 ==0)
                .findFirst();
        System.out.println(firstVal.get());

        //findAny
        Optional<Integer> findAny = numbers.stream()
                .filter((Integer val) -> val % 2 ==0)
                .findAny();
        System.out.println(firstVal.get());





    }
}
