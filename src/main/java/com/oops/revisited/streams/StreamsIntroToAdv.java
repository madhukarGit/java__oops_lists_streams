package com.oops.revisited.streams;

import com.oops.revisited.domain.Employee;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsIntroToAdv {

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
            Kendra, Parliament, 3/3/1910, Analyst, {projectCount=300}
            """;


        Integer totalSalary = people.lines()
                .map(Employee::createEmployee)
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println(totalSalary);

        record Car(String make, String model){}

        Stream.of(new Car("Tesla","10s"), new Car("Nissan","PZ1A"),
                new Car("Toyoto","Fortune"),new Car("Tesla","10s"))
                .distinct()
                .forEach(System.out::println);

    }
}
