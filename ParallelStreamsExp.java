import java.util.Arrays;
import java.util.List;

public class ParallelStreamsExp {
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(11,22,33,44,55,66,77,88,99,100,45,5,46,35,3,3,2,3,1,45,6,57,8,90,12,35,68,2,34,68);

        //Sequential Streams
        long sequentialProcessingTime = System.currentTimeMillis();
        numbers.stream()
                .map((Integer val) -> val * val)
                .forEach((Integer val) -> System.out.println(val));
        System.out.println("sequentialStreamProcessingTime: " + ( System.currentTimeMillis() -sequentialProcessingTime) +" milli Seconds");

        //Parallel Streams
        long parallelProcessingTime = System.currentTimeMillis();
        numbers.parallelStream()
                .map((Integer val) -> val * val)
                .forEach((Integer val)-> System.out.println(val));
        System.out.println("ParallelStreamProcessingTime: " + (System.currentTimeMillis() - parallelProcessingTime) +" milli Seconds");

    }

}
