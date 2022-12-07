package application;

import entities.Employee;
import services.EmployeeService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter full file path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Employee> list =new ArrayList<>();
            String line = br.readLine();
            while (line !=null){
                String[] fields = line.split(",");
                list.add(new Employee(fields[0],fields[1],Double.parseDouble(fields[2])));
                line = br.readLine();
            }
            System.out.print("Enter salary: ");
            double limitSalary = sc.nextDouble();

            Comparator<String> comp = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> emails = list.stream()
                    .filter(employee -> employee.getSalary() > limitSalary)
                    .map(employee -> employee.getEmail())
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println("Email of people whose salary is more than "+ limitSalary +" :" );
            emails.forEach(System.out::println);

            EmployeeService es = new EmployeeService();
            double sum = es.filteredSum(list,employee -> employee.getName().charAt(0) == 'M');

            System.out.println("Sum of salary of people whose starts with 'M' "+ limitSalary +" :" + String.format("%.2f",sum));
        }
        catch (IOException e){
            System.out.println("Error :"+ e.getMessage());
        }


    }
}