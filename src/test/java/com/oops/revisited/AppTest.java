package com.oops.revisited;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}

/*
* int totalSalaries = 0;
        List<Employee> employeeList = null;
        while (matcher.find()){
            employeeList.add(Employee.createEmployee(matcher.group()));
        }
        for(Iterator<Employee> it = employeeList.listIterator();it.hasNext();){
            totalSalaries += it.next().getSalary();
        }*/
