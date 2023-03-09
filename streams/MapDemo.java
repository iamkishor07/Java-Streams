package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Employee{
    int empid;
    String empname;
    int salary;

    public Employee(int empid, String empname, int salary) {
        this.empid = empid;
        this.empname = empname;
        this.salary = salary;
    }
}
public class MapDemo {
/*   This Stream method is an intermediate operation which reads stream and
      returns new stream after applying given function
   */
/*
     Stream map() method is stateless which means it is non-interfering with other elements in the stream
     Another intermediate operation can be applied to returned stream for example filter(), sorted(), distinct()
     methods can be applied after map() operation
    map() method converts one set of values into another set of values applying given function

*/

    //    Note :- Number of elements returned in the new stream will always be equal to number of original elements
    public static void main(String[] args) {
        List<String> vechiles = Arrays.asList("bus", "car", "bike", "jeep", "flight", "train");

        List<String> VechilesinUppercase = new ArrayList<>();

    /*
    Without streams
     for(String  names:vechiles){
        VechilesinUppercase.add(names.toUpperCase());
    }
     */

        //With the java streams api - map
        //we do the same work in just one line
        VechilesinUppercase = vechiles.stream() // 1. get stream
                .map(String::toUpperCase) // 2.1 upper case
                .sorted() // 2.2 sorting alphabetically
                .collect(Collectors.toList()); // 3. collecting to List

//        System.out.println(VechilesinUppercase);

        //For the same we can used to find the length of the given strings
        /*
                vechiles.stream()
                .map(s -> s.length())//This maps the length to their respective strings length
                .forEach(System.out::println);

         */

         /*
            We perform the same operations with the integers
        */

    List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    /*
    BEfore streams
     for(int i:numberList){
     System.out.println(i*3)
     }
     */

    //With streams

    List<Integer>mulNumbers=numberList
            .stream()
            .map(k->k*3)
            .collect(Collectors.toList());

    numberList.stream().map(k->k*3).forEach(System.out::println);


    /*
        Created a class Employee with the empid,empname,empsalary
     */

        List<Employee> employees=Arrays.asList(
                new Employee(1,"kishor",10000),
                new Employee(2,"Kalyan",20000),
                new Employee(3,"Pavan",30000),
                new Employee(4,"kumar",50000)
        );

        //Combination of filter and map
        List<Integer> employeesList =employees.stream()
                .filter(employee -> employee.salary>20000)
                .map(employee -> employee.salary)
                .collect(Collectors.toList());
        System.out.println(employeesList);
}

}
