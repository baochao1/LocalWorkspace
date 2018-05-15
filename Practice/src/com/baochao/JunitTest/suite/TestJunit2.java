package com.baochao.JunitTest.suite;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestJunit2 {
    String message = "Robert";   

    @Test
    public void testSalutationMessage() {
       assertEquals("Robert","Robert");
    }
    
    @BeforeClass
    public static void printControl() {
	System.out.println("method started...");
    }
}
