package com.oops.revisited.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee{
    private int orgSize = 0;
    private int dr = 0;
    String managerRegex = "\\w+=(?<orgSize>\\d+),\\w+=(?<dr>\\d+)";
    Pattern managerMat = Pattern.compile(managerRegex, Pattern.DOTALL | Pattern.COMMENTS);

    public Manager(String personText){
        super(personText);
        Matcher managerMatcher = managerMat.matcher(peopleMat.group("details"));

        if(managerMatcher.matches()){
            this.orgSize  = Integer.parseInt(managerMatcher.group("orgSize"));
            this.dr  = Integer.parseInt(managerMatcher.group("dr"));
        }

    }

    @Override
    public int getSalary(){
        return 3500 + orgSize + dr;
    }

}
