import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DiffferentWaysToCreateStreams {
    public static  void main(String[] args)
    {

        //1.From Collection
        List<Integer> list = Arrays.asList(34,23,32,11,3);
        Stream<Integer> streamFromList = list.stream();

        //2.From Array
        Integer[] array = {23,56,2};
        Stream<Integer> streamFromArray = Arrays.stream(array);

        //3.From Static Method
        Stream<Integer> streamFromStaticMethod = Stream.of(23,1,34,35,3,2,89);

        //4.From Stream Builder
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(23).add(34).add(2).add(99);

        Stream<Integer> streamFromStreamBuilder = streamBuilder.build();

        //5.From Stream Iterate
        Stream<Integer> streamFromStreamIterator = Stream.iterate(100,(Integer n) ->n + 500).limit(5);



    }

}
