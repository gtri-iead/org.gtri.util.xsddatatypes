/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtri.util.xsddatatypes;

import javax.xml.XMLConstants;

/**
 * <pre>
 * <xsd:simpleType name="NCName" id="NCName">
 *   <xsd:restriction base="xsd:Name">
 *     <xsd:pattern value="[\i-[:]][\c-[:]]*"/>
 *   </xsd:restriction>
 * </xsd:simpleType>
 * </pre>
 * 
 * @author Lance
 */
public final class XsdNCName implements Comparable<XsdNCName> {
  private final String value;
  
  public static boolean validate(final String _value) {
    // XML Schema regex pattern "[\i-[:]]" => "[_A-Za-z]"
    // XML Schema regex pattern "[\c-[:]]" => "[-._A-Za-z0-9]"
    // Modified this to allow empty string for the empty namespace prefix
    if(_value.length() == 0) {
      return true;
    }
    return _value.matches("[_A-Za-z][-._A-Za-z0-9]*");
  }

  public XsdNCName(final String _value) {
    if(!validate(_value)) {
      throw new IllegalArgumentException("Invalid {" + XMLConstants.W3C_XML_SCHEMA_NS_URI + "}NCName '" + _value + "'");
    }
    value = _value;
  }
  
  public static XsdNCName parseString(final String _value) throws ValidationFailedException {
    try {
      if(_value == null || _value.length() == 0) {
        // Note :default ns prefix is used here just to get access to an already allocated XsdNCName that is set to ""
        return XmlConstants.DEFAULT_NS_PREFIX;
      }
      return new XsdNCName(_value);
    } catch(IllegalArgumentException ex) {
      throw new ValidationFailedException(ex.getMessage());
    }
  }
  
  public String getValue() {
    return value;
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
    final XsdNCName other = (XsdNCName) obj;
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
  public int compareTo(XsdNCName _rhs) {
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
