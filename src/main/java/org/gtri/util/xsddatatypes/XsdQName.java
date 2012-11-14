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
public final class XsdQName implements Comparable<XsdQName> {
  private final XsdAnyURI namespaceURI;
  private final XsdNCName localName;
  private final XsdNCName suggestedPrefix;

  public XsdQName(final XsdNCName _localName) {
    this(null, XmlConstants.NULL_NS_URI, _localName);
  }
  
  public XsdQName(final XsdAnyURI _namespaceURI, final XsdNCName _localName) {
    this(null, _namespaceURI, _localName);
  }
  
  public XsdQName(final XsdNCName _prefix, final XsdAnyURI _namespaceURI, final XsdNCName _localName) {
    if(_namespaceURI == null) {
      throw new IllegalArgumentException("namespaceURI must not be null.");
    }
    if(_localName == null) {
      throw new IllegalArgumentException("localName must not be null.");
    }
    
    namespaceURI = _namespaceURI;
    localName = _localName;
    suggestedPrefix = _prefix;
  }

  public static interface PrefixToNamespaceURIResolver {
    XsdAnyURI getNamespaceURIForPrefix(XsdNCName prefix);
  }
  
  public static XsdQName parseStringWithPrefix(final String _value, final PrefixToNamespaceURIResolver _prefixResolver) throws ValidationFailedException {
    // Split strong on colon(:)
    String[] temp = _value.split(":", 2);
    
    // If colon(:) is not present, then qname is using default name space and has no prefix
    if(temp.length == 1) {      
      // Get the namespace for the default namespace prefix ("" empty string)
      XsdAnyURI namespaceURI = _prefixResolver.getNamespaceURIForPrefix(XmlConstants.DEFAULT_NS_PREFIX);
      XsdNCName localName = XsdNCName.parseString(temp[0]);
      return new XsdQName(namespaceURI, localName);
    }
    
    if(temp.length == 2) {
      // Get the namespace for the supplied prefix
      XsdNCName prefix = XsdNCName.parseString(temp[0]);
      XsdAnyURI namespaceURI = _prefixResolver.getNamespaceURIForPrefix(prefix);
      XsdNCName localName = XsdNCName.parseString(temp[1]);
      return new XsdQName(prefix, namespaceURI, localName);
   }
    
    throw new ValidationFailedException("Failed to parse {" + XmlConstants.W3C_XML_SCHEMA_NS_URI + "}qname '" + _value + "'. Value must be of the form \"[namespace prefix]:[local name]\"");
  }
  
  public XsdAnyURI getNamespaceURI() {
    return namespaceURI;
  }

  public XsdNCName getLocalName() { 
    return localName;
  }

  public XsdNCName getSuggestedPrefix() {
    return suggestedPrefix;
  }
  
  public XsdNCName resolvePrefix(final NamespaceURIToPrefixResolver _namespaceURIToPrefixResolver) {
    
    // Try to use prefix if it is set
    if(suggestedPrefix != null) {
      if(_namespaceURIToPrefixResolver.isValidPrefixForNamespaceURI(suggestedPrefix, namespaceURI)) {
        // Prefix is valid - use it
        return suggestedPrefix;
      }
    }
    
    // If we should have a prefix but don't then try resolver
    XsdNCName prefix = _namespaceURIToPrefixResolver.getPrefixForNamespaceURI(namespaceURI);
    if(prefix != null) {
      return prefix;
    }
    
    if(namespaceURI.equals(XmlConstants.XML_NS_URI)) {
      return XmlConstants.XML_NS_PREFIX;
    }
    
    if(namespaceURI.equals(XmlConstants.NULL_NS_URI)) {
      return XmlConstants.DEFAULT_NS_PREFIX;
    }
    
    return null;
  }
  
  public interface NamespaceURIToPrefixResolver {
    boolean isValidPrefixForNamespaceURI(XsdNCName _prefix, XsdAnyURI _uri);
    XsdNCName getPrefixForNamespaceURI(XsdAnyURI _uri);
  }
  
  public String toStringWithPrefix(final NamespaceURIToPrefixResolver _namespaceURIToPrefixResolver) {
    XsdNCName prefix = resolvePrefix(_namespaceURIToPrefixResolver);
    StringBuilder builder = new StringBuilder(256);
    if(prefix != null && prefix.toString().length() > 0) {
      builder.append(prefix).append(":");
    }
    return builder.append(localName).toString();
//    
//    // If the namespace is the XML namespace use the default XML prefix
//    if(namespaceURI.equals(XmlConstants.XML_NS_URI)) {
//      return stringBuilder
//              .append(XmlConstants.XML_NS_PREFIX)
//              .append(":")
//              .append(localName)
//              .toString();
//    }
//    
//    // Try to use prefix if it is set
//    if(suggestedPrefix != null) {
//      if(_namespaceURIToPrefixResolver.isValidPrefixForNamespaceURI(suggestedPrefix, namespaceURI)) {
//        // Prefix is valid - use it
//        return buildStringWithPrefix(suggestedPrefix, localName);
//      }
//    }
//    
//    // If we should have a prefix but don't then use resolver
//    if(!namespaceURI.equals(XmlConstants.NULL_NS_URI)) {
//      return buildStringWithPrefix(
//              _namespaceURIToPrefixResolver.getPrefixForNamespaceURI(namespaceURI),
//              localName
//              );
//              
//    }
//    
//    return stringBuilder.append(localName).toString();
    
  }
  
//  private String buildStringWithPrefix(XsdNCName prefix, XsdNCName localName) {
//    StringBuilder builder = new StringBuilder(256);
//    if(prefix != null && prefix.toString().length() > 0) {
//      builder.append(prefix).append(":");
//    }
//    return builder.append(localName).toString();
//  }
  
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(256);
    // Is namespace URI not empty?
    if(!namespaceURI.toString().equals(XMLConstants.NULL_NS_URI)) {
      stringBuilder.append("{").append(namespaceURI).append("}");
    }
    return stringBuilder.append(localName).toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final XsdQName other = (XsdQName) obj;
    // Prefix is ignored for equals
    if (this.namespaceURI != other.namespaceURI && (this.namespaceURI == null || !this.namespaceURI.equals(other.namespaceURI))) {
      return false;
    }
    if ((this.localName == null) ? (other.localName != null) : !this.localName.equals(other.localName)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    // Prefix is ignored for hashCode
    hash = 97 * hash + (this.namespaceURI != null ? this.namespaceURI.hashCode() : 0);
    hash = 97 * hash + (this.localName != null ? this.localName.hashCode() : 0);
    return hash;
  }
  
  @Override
  public int compareTo(XsdQName _rhs) {
    final int BEFORE = -1;
    final int EQUAL = 0;
    final int AFTER = 1;
    
    if(_rhs == null) {
      return AFTER;
    }
    
    if(this == _rhs) {
      return EQUAL;
    }
    
    // Prefix is ignored for compareTo
    int result;
    result = namespaceURI.compareTo(_rhs.namespaceURI);
    if(result != EQUAL) {
      return result;
    }
    result = localName.compareTo(_rhs.localName);
    if(result != EQUAL) {
      return result;
    }
    return EQUAL;
  }
  
}
