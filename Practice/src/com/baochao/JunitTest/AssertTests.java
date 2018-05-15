package com.baochao.JunitTest;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import junit.framework.Assert;

public class AssertTests {
    
    Student a = new Student(1, 1);
    Student b = new Student(1, 1);
    

    @Test
    public void testAssertArrayEquals() {
	byte[] expected = "trial".getBytes();
	byte[] actual = "trial".getBytes();
	assertArrayEquals("failure - byte not same",expected, actual);
    }
    
    @Test
    public void testAssertEquels() {
	assertEquals("failure-String not same", 1,1);
	
    }
    
    @Test
    public void testAssertFalse() {
	assertFalse("failure - should be failure", false);
    }
    
    @Test
    public void testAssertNotNull() {
	assertNotNull("failure - should be not null", new Student(1, 1));
    }
    
    @Test
    public void testAssertThatBothContainsString() {
	assertThat("albumen", both(containsString("a")).and(containsString("u")));
    }
    
}

class Student {
    int studentNum;
    int studentSex;
    
    public Student(int studentNum, int studentSex) {
	this.studentNum = studentNum;
	this.studentSex = studentSex;
    }
    
    
}