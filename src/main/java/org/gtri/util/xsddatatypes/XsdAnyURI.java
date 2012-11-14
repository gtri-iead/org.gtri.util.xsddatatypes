/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtri.util.xsddatatypes;

import java.net.URISyntaxException;
import javax.xml.XMLConstants;

/**
 *
 * @author Lance
 */
public final class XsdAnyURI implements Comparable<XsdAnyURI> {
  private final String value;
  
  public static boolean validate(final String _value) {
    try {
      java.net.URI temp = new java.net.URI(_value);
    } catch (URISyntaxException ex) {
      return false;
    }
    return true;
  }
  
  public XsdAnyURI(final String _value) {
    if(!validate(_value)) {
      throw new IllegalArgumentException("Invalid {" + XmlConstants.W3C_XML_SCHEMA_NS_URI + "}anyURI '" + _value + "'");
    }
    value = _value;
  }
  public static XsdAnyURI parseString(final String _value) throws ValidationFailedException {
    try {
      if(_value == null || _value.length() == 0) {
        return XmlConstants.NULL_NS_URI;
      }
      return new XsdAnyURI(_value);
    } catch(IllegalArgumentException ex) {
      throw new ValidationFailedException(ex.getMessage());
    }
  }
  
  @Override
  public String toString() {
    return value;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final XsdAnyURI other = (XsdAnyURI) obj;
    if ((this.value == null) ? (other.value != null) : !this.value.equals(other.value)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 59 * hash + (this.value != null ? this.value.hashCode() : 0);
    return hash;
  }

  @Override
  public int compareTo(XsdAnyURI _rhs) {
    final int BEFORE = -1;
    final int EQUAL = 0;
    final int AFTER = 1;
    
    if(_rhs == null) {
      return AFTER;
    }
    
    if(this == _rhs) {
      return EQUAL;
    }
    
    return value.compareTo(_rhs.value);
  }  
}
