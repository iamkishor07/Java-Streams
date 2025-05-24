import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperationsExp {
    public static void main(String[] args) {

        //filter Predicate Functional interface
        Stream<String> nameStream =Stream.of("I","LOVE","JAVA","STREAM","API");
        Stream<String> filteredStream = nameStream.filter((String name) -> name.length() > 3);
        List<String> list = filteredStream.collect(Collectors.toList());
        list.forEach((String val) -> System.out.println(val));


        //Map Function Functional Interface
        Stream<String> nameStream1 =Stream.of("I","LOVE","JAVA","STREAM","API");

        Stream<String> mapStream = nameStream1.map((String val) -> val.toLowerCase());
        List<String> listmapStream = mapStream.collect(Collectors.toList());
        list.forEach((String val) -> System.out.println(val));

        //flatMap Function Functional Interface

        List<List<String>> senteneList = Arrays.asList(
                Arrays.asList("I" ,"LOVE","JAVA"),
                Arrays.asList("STREAM" ,"API","JAVA 1.8 VERSION"),
                Arrays.asList("ITS" ,"VERY","EASY")
        );

        Stream<String> wordStream1 = senteneList.stream().flatMap((List<String> sentence) -> sentence.stream());
        //Out Put : I ,LOVE,JAVA,STREAM,API,JAVA 1.8 VERSION,ITS ,VERY,EASY
        Stream<String> wordStream2 =
                senteneList.stream().
                        flatMap((List<String> sentencce) -> sentencce.stream()
                                        .map((String s)-> s.toLowerCase()));

        wordStream2.forEach((String s) -> System.out.println(s));

        //distinct
        Integer[] arr = {23,67,34,67,23,9};
        Stream<Integer> distinctArr = Arrays.stream(arr).distinct();
        distinctArr.forEach((Integer val) -> System.out.println(val));

        //Sorted
        Integer[] arrUnStored = {23,67,34,67,23,9};
        Stream<Integer> arrStored = Arrays.stream(arr).sorted();
        arrStored.forEach((Integer val) -> System.out.println(val));

        //Peek Consumer Functional Interface
        List<String> wordStream3 =
                senteneList.stream().
                        flatMap((List<String> sentencce) -> sentencce.stream()
                                .map((String s)-> s.toLowerCase()))
                        .peek((String s) -> System.out.println(s))
                        .collect(Collectors.toList());

    }
}
