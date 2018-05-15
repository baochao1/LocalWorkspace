package com.baochao.practice;

import java.util.HashMap;
import java.util.Hashtable;

public class ExceptionTest {

  Hashtable<String, String> hashtable = new Hashtable<String, String>();
  
  HashMap<String, String> ja = new HashMap<String, String>();
  private void searchHash(){
    
    
    
  } 

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((hashtable == null) ? 0 : hashtable.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ExceptionTest other = (ExceptionTest) obj;
    if (hashtable == null) {
      if (other.hashtable != null)
        return false;
    } else if (!hashtable.equals(other.hashtable))
      return false;
    return true;
  }
  
  
}
