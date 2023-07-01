package com.oops.revisited.streams;

import com.oops.revisited.domain.Employee;
import com.oops.revisited.domain.Programmer;

import java.util.Comparator;

import java.util.function.Predicate;

public class SortingStreams {

    public static void main(String[] args) {
        var people = """
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
            Kendra, Parliament, 3/3/1910, Analysts, {projectCount=300}
            Kendra, Parliament, 3/3/1910, Analyst, {projectCount=300}
            """;

        Predicate<Employee> employeePredicate = (employee)->employee.getSalary() > 0;
        Predicate<String> removeNoneEmployee = Predicate.not((str)->str.contains("Analysts"));

        people.lines()
                .filter(removeNoneEmployee)
                .map(Employee::createEmployee)
                //.filter(a->!a.getFirstName().equalsIgnoreCase(null))
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getLastName))
                .filter(employeePredicate)
                .forEach(System.out::println);
    }
}
