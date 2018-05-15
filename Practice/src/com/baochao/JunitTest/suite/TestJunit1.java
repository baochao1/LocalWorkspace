package com.baochao.JunitTest.suite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJunit1 {

    String message = "Robert";   

    @Test
    public void testPrintMessage() { 
	assertEquals("Robert1","Robert");  
    }
}
