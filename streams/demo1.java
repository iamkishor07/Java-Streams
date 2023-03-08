package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class demo1 {
    public static void main(String[] args) {
        ArrayList<Integer>l=new ArrayList<>();
        for(int i=1;i<50;i+=5)l.add(i);

        //Example for streams using filter
                List<Integer> l1=l//original source
                            .stream()//get stream from the source
                            .filter(i -> i%2==0)//Intermediate operation to perform even or not
                            .collect(Collectors.toList());// terminal operation to produce result

                System.out.println(l1);
                //[6, 16, 26, 36, 46]

        //Example for streams using map
            List<Integer> l2=l//original source
                    .stream()//get stream from the source
                    .map(integer -> integer*2)//Intermediate operation to every ele multiple by 2
                    .collect(Collectors.toList());// terminal operation to produce result

             System.out.println(l2);
             //[2, 12, 22, 32, 42, 52, 62, 72, 82, 92]
    }

}
