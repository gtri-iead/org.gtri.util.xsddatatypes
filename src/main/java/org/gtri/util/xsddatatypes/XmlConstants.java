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
public class XmlConstants {
  public static XsdAnyURI NULL_NS_URI = new XsdAnyURI(XMLConstants.NULL_NS_URI);
//  public static XsdNCName DEFAULT_NS_PREFIX = null;
  public static XsdNCName DEFAULT_NS_PREFIX = new XsdNCName(XMLConstants.DEFAULT_NS_PREFIX);
  public static XsdAnyURI XML_NS_URI = new XsdAnyURI(XMLConstants.XML_NS_URI);
  public static XsdNCName XML_NS_PREFIX = new XsdNCName(XMLConstants.XML_NS_PREFIX);
  public static XsdAnyURI XMLNS_ATTRIBUTE_NS_URI = new XsdAnyURI(XMLConstants.XMLNS_ATTRIBUTE_NS_URI);
  public static XsdNCName XMLNS_ATTRIBUTE = new XsdNCName(XMLConstants.XMLNS_ATTRIBUTE);  
  public static XsdAnyURI W3C_XML_SCHEMA_NS_URI = new XsdAnyURI(XMLConstants.W3C_XML_SCHEMA_NS_URI);  
  public static XsdAnyURI W3C_XML_SCHEMA_INSTANCE_NS_URI = new XsdAnyURI(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
  public static XsdAnyURI W3C_XPATH_DATATYPE_NS_URI = new XsdAnyURI(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);  
  public static XsdAnyURI XML_DTD_NS_URI = new XsdAnyURI(XMLConstants.XML_DTD_NS_URI);  
  public static XsdAnyURI RELAXNG_NS_URI = new XsdAnyURI(XMLConstants.RELAXNG_NS_URI);
  public static XsdAnyURI FEATURE_SECURE_PROCESSING = new XsdAnyURI(XMLConstants.FEATURE_SECURE_PROCESSING);
}
