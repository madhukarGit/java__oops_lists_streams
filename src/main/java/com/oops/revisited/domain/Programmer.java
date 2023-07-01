package com.oops.revisited.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee{
    private int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;

    String programRegex = "\\w+=(?<locpd>\\d+),\\w+=(?<yoe>\\d+),\\w+=(?<iq>\\d+)";
    Pattern programmerMat = Pattern.compile(programRegex, Pattern.DOTALL | Pattern.COMMENTS);

    public Programmer(String personText){
        super(personText);
        Matcher programmerMatcher = programmerMat.matcher(peopleMat.group("details"));

        if(programmerMatcher.matches()){
            this.linesOfCode  = Integer.parseInt(programmerMatcher.group("locpd"));
            this.yearsOfExp  = Integer.parseInt(programmerMatcher.group("yoe"));
            this.iq  = Integer.parseInt(programmerMatcher.group("iq"));
        }
    }

    @Override
    public int getSalary(){
        return 3000 + linesOfCode + yearsOfExp + iq;
    }
}
