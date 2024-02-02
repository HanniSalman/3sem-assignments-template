package week01.exercise3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {


        List<Integer> bySeven = Arrays.asList(14, 21, 28, 35, 42);
        List<String> employees = Arrays.asList("John", "Jane", "Jack", "Joe", "Jill");

        Predicate<Integer> divisibleBySeven = number -> number / 7 == 0;
        for (Integer number : bySeven) {
            if (divisibleBySeven.test(number)) {
                System.out.println("These numbers can be divided by seven: " + number);
            }
        }

        Supplier<List<Employee>> name = () -> {
            List<Employee> employees1 = new ArrayList<>();

            for (int i = 0; i < employees.size(); i++) {
                int random = (int) (Math.random() * employees.size());
                String randName = employees.get(random);
                int randAge = (int) (Math.random() * 10) + 60;
                Employee employee = new Employee(randName, randAge);
                employees1.add(employee);
            }
            return employees1;
        };

        List<Employee> employee = name.get();
        Consumer<List<Employee>> printEmployees = employeeList -> {
            employeeList.forEach(System.out::println);
        };
        printEmployees.accept(employee);

        Function<List<Employee>, List<String>> converting = employeeList -> {
            List<String> names = new ArrayList<>();
            for (Employee employee1 : employeeList) {
                names.add(employee1.getName());
            }
            return names;
        };

        Predicate<Employee> older18 = employee1 -> employee1.getAge() > 18;
        for (Employee employee1 : employee) {
            boolean result = older18.test(employee1);
            System.out.println(employee1.getName() + " older than 18 " + result);
        }
    }
}
