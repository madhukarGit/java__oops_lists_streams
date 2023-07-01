package com.oops.revisited.domain;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee implements FlyerPilot{
    private int projectCount = 0;
    String analystRegex = "\\w+=(?<projectCount>\\d+)";
    Pattern managerMat = Pattern.compile(analystRegex, Pattern.DOTALL | Pattern.COMMENTS);

    private FlyerPilot pilot =
            new Pilot(10, "Commercial Pilot","IAF",
                    LocalDate.from(dateTimeFormatter.parse("1/1/2019")));
    public Analyst(String personText){
        super(personText);

        Matcher analystMatcher = managerMat.matcher(peopleMat.group("details"));
        if(analystMatcher.matches()){
            this.projectCount = Integer.parseInt(analystMatcher.group("projectCount"));
        }
    }
    @Override
    public int getSalary(){
        return 2500 + projectCount;
    }
    public String toString() {
        return String.format("%s, %s, %s, %s: %s",lastName, firstName, pilot, firstName, currencyFormat.format(getSalary()));
    }

    @Override
    public int commercialFlyingHours() {
        return 0;
    }

    @Override
    public String licence() {
        return null;
    }

    @Override
    public String agency() {
        return null;
    }

    @Override
    public LocalDate dateOfLicenceAchieved() {
        return null;
    }
}
