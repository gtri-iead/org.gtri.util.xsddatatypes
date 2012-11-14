/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtri.util.xsddatatypes;

/**
 * <pre>
 * <xsd:simpleType name="normalizedString" id="normalizedString">
 *   <xsd:restriction base="xsd:string">
 *     <xsd:whiteSpace value="replace"/>
 *   </xsd:restriction>
 * </xsd:simpleType>
 * </pre>
 * The lexical space of xsd:normalizedString is unconstrained (any valid XML 
 * character may be used). Its value space is the set of strings after 
 * whitespace replacement—i.e., after any occurrence of #x9 (tab), #xA 
 * (linefeed), and #xD (carriage return) have been replaced by an occurrence of 
 * #x20 (space) without any whitespace collapsing.
 * (http://books.xmlschemata.org/relaxng/ch19-77263.html)
 * 
 * @author Lance
 */
public final class XsdNormalizedString implements Comparable<XsdNormalizedString> {
  private final String value;
  
  public static boolean validate(final String _value) {
    return true;
  }
  
  public XsdNormalizedString(final String _value) {
    value = _value.replaceAll("\\x09|\\x0A|\\x0D", " ");
  }
  
  public static XsdNormalizedString parseString(final String _value) throws ValidationFailedException {
    try {
      return new XsdNormalizedString(_value);
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
    final XsdNormalizedString other = (XsdNormalizedString) obj;
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
  public int compareTo(XsdNormalizedString _rhs) {
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
