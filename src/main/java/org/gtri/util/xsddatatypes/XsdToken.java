/*
    Copyright 2012 Georgia Tech Research Institute

    Author: lance.gatlin@gtri.gatech.edu

    This file is part of org.gtri.util.xsddatatypes library.

    org.gtri.util.xsddatatypes library is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    org.gtri.util.xsddatatypes library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with org.gtri.util.xsddatatypes library. If not, see <http://www.gnu.org/licenses/>.

*/

package org.gtri.util.xsddatatypes;

/**
 * <pre>
 * <xsd:simpleType name="token" id="token">
 *   <xsd:restriction base="xsd:normalizedString">
 *     <xsd:whiteSpace value="collapse"/>
 *   </xsd:restriction>
 * </xsd:simpleType>
 * </pre>
 * The lexical and value spaces of xsd:token are the sets of all strings after 
 * whitespace replacement; i.e., after any occurrence of #x9 (tab), #xA 
 * (linefeed), or #xD (carriage return).These are replaced by an occurrence of 
 * #x20 (space) and collapsing. Collapsing is when contiguous occurrences of 
 * spaces are replaced by a single space, and leading and trailing spaces are 
 * removed. (http://books.xmlschemata.org/relaxng/ch19-77319.html)
 * 
 * @author Lance
 */
public final class XsdToken implements Comparable<XsdToken> {
  private final String value;
  
  public static boolean validate(final String _value) {
    return true;
  }
  
  public XsdToken(final String _value) {
    String temp = _value.trim();
    value = temp.replaceAll("(\\x09|\\x0A|\\x0D)+", " ");
  }
  
  public static XsdToken parseString(final String _value) throws ValidationFailedException {
    try {
      return new XsdToken(_value);
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
    final XsdToken other = (XsdToken) obj;
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
  public int compareTo(XsdToken _rhs) {
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
