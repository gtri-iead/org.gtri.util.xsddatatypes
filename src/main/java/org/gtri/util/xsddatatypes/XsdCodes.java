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

import java.util.HashMap;
import java.util.Map;

public interface XsdCodes {
  /**
   * Enum for the all or none code used for the xsd:schema finalDefault and 
   * blockDefault attributes. 
   * 
   * To simultaneously satisfy the standard Java practice of using all capital 
   * letters in enum values and having an arbitrary string value that 
   * corresponds to the enum value, a string literal is stored with each enum 
   * value. This toString method is overridden, returning the string literal 
   * instead of the enum value. Additionally, two parsing methods are provided
   * to parse strings based on the string literal vice the enum value.
   */
  enum AllOrNoneCode {
    NONE(""),
    ALL("#all");
    
    /*
     * Stores the string value for the enum.
     */
    private String svalue;

    /**
     * Construct a new AllOrNodeCode with the string literal.
     * @param _svalue string literal
     */
    AllOrNoneCode(String _svalue) {
      svalue = _svalue;
    }
    /**
     * Returns the string literal for the AllOrNoneCode.
     * @return the string literal for the AllOrNoneCode.
     */
    @Override public String toString() { return svalue; }
    
    /**
     * A map to lookup an AllOrNoneCode given a string. Created on demand.
     */
    private static Map<String, AllOrNoneCode> parseMap = null;
    /**
     * Parse an AllOrNoneCode from a string OR return NULL if parsing fails.
     * @param _svalue a string literal to parse
     * @return AllOrNoneCode OR NULL if parsing failed
     */
    public static AllOrNoneCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(AllOrNoneCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    /**
     * Parse an AllOrNoneCode from a string OR return NULL if parsing fails.
     * @param _svalue a string literal to parse
     * @return AllOrNoneCode 
     * @throws ValidationFailedException if parsing failed
     */
    public static AllOrNoneCode parseString(String _svalue) throws ValidationFailedException {
      AllOrNoneCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + AllOrNoneCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
  }
  
  enum FormChoiceCode {
    QUALIFIED("qualified"),
    UNQUALIFIED("unqualified");
    
    private String svalue;
    FormChoiceCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, FormChoiceCode> parseMap = null;
    public static FormChoiceCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(FormChoiceCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static FormChoiceCode parseString(String _svalue) throws ValidationFailedException {
      FormChoiceCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + FormChoiceCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
  }
  
  enum BlockDefaultCode {
    EXTENSION("extension"),
    RESTRICTION("restriction"),
    SUBSTITUTION("substitution");

    private String svalue;
    BlockDefaultCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, BlockDefaultCode> parseMap = null;
    public static BlockDefaultCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(BlockDefaultCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static BlockDefaultCode parseString(String _svalue) throws ValidationFailedException {
      BlockDefaultCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + BlockDefaultCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
}
  
  enum FinalDefaultCode {
    EXTENSION("extension"),
    LIST("list"),
    RESTRICTION("restriction"),
    UNION("union");
    
    private String svalue;
    FinalDefaultCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, FinalDefaultCode> parseMap = null;
    public static FinalDefaultCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(FinalDefaultCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static FinalDefaultCode parseString(String _svalue) throws ValidationFailedException {
      FinalDefaultCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + FinalDefaultCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
  }
  
  enum ElementBlockCode {
    EXTENSION("extension"),
    RESTRICTION("restriction"),
    SUBSTITUTION("substitution");
    
    private String svalue;
    ElementBlockCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, ElementBlockCode> parseMap = null;
    public static ElementBlockCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(ElementBlockCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static ElementBlockCode parseString(String _svalue) throws ValidationFailedException {
      ElementBlockCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + ElementBlockCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
  }
  
  enum ElementFinalCode {
    EXTENSION("extension"),
    RESTRICTION("restriction");
    
    private String svalue;
    ElementFinalCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, ElementFinalCode> parseMap = null;
    public static ElementFinalCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(ElementFinalCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static ElementFinalCode parseString(String _svalue) throws ValidationFailedException {
      ElementFinalCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + ElementFinalCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
  }
  
  enum ComplexTypeBlockCode {
    EXTENSION("extension"),
    RESTRICTION("restriction");
    
    private String svalue;
    ComplexTypeBlockCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, ComplexTypeBlockCode> parseMap = null;
    public static ComplexTypeBlockCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(ComplexTypeBlockCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }    
    public static ComplexTypeBlockCode parseString(String _svalue) throws ValidationFailedException {
      ComplexTypeBlockCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + ComplexTypeBlockCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
  }
  
  enum ComplexTypeFinalCode {
    EXTENSION("extension"),
    RESTRICTION("restriction");
    
    private String svalue;
    ComplexTypeFinalCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, ComplexTypeFinalCode> parseMap = null;
    public static ComplexTypeFinalCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(ComplexTypeFinalCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static ComplexTypeFinalCode parseString(String _svalue) throws ValidationFailedException {
      ComplexTypeFinalCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + ComplexTypeFinalCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }    
  }
  
  enum SimpleTypeFinalCode {
    LIST("list"),
    RESTRICTION("restriction"),
    UNION("union");
    
    private String svalue;
    SimpleTypeFinalCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, SimpleTypeFinalCode> parseMap = null;
    public static SimpleTypeFinalCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(SimpleTypeFinalCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static SimpleTypeFinalCode parseString(String _svalue) throws ValidationFailedException {
      SimpleTypeFinalCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + SimpleTypeFinalCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }    
  }
  
  enum ProcessContentsCode {
    LAX("lax"),
    SKIP("skip"),
    STRICT("strict");
    
    private String svalue;
    ProcessContentsCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, ProcessContentsCode> parseMap = null;
    public static ProcessContentsCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(ProcessContentsCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static ProcessContentsCode parseString(String _svalue) throws ValidationFailedException {
      ProcessContentsCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + ProcessContentsCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }    
  }
  
  enum AttributeUseCode {
    OPTIONAL("optional"),
    PROHIBITED("prohibited"),
    REQUIRED("required");
    
    private String svalue;
    AttributeUseCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, AttributeUseCode> parseMap = null;
    public static AttributeUseCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(AttributeUseCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static AttributeUseCode parseString(String _svalue) throws ValidationFailedException {
      AttributeUseCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + AttributeUseCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
  }
  
  enum WhitespaceFacetCode {
    COLLAPSE("collapse"),
    PRESERVE("preserve"),
    REPLACE("replace");
    
    private String svalue;
    WhitespaceFacetCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, WhitespaceFacetCode> parseMap = null;
    public static WhitespaceFacetCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(WhitespaceFacetCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static WhitespaceFacetCode parseString(String _svalue) throws ValidationFailedException {
      WhitespaceFacetCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + WhitespaceFacetCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
  }
  
  enum AllowedNamespacesCode {
    ANY("##any"),
    LOCAL("##local"),
    OTHER("##other"),
    TARGETNAMESPACE("##targetNamespace");
    
    private String svalue;
    AllowedNamespacesCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, AllowedNamespacesCode> parseMap = null;
    public static AllowedNamespacesCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(AllowedNamespacesCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static AllowedNamespacesCode parseString(String _svalue) throws ValidationFailedException {
      AllowedNamespacesCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + AllowedNamespacesCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
  }
  
  enum UnboundedCode {
    UNBOUNDED("unbounded");
    private String svalue;
    UnboundedCode(String _svalue) {
      svalue = _svalue;
    }
    @Override public String toString() { return svalue; }
    private static Map<String, UnboundedCode> parseMap = null;
    public static UnboundedCode fromString(String _svalue) {
      if(parseMap == null) {
        parseMap = new HashMap();
        for(UnboundedCode current : values()) {
          parseMap.put(current.toString(), current);
        }
      }
      return parseMap.get(_svalue);
    }
    public static UnboundedCode parseString(String _svalue) throws ValidationFailedException {
      UnboundedCode retv = fromString(_svalue);
      if(retv == null) {
        throw new ValidationFailedException("Invalid " + UnboundedCode.class.getCanonicalName() +  " '" + _svalue + "'");
      }
      return retv;
    }
  }
  
}
