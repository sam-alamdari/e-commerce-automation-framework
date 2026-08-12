package com.sam.automation.utils;

public class TestDataGenerator {

    private TestDataGenerator(){
    }
    public static String generateUniqueUsername(){
        return "sam_automation_" + System.currentTimeMillis();
    }
    public static String getTestPassword(){
        return "REMOVED";
    }
}
