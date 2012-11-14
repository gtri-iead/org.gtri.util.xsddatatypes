/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtri.util.xsddatatypes;

import javax.xml.XMLConstants;

/**
 *
 * @author Lance
 */
public final class XsdPositiveInteger implements Comparable<XsdPositiveInteger> {
  private final int value;
  
  public static boolean validate(int _value) {
    return _value > 0;
  }
  
  public XsdPositiveInteger(int _value) {
    if(!validate(_value)) {
      throw new IllegalArgumentException("Invalid {" + XMLConstants.W3C_XML_SCHEMA_NS_URI + "}positiveInteger '" + _value + "'");
    }
    value = _value;
  }
  
  public static XsdPositiveInteger fromInt(Integer _value) throws ValidationFailedException {
    try {
      return new XsdPositiveInteger(_value);
    } catch(IllegalArgumentException ex) {
      throw new ValidationFailedException(ex.getMessage());
    }
    
  }
  
  public static XsdPositiveInteger parseString(final String _value) throws ValidationFailedException {
    try {
      Integer value = Integer.parseInt(_value);
      return new XsdPositiveInteger(value);
    } catch(NumberFormatException ex) {
      throw new ValidationFailedException("Failed to parse {" + XMLConstants.W3C_XML_SCHEMA_NS_URI + "}positiveInteger from '" + _value + "'", ex);
    } catch(IllegalArgumentException ex) {
      throw new ValidationFailedException(ex.getMessage());
    }
  }
  
  
  public int getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return Integer.toString(value);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final XsdPositiveInteger other = (XsdPositiveInteger) obj;
    if (this.value != other.value) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 17 * hash + this.value;
    return hash;
  }
  
  @Override
  public int compareTo(XsdPositiveInteger _rhs) {
    final int BEFORE = -1;
    final int EQUAL = 0;
    final int AFTER = 1;
    
    if(_rhs == null) {
      return AFTER;
    }
    
    if(this == _rhs) {
      return EQUAL;
    }
    
    if(value < _rhs.value) {
      return BEFORE;
    } 
    else if(value > _rhs.value) {
      return AFTER;
    }
    return EQUAL;
  }
}
