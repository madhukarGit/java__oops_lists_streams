package com.oops.revisited.collections;

import com.oops.revisited.domain.Analyst;
import com.oops.revisited.domain.Employee;
import com.oops.revisited.domain.FlyerPilot;
import com.oops.revisited.domain.IEmployee;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainCollections {
    public static void main( String[] args )
    {
        String people = """
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Robert, Brad, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Hummus, Jr, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Ilhan, Omar, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Keira, Brat, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Keaar, Jr, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Raj, Lt, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Maxie, Air, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Apple, Gala, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Babu, Mahesh, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
            Bard, Beard, 1/1/1900, Programmer, {locpd=2130,yoe=10,iq=105}
            Leo, Cap, 1/1/1900, Programmer, {locpd=1800,yoe=10,iq=115}
            Matt, Demon, 2/2/1905, Manager, {orgSize=300,dr=10}
            Man, Made, 2/2/1905, Manager, {orgSize=301,dr=11}
            Ron, Ruin, 2/2/1905, Manager, {orgSize=302,dr=12}
            Vendetta, Van, 2/2/1905, Manager, {orgSize=303,dr=13}
            Steve, Carwley, 3/3/1910, Analyst, {projectCount=3}
            Flink, Apache, 3/3/1910, Analyst, {projectCount=3}
            Maxie, Millan, 3/3/1910, Analyst, {projectCount=3}
            Kendra, Parliament, 3/3/1910, Analyst, {projectCount=300}
            """;
        String regex = """
        (?<lastName>\\w+),\\s+(?<firstName>\\w+),\\s+(?<dob>\\d{1,2}/\\d{1,2}/\\d+),\\s+(?<role>\\w+),\\s+\\{(?<details>.*?)\\}
        """;

        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(people);

        int totalSalaries = 0;
        List<Employee> employeeList = new ArrayList<>();
        while (matcher.find()){
            Employee employeeResult = Employee.createEmployee(matcher.group());
            employeeList.add(employeeResult);
        }
        totalSalaries = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(0,(a,b)->a+b);
        NumberFormat currency  = NumberFormat.getCurrencyInstance();
        System.out.println(currency.format(totalSalaries));

        int totalSalariesLoop = 0;

        for(Iterator<Employee> it = employeeList.iterator();it.hasNext();){
            totalSalariesLoop += it.next().getSalary();
        }
        System.out.println(currency.format(totalSalariesLoop));

        /*
        * concurrent modification exception
        * */

        List<String> removalNames = List.of("Robert");
//        removalNames.add("Robert");
//        removalNames.add("Steve");
//        removalNames.add("Kendra");

        for(Iterator<Employee> it = employeeList.iterator(); it.hasNext();){
            Employee employee = it.next();
            if(removalNames.contains(employee.getLastName())){
                it.remove();
            }
        }

        employeeList.forEach(System.out::println);
    }
}