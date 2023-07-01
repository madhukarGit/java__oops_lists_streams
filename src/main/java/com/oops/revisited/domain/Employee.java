package com.oops.revisited.domain;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee {
    protected String lastName;
    protected String firstName;
    protected LocalDate dob;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    static String peopleRegex = """
        (?<lastName>\\w+),\\s+(?<firstName>\\w+),\\s+(?<dob>\\d{1,2}/\\d{1,2}/\\d+),\\s+(?<role>\\w+),\\s+\\{(?<details>.*?)\\}
        """;
    static Pattern peoplePattern = Pattern.compile(peopleRegex, Pattern.DOTALL | Pattern.COMMENTS);

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    Matcher peopleMat = null;

    public Employee(String personText) {
        peopleMat = peoplePattern.matcher(personText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dateTimeFormatter.parse(peopleMat.group("dob")));
        }
    }

    public abstract int getSalary();

    public String toString() {
        return String.format("%s, %s: %s",lastName, firstName, currencyFormat.format(getSalary()));
    }

    public static final Employee createEmployee(String personText){
        Matcher peopleMat = peoplePattern.matcher(personText);
        if(peopleMat.matches()){
            return switch (peopleMat.group("role")){
                case "Programmer" -> new Programmer(peopleMat.group());
                case "Analyst" -> new Analyst(peopleMat.group());
                case "Manager" -> new Manager(peopleMat.group());
                default -> new DummyEmployee(peopleMat.group());
            };
        }
        return new DummyEmployee(peopleMat.group());
    }

    //Nested classes
    public static final class DummyEmployee extends Employee{

        public DummyEmployee(String personText) {
            super(personText);
            this.firstName = "NA";
            this.lastName = "NA";
        }

        @Override
        public int getSalary() {
            return 10;
        }
    }
}
