package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class  product{
    int id;
    String name;
    double price;

    public product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class FilterDemo {
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

        //Instead of storing it in the array, we just print it using sysprintln

        /*l.stream().filter(n->n%2!=0).forEach(i->System.out.println(i));*/

        //This the below does the same thing as the above no need to mention the variable again
        l.stream().filter(n->n%2!=0).forEach(System.out::println);




        //demo of filters on arraylist of strings
         List<String>names= Arrays.asList("kishor","PavanKalyan","Naveen","Aravind","Adhi");

         //We directly printed the strings ,Instead we use collections to store the result
            names
                .stream()
                 .filter(str->str.length()>4 && str.length()<8) //This is the predicate for the filter the array of list
                    .forEach(i->System.out.println(i));//Uses the foreach loop to print the results out

        //We converted the filtered arraylist strings into a list to store it easily
         List<String> namesresults=names
                .stream()
                .filter(str->str.length()>4 && str.length()<8) //This is the predicate for the filter the array of list
                .collect(Collectors.toList());//Uses collect to store it as a list



        List<String>words= Arrays.asList("kishor","PavanKalyan",null,"Aravind","Adhi",null);

        /*words.stream().filter(str->str!=null).forEach(System.out::println);*/

        List<String> wordresults= words
                .stream()
                .filter(str->str!=null) //Here the predicate is that nothing but a condition that we used to mention it in
                .collect(Collectors.toList());//if condition to remove the null values


        /*
            Created a class of products to store the product id,product name,product price

            We create a arraylsit of type product and insert some values and perform the filter operations
            on the list using streams by the specified your own condition(Predicate Logic)
         */
        List<product> productList=new ArrayList<>();
        productList.add(new product(1,"HP Laptop",30000));
        productList.add(new product(2,"Dell Laptop",80000));
        productList.add(new product(3,"Realme Mobile",50000));
        productList.add(new product(4,"Mac Book",130000));

        productList.stream()
                .filter(product -> product.price>40000)//Filtering the data
                .forEach(product -> System.out.println(product.name));//Iterating the data


    }

}
