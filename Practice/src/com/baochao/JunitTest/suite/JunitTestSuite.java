package com.baochao.JunitTest.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestJunit1.class,TestJunit2.class
})
public class JunitTestSuite {

    
}
