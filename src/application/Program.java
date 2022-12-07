package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in)
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

            double listSalary = list.stream().map(employee -> )
        }
        catch (IOException e){
            System.out.println("Error :"+ e.getMessage());
        }


    }
}