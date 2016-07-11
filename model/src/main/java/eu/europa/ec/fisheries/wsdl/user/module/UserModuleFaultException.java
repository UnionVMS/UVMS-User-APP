
package eu.europa.ec.fisheries.wsdl.user.module;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.6
 * 2016-07-11T11:14:06.873+02:00
 * Generated source version: 2.7.6
 */

@WebFault(name = "UserFault", targetNamespace = "types.user.wsdl.fisheries.ec.europa.eu")
public class UserModuleFaultException extends Exception {
    
    private eu.europa.ec.fisheries.wsdl.user.types.UserFault userFault;

    public UserModuleFaultException() {
        super();
    }
    
    public UserModuleFaultException(String message) {
        super(message);
    }
    
    public UserModuleFaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserModuleFaultException(String message, eu.europa.ec.fisheries.wsdl.user.types.UserFault userFault) {
        super(message);
        this.userFault = userFault;
    }

    public UserModuleFaultException(String message, eu.europa.ec.fisheries.wsdl.user.types.UserFault userFault, Throwable cause) {
        super(message, cause);
        this.userFault = userFault;
    }

    public eu.europa.ec.fisheries.wsdl.user.types.UserFault getFaultInfo() {
        return this.userFault;
    }
}
