/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtri.util.xsddatatypes;

/**
 *
 * @author Lance
 */
public class ValidationFailedException extends Exception {
  public ValidationFailedException() {
    super();
  }

  public ValidationFailedException(String _message) {
    super(_message);
  }

  public ValidationFailedException(String _message, Throwable _cause) {
    super(_message, _cause);
  }

  public ValidationFailedException(Throwable _cause) {
    super(_cause);
  }    
}
