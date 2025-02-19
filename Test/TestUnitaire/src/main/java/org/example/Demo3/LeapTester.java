package org.example.Demo3;

import jdk.jshell.spi.ExecutionControl;

public class LeapTester {

    public boolean  isLeap(int year) {
       return (year % 400 == 0||(year % 4 == 0 && year % 100 != 0))&& year % 4000 != 0;
    }
}
