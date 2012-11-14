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
public final class XsdNonNegativeInteger implements Comparable<XsdNonNegativeInteger> {
  private final int value;
  
  public static boolean validate(int _value) {
    return _value >= 0;
  }
  
  public XsdNonNegativeInteger(int _value) {
    if(!validate(_value)) {
      throw new IllegalArgumentException("Invalid {" + XMLConstants.W3C_XML_SCHEMA_NS_URI + "}nonNegativeInteger '" + _value + "'");
    }
    value = _value;
  }
  
  public static XsdNonNegativeInteger fromInt(Integer _value) throws ValidationFailedException {
    try {
      return new XsdNonNegativeInteger(_value);
    } catch(IllegalArgumentException ex) {
      throw new ValidationFailedException(ex.getMessage());
    }
    
  }
  
  public static XsdNonNegativeInteger parseString(final String _value) throws ValidationFailedException {
    try {
      Integer value = Integer.parseInt(_value);
      return new XsdNonNegativeInteger(value);
    } catch(NumberFormatException ex) {
      throw new ValidationFailedException("Failed to parse {" + XMLConstants.W3C_XML_SCHEMA_NS_URI + "}nonNegativeInteger from '" + _value + "'", ex);
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
    final XsdNonNegativeInteger other = (XsdNonNegativeInteger) obj;
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
  public int compareTo(XsdNonNegativeInteger _rhs) {
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
